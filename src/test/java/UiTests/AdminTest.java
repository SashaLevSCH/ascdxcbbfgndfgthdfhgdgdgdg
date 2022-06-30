package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static utils.Utilities.readTestData;

public class AdminTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("adminpage", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
    }

    @Test(groups = { "Admin", "regression", "login"},priority = 0, description="Admin Login")
    public void AdminLoginTest(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 1, description="Navigate to Partners")
    public void NavigatetoPartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'New partner')]")).isDisplayed(), "New Partner");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 2, description="Navigate to Groups")
    public void NavigatetoGroups(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToGroups();
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Groups')]")).isDisplayed(), "New Partner");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 3, description="Search a Partner")
    public void SearchPartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search("saksun2003");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'1706')]")).isDisplayed(), "Searched Partner");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 4, description="Search a Group")
    public void SearchGroup(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToGroups();
            adminDashBoardPage.search("Grouppays");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'sudhanshu.scqa+grouppays@gmail.com')]")).isDisplayed(), "Searched Group");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 5, description="Resend Invite to a Partner")
    public void ResendInvitePartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search(testData.getString("partnername"));
            adminDashBoardPage.resendInvitePartner();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'An email has been sent to sudhanshu.scqa+partner@gmail.com.')]")).isDisplayed(), "Searched Partner");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 6, description="Add Package to a Partner")
    public void AddPackagePartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search(testData.getString("partnername"));
            adminDashBoardPage.addPackagePartner(testData.getString("IYP"),testData.getString("AYP"),testData.getString("FYOP"),testData.getString("AYOP"));
            Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'201')]")).isDisplayed(), "Package Added");
            Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'202')]")).isDisplayed(), "Package Added");
            Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'203')]")).isDisplayed(), "Package Added");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 7, description="Delete Package to a Partner")
    public void DeletePackagePartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search(testData.getString("partnername"));
            adminDashBoardPage.deletePackagePartner();
            Assert.assertFalse(driver.findElement(By.xpath("//td[contains(text(),'201')]")).isDisplayed(), "Package Removed");
        } catch(Exception e) { System.out.println("Exception Occured " + e);
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 8, description="Add Override to a Partner")
    public void AddOverridePartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search(testData.getString("partnername"));
            adminDashBoardPage.addOverridePartner(testData.getString("groupname"),testData.getString("IYP"),testData.getString("AYP"));
            Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'201')]")).isDisplayed(), "Override Added");
            Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'202')]")).isDisplayed(), "Override Added");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }



    @Test(groups = { "partners", "regression", "smoke"},priority = 9, description="Delete Override to a Partner")
    public void DeleteOverridePartner(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToPartner();
            adminDashBoardPage.search(testData.getString("partnername"));
            adminDashBoardPage.deleteOverridePartner();
            Assert.assertFalse(driver.findElement(By.xpath("//td[contains(text(),'201')]")).isDisplayed(), "Override Removed");
        } catch(Exception e) { System.out.println("Exception Occured " + e);
        }
    }


}