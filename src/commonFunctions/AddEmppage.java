package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmppage {
WebDriver driver;
//Constructor
public AddEmppage(WebDriver driver)
{
this.driver= driver;	
}
//define respository
@FindBy (xpath = "//b[normalize-space()='PIM']")
WebElement clickpim;
@FindBy (xpath = "//a[@id='menu_pim_addEmployee']")
WebElement clickAddbtn;
@FindBy (name = "firstName")
WebElement enterfirstname;
@FindBy (name = "middleName")
WebElement entermiddlename;
@FindBy (name = "lastName")
WebElement enterlastname;
@FindBy (xpath = "//input[@id='employeeId']")
WebElement  beforeid;
@FindBy (xpath = "//input[@id='btnSave']")
WebElement clicksavebutton;
@FindBy (xpath = "//input[@id='personal_txtEmployeeId']")
WebElement afterid;
public boolean verify_emp(String fname,String mname,String lname)
{
	Actions b = new Actions(driver);
	b.moveToElement(clickpim).click().perform();
	b.moveToElement(this.clickAddbtn).click().perform();
	this.enterfirstname.sendKeys(fname);
	this.entermiddlename.sendKeys(mname);
	this.enterlastname.sendKeys(lname);
	//capture eid
	String expectedeid = beforeid.getAttribute("value");
	b.moveToElement(this.clicksavebutton).click().perform();
	String actualid = this.afterid.getAttribute("value");
	if (expectedeid.equals(actualid))
	{
		Reporter.log("add employee success::"+expectedeid+"    "+actualid,true);
		return true;
	}
	else
	{
		Reporter.log("add employee fail::"+expectedeid+"    "+actualid,true);
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



}
