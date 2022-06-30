package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static utils.Utilities.readTestData;

public class PartnerTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("patnerpage", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        Constants.jsonString = readTestData("getQuotePrimary", "src/test/resources/TestData/QAData.json").toString();
        partnercredentials = new JSONObject(Constants.jsonString);
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 0, description="Partner  Login")
    public void PartnerLoginTest(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("C1234",methodname, "Group Login");
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Dashboard')]")).isDisplayed(), "Dashboard");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Get quote')]")).isDisplayed(), "Get Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Account')]")).isDisplayed(), "Accounts");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Refer your clients to your custom Sidecar Health link')]")).isDisplayed(), "Link");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Next step: Upload your W-9 to get paid')]")).isDisplayed(), "W9 Area");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
             }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 2, description="Create Manual Quote")
    public void CreateManualQuote(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.calculateQuote(partnercredentials.getString("firstName"), partnercredentials.getString("lastName"),partnercredentials.getString("email"),partnercredentials.getString("dob"),partnercredentials.getString("zip"));
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 3, description="View Last Quote")
    public void ViewLastQuote(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.viewLastQuote();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/saksun2003')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_maternityCareCovered_0']/span[@class='sc-hrWEMg ePWbfz sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 4, description="Upload Census")
    public void uploadNewCensus(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.uploadNewCensus();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/saksun2003')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_maternityCareCovered_0']/span[@class='sc-hrWEMg ePWbfz sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 5, description="Upload List")
    public void uploadList(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.uploadList();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/saksun2003')]")).isDisplayed(), "Text is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Individual quotes']")).isDisplayed(), "Individual Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Export as PDF']")).isDisplayed(), "Export as PDF");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Upload new census']")).isDisplayed(), "Upload new census");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers maternity care']/parent::div//following-sibling::div[@data-qaid='info_maternityCareCovered_0']/span[@class='sc-hrWEMg ePWbfz sidecon-x']")).isDisplayed(), "Maternity not Covered in Quote");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Covers necessary care']/parent::div//following-sibling::div[@data-qaid='info_necessaryCareCovered_0']/span[@class='sc-hrWEMg UufZD sidecon-checkmark']")).isDisplayed(), "Covers Necessary Care");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 6, description="Accounts Section Layout")
    public void navigatetoAccount(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.navigatetoAccount();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'/account/profile')]")).isDisplayed(), "Profile is Displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'/account/profile/details')]")).isDisplayed(),"Details Tab");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'/account/profile/licenses')]")).isDisplayed(),"Licenses Tab");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'/account/profile/security')]")).isDisplayed(),"Security Tab");
            Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Save changes']")).isDisplayed(), "Save Changes");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 7, description="Group Section Layout")
    public void navigatetoGroup(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.navigatetoGroup();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Groups')]")).isDisplayed(), "Group title is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sc-jhAzac brXkFX sidecon-edit']")).isDisplayed(),"Edit Button");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'saksun2003')]")).isDisplayed(), "Default Group Link");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 8, description="Add Group")
    public void addGroupLayout(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.navigatetoGroup();
            partnerGroup.addGroupLayout();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Groups')]")).isDisplayed(), "Group title is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sc-jhAzac brXkFX sidecon-edit']")).isDisplayed(),"Edit Button");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'saksun2003')]")).isDisplayed(), "Default Group Link");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 9, description="Edit Group, update Firstname and Slug URL")
    public void editGroup(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.navigatetoGroup();
            partnerGroup.editGroup();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Groups')]")).isDisplayed(), "Group title is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='sc-jhAzac brXkFX sidecon-edit']")).isDisplayed(),"Edit Button");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'saksun2003')]")).isDisplayed(), "Default Group Link");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 10, description="URL Taken")
    public void urlTaken(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.navigatetoGroup();
            partnerGroup.urlTaken();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Custom url is taken.')]")).isDisplayed(), "Group title is displayed");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 11, description="Required Field in Quotation")
    public void requiredFields(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.requiredFieldError(partnercredentials.getString("firstName"), partnercredentials.getString("lastName"),partnercredentials.getString("email"),partnercredentials.getString("dob"),partnercredentials.getString("zip"));
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'This is a required field')]")).isDisplayed(), "This is a required field");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 12, description="Upload file in correct format in Quote Page")
    public void uploadInvalidFileQuote(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.uploadInvalidFilequote();
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your file must be a csv or xlsx']")).isDisplayed(), "Upload valid file");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "partners", "regression", "smoke"},priority = 13, description="Upload file in correct format in Estimate Page")
    public void uploadInvalidFileEstimate(){
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            loginPages.login(testData.getString("patnerurl"),testData.getString("patneruserName"),testData.getString("patnerpassword") );
            partnerGroup.uploadInvalidFileestimate();
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your file must be a csv or xlsx']")).isDisplayed(), "Upload valid file");
        } catch(Exception e) { System.out.println("Exception Occured " + e); Assert.fail("Assertion failed");
        }
    }
}
