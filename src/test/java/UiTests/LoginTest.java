package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import setup.BasePage;
import org.testng.annotations.Test;
import setup.BasePage;
import utils.Constants;
import utils.JsonPathUtil;

import java.io.File;
import java.io.IOException;

import static utils.Utilities.readTestData;

public class LoginTest extends TestBase {

	@BeforeClass(alwaysRun = true)
	public void intializeClassObjects() throws Exception {
		Constants.jsonString = readTestData("grppage", "src/test/resources/TestData/QAData.json").toString();
		testData = new JSONObject(Constants.jsonString);
		// System.out.println(testData);
	}
	@Test(groups = { "login", "regression", "smoke"})
	public void GrpLoginTest(){
		try {
			String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
			System.out.println("Method name is: "+methodname);
			//htmlReport.reportStartTest("C1234",methodname, "Group Login");
			loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
		}catch(Exception e) { System.out.println("Exception Occured " + e); }
	}
}


