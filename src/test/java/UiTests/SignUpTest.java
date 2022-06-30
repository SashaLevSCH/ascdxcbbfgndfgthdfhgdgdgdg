package UiTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import core.TestBase;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.*;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.JsonPathUtil.*;
import static utils.Utilities.*;
import pages.SignUpPages.*;
import utils.FakeName.*;
import pages.CarePages.CarePage.*;
import pages.DoctorsPages.DoctorsPage.*;
import pages.LoginPages.LoginPage.*;

public class SignUpTest extends TestBase {


    public JSONObject testData = new JSONObject();

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("signup", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
       // System.out.println(testData);
    }


    @Test(groups = { "signup", "regression", "smoke"},priority=64)
    public void SignupTestOnlyPrimary(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("91",methodname, "Signup with adding a Primary");
            loginPages.launchUrl(testData.getString("url"));
            loginPages.TrustPilotCheck();
            signUpPage.signupByZip(testData.getString("zip"));
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),1,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.SeeQuotes();
            signUpPage.SelectPackage(testData.getString("Package"));
            signUpPage.SaveQuotes(testData.getString("State"));
            paymentPage.Address(testData.getString("Address"));
            paymentPage.PaymentByCard(testData.getString("CardHolderName"),testData.getString("CardNo"),testData.getString("CVC"),testData.getString("Exp"),testData.getString("zip"));
            signUpPage.EnterSSN(testData.getInt("Dependants"));
            signUpPage.AutoPayment();
            signUpPage.Disclosures();
            signUpPage.Completeapplication();
            loginPages.logout();
        }catch(Exception e) { System.out.println("Exception Occured " + e); }
    }

    @Test(groups = { "signup", "regression" },priority=65)
    public void SignupTestwithoneDependant() throws Exception {
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
         // htmlReport.reportStartTest("90",methodname, "Signup with Primary and Dependant");
            loginPages.launchUrl(testData.getString("url"));
            signUpPage.signupByZip(testData.getString("zip"));
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),1,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.CoverDependant();
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),2,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.SeeQuotes();
            signUpPage.SelectPackage(testData.getString("Package"));
            signUpPage.SaveQuotes(testData.getString("State"));
            paymentPage.Address(testData.getString("Address"));
            paymentPage.PaymentByCard(testData.getString("CardHolderName"),testData.getString("CardNo"),testData.getString("CVC"),testData.getString("Exp"),testData.getString("zip"));
            signUpPage.EnterSSN(2);
            signUpPage.Disclosures();
            signUpPage.Completeapplication();
            loginPages.logout();
        }catch(Exception e) { System.out.println("Exception Occured " + e);
           // htmlReport.reportPassFail(" Scenario : Signup with Primary and Dependant Failed due to :"+e,
                  //  "true", "False");
            }
    }

    @Test(groups = { "signup", "regression" },priority=66)
    public void SignupTestwithDependantonly(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("92",methodname, "Non-Covered Primary Flow");
            loginPages.launchUrl(testData.getString("url"));
            signUpPage.signupByZip(testData.getString("zip"));
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),1,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.CoverDependant();
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),2,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.SeeQuotes();
            signUpPage.SelectPackage(testData.getString("Package"));
            signUpPage.SaveQuotes(testData.getString("State"));
            paymentPage.Address(testData.getString("Address"));
            paymentPage.PaymentByCard(testData.getString("CardHolderName"),testData.getString("CardNo"),testData.getString("CVC"),testData.getString("Exp"),testData.getString("zip"));
            signUpPage.EnterSSN(1);
            signUpPage.AutoPayment();
            signUpPage.Disclosures();
            signUpPage.Completeapplication();
            loginPages.logout();
        }catch(Exception e) { System.out.println("Exception Occured " + e); }

    }

    @Test(groups = { "signup", "regression" },priority=67)
    public void SignupwithNocoverageState(){
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            //htmlReport.reportStartTest("C169",methodname, "Non-Covered State");
            Thread.sleep(5000);
            loginPages.launchUrl(testData.getString("url"));
            System.out.println();
            signUpPage.signupByZip(testData.getString("zip"));
            signUpPage.PrimaryForm(testData.getString("State"), testData.getString("Gender"), testData.getString("SelfCoverage"),1,testData.getString("procedures"),(testData.getJSONArray("MedicalPro")));
            signUpPage.SeeQuotes();
            signUpPage.SelectPackage(testData.getString("Package"));
            signUpPage.SaveQuotes(testData.getString("State"));
            signUpPage.CheckInvaidzipMsg();
        }catch(Exception e) { System.out.println("Exception Occured " + e); }

    }

    @Test(groups = { "signup",  "TX", "regression", "smoke"},priority = 0)
    public void VerifyNewSignUpMale40() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$189", "$235", "$339", "$209");
    }


    @Test(groups = { "signup", "TX","regression" },priority = 1)
    public void VerifyNewSignUpFemale50() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 50, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$215", "$265", "$405", "$235");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 2)
    public void VerifyNewSignUpFemale20() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 20, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$165", "$195", "$265", "$179");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 3)
    public void VerifyNewSignUpFemale30() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
       // //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 30, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$215", "$289", "$189");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 4)
    public void VerifyNewSignUpFemale30Pregnant() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
       // //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 30, true, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$215", "$289", "$189");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 5)
    public void VerifyNewSignUpMale40Cancer() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 40, false, true, false, false, "");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 6)
    public void VerifyNewSignUpMale40DeviceDep() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
       // //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 40, false, false, false, true, "");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 7)
    public void VerifyNewSignUpFemale30Tobacco() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TX 75006", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$259", "$315", "$435", "$285");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 8)
    public void VerifyNewSignUpFamilyDep1() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroup("TX 75006", 40, 25, 0);
        signUpPage.verifyPlanPagePrice("$354", "$434", "$604", "$394");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 9)
    public void VerifyNewSignUpFamilyDep2() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
      //  //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroup("TX 75006", 40, 50, 30);
        signUpPage.verifyPlanPagePrice("$573", "$709", "$1,015", "$633");
    }

    @Test(groups = { "signup", "OK","regression", "smoke"},priority = 11)
    public void VerifyNewSignUpFemale50OK() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OK 73112", 50, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$215", "$269", "$409", "$239");
    }

    @Test(groups = { "signup","AL", "regression", "smoke"},priority = 12)
    public void VerifyNewSignUpFemale20AL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AL 35215", 20, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$159", "$195", "$255", "$175");
    }

    @Test(groups = { "signup", "GA","regression", "smoke"},priority = 13)
    public void VerifyNewSignUpFemale30GA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
       // //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("GA 31405", 30, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$169", "$205", "$285", "$189");
    }

    @Test(groups = { "signup","KY", "regression", "smoke"},priority = 14)
    public void VerifyNewSignUpFemale30PregnantKY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("KY 41031", 30, true, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$209", "$285", "$189");
    }

    @Test(groups = { "signup", "TN", "regression", "smoke"},priority = 18)
    public void VerifyNewSignUpFamilyDep1TN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroup("TN 37217", 40, 25, 0);
        signUpPage.verifyPlanPagePrice("$350", "$420", "$584", "$380");
    }

    @Test(groups = { "signup", "SC", "regression", "smoke"},priority = 19)
    public void VerifyNewSignUpFamilyDep2SC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroup("SC 29440", 40, 50, 30);
        signUpPage.verifyPlanPagePrice("$573", "$709", "$1,015", "$633");
    }

    @Test(groups = { "signup", "SC","maternity","regression", "smoke"},priority = 25, enabled = true)
    public void VerifyMaternityPriceFemale30SC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("189", 45, 2,"SC 29440", 30, true,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "NC","regression", "smoke"},priority = 20)
    public void VerifyNewSignUpFemale30TobaccoNC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("NC 28334", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$255", "$305", "$415", "$275");
    }

    @Test(groups = { "signup", "TX","regression" },priority = 21)
    public void VerifyNewSignUpFemale30TXBUDGET() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("TX 75006", 30, false, false, false, false, 1);
    }

    @Test(groups = { "signup", "TX","regression" },priority = 22)
    public void VerifyNewSignUpFemale30TXStandart() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("TX 75006", 30, false, false, false, false, 2);
    }

    @Test(groups = { "signup", "TX","regression" },priority = 23)
    public void VerifyNewSignUpFemale30TXPremium() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("TX 75006", 30, false, false, false, false, 3);
    }

    @Test(groups = { "signup", "TX","regression" },priority = 24, enabled = true)
    public void VerifyNewSignUpFemale30TXCustom() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("TX 75006", 30, false, false, false, false, 4);
    }

    @Test(groups = { "signup", "TX","maternity","regression", "smoke"},priority = 25, enabled = true)
    public void VerifyMaternityPriceFemale30TX() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("189", 45, 2,"TX 75235", 30, true,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "AL","maternity","regression", "smoke"},priority = 26, enabled = true)
    public void VerifyMaternityPriceFemale35AL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("195", 45, 2,"AL 35215", 35, true,false, false, false, false, 4);

    }

    @Test(groups = { "signup", "maternity","regression" },priority = 25, enabled = false)
    public void VerifyExistedUserMaternity() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupMaternity(false, false, false, false);
        signUpPage.verifyPlanPagePrice("$364", "$450", "$624", "$398");
    }


    @Test(groups = { "signup", "maternity","regression" },priority = 26, enabled = false)
    public void VerifyExistedUserDependMaternity() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroupMaternity(30, 0);
        signUpPage.verifyPlanPagePrice("$350", "$424", "$574", "$378");
    }

    @Test(groups = { "signup", "maternity","regression" },priority = 27, enabled = false)
    public void VerifyExistedUserDepend2Maternity() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroupMaternity(30, 40);
        signUpPage.verifyPlanPagePrice("$539", "$659", "$909", "$587");
    }

    @Test(groups = { "signup", "maternity","regression" },priority = 28, enabled = false)
    public void VerifyExistedUserMaternityAL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupMaternityAl(false, false, false, false);
        signUpPage.verifyPlanPagePrice("$364", "$450", "$624", "$398");
    }

    @Test(groups = { "signup","maternity", "regression" },priority = 29, enabled = false)
    public void VerifyExistedUserDependMaternityAL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroupMaternityAl(30, 0);
        signUpPage.verifyPlanPagePrice("$328", "$400", "$530", "$360");
    }


    @Test(groups = { "signup", "maternity","regression" },priority = 30, enabled = false)
    public void VerifyExistedUserDepend2MaternityAL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroupMaternityAl(30, 40);
        signUpPage.verifyPlanPagePrice("$539", "$659", "$909", "$587");
    }

    @Test(groups = { "signup", "TX","healthquestions", "regression", "smoke"},priority = 31, enabled = true)
    public void VerifyFilingsQuestionsTX() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("TX 75006");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Texas are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }


    @Test(groups = { "signup", "OK","healthquestions", "regression" },priority = 32, enabled = true)
    public void VerifyFilingsQuestionsOK() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("OK 73112");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Oklahoma are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "AL","healthquestions", "regression" },priority = 34, enabled = true)
    public void VerifyFilingsQuestionsAL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("AL 35215");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Alabama are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "GA","healthquestions", "regression" },priority = 35, enabled = true)
    public void VerifyFilingsQuestionsGA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("GA 30331");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Georgia are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "KY","healthquestions", "regression" },priority = 36, enabled = true)
    public void VerifyFilingsQuestionsKY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("KY 41031");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Kentucky are underwritten by Sirius America Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "IN","healthquestions", "regression" },priority = 37, enabled = true)
    public void VerifyFilingsQuestionsIN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("IN 46323");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByTextBoolean(true, "Please be honest with your answers. We will use this information to fill in your application if you choose to apply after receiving a quote.");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Indiana are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "AR","healthquestions", "regression" },priority = 38, enabled = true)
    public void VerifyFilingsQuestionsAR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("AR 72212");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Arkansas are underwritten by Sirius America Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "TN", "healthquestions", "regression2" },priority = 39, enabled = true)
    public void VerifyFilingsQuestionsTN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("TN 37217");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByTextBoolean(true, "Please be honest with your answers. We will use this information to fill in your application if you choose to apply after receiving a quote.");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Tennessee are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "SC","healthquestions", "regression" },priority = 40, enabled = true)
    public void VerifyFilingsQuestionsSC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("SC 29440");
        signUpPage.verifyElementByTextBoolean(true,"Are you currently");
        signUpPage.verifyElementByTextBoolean(true,"Pregnant");
        signUpPage.verifyElementByTextBoolean(true,"Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true,"Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true,"Have you in the past 5 years been diagnosed with or treated for any of the following");
        signUpPage.verifyElementByTextBoolean(true, "Cancer");
        signUpPage.verifyElementByTextBoolean(true, "AIDS/HIV");
        signUpPage.verifyElementByTextBoolean(true, "Diabetes");
        signUpPage.verifyElementByTextBoolean(true, "Transplant");
        signUpPage.verifyElementByTextBoolean(true, "Lung disease");
        signUpPage.verifyElementByTextBoolean(true, "Heart disease");
        signUpPage.verifyElementByTextBoolean(true, "Liver disease");
        signUpPage.verifyElementByTextBoolean(true, "Systemic lupus");
        signUpPage.verifyElementByTextBoolean(true, "Blood disorders");
        signUpPage.verifyElementByTextBoolean(true, "Muscular dystrophy");
        signUpPage.verifyElementByTextBoolean(true, "Kidney/renal failure");
        signUpPage.verifyElementByTextBoolean(true, "Rheumatoid arthritis");
        signUpPage.verifyElementByTextBoolean(true, "Mental health disorder");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Hepatitis C");
        signUpPage.verifyElementByTextBoolean(true, "Back surgery");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByTextBoolean(true, "Please be honest with your answers. We will use this information to fill in your application if you choose to apply after receiving a quote.");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in South Carolina are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "NC","healthquestions", "regression" },priority = 41, enabled = true)
    public void VerifyFilingsQuestionsNC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("NC 28334");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in North Carolina are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "UT","healthquestions", "regression" },priority = 34, enabled = true)
    public void VerifyFilingsQuestionsUT() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("UT 84098");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Pregnant");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with or treated for any of the following");
        signUpPage.verifyElementByTextBoolean(true, "Cancer, including but not limited to any cancer, carcinoma in situ, leukemia, or Hodgkin’s or non-Hodgkin’s lymphoma");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with or treated for any of the following");
        signUpPage.verifyElementByTextBoolean(true, "AIDS, HIV infection, or any AIDS related condition");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with or treated for any of the following");
        signUpPage.verifyElementByTextBoolean(true, "Diabetes");
        signUpPage.verifyElementByTextBoolean(true, "Transplant");
        signUpPage.verifyElementByTextBoolean(true, "Lung disease, including but not limited to chronic obstructive pulmonary disease (COPD) or cystic fibrosis");
        signUpPage.verifyElementByTextBoolean(true, "Heart disease, including but not limited to high blood pressure, coronary artery disease, heart attack, stroke, heart murmur, congestive heart failure, mitral valve prolapse, irregular heartbeat, atherosclerosis, aneurysm, or received a heart graft");
        signUpPage.verifyElementByTextBoolean(true, "Liver disease, including but not limited to cirrhosis or alcoholic hepatitis");
        signUpPage.verifyElementByTextBoolean(true, "Systemic lupus");
        signUpPage.verifyElementByTextBoolean(true, "Blood disorders, including but not limited to anemia, hemophilia or blood clots");
        signUpPage.verifyElementByTextBoolean(true, "Muscular dystrophy");
        signUpPage.verifyElementByTextBoolean(true, "Kidney/renal failure, including but not limited to chronic kidney disease (CKD), or congenital renal failure");
        signUpPage.verifyElementByTextBoolean(true, "Rheumatoid arthritis");
        signUpPage.verifyElementByTextBoolean(true, "Mental health disorder, including but not limited to hospitalizing depression, major depressive disorder, bipolar disorder, or schizophrenia");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "What procedures, prescription drugs, medical services, or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Back Surgery");
        signUpPage.verifyElementByTextBoolean(true, "Hepatitis C");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Utah are underwritten by Sirius America Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }


    @Test(groups = { "signup", "regression" },priority = 42)
    public void VerifyNewSignUpMale40Diabets() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, true, false,
                false, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 43)
    public void VerifyNewSignUpMale40Aids() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, true,
                false, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 44)
    public void VerifyNewSignUpMale40Transplant() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                true, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 45)
    public void VerifyNewSignUpMale40Lung() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, true, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 46)
    public void VerifyNewSignUpMale40Heart() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, true, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 47)
    public void VerifyNewSignUpMale40Liver() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 48)
    public void VerifyNewSignUpMale40Lupus() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, true, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression", "smoke"},priority = 49)
    public void VerifyNewSignUpMale40Blood() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, false, true, false, false, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 50)
    public void VerifyNewSignUpMale40Muscular() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, true, false, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 51)
    public void VerifyNewSignUpMale40Kidney() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, true, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 52)
    public void VerifyNewSignUpMale40Mental() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, true, false);
    }

    @Test(groups = { "signup", "regression" },priority = 53)
    public void VerifyNewSignUpMale40Arhritis() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("TX 75006", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, true);
    }


    @Test(groups = { "signup","autopay", "regression" },priority = 54)
    public void VerifySignUpAutopayAll() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignUpAutopayDefAll();
    }


    @Test(groups = { "signup","autopay", "regression", "smoke"},priority = 55)
    public void VerifySignUpAutopayOff() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignUpAutopayDef(false,true,true,true);
    }


    @Test(groups = { "signup", "autopay","regression", "smoke"},priority = 56)
    public void VerifySignUpDiscl1Off() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignUpAutopayDef(true,false,true,true);
    }


    @Test(groups = { "signup", "autopay","regression", "smoke"},priority = 57)
    public void VerifySignUpDiscl2Off() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignUpAutopayDef(true,true,false,true);
    }


    @Test(groups = { "signup", "autopay","regression" },priority = 58)
    public void VerifySignUpDiscl3Off() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignUpAutopayDef(true,true,true,false);
    }


    @Test(groups = { "signup", "autopay","regression", "smoke"},priority = 59)
    public void VerifyAutopayOff() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyAutopayByAccount("scqa.sidecar+fl+active@gmail.com", "off");
    }


    @Test(groups = { "signup", "autopay","regression", "smoke"},priority = 60)
    public void VerifyAutopayOn() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyAutopayByAccount("scqa.sidecar+tx+credit@gmail.com", "on");
    }


    @Test(groups = { "signup", "autopay","regression", "smoke"},priority = 61)
    public void VerifyAutopayTermsConditions() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyAutopayTC();
    }

    @Test(groups = { "signup","prescription", "regression", "smoke"},priority = 62)
    public void VerifyNewSignUpFemale20PrescriptionNC() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("NC 28334", 20, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$159", "$189", "$249", "$175");
    }


    @Test(groups = { "signup","AL","prescription", "regression" },priority = 64)
    public void VerifyNewSignUpMale42PrescriptionAL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AL 35215", 42, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$189", "$235", "$335", "$209");
    }


    @Test(groups = { "signup", "prescription","regression" },priority = 65)
    public void VerifyNewSignUpFemale18PrescriptionOK() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OK 73112", 18, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$165", "$199", "$265", "$179");

    }

    @Test(groups = { "signup", "NY", "unavailable", "regression", "smoke"},priority = 66)
    public void VerifyUnavailableSignup() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifySignupUncoverStates("NY 10022");
    }

    @Test(groups = { "signup", "NY", "unavailable", "regression" },priority = 67)
    public void verifyUnavailableSignupOtherOptions() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyUnavailableSignupOtherOptions("NY 10022");
    }

    @Test(groups = { "signup", "regression", "smoke"},priority = 68)
    public void Verify18AgeText() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyAge18_65ErrorMsg(17,"OK 73112");
    }


    @Test(groups = { "signup", "regression", "smoke"},priority = 69)
    public void Verify65AgeText() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.verifyAge18_65ErrorMsg(65,"OK 73112");
    }

    ////    Regression OH
    @Test(groups = { "signup","OH", "regression" },priority = 70)
    public void VerifyNewSignUpMale40OH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$189", "$235", "$329", "$209");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 71)
    public void VerifyNewSignUpFemale50OH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 50, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$209", "$265", "$395", "$235");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 72)
    public void VerifyNewSignUpFemaleOH20() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 20, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$165", "$195", "$255", "$175");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 73)
    public void VerifyNewSignUpFemale30OH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 30, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$209", "$285", "$189");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 74)
    public void VerifyNewSignUpFemale30PregnantOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 30, true, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$209", "$285", "$189");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 75)
    public void VerifyNewSignUpMale40CancerOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 40, false, true, false, false, "");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 6)
    public void VerifyNewSignUpMale40DeviceDepOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 40, false, false, false, true, "");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 77)
    public void VerifyNewSignUpFemale30TobaccoOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$255", "$315", "$425", "$285");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 78)
    public void VerifyNewSignUpFamilyDep1OH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroup("OH 44004", 40, 25, 0);
        signUpPage.verifyPlanPagePrice("$350", "$424", "$590", "$384");
    }

