package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PgaeBase.Basepage;

public class loginsuccesspage extends Basepage {
	public loginsuccesspage(WebDriver driver) {
		super(driver);

}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement linklogouot;
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
		
	
	public void clicklogout() {
		linklogouot.click();
	}
}
