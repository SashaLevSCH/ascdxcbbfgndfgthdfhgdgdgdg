package UiTests;

import core.TestBase;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static utils.Utilities.readTestData;

public class ASOTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void intializeClassObjects() throws Exception {
        Constants.jsonString = readTestData("asopage", "src/test/resources/TestData/QAData.json").toString();
        testData = new JSONObject(Constants.jsonString);
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 1, description = "Dashboard ASO Changes")
    public void ASODashboardCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            Assert.assertTrue(driver.findElements(By.xpath("//div[@data-qaid='info_statusItem']")).isEmpty());
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Estimate care')]")).isDisplayed(), "Estimate care");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Doctors')]")).isDisplayed(), "Doctors");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Account')]")).isDisplayed(), "Accounts");
            Assert.assertTrue(driver.findElement(By.xpath("//a[@data-qaid='btn_reminder_orderPaymentCard_action']")).isDisplayed(), "Order Card Button");
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 2, description = "ASO Profile Changes")
    public void ASOAccountProfileCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            partnerGroup.navigatetoAccount();
            Assert.assertTrue(driver.findElements(By.xpath("//button[@data-qaid='btn_saveChanges']")).isEmpty());
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'sidecar.ease.com')]")).isDisplayed(), "Link");
            Assert.assertTrue(driver.findElements(By.xpath("//input[@id='firstName']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//input[@id='lastName']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//input[@id='email']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//input[@id='phoneNumber']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//input[@id='city']")).isEmpty());
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 17, description = "ASO Profile Changes")
    public void ASOAccountFullBenefitsCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName2"), testData.getString("asopassword2"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigatetoMycoverage();
            partnerGroup.clickBurgerIcon();
            partnerGroup.clickFullBenefits();
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_info_policyPrescriptionLimit' and text()='$250']")).isDisplayed(), "Swipe Limit for Prescription");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_info_policyOtherCareLimit' and text()='$2,500']")).isDisplayed(), "Swipe Limit for Other Care");
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 17, description = "ASO Profile Changes")
    public void ASOAccountChangeCoverageCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName2"), testData.getString("asopassword2"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigatetoMycoverage();
            partnerGroup.clickBurgerIcon();
            partnerGroup.clickFullBenefits();
            partnerGroup.clickChangeCoverage();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'sidecar.ease.com')]")).isDisplayed(), "Link");
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 3, description = "ASO MyCoverage Changes")
    public void ASOAccountMycoverageCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigatetoMycoverage();
            partnerGroup.clickBurgerIcon();
            Assert.assertTrue(driver.findElements(By.xpath("//div[@data-qaid='list_cancel']")).isEmpty());
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 4, description = "ASO Edit Coverage Checks")
    public void ASOAccountEditcoverageCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName2"), testData.getString("asopassword2"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigatetoMycoverage();
            partnerGroup.clickBurgerIcon();
            partnerGroup.navigateToEditCoverage();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'sidecar.ease.com')]")).isDisplayed(), "Link");
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 5, description = "ASO Edit Member Checks")
    public void ASOAccountEditmemberCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigatetoMycoverage();
            partnerGroup.clickBurgerIcon();
            partnerGroup.navigateToEditMember();
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'sidecar.ease.com')]")).isDisplayed(), "Link");
        } catch (Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 6, description = "ASO Notification Checks")
    public void ASONotificationCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigateToNotification();
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Policy & account alerts')]")).isDisplayed(), "Link");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 7, description = "ASO Benefit Card Checks")
    public void ASOPaymentCardCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName2"), testData.getString("asopassword2"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigateToPaymentCard();
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Benefit card is tied to')]")).isDisplayed(), "Link");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 8, description = "ASO Documents Checks")
    public void ASODocumentsCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("asourl"), testData.getString("asouserName"), testData.getString("asopassword"));
            partnerGroup.navigatetoAccount();
            partnerGroup.navigateToDocuments();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'+ Upload document')]")).isDisplayed(), "Link");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 9, description = "ASO Edit Details")
    public void ASOAdminEditDetailsCheck() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToMembers();
            adminDashBoardPage.searchMember("asotest");
            Assert.assertTrue(driver.findElements(By.xpath("//span[@data-qaid='btn__edit']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//span[@data-qaid='btn_member.email_edit']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//span[@data-qaid='btn_undefined_edit']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//span[@data-qaid='btn_member.phoneNumber_edit']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//button[@data-qaid='btn_editCoverage']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//button[@data-qaid='btn_cancel']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//button[@data-qaid='btn_misstatement']")).isEmpty());
            Assert.assertTrue(driver.findElement(By.xpath("//button[@data-qaid='btn_viewPolicy']")).isDisplayed(), "View Button");
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Premium managed by ASO']")).isDisplayed(), "Premium");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_benefitType-FAMILY_DEDUCTIBLE']")).isDisplayed(), "Premium");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_aso_employer']")).isDisplayed(), "Employer info");
            Assert.assertTrue(driver.findElements(By.xpath("//div[@data-qaid='info_maternityAllowance']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//div[@data-qaid='info_maternityDeductible']")).isEmpty());
            Assert.assertTrue(driver.findElements(By.xpath("//div[text()='Maternity care']")).isEmpty());
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }


    @Test(groups = { "ASO", "regression", "smoke"},priority = 10, description = "ASO Policy Drawer Check")
    public void ASOPolicyDrawer() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToMembers();
            adminDashBoardPage.searchMember("asotest");
            adminDashBoardPage.navigateToOther();
            adminDashBoardPage.navigateToOtherPoliciesDetail();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Safelite')]")).isDisplayed(), "Plan Type");
            Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'May 15, 2021 to Jan 01, 2022')]")).isDisplayed(), "Start Date");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Managed by ASO')]")).isDisplayed(), "Premium");
            adminDashBoardPage.navigateToOtherPoliciyContactDetail();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'3683 East Colonial Drive, 254')]")).isDisplayed(), "Address");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'777-000-5500')]")).isDisplayed(), "Address");
            adminDashBoardPage.navigateToOtherPoliciyPolicyDetail();
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_benefitType-FAMILY_DEDUCTIBLE-title']")).isDisplayed(), "Family Deductible");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_benefitType-DEDUCTIBLE']")).isDisplayed(), "Individual Deductible");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Service limits')]")).isDisplayed(), "Service limits");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Transaction limits')]")).isDisplayed(), "Transaction limits");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 11, description = "Members in Account")
    public void AllMembersInAccount() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToMembers();
            adminDashBoardPage.searchMember("asotest");
            adminDashBoardPage.navigateToAccounts();
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_benefitType-FAMILY_DEDUCTIBLE']")).isDisplayed(), "Family Deductible");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_benefitType-DEDUCTIBLE']")).isDisplayed(), "Individual Deductible");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_policy_dates']")).isDisplayed(), "Policy Date");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_purchase_date']")).isDisplayed(), "Purchase Dates");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_email']")).isDisplayed(), "Email");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_gender']")).isDisplayed(), "Gender");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_dateOfBirth']")).isDisplayed(), "DOB");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='info_member_policyId']")).isDisplayed(), "Policy ID");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 12, description = "ASO Documents Checks")
    public void ASOOrderCardAdmin() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToMembers();
            adminDashBoardPage.searchMember("asotest");
            adminDashBoardPage.navigateToCard();
            Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Expense payment method is required for a payment card')]")).isDisplayed(), "Payment");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    
    @Test(groups = { "ASO", "regression", "smoke"},priority = 13, description = "View Single ASO")
    public void ViewSingleASOAdmin() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.login(testData.getString("adminurl"),testData.getString("adminuserName"),testData.getString("adminpassword") );
            adminDashBoardPage.navigateToASO();
            adminDashBoardPage.searchASOGroup("Sidecar Health");
            Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qaid='button_drawerTabDetails']")).isDisplayed(), "Details Drawer");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 14, description = "Register Account ASO")
    public void RegisterAccountLayout() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.launchUrl(testData.getString("registeraccount" ));
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Register for your own online account')]")).isDisplayed(), "Register Account Header");
            Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'First, what is your policy?')]")).isDisplayed(), "Register Account Text");
            Assert.assertFalse(driver.findElement(By.xpath("//button[@data-qaid='btn_continue']")).isEnabled(), " Button is disabled");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 15, description = "Register Account Validation Error")
    public void PolicyValidationError() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.launchUrl(testData.getString("registeraccount" ));
            partnerGroup.registeraccount(testData.getString("firstname" ),testData.getString("lastname" ),testData.getString("birthday" ),testData.getString("zip" ),testData.getString("policyidnegative" ));
            Assert.assertTrue(driver.findElement(By.xpath("//div[@type='error']")).isDisplayed(), "Error");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }

    @Test(groups = { "ASO", "regression", "smoke"},priority = 16, description = "Register Account Validation Success")
    public void PolicyValidationSuccess() {
        try {
            String methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: " + methodname);
            loginPages.launchUrl(testData.getString("registeraccount" ));
            partnerGroup.registeraccount(testData.getString("firstname" ),testData.getString("lastname" ),testData.getString("birthday" ),testData.getString("zip" ),testData.getString("policyid" ));
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Password Reset')]")).isDisplayed(), "Password Reset Screen");
        } catch(Exception e) {
            System.out.println("Exception Occured " + e);
            Assert.fail("Assertion failed");
        }
    }
}