//
//    @Test(groups = { "signup", "OH", "regression" },priority = 79)
//    public void VerifyNewSignUpMale40DeviceDepOH() throws Exception {
//		String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
//		htmlReport.reportStartTest("",methodname, "signup");
//        signUpPage.signup("OH 44004", 40, false, false, false, true, "");
//    }


    @Test(groups = { "signup", "OH", "regression" },priority = 80)
    public void VerifyNewSignUpFemale30BudgetOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("OH 44004", 30, false, false, false, false, 1);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 81)
    public void VerifyNewSignUpFemale30StandartOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("OH 44004", 30, false, false, false, false, 2);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 82)
    public void VerifyNewSignUpFemale30PremiumOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("OH 44004", 30, false, false, false, false, 3);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 83, enabled = true)
    public void VerifyNewSignUpFemale30CustomOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckout("OH 44004", 30, false, false, false, false, 4);
    }

    @Test(groups = { "signup", "maternity", "regression" },priority = 84, enabled = false)
    public void VerifyExistedUserM30Depend3040AL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupGroupMaternity(30, 40);
        signUpPage.verifyPlanPagePrice("$533", "$649", "$905", "$585");
    }

    @Test(groups = { "signup", "OH", "healthquestions", "regression" },priority = 85, enabled = true)
    public void VerifyFilingsQuestionsOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("OH 44004");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you ever been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true, "//p[contains(.,'Plans in')]", "Plans in Ohio are underwritten by Sirius America Insurance Company.");
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 86)
    public void VerifyNewSignUpMale40DiabetsOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, true, false,
                false, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 87)
    public void VerifyNewSignUpMale40AidsOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, true,
                false, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 88)
    public void VerifyNewSignUpMale40TransplantOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                true, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 89)
    public void VerifyNewSignUpMale40LungOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, true, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 90)
    public void VerifyNewSignUpMale40HeartOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, true, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 91)
    public void VerifyNewSignUpMale40LiverOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 92)
    public void VerifyNewSignUpMale40LupusOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, true, false, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 93)
    public void VerifyNewSignUpMale40BloodOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, false, true, false, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 94)
    public void VerifyNewSignUpMale40MuscularOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, true, false, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 95)
    public void VerifyNewSignUpMale40KidneyOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, true, false, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 96)
    public void VerifyNewSignUpMale40MentalOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, true, false);
    }

    @Test(groups = { "signup", "OH", "regression" },priority = 97)
    public void VerifyNewSignUpMale40ArhritisOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("OH 44004", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, true);
    }

    @Test(groups = { "signup", "OH", "prescription","regression" },priority = 98)
    public void VerifyNewSignUpFemale20PrescriptionOH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("OH 44004", 20, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$165", "$195", "$255", "$175");
    }

    @Test(groups = { "signup", "OH", "maternity", "regression" },priority = 99, enabled = true)
    public void VerifyMaternityPriceFemale30OH() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("189", 45, 2,"OH 44004", 30, true,false, false, false, false, 4);
    }

    //MD
    @Test(groups = { "signup","MD", "regression" },priority = 101)
    public void VerifyNewSignUpMale40MD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$189", "$239", "$355", "$215");
    }

    @Test(groups = { "signup" ,"MD", "regression" },priority = 102)
    public void VerifyNewSignUpFemale50MD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 50, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$215", "$275", "$429", "$239");
    }

    @Test(groups = { "signup" ,"MD", "regression" },priority = 103)
    public void VerifySignUpFemale20MD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 20, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$165", "$199", "$275", "$179");
    }

    @Test(groups = { "signup", "MD","regression" },priority = 104)
    public void VerifySignUpFemale30PregnantMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 30, true, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$175", "$215", "$305", "$189");
    }

    @Test(groups = { "signup", "MD","healthquestions", "regression" },priority = 105, enabled = true)
    public void VerifyFilingsQuestionsMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("MD 20833");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 7 years been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true, "//p[contains(.,'Plans in')]", "Plans in Maryland are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "MD","regression" },priority = 106)
    public void VerifySignUpMale40CancerMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 40, false, true, false, false, "");
    }

    @Test(groups = { "signup", "MD","regression" },priority = 107)
    public void VerifyNewSignUpMale40DeviceDepMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 40, false, false, false, true, "");
    }

    @Test(groups = { "signup", "MD","regression" },priority = 108)
    public void VerifySignUpFemale30TobaccoMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$259", "$319", "$455", "$285");
    }

    @Test(groups = { "signup", "MD","regression" },priority = 109)
    public void VerifyNewSignUpMale40DiabetsMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, true, false,
                false, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 110)
    public void VerifyNewSignUpMale40AidsMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, true,
                false, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 111)
    public void VerifyNewSignUpMale40TransplantMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                true, false, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 112)
    public void VerifyNewSignUpMale40LungMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, true, false, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 113)
    public void VerifyNewSignUpMale40HeartMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, true, false, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 114)
    public void VerifyNewSignUpMale40LiverMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 115)
    public void VerifyNewSignUpMale40LupusMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, true, false, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 116)
    public void VerifyNewSignUpMale40BloodMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, false, true, false, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 117)
    public void VerifyNewSignUpMale40MuscularMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, true, false, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 118)
    public void VerifyNewSignUpMale40KidneyMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, true, false, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 119)
    public void VerifyNewSignUpMale40MentalMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, true, false);
    }

    @Test(groups = { "signup", "MD","regression" },priority = 120)
    public void VerifyNewSignUpMale40ArhritisMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MD 20833", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, true);
    }

    @Test(groups = { "signup", "MD","prescription","regression" },priority = 121)
    public void VerifyNewSignUpFemale20PrescriptionMD() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MD 20833", 20, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$165", "$199", "$275", "$179");
    }
