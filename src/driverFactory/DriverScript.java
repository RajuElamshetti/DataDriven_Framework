package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil{
	String inputpath = "C:\\Automation\\DDT_Framework\\FileInput\\Loginpage.xlsx";
	String outputpath = "C:\\Automation\\DDT_Framework\\FileOutput\\DataDrivenResults.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void starttest()throws Throwable
	{
		//create obj for excel file
		ExcelFileUtil a = new ExcelFileUtil(inputpath);
		//count no of rows in loginsheet
		int rc = a.rowcount("Login");
		report = new ExtentReports("./ExtentReoports/login.html");
		Reporter.log("no of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			test = report.startTest("validate login");
			test.assignAuthor("Raju");
			//read username&password data
			String username = a.getcelldata("login", i, 0);
			String password = a.getcelldata("login", i, 1);
			//call login method
			boolean res = FunctionLibrary.verify_login(username, password);
			if(res)
			{
				//if res true write login success into results
				a.setcelldata("Login", i, 2, "login success",outputpath);
				a.setcelldata("Login", i, 3, "pass", outputpath);
				test.log(LogStatus.PASS,"login success");
			}
			else
			{
				// if res true write login fail into results
				a.setcelldata("Login", i, 2, "login success", inputpath);
				a.setcelldata("Login", i, 3, "fail", outputpath);
				test.log(LogStatus.FAIL, "login fail");
			}
			report.endTest(test);
			report.flush();
		}
		
		
	}

}
