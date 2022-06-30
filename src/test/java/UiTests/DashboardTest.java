package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;
import pages.CarePages.CarePage.*;
import pages.DoctorsPages.DoctorsPage.*;
import pages.LoginPages.LoginPage.*;
import static utils.Utilities.readTestData;

public class DashboardTest extends TestBase {

    public JSONObject testData = new JSONObject();

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("signup", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        // System.out.println(testData);
    }



    @Test(groups = { "dashboard", "regression", "smoke"},priority = 0)
    public void VerifyDashbordPrimary() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "dashboard");
        carePage.acctLoginPage(1);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Expenses')]")).isDisplayed(), "Expenses");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'My annual max benefit')]")).isDisplayed(), "My annual max benefit");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Get care')]")).isDisplayed(), "Get care");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Find doctors')]")).isDisplayed(), "Find doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Pay for drugs')]")).isDisplayed(), "Pay for drugs");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Upload a bill')]")).isDisplayed(),"Upload a bill");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Bookmarked Doctors')]")).isDisplayed(),"Bookmarked Doctors");
    }

    @Test(groups = { "dashboard", "regression", "smoke"},priority = 1)
    public void VerifyDashbordCanceled() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "dashboard");
        carePage.acctLoginPage(10);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Expenses')]")).isDisplayed(), "Expenses");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Get care')]")).isDisplayed(), "Get care");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Find doctors')]")).isDisplayed(), "Find doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Pay for drugs')]")).isDisplayed(), "Pay for drugs");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Upload a bill')]")).isDisplayed(),"Upload a bill");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Bookmarked Doctors')]")).isDisplayed(),"Bookmarked Doctors");
    }

    @Test(groups = { "dashboard", "regression", "smoke"},priority = 2)
    public void VerifyDashbordOnlyDep() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "dashboard");
        carePage.acctLoginPage(12);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Expenses')]")).isDisplayed(), "Expenses");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
        Assert.assertFalse(driver.findElements(By.xpath("//a[contains(.,'My annual max benefit')]")).size()==1, "My annual max benefit");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Get care')]")).isDisplayed(), "Get care");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Find doctors')]")).isDisplayed(), "Find doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Pay for drugs')]")).isDisplayed(), "Pay for drugs");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Upload a bill')]")).isDisplayed(),"Upload a bill");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Bookmarked Doctors')]")).isDisplayed(),"Bookmarked Doctors");
    }

    @Test(groups = { "dashboard", "regression", "smoke"},priority = 3)
    public void VerifyDashbordSuspended() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "dashboard");
        carePage.acctLoginPage(15);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Expenses')]")).isDisplayed(), "Expenses");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
        carePage.verifyElementByText("Your policy is currently suspended");
        Assert.assertFalse(driver.findElements(By.xpath("//a[contains(.,'My annual max benefit')]")).size()==1, "My annual max benefit");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Get care')]")).isDisplayed(), "Get care");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Find doctors')]")).isDisplayed(), "Find doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Pay for drugs')]")).isDisplayed(), "Pay for drugs");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Upload a bill')]")).isDisplayed(),"Upload a bill");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Bookmarked Doctors')]")).isDisplayed(),"Bookmarked Doctors");
    }
    @Test(groups = { "dashboard", "regression", "smoke"},priority = 4)
    public void VerifyDashbordExpired() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "dashboard");
        carePage.acctLoginPage(16);
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Expenses')]")).isDisplayed(), "Expenses");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
        carePage.verifyElementByText("Your coverage has been cancelled");
        carePage.verifyElementByText("Get covered again by Sidecar Health");
        Assert.assertFalse(driver.findElements(By.xpath("//a[contains(.,'My annual max benefit')]")).size()==1, "My annual max benefit");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Get care')]")).isDisplayed(), "Get care");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Find doctors')]")).isDisplayed(), "Find doctors");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Pay for drugs')]")).isDisplayed(), "Pay for drugs");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Upload a bill')]")).isDisplayed(),"Upload a bill");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Bookmarked Doctors')]")).isDisplayed(),"Bookmarked Doctors");
    }
}
