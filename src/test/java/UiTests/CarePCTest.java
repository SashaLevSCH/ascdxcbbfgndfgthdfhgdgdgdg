package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;
import pages.CarePages.CarePage.*;
import pages.DoctorsPages.DoctorsPage.*;
import pages.LoginPages.LoginPage.*;

import static utils.Utilities.readTestData;

public class CarePCTest extends TestBase {

    public JSONObject testData = new JSONObject();
    public static final By SEARCHZIP = By.xpath("//*[@id='searchLocation.address']");


    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("signup", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        // System.out.println(testData);
    }


    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority=0, enabled=false)
    public void PreviewCoverageCareTestMaternity(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("C1234",methodname, "Preview Coverage verify search results with care category");
           loginPages.launchUrl(previewCovUrl);
           carePage.estimatecare(testData.getJSONArray("CareTypes"),"Yes","75235");
        }catch(Exception e) { System.out.println("Exception Occured " + e); }
    }

    @Test(groups = { "previewCoverage", "care","regression", "smoke"},priority=1)
    public void CareSearchTestMaternityPreviewPage(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("C26",methodname, "Check if maternity care items show up when search criteria = Male");
            loginPages.launchUrl(previewCovUrl);
            carePage.CareItemSearch(testData.getString("Gender"), testData.getBoolean("IsDisplayed"), testData.getJSONArray("CareTypes"), "Yes","75235");
        }catch(Exception e) { System.out.println("Exception Occured " + e); }
    }


    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority = 2)
    public void VerifyPrevCovColonoscopyCareTX() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority = 3)
    public void VerifyPrevCovCrestorTx() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextByJs("searchLocation.address", "TX 75006");
        carePage.clickCareSearch("CRESTOR");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority = 4)
    public void VerifyPrevCovColonoscopyCA() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "90001");
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 5)
    public void VerifyPrevCovCrestorCA() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "90001");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority = 6)
    public void VerifyPrevCovProviderBirthTX() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "TX 75235");
        carePage.clickCareSearch("vaginal birth");
        carePage.clickFromListCareByText("Provider fee for vaginal birth");
        carePage.verifyPercentage( "info_benefitAmount", 80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage OR this service is rendered during a complication in pregnancy.");
    }


    @Test(groups = { "care", "previewCoverage", "regression", "FL", "smoke"},priority = 7)
    public void VerifyPrevCovTamifluFL() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.clickCareSearch("tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression", "smoke"},priority = 8)
    public void VerifyPrevCovProviderBirthCA() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "CA 90277");
        carePage.clickCareSearch("vaginal birth");
        carePage.clickFromListCareByText("Provider fee for vaginal birth");
        carePage.verifyPercentage( "info_benefitAmount", 80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage OR this service is rendered during a complication in pregnancy.");
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 9)
    public void VerifyPrevCovProviderLabUrineCA() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "CA 90277");
        carePage.clickCareSearch("Lab fee for urine test");
        carePage.clickFromListCareByText("Lab fee for urine test");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 10)
    public void VerifyPrevCovTamifluAL() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "AL 35215");
        carePage.clickCareSearch("tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 42)
    public void VerifyPrevCovCialisOK() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "OK 73112");
        carePage.clickCareSearch("cialis");
        carePage.clickFromListCareByText("CIALIS");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 43)
    public void VerifyPrevCovAspirinNC() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "NC 28334");
        carePage.clickCareSearch("aspirin");
        carePage.clickFromListCareByText("ASPIRIN EC");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "care", "previewCoverage", "regression" },priority = 44)
    public void VerifyPrevCovTylenolMD() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.clickCareSearch("tylenol");
        carePage.clickFromListCareByText("TYLENOL-CODEINE NO.3");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "care", "previewCoverage", "regression" },priority = 45)
    public void VerifyPrevCovTylenolMS() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.clickCareSearch("tylenol");
        carePage.clickFromListCareByText("TYLENOL-CODEINE NO.3");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "care", "previewCoverage", "regression", "AZ"},priority = 46)
    public void VerifyPrevCovCrestorAZ() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "AZ 86401");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 47)
    public void VerifyPrevCovCrestorKY() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "KY 40217");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 48)
    public void VerifyPrevCovRadiologyultrasoundKY() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "KY 40217");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 49)
    public void VerifyPrevCovCrestorAR() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "AR 72212");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 50)
    public void VerifyPrevCovRadiologyultrasoundAR() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "Little Rock, AR 72227, USA");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }


    @Test(groups = { "care", "previewCoverage", "regression" },priority = 51)
    public void VerifyPrevCovCrestorGA() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, " GA 31405");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression1", "GA" },priority = 52)
    public void VerifyPrevCovRadiologyultrasoundGA() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, " GA 31405");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }


    @Test(groups = { "care", "previewCoverage", "regression", "IN" },priority = 53)
    public void VerifyPrevCovCrestorIN() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "IN 46323");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }


    @Test(groups = { "care", "previewCoverage", "regression", "IN" },priority = 54)
    public void VerifyPrevCovRadiologyultrasoundIN() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage. inputTextBy(SEARCHZIP, " Hammond, IN 46323");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }


    @Test(groups = { "care", "AZ", "previewCoverage", "regression" },priority = 55)
    public void VerifyPrevCovRadiologyultrasoundAZ() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, " AZ 86401");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",0);
        carePage.verifyElementByText("Routine abdominal ultrasound of a pregnant uterus");
    }

    @Test(groups = { "previewCoverage", "regression", "CA" },priority = 56)
    public void VerifyPrevCovRadiologyUltrasoundCA() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "CA 90277");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",0);
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='sc-hqyNC dbCukp' and contains(., '$0')]")).isDisplayed());
    }


    @Test(groups = { "previewCoverage", "regression", "TX" },priority = 57)
    public void VerifyPrevCovRadiologyultrasoundTX() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }

    @Test(groups = { "previewCoverage", "regression" },priority = 58)
    public void VerifyPrevCovRadiologyultrasoundTN() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "TN 37217");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }

    @Test(groups = { "previewCoverage", "TN", "regression" },priority = 59)
    public void VerifyPrevCovProviderBirthTN() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "TN 37217");
        carePage.clickCareSearch("vaginal birth");
        carePage.clickFromListCareByText("Provider fee for vaginal birth");
        carePage.verifyPercentage( "info_benefitAmount", 80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage OR this service is rendered during a complication in pregnancy.");
    }


    @Test(groups = { "previewCoverage", "TN", "regression" },priority = 60)
    public void VerifyPrevCovCrestorTN() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "TN 37217");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "previewCoverage", "FL", "regression" },priority = 59)
    public void VerifyPrevCovProviderBirthFL() throws Exception {
        driver.navigate().to(previewCovUrl);
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.clickCareSearch("vaginal birth");
        carePage.clickFromListCareByText("Provider fee for vaginal birth");
        carePage.verifyPercentage( "info_benefitAmount", 80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage OR this service is rendered during a complication in pregnancy.");
    }

    @Test(groups = { "previewCoverage", "FL", "regression" },priority = 57)
    public void VerifyPrevCovRadiologyultrasoundFL() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("This specific service will only be covered if your plan includes maternity coverage.");
    }

    @Test(groups = { "previewCoverage", "regression", "UT"},priority = 58)
    public void VerifyPrevCovCrestorUT() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "UT 84098");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "UT", "previewCoverage", "regression" },priority = 59)
    public void VerifyPrevCovRadiologyultrasoundUT() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "UT 84098");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",0);
        carePage.verifyElementByText("Routine abdominal ultrasound of a pregnant uterus");
    }

    @Test(groups = { "SC", "previewCoverage", "regression",},priority = 58)
    public void VerifyPrevCovCrestorSC() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(10);
        carePage.inputTextBy(SEARCHZIP, "SC 29440");
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.verifyPercentage( "info_benefitAmount", 80);
    }

    @Test(groups = { "SC", "previewCoverage", "regression", "maternity" },priority = 59)
    public void VerifyPrevCovRadiologyultrasoundSC() throws Exception {
        driver.navigate().to(previewCovUrl);
        carePage.jsWaitForPageToLoad(5);
        carePage.inputTextBy(SEARCHZIP, "SC 29440");
        carePage.clickCareSearch("radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.verifyPercentage( "info_benefitAmount",80);
        carePage.verifyElementByText("Routine abdominal ultrasound of a pregnant uterus");
    }

}
