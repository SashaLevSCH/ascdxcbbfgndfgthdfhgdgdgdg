package UiTests;
import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static utils.Utilities.readTestData;

public class GroupTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("grppage", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        Constants.jsonString = readTestData("getQuotePrimary", "src/test/resources/TestData/QAData.json").toString();
        partnercredentials = new JSONObject(Constants.jsonString);
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 1, description="Group  Login")
    public void GroupLoginTest(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("C1234",methodname, "Group Login");
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Get quote')]")).isDisplayed(), "Get Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Account')]")).isDisplayed(), "Accounts");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Share your custom Sidecar Health link with your employees')]")).isDisplayed(), "Link");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 2, description="Create Manual Quote")
    public void CreateManualQuote(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.calculateQuote(partnercredentials.getString("firstName"), partnercredentials.getString("lastName"),partnercredentials.getString("email"),partnercredentials.getString("dob"),partnercredentials.getString("zip"));
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 3, description="View Last Quote")
    public void ViewLastQuote(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.viewLastQuote();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/helloworld')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_pkg_maternityCareCovered_0']/span[@class='sc-jtRfpW koklXs sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_pkg_necessaryCareCovered_0']/span[@class='sc-jtRfpW gUAiIg sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 4, description="Upload Census")
    public void uploadNewCensus(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.uploadNewCensus();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/helloworld')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_pkg_maternityCareCovered_0']/span[@class='sc-jtRfpW koklXs sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_pkg_necessaryCareCovered_0']/span[@class='sc-jtRfpW gUAiIg sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 5, description="Upload List")
    public void uploadList(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.uploadList();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/helloworld')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_pkg_maternityCareCovered_0']/span[@class='sc-jtRfpW koklXs sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_pkg_necessaryCareCovered_0']/span[@class='sc-jtRfpW gUAiIg sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 6, description="Accounts Section Layout")
    public void navigatetoAccount(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.navigatetoAccount();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'/account/profile')]")).isDisplayed(), "Profile is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Optional: Upload a logo to your landing page']")).isDisplayed(), "Upload Logo");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Upload group logo']")).isDisplayed(), "Upload group Logo button");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Save changes']")).isDisplayed(), "Save Changes");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }
    @Test(groups = { "groups", "regression", "smoke"},priority = 7, description="UploadLogo")
    public void uploadLogo(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.uploadLogo("Acorns Logo_Full.png");
            Assert.assertTrue(driver.findElement(By.xpath("//img[@data-qaid='input_logoImage']")).isDisplayed(), "Logo is Displayed");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 8, description="InvalidUploadLogo")
    public void invaliduploadLogo(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.uploadLogo("invalid.png");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Please make sure the image is ~65px tall')]")).isDisplayed(), "Error is Displayed");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "groups", "regression", "smoke"},priority = 9, description="InvalidUploadLogoTypeFile")
    public void invaliduploadLogoTypeFile(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("grpurl"),testData.getString("grpuserName"),testData.getString("grppassword") );
            partnerGroup.uploadLogo("doctor_db.json");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your file must be a JPG, GIF, or PNG')]")).isDisplayed(), "Error is Displayed");
        }catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }
}
