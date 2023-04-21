package commonFunctions;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
public static boolean verify_login(String user,String pass)
{
	driver.get(conpro.getProperty("Url"));
	driver.manage().window().maximize();
	driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(user);
	driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(pass);
	driver.findElement(By.xpath(conpro.getProperty("Objlogin"))).click();
	String expected = "dashboard";
	String actual = driver.getCurrentUrl();
	if (actual.contains(expected))
	{
		Reporter.log("login success::"+expected+"    "+actual,true);
		return true;
	}
	else
	{
		String error_message = driver.findElement(By.xpath(conpro.getProperty("Objerror"))).getText();
		Reporter.log(error_message+"     "+expected+"    "+actual,true);
	}
	return false;
}
}
