package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PgaeBase.Basepage;

public class Homepage extends Basepage {
	
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement inklogin;	
	
	public void clickmyacount() {
		
		lnkmyaccount.click();
		
	}
	
	public void clickregiscter() {
		lnkRegister.click();
	}
	
	public void clicklogin() {
		inklogin.click();
		
	}


}

