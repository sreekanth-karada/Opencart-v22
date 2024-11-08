  package utilities;



import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders  {
	
	//Data Provider 1
	
	@DataProvider(name="LoginData") 
	public String [][] getData() throws IOException 
	{
		String path=".\\testdata\\Opencart_LoginData1.xlsx";  //taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path);     //Create an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1"); 
		int totalcols=xlutil.getCellCount("Sheet1",1); 
		
		String logindata[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows; i++)
		{
			for(int j=0; j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j); //1,0
				System.out.println();
			}
		}
		
	return logindata; //returning the 2 dimensional array
	
	}

}