//MS

    @Test(groups = { "signup", "healthquestions", "regression" },priority = 122, enabled = true)
    public void VerifyFilingsQuestionsMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("MS 39507");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Using tobacco products once or more daily");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you visited any of the following 5 or more times in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Chiropractor");
        signUpPage.verifyElementByTextBoolean(true, "Psychiatrist or psychologist");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Mississippi are underwritten by Sirius America Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }


    @Test(groups = { "signup", "regression" },priority = 123)
    public void VerifySignUpMale40CancerMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MS 39507", 40, false, true, false, false, "");
    }


    @Test(groups = { "signup", "regression" },priority = 124)
    public void VerifyNewSignUpMale40DeviceDepMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MS 39507", 40, false, false, false, true, "");
    }


    @Test(groups = { "signup", "regression" },priority = 125)
    public void VerifySignUpFemale30TobaccoMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MS 39507", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$239", "$295", "$405", "$265");
    }


    @Test(groups = { "signup", "regression" },priority = 126)
    public void VerifyNewSignUpMale40DiabetsMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, true, false,
                false, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 127)
    public void VerifyNewSignUpMale40AidsMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, true,
                false, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 128)
    public void VerifyNewSignUpMale40TransplantMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                true, false, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 129)
    public void VerifyNewSignUpMale40LungMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, true, false, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 130)
    public void VerifyNewSignUpMale40HeartMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, true, false, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 131)
    public void VerifyNewSignUpMale40LiverMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, true, false, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 132)
    public void VerifyNewSignUpMale40LupusMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, true, false, false, false, false, false);
    }


    @Test(groups = { "signup", "regression" },priority = 133)
    public void VerifyNewSignUpMale40BloodMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, false, true, false, false, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 134)
    public void VerifyNewSignUpMale40MuscularMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, true, false, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 135)
    public void VerifyNewSignUpMale40KidneyMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, true, false, false);
    }

    @Test(groups = { "signup", "regression" },priority = 136)
    public void VerifyNewSignUpMale40MentalMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, true, false);
    }

    @Test(groups = { "signup", "regression" },priority = 137)
    public void VerifyNewSignUpMale40ArhritisMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("MS 39507", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, true);
    }


    @Test(groups = { "signup", "prescription","regression" },priority = 138)
    public void VerifyNewSignUpFemale30PrescriptionMS() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("MS 39507", 30, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$159", "$195", "$269", "$175");
    }
    //AZ
    @Test(groups = { "signup", "AZ", "healthquestions", "regression", "smoke"},priority = 139, enabled = false)
    public void VerifyFilingsQuestionsAZ() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("AZ 86401");
        signUpPage.verifyElementByTextBoolean(true, "Are you currently:");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Have you had any of the following in the last 5 years?");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Have you in the past 5 years been diagnosed with, or treated for, any of the following");
        signUpPage.verifyElementByTextBoolean(true, "In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Chiropractor five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Visited a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "What procedures or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "What prescriptions do you regularly take?");
        signUpPage.verifyElementByTextBoolean(true, "Are there any health conditions, prescription drugs, or upcoming procedures that you would like to exclude from your coverage?");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Arizona are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }
    //KY

    @Test(groups = { "signup", "maternity","regression" },priority = 25, enabled = true)
    public void VerifyMaternityPriceFemale23KY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("179", 45, 2,"KY 41031", 23, true,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "maternity","regression" },priority = 26, enabled = true)
    public void VerifyMaternityPriceFemale35KY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("199", 45, 2,"KY 41031", 35, true,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "prescription","regression" },priority = 62)
    public void VerifyNewSignUpFemale35PrescriptionProtonixIVKY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("KY 41031", 35, false, false, false, false,"Protonix IV");
        signUpPage.verifyPlanPagePrice("$179", "$219", "$305", "$199");
        // 349 389 475 365
    }

    @Test(groups = { "signup","prescription", "regression" },priority = 62)
    public void VerifyNewSignUpFemale20PrescriptionKY() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("KY 41031", 20, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$159", "$195", "$255", "$175");
    }

    //AR

    @Test(groups = { "signup", "maternity","regression" },priority = 25, enabled = true)
    public void VerifyMaternityPriceFemale28AR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("165", 45, 2,"AR 72212", 28, true,false, false, false, false, 1);
    }


    @Test(groups = { "signup", "maternity","regression" },priority = 26, enabled = true)
    public void VerifyMaternityPriceFemale33AR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("209", 35, 1,"AR 72212", 33, true,false, false, false, false, 2);

    }

    @Test(groups = { "signup", "prescription", "regression" },priority = 62)
    public void VerifyNewSignUpFemale45PrescriptionProtonixIVAR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AR 72212", 45, false, false, false, false, "Protonix IV");
        signUpPage.verifyPlanPagePrice("$195", "$235", "$345", "$215");
    }

    @Test(groups = { "signup", "prescription","regression" },priority = 63)
    public void VerifyNewSignUpFemale18PrescriptionAR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AR 72212", 18, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$155", "$185", "$245", "$169");
    }


    @Test(groups = { "signup", "regression" },priority = 17)
    public void VerifyNewSignUpFemale30TobaccoAR() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AR 72212", 30, false, false, true, false, "");
        signUpPage.verifyPlanPagePrice("$249", "$299", "$405", "$275");
    }

    //GA

    @Test(groups = { "signup", "GA","maternity","regression" },priority = 42, enabled = true)
    public void VerifyMaternityPriceFemale29GA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("279", 45, 1,"GA 31405", 29, true,false, false, false, false, 3);
    }

    @Test(groups = { "signup", "GA","maternity","regression" },priority = 26, enabled = true)
    public void VerifyMaternityPriceFemale34GA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("215", 50, 1,"GA 31405", 34, true,false, false, false, false, 2);

    }

    @Test(groups = { "signup", "GA","prescription","regression" },priority = 62)
    public void VerifyNewSignUpFemale64PrescriptionProtonixIVGA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("GA 31405", 64, false, false, false, false, "Protonix IV");
        signUpPage.verifyPlanPagePrice("$285", "$375", "$685", "$325");
    }

    @Test(groups = { "signup", "GA","prescription","regression" },priority = 63)
    public void VerifyNewSignUpFemale55PrescriptionGA() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("GA 31405", 55, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$225", "$279", "$439", "$249");
    }

    //IN

    @Test(groups = { "signup", "IN","regression" },priority = 15)
    public void VerifyNewSignUpMale40IN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("IN 46323", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("189", "$235", "$335", "$209");
    }

    @Test(groups = { "signup", "IN","regression" },priority = 16)
    public void VerifyNewSignUpMale40DeviceDepIN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("IN 46323", 40, false, false, false, true, "");
    }

    @Test(groups = { "signup", "IN","maternity","regression" },priority = 42, enabled = true)
    public void VerifyMaternityPriceFemale19IN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("179", 45, 1,"IN 46323", 19, true,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "IN","prescription","regression" },priority = 62)
    public void VerifyNewSignUpFemale64PrescriptionProtonixIVIN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("IN 46323", 64, false, false, false, false, "Protonix IV");
        signUpPage.verifyPlanPagePrice("$289", "$379", "$699", "$329");
    }

    @Test(groups = { "signup", "IN","prescription","regression" },priority = 63)
    public void VerifyNewSignUpFemale40PrescriptionIN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("IN 46323", 40, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$189", "$235", "$335", "$209");
    }

    //AZ
    @Test(groups = { "signup","AZ", "regression", "smoke"},priority = 15)
    public void VerifyNewSignUpFemale40AZ() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AZ 86401", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("185", "$229", "$335", "$205");
    }


    @Test(groups = { "signup", "AZ", "regression", "smoke"},priority = 16)
    public void VerifyNewSignUpMale40DeviceDepAZ() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AZ 86401", 40, false, false, false, true, "");
    }

    @Test(groups = { "signup", "AZ", "prescription","regression", "smoke"},priority = 63)
    public void VerifyNewSignUpFemale40PrescriptionAZ() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("AZ 86401", 40, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$185", "$229", "$335", "$205");
    }

    //TN
    @Test(groups = { "signup","TN", "regression" },priority = 15)
    public void VerifyNewSignUpFemale30TN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TN 37217", 30, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("169", "$205", "$279", "$185");
    }

    @Test(groups = { "signup", "TN", "regression" },priority = 16)
    public void VerifyNewSignUpMale42DeviceDepTN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TN 37217", 42, false, false, false, true, "");
    }

    @Test(groups = { "signup", "TN", "maternity","regression" },priority = 42, enabled = true)
    public void VerifyMaternityPriceFemale23TN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("255", 45, 0,"TN 37217", 23, true,false, false, false, false, 3);
    }
    //not working

    @Test(groups = { "signup", "TN", "prescription","regression", "smoke"},priority = 62)
    public void VerifyNewSignUpFemale45Prescription$149TN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TN 37217", 45, false, false, false, false, "SODIUM NITROPRUSSIDE");
        signUpPage.verifyPlanPagePrice("$385", "$429", "$539", "$405");
    }

    @Test(groups = { "signup", "TN", "prescription", "regression" },priority = 63)
    public void VerifyNewSignUpFemale40PrescriptionTN() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("TN 37217", 40, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$185", "$229", "$325", "$205");
    }

    //FL regression

    @Test(groups = { "signup", "FL","healthquestions", "regression" },priority = 33, enabled = true)
    public void VerifyFilingsQuestionsFL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.navSignUpPageByState("FL 33133");
        signUpPage.verifyElementByTextBoolean(true,"Have you in the past 5 years been diagnosed with or treated for any of the following by a licensed member of the medical profession?");
        signUpPage.verifyElementByTextBoolean(true,"In the past 12 months, have you?");
        signUpPage.verifyElementByTextBoolean(true, "Used tobacco products in any form");
        signUpPage.verifyElementByTextBoolean(true, "Dependent on a device that helps with walking, breathing, dialysis, etc.");
        signUpPage.verifyElementByTextBoolean(true, "Been tested positive for exposure to the HIV infection or been diagnosed as having ARC or AIDS caused by the HIV infection or other sickness or condition derived from such infection");
        signUpPage.verifyElementByTextBoolean(true, "Transplant");
        signUpPage.verifyElementByTextBoolean(true, "Liver disease (excluding Hepatitis C)");
        signUpPage.verifyElementByTextBoolean(true, "Back condition that required surgery");
        signUpPage.verifyElementByTextBoolean(true, "Weighed over 300 lbs. as a male or 260 lbs. as a female");
        signUpPage.verifyElementByTextBoolean(true, "Consulted or received treatment from a Psychiatrist or Psychologist five or more times");
        signUpPage.verifyElementByTextBoolean(true, "What procedures, prescription drugs, medical services, or medical devices has a medical provider recommended to you in the past 12 months?");
        signUpPage.verifyElementByTextBoolean(true, "Consulted or received treatment from a Chiropractor five or more times");
        signUpPage.verifyElementByAtributeBoolean(true,"//p[contains(.,'Plans in')]","Plans in Florida are underwritten by United States Fire Insurance Company.");
        signUpPage.verifyElementByTextBoolean(true, "If you choose to apply after receiving your quote, you can do so on behalf of children under the age of 18 if you are their parent or legal guardian. Individuals over the age of 18 must complete their own application.");
        signUpPage.verifyElementByTextBoolean(true, "Quote another person");
    }

    @Test(groups = { "signup", "FL","regression", "smoke"},priority = 10)
    public void VerifyNewSignUpMale40FL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("FL 33133", 40, false, false, false, false, "");
        signUpPage.verifyPlanPagePrice("$195", "$235", "$339", "$215");
    }


    @Test(groups = { "signup", "FL", "maternity", "regression" },priority = 99, enabled = true)
    public void VerifyMaternityPriceFemale35FL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signUpCheckoutPriceVer("205", 35, 2,"FL 33133", 35, false,false, false, false, false, 4);
    }

    @Test(groups = { "signup", "FL", "prescription", "regression" },priority = 63)
    public void VerifyNewSignUpFemale40PrescriptionFL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signup("FL 33133", 40, false, false, false, false,"CIALIS");
        signUpPage.verifyPlanPagePrice("$195", "$235", "$339", "$215");
    }

    @Test(groups = { "signup", "FL", "regression" },priority = 133)
    public void VerifyNewSignUpMale40BloodFL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("FL 33133", 40, false, false, false, false, false, false,
                false, false, false, false, false, true, false, false, false, false);
    }

    @Test(groups = { "signup", "FL", "regression" },priority = 134)
    public void VerifyNewSignUpMale40MuscularFL() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupAll("FL 33133", 40, false, false, false, false, false, false,
                false, false, false, false, false, false, true, false, false, false);
    }

    @Test(groups = { "signup", "smoke", "regression" },priority = 64)
    public void VerifySignPage() throws Exception {
        String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
        //htmlReport.reportStartTest("",methodname, "signup");
        signUpPage.signupPageElements();
    }
}
