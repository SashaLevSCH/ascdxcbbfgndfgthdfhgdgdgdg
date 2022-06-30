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

public class CareTest extends TestBase {

    public JSONObject testData = new JSONObject();
    public static final By SEARCHZIP = By.xpath("//*[@id='searchLocation.address']");

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("signup", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
        // System.out.println(testData);
    }

    @Test(groups = {"care", "regression"}, priority = 2)
    public void VerifyCrestorTX() throws Exception {
        carePage.acctLoginPage(1);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 3)
    public void VerifyTamifluARold() throws Exception {
        carePage.acctLoginPage(3);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.inputTextBy(SEARCHZIP, "AR 72212");
        carePage.verifyPercentage("info_benefitAmount", 100);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 3)
    public void VerifyIVERMECTINARold() throws Exception {
        carePage.acctLoginPage(3);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("IVERMECTIN");
        carePage.clickFromListCareByText("Ivermectin");
        //carePage.verifyCarePinOnMap(true, "We currently cannot find what this prescription should cost or its benefit");
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 4)
    public void VerifyCrestorFLold() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 100);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }


    @Test(groups = {"care", "regression"}, priority = 5)
    public void VerifyCrestorDeductibleTX() throws Exception {
        carePage.acctLoginPage(11);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "TX 75235");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("has deductible");
        carePage.verifyBenefitModuleAmounts(61, 48, 48, 0);
    }


    @Test(groups = {"care", "regression", "smoke"}, priority = 6)
    public void VerifyCrestorFLMapPrice() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPriceRXOnMap();
    }


    @Test(groups = {"care", "regression"}, priority = 7)
    public void VerifyCrestorTXnoRX() throws Exception {
        carePage.acctLoginPage(24);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyVisibleElementByText("info_benefitAmount", "$0");
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }


    @Test(groups = {"care", "regression"}, priority = 8)
    public void VerifyCrestorOH() throws Exception {
        carePage.acctLoginPage(17);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 9)
    public void VerifyTamifluDeductibleOH() throws Exception {
        carePage.acctLoginPage(18);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("has deductible");
        carePage.verifyBenefitModuleAmounts(82, 65, 65, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 10)
    public void VerifyCrestorMD() throws Exception {
        carePage.acctLoginPage(19);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("care");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 11)
    public void VerifyTamifluDeductibleMD() throws Exception {
        carePage.acctLoginPage(20);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(82, 65, 65, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 12)
    public void VerifyCialisNC() throws Exception {
        carePage.acctLoginPage(2);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("cialis");
        carePage.clickFromListCareByText("CIALIS");
        carePage.inputTextBy(SEARCHZIP, "NC 28334");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }


    @Test(groups = {"care", "regression"}, priority = 13)
    public void VerifyCrestorMS() throws Exception {
        carePage.acctLoginPage(21);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 14)
    public void VerifyTamifluDeductibleMS() throws Exception {
        carePage.acctLoginPage(22);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Tamiflu");
        carePage.clickFromListCareByText("Tamiflu");
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(82, 65, 65, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 15)
    public void VerifyCrestorTN() throws Exception {
        carePage.acctLoginPage(25);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "TN 37217");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }


    @Test(groups = {"care", "regression"}, priority = 16)
    public void VerifyFlusonePendingActivationNoRX() throws Exception {
        //htmlReport.reportStartTest("C457","VerifyFlusonePendingActivationNoRX", "VerifyFlusonePendingActivationNoRX");
        carePage.acctLoginPage(26);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("49281001310");
        carePage.clickFromListCareByText("FLUZONE 2013-2014");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("not active");
        //	carePage.verifyBenefitAmountInText("0");
    }


    @Test(groups = {"care", "regression", "smoke"}, priority = 17)
    public void VerifyCrestorNotActivewithPrescriptionFalse() throws Exception {
        carePage.acctLoginPage(26);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyVisibleElementByText("info_benefitAmount", "$0");
        carePage.verifyBenefitAmountPriceBox("not active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 18)
    public void VerifyFluzoneTXnoRX() throws Exception {
        carePage.acctLoginPage(24);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("49281001310");
        carePage.clickFromListCareByText("FLUZONE 2013-2014");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }

    //Care

    @Test(groups = {"care", "regression"}, priority = 19)
    public void VerifyKneeReplacementTX() throws Exception {
        carePage.acctLoginPage(1);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee replacement");
        carePage.clickFromListCareByText("Admission to revise hip or knee replacement");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(56995, 45596, 0, 45596);
    }

    @Test(groups = {"care", "regression"}, priority = 20)
    public void VerifyKneeReplacementDeductibleTX() throws Exception {
        carePage.acctLoginPage(11);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee replacement");
        carePage.clickFromListCareByText("Admission to revise hip or knee replacement");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(56995, 45596, 1000, 44596);
    }

    @Test(groups = {"care", "regression"}, priority = 21)
    public void VerifyXrayFL() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 22)
    public void VerifyHeartBypassAR() throws Exception {
        carePage.acctLoginPage(3);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("heart bypass");
        carePage.clickFromListCareByText("Provider fee for heart artery bypass");
        carePage.inputTextBy(SEARCHZIP, "AR 72212");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 23)
    public void VerifyKneeSurgeryTX() throws Exception {
        carePage.acctLoginPage(1);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee surgery");
        carePage.clickFromListCareByText("Radiology fee for knee x-ray");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }


    @Test(groups = {"care", "regression"}, priority = 24)
    public void VerifyKneeSurgeryDeductibleTX() throws Exception {
        carePage.acctLoginPage(11);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee surgery");
        carePage.clickFromListCareByText("Radiology fee for knee x-ray");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountInText("0");
    }


    @Test(groups = {"care", "regression"}, priority = 25)
    public void VerifyKneeSurgeryFL() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee surgery");
        carePage.clickFromListCareByText("Radiology fee for knee x-ray");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }


    @Test(groups = {"care", "regression"}, priority = 26)
    public void VerifyAnesthesiologistFL() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Anesthesiologist");
        carePage.clickFromListCareByText("Anesthesiologist time to be \"put under\" for procedure");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 27)
    public void VerifyAnesthesiologistNewUserFL() throws Exception, InterruptedException {
//        signupLogin();
        carePage.acctLoginPage(14);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Anesthesiologist");
        carePage.clickFromListCareByText("Anesthesiologist time to be \"put under\" for procedure");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("not active");
        //	carePage.verifyBenefitAmountInText("0");
    }


    @Test(groups = {"care", "regression"}, priority = 28)
    public void VerifyColonoscopyDedNC() throws Exception, InterruptedException {
        carePage.acctLoginPage(9);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.inputTextBy(SEARCHZIP, "NC 28334");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(383, 306, 306, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 29)
    public void VerifyKneeReplacementDeductibleMD() throws Exception {
        carePage.acctLoginPage(20);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee replacement");
        carePage.clickFromListCareByText("Admission to revise hip or knee replacement");
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(63269, 50615, 1000, 49615);
    }

    @Test(groups = {"care", "regression"}, priority = 30)
    public void VerifyXrayMD() throws Exception {
        carePage.acctLoginPage(19);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
    }

    @Test(groups = {"care", "regression"}, priority = 31)
    public void VerifyDoctorVisitProviderFeeCareTX() throws Exception {
        carePage.acctLoginPage(1);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Doctor visit provider fee");
        carePage.clickFromListCareByText("Doctor visit provider fee");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
        carePage.verifyCarePinOnMap();
    }

    @Test(groups = {"care", "regression"}, priority = 32)
    public void VerifyKneeReplacementDeductibleOH() throws Exception {
        carePage.acctLoginPage(18);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee replacement");
        carePage.clickFromListCareByText("Admission to revise hip or knee replacement");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(54763, 43810, 1000, 42810);
    }

    @Test(groups = {"care", "regression"}, priority = 33)
    public void VerifyXrayOH() throws Exception {
        carePage.acctLoginPage(17);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(40, 32, 0, 32);
    }

    @Test(groups = {"care", "regression"}, priority = 34)
    public void VerifyColonoscopyDedOH() throws Exception, InterruptedException {
        carePage.acctLoginPage(18);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(409, 327, 327, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 35)
    public void VerifyKneeReplacementDeductibleMS() throws Exception {
        carePage.acctLoginPage(22);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("knee replacement");
        carePage.clickFromListCareByText("Admission to revise hip or knee replacement");
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(54060, 43248, 1000, 42248);
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 36)
    public void VerifyXrayMS() throws Exception {
        carePage.acctLoginPage(21);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(39, 31, 0, 31);
    }

    @Test(groups = {"care", "regression"}, priority = 37)
    public void VerifyColonoscopyDedMS() throws Exception, InterruptedException {
        carePage.acctLoginPage(22);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.inputTextBy(SEARCHZIP, "MS 39507");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(403, 323, 323, 0);
    }

    @Test(groups = {"care", "regression", "smoke"}, priority = 38)
    public void VerifyColonoscopyDedMD() throws Exception, InterruptedException {
        carePage.acctLoginPage(20);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("colonoscopy");
        carePage.clickFromListCareByText("Provider fee for diagnostic colonoscopy");
        carePage.inputTextBy(SEARCHZIP, "MD 20833");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitModuleAmounts(472, 378, 378, 0);
    }

    @Test(groups = {"care", "regression"}, priority = 39)
    public void VerifyXrayTN() throws Exception {
        carePage.acctLoginPage(25);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "TN 37217");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(38, 31, 0, 31);
    }

    @Test(groups = {"care", "AZ", "regression"}, priority = 39)
    public void VerifyXrayAZ() throws Exception {
        carePage.acctLoginPage(27);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "AZ 86401");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(44, 35, 0, 35);
    }

    @Test(groups = {"care", "AZ", "regression"}, priority = 39)
    public void VerifyMaternityAZ() throws Exception {
        carePage.acctLoginPage(27);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.inputTextBy(SEARCHZIP, "AZ 86401");
        carePage.verifyPercentage("info_benefitAmount", 0);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(176, 0, 0, 0);
    }

    @Test(groups = {"care", "FL", "regression"}, priority = 40)
    public void VerifyMaternityFL() throws Exception {
        carePage.acctLoginPage(8);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 0);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(172, 0, 0, 0);
    }

    @Test(groups = {"care", "FL", "regression"}, priority = 41)
    public void VerifyMaternityFlnew() throws Exception {
        carePage.acctLoginPage(28);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.inputTextBy(SEARCHZIP, "FL 33133");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(171, 137, 0, 137);
    }

    @Test(groups = {"care", "UT", "regression"}, priority = 39)
    public void VerifyXrayUT() throws Exception {
        carePage.acctLoginPage(29);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "UT 84098");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(43, 35, 0, 35);
    }

    @Test(groups = {"care", "UT", "regression"}, priority = 39)
    public void VerifyMaternityUT() throws Exception {
        carePage.acctLoginPage(29);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.inputTextBy(SEARCHZIP, "UT 84098");
        carePage.verifyPercentage("info_benefitAmount", 0);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(174, 0, 0, 0);
    }

    @Test(groups = {"care", "regression", "UT"}, priority = 8)
    public void VerifyCrestorUT() throws Exception {
        carePage.acctLoginPage(29);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "UT 84098");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "regression"}, priority = 40)
    public void VerifyEpisodeOfCareTX() throws Exception {
        carePage.acctLoginPage(1);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Colonoscopy at an Outpatient Hospital");
        carePage.clickFromListCareByText("Colonoscopy at an Outpatient Hospital");
        carePage.inputTextBy(SEARCHZIP, "TX 75006");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(1700, 1360, 0, 1360);
    }

    @Test(groups = {"care", "OH", "regression", "smoke"}, priority = 39)
    public void VerifyXrayUT100() throws Exception {
        carePage.acctLoginPage(30);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("x-ray");
        carePage.clickFromListCareByText("Radiology fee for chest x-ray");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 100);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(40, 40, 0, 40);
    }

    @Test(groups = {"care", "OH", "regression"}, priority = 39)
    public void VerifyMaternityUT100() throws Exception {
        carePage.acctLoginPage(30);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Radiology fee for pregnant uterus ultrasound");
        carePage.clickFromListCareByText("Radiology fee for pregnant uterus ultrasound");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 0);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(160, 0, 0, 0);
    }

    @Test(groups = {"care", "regression", "Smoke", "OH"}, priority = 8)
    public void VerifyCrestorUT100() throws Exception {
        carePage.acctLoginPage(30);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("crestor");
        carePage.clickFromListCareByText("CRESTOR");
        carePage.inputTextBy(SEARCHZIP, "OH 44004");
        carePage.verifyPercentage("info_benefitAmount", 100);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyCarePriceWithSideCar(1);
    }

    @Test(groups = {"care", "SC", "regression"}, priority = 41)
    public void VerifyMaternitySCnew() throws Exception {
        carePage.acctLoginPage(34);
        carePage.clickEstimateLink();
        carePage.clickCareSearch("Provider fee for vaginal birth");
        carePage.clickFromListCareByText("Provider fee for vaginal birth");
        carePage.inputTextBy(SEARCHZIP, "SC 29440");
        carePage.verifyPercentage("info_benefitAmount", 80);
        carePage.verifyBenefitAmountPriceBox("active");
        carePage.verifyBenefitModuleAmounts(2737, 2190, 0, 2190);
    }
}
