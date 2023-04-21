package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmppage;
import config.AppUtilPOM;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtilPOM{
String inputpath = "C:\\Automation\\DDT_Framework\\FileInput\\Employee.xlsx";
String outputpath = "C:\\Automation\\DDT_Framework\\FileOutput\\EmpResults.xlsx";
@Test

public void startTest()throws Throwable

{

AddEmppage emp =PageFactory.initElements(driver, AddEmppage.class);
//create obj for excelfile
ExcelFileUtil a = new ExcelFileUtil(inputpath);
//count no of rws in sheet
int rc = a.rowcount("Empdata");
Reporter.log("no of rows are::"+rc,true);
for (int i=1; i<=rc; i++)
{
	String Firstname = a.getcelldata("Empdata", i, 0);
	String Middlename = a.getcelldata("Empdata", i, 1);
	String Lastname = a.getcelldata("Empdata", i, 2);
	boolean res = emp.verify_emp(Firstname, Middlename, Lastname);
	if (res)
	{
		//write pass to status column
		a.setcelldata("Empdata", i, 3, "paass", outputpath);
	}
	else
	{
		a.setcelldata("Empdata", i, 3, "fail", outputpath);
	}
}

}
}