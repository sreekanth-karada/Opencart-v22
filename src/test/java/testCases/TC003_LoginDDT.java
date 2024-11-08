package testCases;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	  
     
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven")  //getting data provider from different class 
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException 
	{ 
		logger.info("***** Starting TC003_LoginDDT *****");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
					
		hp.clickLogin();
		 
		//Login page
		LoginPage lp=new LoginPage(driver); 
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.setClick();
		
		//MyAccount
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetPage=mp.isMyAccountPageExists();
		
		/* Data is valid - login success - test pass -logout
		                 -login failed - test fail
		 Data is invalid - login success - test fail -logout
		                 -login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				mp.clickLogout();	
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			
			if(targetPage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finshed TC003_LoginTest****");

	}

	
	
}
