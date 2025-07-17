package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Registrationpage;
import testbase.BaseClass;

public class TC001_AccountRegistrationtest extends BaseClass {

	
		@Test(groups={"regression","master"})
		public void verify_account_registration() {
			logger.info("***** starting TC001_AccountRegistrationtest****");
			
			
			
			try
			{
			Homepage hm=new Homepage(driver);
			hm.clickmyacount();
			
			logger.info("***** clicked on my account llink*****");
			hm.clickregiscter();
			
			Registrationpage rg=new Registrationpage(driver);
			rg.setFirstName(RandomString().toUpperCase());
			rg.setLastName(RandomString().toUpperCase());
			rg.setEmail(RandomString()+ "@gmail.com");
			rg.setTelephone(RandomNumber());
			
			String password=RandomAlphanumeric();
			
			rg.setPassword(password);
			rg.setConfirmPassword(password);
			rg.setPrivacyPolicy();
			rg.clickContinue(); 
			String confimmsg= rg.getConfirmationMsg();
			Assert.assertEquals(confimmsg,"Your Account Has Been Created!");
			}
			catch(Exception e)
			{
				logger.error("test failed");
				logger.debug("dubug log");
				Assert.fail();
			
		}
		
			logger.info("***** finished TC001_AccountRegistrationtest****");
			
			
}

}
