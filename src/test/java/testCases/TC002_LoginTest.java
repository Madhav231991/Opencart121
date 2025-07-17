package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.loginsuccesspage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	
	@Test(groups={"sanity","master"})
	public void verifylogin() {
		
		Homepage hm=new Homepage(driver);
		hm.clickmyacount();
		hm.clicklogin();
		
		LoginPage lg=new LoginPage(driver);
		lg.enteremail(p.getProperty("email"));
		lg.enterpassword(p.getProperty("password"));
		lg.clickbutton();
		
		loginsuccesspage log=new loginsuccesspage(driver);
		Boolean targetpage=log.isMyAccountPageExists();
		
		
		
		log.clicklogout();
			
			
			
		}
	}


