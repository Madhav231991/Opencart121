package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.loginsuccesspage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
		
		logger.info("*****Starting TC003_loginDDT*****");
		try
		{
		
		Homepage hm=new Homepage(driver);
		hm.clickmyacount();
		hm.clicklogin();
		
		LoginPage lg=new LoginPage(driver);
		lg.enteremail(email);
		lg.enterpassword(pwd);
		lg.clickbutton(); 
		
		loginsuccesspage log=new loginsuccesspage(driver);

		boolean targetpage=log.isMyAccountPageExists();
		
		/*Data is valid  - login success - test pass  - logout
		                   login failed - test fail

		Data is invalid - login success - test fail  - logout
		                  login failed - test pass*/
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				
				log.clicklogout();
				Assert.assertTrue(true);
				
			}
			
		}else {
			
			Assert.assertTrue(false);
		}
		
		if(exp.equalsIgnoreCase("Inalid")) {
			if(targetpage==true) {
				
				log.clicklogout();
				Assert.assertTrue(false);
				
			}
			
		}else {
			
			Assert.assertTrue(true);
		
	}
	
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****finished TC003_loginDDT*****");
	

	}
}
