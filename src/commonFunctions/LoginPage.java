package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define repository for login
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement enteruser;
	@FindBy (name = "txtPassword")
	WebElement enterpass;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement clicklogin;
	//method for login
	public void verify_login(String username, String password)
	{
		enteruser.sendKeys(username);
		enterpass.sendKeys(password);
		clicklogin.click();
	}
	
}
