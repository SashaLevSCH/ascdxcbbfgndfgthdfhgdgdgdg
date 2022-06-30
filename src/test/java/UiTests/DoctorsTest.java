package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static utils.Utilities.readTestData;
import pages.CarePages.CarePage.*;
import pages.DoctorsPages.DoctorsPage.*;
import pages.LoginPages.LoginPage.*;

import pages.DoctorsPages.DoctorsPage.*;

public class DoctorsTest extends TestBase {

    public JSONObject testData = new JSONObject();

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("signup", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        // System.out.println(testData);
    }



    @Test(groups = { "doctor", "regression", "smoke"})
    public void LoginTest(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("c1234",methodname, "Login");
            loginPages.login(testData.getString("url"),testData.getString("userName"),testData.getString("password") );
           // htmlReport.reportStartTest("c1233",scenarioName, "Search with Specialities");
            doctorsPage.SearchBySpecialities(testData.getJSONArray("specialities"));

        }catch(Exception e) { System.out.println("Exception Occured " + e); }
    }


    @Test(groups = { "doctor", "regression", "smoke"},priority = 0, enabled = true)
    public void VerifyDoctorDavidWallis() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("Method name is: "+methodname);
        //htmlReport.reportStartTest("T28393", methodname, "Validate Doctors");
        doctorsPage.searchDoctor(1,"Torrance, CA", "David Wallis");
        loginPages.clickByXpathElement(doctorsPage.DOCTORNAME);
        Assert.assertTrue(driver.findElement(loginPages.OVERVIEW_TEXT).isDisplayed(), "OVERVIEW_TEXT");
        Assert.assertTrue(driver.findElement(loginPages.COST_TEXT).isDisplayed(), "COST_TEXT");
        Assert.assertTrue(driver.findElement(loginPages.REVIEWS_TEXT).isDisplayed(), "REVIEWS_TEXT");
        Assert.assertTrue(driver.findElement(loginPages.BOOKMARK).isDisplayed(), "BOOKMARK");
        Assert.assertTrue(driver.findElements(doctorsPage.DOCTORCARDNAME).size()==1, "DOCTORCARDNAME");
        loginPages.clickByXpathElement(loginPages.BOOKMARK);
        Assert.assertTrue(driver.findElement(loginPages.BOOKMARK).isDisplayed(), "BOOKMARKED");
//        Assert.assertTrue(driver.findElements(DOCTORIMGCARD).size()==1, "DOCTOR IMG");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORNAME).isDisplayed(), "Doctor name");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORADDRESS).isDisplayed(), "Doctor address");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORSTARS).isDisplayed(), "Doctor stars");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORREVIEW).isDisplayed(), "Doctor review");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORCARDMAP).isDisplayed(), "Doctor map");
        Assert.assertTrue(driver.findElement(doctorsPage.PRIMARYADDRESS).isDisplayed(), "PRIMARY ADDRESS");
        Assert.assertTrue(driver.findElement(doctorsPage.OTHERADDRESS).isDisplayed(), "OTHER ADDRESS");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORADDRESSMAP).isDisplayed(), "DOCTOR ADDRESS MAP");
        Assert.assertTrue(driver.findElement(doctorsPage.DOCTORPHONEMAP).isDisplayed(), "DOCTOR PHONE MAP");
    }

    @Test(groups = { "doctor", "regression", "smoke"},priority = 1, enabled = true)
    public void VerifyDoctorDavidWallisBookMarked() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("Method name is:"+methodname);
        //htmlReport.reportStartTest("T28394",methodname,  "Look for doctor David Wallis");
        doctorsPage.searchDoctor(1,"Torrance, CA", "David Wallis");
        loginPages.clickByXpathElement(doctorsPage.DOCTORNAME);
        if(driver.findElements(loginPages.BOOKMARKED).size()==0){
            loginPages.clickByXpathElement(loginPages.BOOKMARK);
            Assert.assertTrue(driver.findElement(loginPages.BOOKMARKED).isDisplayed(), "BOOKMARKED");
        }
        doctorsPage.clickDoctorsLink();
        WebElement element1 = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(doctorsPage.BOOKMARKED_DOCTORS)));
        driver.findElement(doctorsPage.BOOKMARKED_DOCTORS);
        Assert.assertEquals(element1.getText(), "Bookmarked Doctors", "Bookmarked Doctors");
        Assert.assertTrue(driver.findElement(loginPages.BOOKMARKED_DOCTORS_NAMES2).getAttribute("innerText").contains("David Wallis")||driver.findElement(loginPages.BOOKMARKED_DOCTORS_NAMES).getAttribute("innerText").contains("David Wallis"), "BOOKMARKED_DOCTORS_NAMES");
    }

    @Test(groups = { "doctor", "regression", "smoke"},priority = 3, enabled = false)
    public void VerifyDoctorDavidWallisBookMarkedTemp() throws Exception {
        carePage.acctLoginPage(1);
        doctorsPage.clickDoctorsLink();
        loginPages.clickByXpathElement(doctorsPage.FAMILYPRACTISE);
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("(//div[@style='color: rgb(255, 255, 255); font-size: 1.6rem; font-family: Roboto, Arial, sans-serif;'][contains(.,'13')])[1]"));
        WebElement element3dot = driver.findElement(By.xpath("//div[@style='z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        executor.executeScript("arguments[0].click();", element);
        element.click();
        Assert.assertTrue(driver.findElements(By.xpath("13")).size()==1);
        executor.executeScript("arguments[0].click();", element3dot);
        Assert.assertTrue(driver.findElements(By.xpath("3dot")).size()>=1);
    }
}
