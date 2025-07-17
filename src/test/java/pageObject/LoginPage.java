package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PgaeBase.Basepage;

public class LoginPage extends Basepage {
	
	public LoginPage(WebDriver driver) {
		super(driver);

}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnclick;


public void enteremail(String email) {
	
	txtemail.sendKeys(email);
}

public void enterpassword(String password) {
	txtpassword.sendKeys(password);
	
}

public void clickbutton() {
	
	btnclick.click();
}

}
