package pages.SignUpPages;

import PageLocators.HealthCareGovPageLocators.BeforeGetStartedLocators;
import PageLocators.SignUpPageLocators.SignUpPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
//import net.minidev.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HealthCareGovPages.CreateAccountPage;
import pages.LoginPages.LoginPage;
import setup.BasePage;
import utils.Configuration;
import utils.Logs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class SignUpPage extends BasePage {


    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);
    public static By searchZIP   = By.xpath("//*[@name='zip']");
    public static By btquote     = By.xpath("(//*[contains(text(),'Get quote')])[1]");
    public By BTNCOVERDEP = By.xpath("//button[contains(@data-qaid,'btn_addMember')]");
    public By BTNSEEQUOTES= By.cssSelector("button[data-qaid='btn_continue']");
    public By TextBxEmail = By.xpath("//input[contains(@data-qaid,'input_email')]");
    public By TextBxPassword = By.xpath("//input[contains(@data-qaid,'input_password')]");
    public By BTNCREATEACCOUNT= By.xpath("//button[@label='Create account']");
    public By CHKBOXConst1 = By.xpath("//label[1]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']");
    public By CHKBOXConst2 = By.xpath("//label[2]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']");
    public By CHKBOXConst3 = By.xpath("//label[3]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']");
    public By Button_Buynow = By.xpath("//button[contains(@data-qaid,'buyNow')]");
    public By Button_CompApplication = By.xpath("//button[contains(@data-qaid,'Application')]");
    public By chkbox_autopay = By.xpath("//input[@data-qaid='input_autopaymentExpense']/..//span");
    public By Reviews   =  By.xpath("//div[contains(@class,'Reviews')]");
    public static final By SEARCHZIPSIGNUP = By.xpath("//*[@id='zip']");
    public static final By SIGNUP = By.xpath("//a[@href='/signup' and contains(.,'Sign up')]");
    public static final By SIGNUP2 = By.xpath("//a[@href='/signup' and contains(.,'Sign Up')]");
    public static final By FIRSTNAME = By.xpath("//input[@data-qaid='input_firstName_0']");
    public static final By LASTNAME = By.xpath("//input[@data-qaid='input_lastName_0']");
    public static final By BIRTHDAY = By.xpath("//input[@data-qaid='input_dateOfBirth_0']");
    public static final By FIRSTNAMED1 = By.xpath("(//input[@data-qaid='input_firstName_0'])[2]");
    public static final By LASTNAMED1 = By.xpath("(//input[@data-qaid='input_lastName_0'])[2]");
    public static final By BIRTHDAYD1 = By.xpath("(//input[@data-qaid='input_dateOfBirth_0'])[2]");
    public static final By FIRSTNAMED2 = By.xpath("(//input[@data-qaid='input_firstName_0'])[3]");
    public static final By LASTNAMED2 = By.xpath("(//input[@data-qaid='input_lastName_0'])[3]");
    public static final By FIRSTNAMEDUNCOV = By.id("applicant.firstName");
    public static final By LASTNAMEDUNCOV = By.id("applicant.lastName");
    public static final By EMAILUNCOV = By.xpath("//input[@data-qaid='input_email']");
    public static final By BIRTHDAYD2 = By.xpath("(//input[@data-qaid='input_dateOfBirth_0'])[3]");
    public static final By MALE = By.xpath("//label[@data-qaid='input_MALE-label']");
    public static final By MALEDEP1 = By.xpath("(//label[@data-qaid='input_MALE-label'])[2]");
    public static final By MALEDEP2 = By.xpath("(//label[@data-qaid='input_MALE-label'])[3]");
    public static final By FEMALE = By.xpath("//label[@data-qaid='input_FEMALE-label']");
    public static final By PREGNANT = By.xpath("//label[contains(.,'Pregnant')]/label");
    public static final By TOBACCO = By.xpath("//label[contains(.,'tobacco products')]/label");
    public static final By DEPENDENTDEVICE = By.xpath("//label[contains(.,'Dependent on')]/label");
    public static final By SELECTPLACEHOLDERFIELD = By.xpath("//*[@role='combobox']");
    public static final By SELECTPLACEHOLDERFIELDVALUE = By.xpath("//*[@class='Select-option is-focused']");
    public static final By CANCER = By.xpath("//label[contains(.,'ancer')]/label");
    public static final By PREGNANTCHBOX = By.xpath("//label[contains(.,'Pregnant')]/label/input");
    public static final By DEPENDENTDEVICECHBOX = By.xpath("//label[contains(.,'Dependent on')]/label/input");
    public static final By CANCERCHBOX = By.xpath("//label[contains(.,'ancer')]/label/input");
    public static final By DIABETESCHBOX = By.xpath("//label[contains(.,'iabetes')]/label");
    public static final By TRANSPLANTCHBOX = By.xpath("//label[contains(.,'ransplant')]/label");
    public static final By AIDSCHBOX = By.xpath("//label[contains(.,'AIDS')]/label");
    public static final By LUNGCHBOX = By.xpath("//label[contains(.,'Lung')]/label");
    public static final By HEARTCHBOX = By.xpath("//label[contains(.,'Heart')]/label");
    public static final By LIVERCHBOX = By.xpath("//label[contains(.,'Liver')]/label");
    public static final By LUPUSCHBOX = By.xpath("//label[contains(.,'upus')]/label");
    public static final By BLOODCHBOX = By.xpath("//label[contains(.,'Blood')]/label");
    public static final By MUSCULARCHBOX = By.xpath("//label[contains(.,'Muscular')]/label");
    public static final By KIDNEYCHBOX = By.xpath("//label[contains(.,'Kidney')]/label");
    public static final By MENTALCHBOX = By.xpath("//label[contains(.,'Mental')]/label");
    public static final By ATHRITISCHBOX = By.xpath("//label[contains(.,'arthritis')]/label");
    public static final By ADDMEMBER = By.xpath("//button[@data-qaid='btn_addMember']");
    public static final By REMOVEMEMBER = By.xpath("//a[@data-qaid='btn_removeMember_1']");
    public static final By SEEQUOTES = By.xpath("//button[@label='See quotes']");
    public static final By BUDGET = By.xpath("//h2[contains(.,'Budget')]");
    public static final By STANDART = By.xpath("//h2[contains(.,'Standard')]");
    public static final By PREMIUM = By.xpath("//h2[contains(.,'Premium')]");
    public static final By CUSTOM = By.xpath("//h2[contains(.,'Custom')]");
    public static final By SELECT = By.xpath("//button[contains(.,'Select')]");
    public static final By BASICPRICE = By.xpath("//div[@data-qaid='info_packageCost_basicPackage']");
    public static final By ESSINTIALPRICE = By.xpath("//div[@data-qaid='info_packageCost_essentialPackage']");
    public static final By PREMIUMPRICE = By.xpath("//div[@data-qaid='info_packageCost_premiumPackage']");
    public static final By CUSTOMPRICE = By.xpath("//div[@data-qaid='info_packageCost_customizedPackage']");
    public static final By WEMAYNOTBE = By.xpath("//h1[contains(.,'We may not be your best option')]");
    public static final By VISITHEALTHCARE = By.xpath("//a[@href='http://healthcare.gov/']");
    public static final By CALLUS = By.xpath("(//a[@href='tel:877-653-6440'])[4]");
    public static final By BANKACCOUNTLINK = By.xpath("//a[contains(.,'bank account')]");
    public static final By CONTINUEBUTTON = By.xpath("//button[@id='aut-continue-button']");
    public static final By CHASE = By.xpath("//p[contains(.,'www.chase.com')]");
    public static final By CHASE_USER = By.xpath("//*[@id='username']");
    public static final By CHASE_PWD = By.xpath("//*[@id='password']");
    public static final By CHASE_SUBMIT = By.xpath("//*[@id='aut-submit-button']");
    public static final By CHASE_CONTINUE = By.xpath("//span[contains(@class, 'Button') and text() = 'Continue']");
    public static final By PAYMENT_CONTINUE = By.xpath("//*[starts-with(@class, 'Button') and (@data-qaid='btn_continue')]");
    public static final By CHASE_SAVING = By.xpath("//*[@class='AccountListItem__label']/input");
    public static final By ADDRESS_STREET = By.id("street");
    public static final By PHONE_NUMBER_INPUT = By.id("phoneNumber");
    public static final By SSN_INPUT = By.xpath("//*[contains(@id,'ssn')]");
    public static final By AUTOPAY_CHECKBOX = By.xpath("(//label[@type='checkbox'])[3]");
    public static final By DISCLOSURES_CHECKBOX1 = By.xpath("(//label[@type='checkbox'])[4]");
    public static final By DISCLOSURES_CHECKBOX2 = By.xpath("(//label[@type='checkbox'])[5]");
    public static final By DISCLOSURES_CHECKBOX3 = By.xpath("(//label[@type='checkbox'])[6]");
    public static final By COMPLETE_APPLICATION_DISABLE = By.xpath("//*[contains(@data-qaid,'Application') and @disabled]");
    public static final By COMPLETE_APPLICATION_ENABLED = By.xpath("//*[contains(@data-qaid,'Application')]");
    public static final By PAYMENTCARD_BUTTON = By.xpath("//a[contains(text(), 'Payment card')]");
    public static final By AUTOPAY_TC_BUTTON = By.xpath("//a[contains(text(), 'automatic payment terms and conditions')]");
    public static final By AGE_18_ERR = By.xpath("//*[contains(text(), 'You must be at least 18 years old to create an account')]");
    public static final By AGE_65_ERR = By.xpath("//*[contains(text(), 'You must be under 65 to be covered')]");
    public static final By AUTOPAYDISABLED_BUTTON = By.xpath("(//input[@name='autopaymentExpense'])[1]");
    public static final By AUTOPAYENABLED_BUTTON = By.xpath("(//input[@name='autopaymentExpense'])[2]");
    public static final By THANKSMES = By.xpath("//h3[contains(.,'Thank you for you interest in Sidecar Health')]");
    public static final By THANKSMES2 = By.xpath("//h1[contains(.,'Thank you for you interest in Sidecar Health')]");
    public static final By NOTAVAILMES = By.xpath("//h1[contains(.,'We are currently not available in your area')]");
    public static final By SHAREEMAILMES = By.xpath("//h2[contains(.,'Share with us your email and we')]");
    public static final By NOTAVAILMES2 = By.xpath("//p[contains(.,'In the mean time, tell your friends about how Sidecar Health is making health insurance the way it should be: affordable, personalized and simple to use.')]");
    public static final By SHAREEMAILMES2 = By.xpath("//h3[contains(.,'email you when')]");
    public static final By TELLUSABOUTYOU = By.xpath("//h1[contains(.,'Tell us about you & your family')]");
    public static final By SELECTSTATE = By.xpath("//*[@class='Select-arrow-zone']/span");
    public static final By SELECTSTATEFL = By.xpath("(//*[@class='Select-menu-outer']/div)[1]");
    public static final By SELECTSTATEBTN = By.xpath("(//button[*])[2]");
    public static final By CONTACTMELATER_BUTTON = By.xpath("//button[contains(.,'Contact me later')]");
    public static final By CHECKBOX_UNCOVER = By.xpath("//label[@type='checkbox']");
    public static final By ACCOUNT_lOGIN_LINK = By.xpath("//*[contains(text(), 'Log in')]");
    public static final By ACCOUNT_lOGIN_LINK2 = By.xpath("//*[contains(text(), 'Log In')]");
    public static final By INPUT_EMAIL = By.xpath("//*[@id='email']");
    public static final By INPUT_PASSWORD = By.xpath("//*[@id=\"password\"]");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Login')]");
    public static final By ACCOUNT_BUTTON = By.xpath("//a[contains(text(), 'Account')]");
    String urlDevMaternity = "https://qa-app.sidecarhealth.com/signup";




    public SignUpPage(WebDriver driver) {
        super(driver);

    }


    public void signupByZip(String zip) throws Exception{
        try {

            // Navigation Page to get Quote
            waitForElement(this.searchZIP, "ZipCode = " + zip, "visible");
            clearNtypeValue(this.searchZIP, "ZipCode", zip );
            driver.findElement(By.xpath("//*[@name='zip']")).clear();
            driver.findElement(By.xpath("//*[@name='zip']")).sendKeys(zip);
            clickObject(this.btquote, "Get Quote");
        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    //Enter details for Primary (Family Tab)
    public void PrimaryForm(String State , String Gender , String SelfCoverage , int noOfDependants, String procedures , JSONArray MedicalPro) {
        try {
            Thread.sleep(5000);
            clearNtypeValue(By.xpath("(//input[contains(@id,'firstName')])"+"["+noOfDependants+"]"), "Firstname", "Firstname" +State + "AutomationUser" );
            clearNtypeValue(By.xpath("(//input[contains(@id,'lastName')])"+"["+noOfDependants+"]"), "Lastname", "Lastname" +State + "AutomationUser" );
            clearNtypeValue(By.xpath("(//input[contains(@id,'dateOfBirth')])"+"["+noOfDependants+"]"), "Date Of Birth for Primary ", "10/3/2000" );
            clickObject(By.xpath("(//label[@data-qaid='input_"+Gender+"-label'])"+"["+noOfDependants+"]"), "Select Gender as " +Gender);
//            for ( int i = 0; i< MedicalPro.length(); i++ ) {
//                if(SelfCoverage != "Yes")
//
//                {    		elementExistance(By.xpath("(//label[contains(.,'"+MedicalPro.get(i)+"')])[1]"),String.valueOf(MedicalPro.get(i)),3);
//                    System.out.println("(//label[contains(.,'"+MedicalPro.get(i)+"')])[1]");
//                    elementExistance(By.xpath("(//label[contains(.,'Pregnant')])[1]"),String.valueOf(MedicalPro.get(i)),3);
//
//                }else
//
//                    elementExistance(By.xpath("(//label[contains(.,'"+MedicalPro.get(i)+"')])"+"["+noOfDependants+"]"),String.valueOf(MedicalPro.get(i)),3);
//            }



            clearNtypeValue(By.xpath("(//textarea[contains(@name,'procedures')])"+"["+noOfDependants+"]"), "What procedures have you been recommended to have within the next 12 months?", procedures );
            //clearNtypeValue(By.xpath("(//textarea[contains(@name,'exclusions')])"+"["+noOfDependants+"]"), "What procedures have you been recommended to have within the next 12 months?", "No" );

            //driver.findElement(By.xpath("//input[contains(@data-qaid, 'input_prescriptions')]")).sendKeys("crab");
            // driver.findElement(By.cssSelector(".Select-option#react-select-2--option-0")).click();


            if(noOfDependants ==1) {
                clickObject(By.xpath("//label[text()= '"+SelfCoverage+"']"), "Are you looking to cover yourself?");


            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        }catch(Exception e) { System.out.println("Exception Occured" + e); }


    }

    public void CoverDependant() {
        try {
            clickObject(this.BTNCOVERDEP, "Cover Dependant ");

        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }
    public void SelectPackage(String Package) {

        try {

            clickObject(By.xpath("//button[contains(@data-qaid,'btn_select_"+Package+"')]"), "Pick a plan that fits your needs");

        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void SeeQuotes() {
        try {
            Thread.sleep(5000);
            clickObject(this.BTNSEEQUOTES, "See Quote");

        }
        catch(Exception e) { System.out.println("Exception Occured" + e); }


    }


    public void SaveQuotes(String State) throws Exception {

        //This method save the plan selected and will send it to the Customer's email.

        clearNtypeValue(this.TextBxEmail, "Enter email to save your quote", "sudhanshu.scqa"+"+"+State+utils.Utilities.generateRandomDigits(4)+"@gmail.com" );
        clearNtypeValue(this.TextBxPassword, "Enter Password", "Test1234!" );
        elementExistance(Reviews, "Checking for Reviews from TrustPilot", 10);

        clickObject(this.BTNCREATEACCOUNT, "Click the Button Create Account");

    }

    public void EnterSSN (int Dependants) {

        try {
            clearNtypeValue(By.xpath("(//input[@data-qaid='input_ssn_0'])"), "Enter SSN",utils.Utilities.generateRandomDigits(9));
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
//            for ( int i = 0; i<= Dependants; i++ ) {
//                driver.switchTo().defaultContent();
//                clearNtypeValue(By.xpath("(//input[@data-qaid='input_ssn'])"+"["+i+"]"), "Enter SSN",utils.Utilities.generateRandomDigits(9));
//            }
//            driver.switchTo().defaultContent();





        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Disclosures() {
        try {
            clickObject(this.CHKBOXConst1, "Click the Button Complete Application");
            clickObject(this.CHKBOXConst2, "Click the Button Complete Application");
            clickObject(this.CHKBOXConst3, "Click the Button Complete Application");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Completeapplication()	{
        {
            try {
                clickObject(this.Button_CompApplication, "Click the Button Complete Application");
                explicitSleep(7000);
                clickObject(this.Button_Buynow, "Click the Button Buy Now");
                explicitSleep(7000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
    public void AutoPayment () {
        try {
            String methodname =Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("Method name is: "+methodname);
            WebElement element = driver.findElement(By.xpath("//input[@data-qaid='input_autopaymentExpense']/..//span"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void CheckInvaidzipMsg () {
        try {
            Thread.sleep(5000);
            String CoverageCheck = driver.getCurrentUrl();
            System.out.println(CoverageCheck);
            if (CoverageCheck.contains("notAvailable")) {
                driver.findElement(By.xpath("//h2[contains(text(),'We’ll be sure to contact you when we’re available in your area')]"));
                String MessageInvalid = driver.findElement(By.xpath("//h2[contains(text(),'We’ll be sure to contact you when we’re available in your area')]")).getText();
                System.out.println(MessageInvalid);
               // objHtmlReport.reportPassFail("URL Contains not available and shows the message " + MessageInvalid, "true", "true");

            } else
               // objHtmlReport.reportPassFail("coverage is available ", "False", "False");
                System.out.println("coverage is available");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  void clickSelectButton(int selectButton) throws Exception {
        final By select = By.xpath("(//button[@label='Select'])[" + selectButton + "]");
        clickByXpathElement(select);
    }

    public void navSignUpPageByState(String state) throws Exception {
        clickByXpathJS(SIGNUP);
        inputTextBy(SEARCHZIPSIGNUP, state);
    }

    public  void signUpCheckout(String state, int birthday, Boolean pregnant, Boolean cancer, Boolean tobacco, Boolean device, int selectButton) throws Exception {
        signup(state, birthday, pregnant, cancer, tobacco, device, "");
        if (device == true || cancer == true) {
            System.out.println("WE MAY NOT BE");
        } else {
            String select = "";
            String packages = "";
            if (selectButton == 1) {
                select = "//div[@data-qaid='info_packageCost_basicPackage']";
                packages = "$10,000";
            } else if (selectButton == 2) {
                select = "//div[@data-qaid='info_packageCost_essentialPackage']";
                packages = "$25,000";
            } else if (selectButton == 3) {
                select = "//div[@data-qaid='info_packageCost_premiumPackage']";
                packages = "$2,000,000";
            } else if (selectButton == 4) {
                select = "//div[@data-qaid='info_packageCost_customizedPackage']";
                packages = "$15,000";
            }
            int price = Integer.valueOf(driver.findElement(By.xpath(select)).getText().replace("$", "").replace("/mo", ""));
            System.out.println("Price is: " + price);
            navCheckout(selectButton, "scqa.sidecar+tx@gmail.com", "Test1234!");
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + price + "')]")).isDisplayed(), "price");
            Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(), '" + packages + "')]")).isDisplayed(), packages);
            if(!state.contains("TN")||!state.contains("37217")){
                Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(), '$0')]")).isDisplayed(), "Deductible 0");}
            Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + price + "')]")).size() == 3, "prices");
//				logger.createNode("Verified prices");

            int add3y=0;
            if (!state.contains("OH")) {

                add3y = Integer.valueOf(driver.findElement(By.xpath("(//a[contains(text(), 'Add')])[1]")).getText().replace("Add (+$", "").replace(")", ""));
                System.out.println("Price for add 3 years is: " + add3y);
                clickByXpathElement(By.xpath("(//a[contains(text(), 'Add')])[1]"));
                Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Lock in rate for 3 years')]")).isDisplayed(), "Lock in rate for 3 years");
                clickByXpathElement(By.xpath("//button[@label='Add $" + add3y + "/mo']"));

                int newPrice = price + add3y;
                System.out.println("Price after add 3 years is: " + newPrice);
                Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + newPrice + "')]")).isDisplayed(), "new price");
                Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + newPrice + "')]")).size() == 3, "All new prices is displayed");
                Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Remove (')]")).isDisplayed(), "Remove button is visible");
            }
            int addMaternity = Integer.valueOf(driver.findElement(By.xpath("(//a[contains(text(), 'Add')])[1]")).getText().replace("Add (+$", "").replace(")", ""));
            System.out.println("Price for add maternity is: " + addMaternity);
            clickByXpathElement(By.xpath("(//a[contains(text(), 'Add')])[1]"));
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Add maternity coverage')]")).isDisplayed(), "Add maternity coverage");
            clickByXpathElement(By.xpath("//button[@label='Add $" + addMaternity + "/mo']"));

            int newPriceMaternity = price + add3y + addMaternity;
            System.out.println("Total price with 3y and maternity is: " + newPriceMaternity);
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + newPriceMaternity + "')]")).isDisplayed(), "new price");
            Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + newPriceMaternity + "')]")).size() == 3, "All new prices is visible");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Remove (')]")).isDisplayed(), "Remove button still visible");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).isDisplayed(), "Edit button is visible");
        }
    }


    public  void signUpCheckoutPriceVer(String price,int annualCoverage, int deductible, String state, int birthday, Boolean add3, Boolean pregnant, Boolean cancer, Boolean tobacco, Boolean device, int selectButton) throws Exception {
        signup(state, birthday, pregnant, cancer, tobacco, device, "");
        if (device == true || cancer == true) {
            System.out.println("WE MAY NOT BE");
        } else {
            String select = "";
            String packages = "";
            if (selectButton == 1) {
                select = "//div[@data-qaid='info_packageCost_basicPackage']";
                packages = "$10,000";
            } else if (selectButton == 2) {
                select = "//div[@data-qaid='info_packageCost_essentialPackage']";
                packages = "$25,000";
            } else if (selectButton == 3) {
                select = "//div[@data-qaid='info_packageCost_premiumPackage']";
                packages = "$2,000,000";
            } else if (selectButton == 4) {
                select = "//div[@data-qaid='info_packageCost_customizedPackage']";
                packages = "$15,000";
            }
            int pr = Integer.valueOf(driver.findElement(By.xpath(select)).getText().replace("$", "").replace("/mo", ""));
            System.out.println("Price is: " + pr);
            navCheckout(selectButton, "scqa.sidecar+tx@gmail.com", "Test1234!");
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + pr + "')]")).isDisplayed(), "price");
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + pr + "')]")).getText().contains(price), "price");
            Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(), '" + packages + "')]")).isDisplayed(), packages);
            if(!state.contains("TN")||!state.contains("37217")){
                Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(), '$0')]")).isDisplayed(), "Deductible 0");}
            Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + pr + "')]")).size() == 3, "prices");
//				logger.createNode("Verified prices");

            int add3y = 0;
            if(add3==true) {
                if (!state.contains("OH")) {
                    add3y = Integer.valueOf(driver.findElement(By.xpath("(//a[contains(text(), 'Add')])[1]")).getText().replace("Add (+$", "").replace(")", ""));
                    System.out.println("Price for add 3 years is: " + add3y);
                    clickByXpathElement(By.xpath("(//a[contains(text(), 'Add')])[1]"));
                    Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Lock in rate for 3 years')]")).isDisplayed(), "Lock in rate for 3 years");
                    clickByXpathElement(By.xpath("//button[@label='Add $" + add3y + "/mo']"));

                    int newPrice = pr + add3y;
                    System.out.println("Price after add 3 years is: " + newPrice);
                    Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + newPrice + "')]")).isDisplayed(), "new price");
                    Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + newPrice + "')]")).size() == 3, "All new prices is displayed");
                    Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Remove (')]")).isDisplayed(), "Remove button is visible");
                }
            }
            int addMaternity=0;
            addMaternity = Integer.valueOf(driver.findElement(By.xpath("(//a[contains(text(), 'Add')])[1]")).getText().replace("Add (+$", "").replace(")", ""));
            System.out.println("Price for add maternity is: " + addMaternity);
            clickByXpathElement(By.xpath("(//a[contains(text(), 'Add')])[1]"));
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Add maternity coverage')]")).isDisplayed(), "Add maternity coverage");

            addMaternityCoverage(annualCoverage,deductible);
            if(annualCoverage!=0||deductible!=0) {
                addMaternity = Integer.valueOf(driver.findElement(By.xpath("//button[contains(@label,'$')]")).getText().replace("Add $", "").replace("/mo", ""));
            }
            clickByXpathElement(By.xpath("//button[@label='Add $" + addMaternity + "/mo']"));
            int newPriceMaternity = pr + add3y + addMaternity;
            System.out.println("Total price with 3y and maternity is: " + newPriceMaternity);
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), '$" + newPriceMaternity + "')]")).isDisplayed(), "new price");
            Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(), '$" + newPriceMaternity + "')]")).size() == 3, "All new prices is visible");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Remove (')]")).isDisplayed(), "Remove button still visible");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).isDisplayed(), "Edit button is visible");
        }
    }


    public  void addMaternityCoverage(int annualCoverage, int deductible) throws InterruptedException {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("(//span[contains(@class,'sidecon-dropdown')])[2]")).click();
        action.click(driver.findElement(By.xpath("//*[contains(text(),'$"+annualCoverage+",000/year')]"))).build().perform();
        Thread.sleep(3000);
        if(deductible!=0){
            driver.findElement(By.xpath("(//span[contains(@class,'sidecon-dropdown')])[3]")).click();
            action.click(driver.findElement(By.xpath("//*[contains(text(),'$"+deductible+",000')]"))).build().perform();}
        Thread.sleep(3000);
    }


    public  void navCheckout(int selectButton, String email, String pwd) throws Exception {
        clickSelectButton(selectButton);
        clickByXpathElement(ACCOUNT_lOGIN_LINK);
        insertTextByXpath(INPUT_EMAIL, email);
        insertTextByXpath(INPUT_PASSWORD, pwd);
        clickByXpathElement(LOGIN_BUTTON);
//			logger.createNode("Verified signup/login page");
    }

    public  void signupPageElements() throws Exception {
        driver.get("https://qa-site.sidecarhealth.com/");
        Assert.assertTrue(driver.findElement(By.id("Symbols")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'How it works')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'Features')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'About')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'FAQ')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'Member stories')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(.,'Log in')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(.,'877-653-6440')])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'sidecon-dropdown')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1['Design your own health insurance']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='zip'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//button[@label='Get quote'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='zip'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//button[@label='Get quote'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//h4['Budget'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//h4['Budget'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//h4['Standard'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//h4['Premium'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//h4['Premium'])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//button['Get quote'])[3]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//button['Get quote'])[4]")).isDisplayed());
        inputTextBy(searchZIP, "TN 37217");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup/"));
        Assert.assertTrue(driver.findElement(By.xpath("(//h1['Tell us about you & your family'])[1]")).isDisplayed());
    }

    public  void signup(String state, int birthday, Boolean pregnant, Boolean cancer, Boolean tobacco, Boolean device, String rx) throws Exception {
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        inputTextBy(SEARCHZIPSIGNUP, state);
        insertTextByXpath(FIRSTNAME, firstname);
        insertTextByXpath(LASTNAME, lastname);
        insertTextByXpath(BIRTHDAY, setAges(birthday));
        if (!driver.findElement(PREGNANTCHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(PREGNANT);
        }
        System.out.println(driver.findElement(PREGNANTCHBOX).getAttribute("value"));
        System.out.println(driver.findElement(CANCERCHBOX).getAttribute("value"));
        System.out.println(driver.findElement(DEPENDENTDEVICECHBOX).getAttribute("value"));
        if (!driver.findElement(CANCERCHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(CANCER);
        }
        if (!driver.findElement(DEPENDENTDEVICECHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(DEPENDENTDEVICE);
        }
        if (pregnant == true) {
            clickByXpathJS(FEMALE);
            clickByXpathJS(PREGNANT);
        } else {
            clickByXpathJS(MALE);
        }
        if (cancer == true) {
            clickByXpathJS(CANCER);
        }
        if (tobacco == true) {
            clickByXpathJS(TOBACCO);
        }
        if (device == true) {
            clickByXpathJS(DEPENDENTDEVICE);
        }
        if (!rx.isEmpty()) {
            driver.findElement(SELECTPLACEHOLDERFIELD).sendKeys(rx);
            Actions action = new Actions(driver);
            action.click(driver.findElement(SELECTPLACEHOLDERFIELDVALUE)).build().perform();
        }

        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
        if (device == true || cancer == true) {
            verifyPopUpWeMayNotBe();
        }
    }

    public  void verifySignUpAutopayDef(boolean autopay, boolean disclosure1,boolean disclosure2,boolean disclosure3) throws Exception {
        navToCheckout();
        navCheckout(1, "scqa.sidecar+tx@gmail.com", "Test1234!");
        selectBankAccount();
        driver.findElement(ADDRESS_STREET).sendKeys("111 Ogden Dr");
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys("3109002121");
        driver.findElement(SSN_INPUT).sendKeys("211929292");
        Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        if((autopay&&disclosure1&&disclosure2&&disclosure3)==true){
            clickByXpath(AUTOPAY_CHECKBOX);
            clickByXpath(DISCLOSURES_CHECKBOX1);
            clickByXpath(DISCLOSURES_CHECKBOX2);
            clickByXpath(DISCLOSURES_CHECKBOX3);
            Assert.assertTrue(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        }
        else if((disclosure1&&disclosure2&&disclosure3)==true && autopay==false){
            clickByXpath(DISCLOSURES_CHECKBOX1);
            clickByXpath(DISCLOSURES_CHECKBOX2);
            clickByXpath(DISCLOSURES_CHECKBOX3);
            Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        }
        else if((autopay&&disclosure2&&disclosure3)==true && disclosure1==false){
            clickByXpath(AUTOPAY_CHECKBOX);
            clickByXpath(DISCLOSURES_CHECKBOX2);
            clickByXpath(DISCLOSURES_CHECKBOX3);
            Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        }
        else if((autopay&&disclosure1&&disclosure3)==true && disclosure2==false){
            clickByXpath(AUTOPAY_CHECKBOX);
            clickByXpath(DISCLOSURES_CHECKBOX1);
            clickByXpath(DISCLOSURES_CHECKBOX3);
            Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        }
        else if((autopay&&disclosure1&&disclosure2)==true && disclosure3==false){
            clickByXpath(AUTOPAY_CHECKBOX);
            clickByXpath(DISCLOSURES_CHECKBOX1);
            clickByXpath(DISCLOSURES_CHECKBOX2);
            Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        }
    }

    public  void verifySignUpAutopayDefAll() throws Exception {
        navToCheckout();
        navCheckout(1, "scqa.sidecar+tx@gmail.com", "Test1234!");
        selectBankAccount();
        driver.findElement(ADDRESS_STREET).sendKeys("111 Ogden Dr");
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys("3109002121");
        driver.findElement(SSN_INPUT).sendKeys("211929292");
        Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        clickByXpath(AUTOPAY_CHECKBOX);
        Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        clickByXpath(DISCLOSURES_CHECKBOX1);
        Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        clickByXpath(DISCLOSURES_CHECKBOX2);
        Assert.assertFalse(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
        clickByXpath(DISCLOSURES_CHECKBOX3);
        Assert.assertTrue(driver.findElement(COMPLETE_APPLICATION_ENABLED).isEnabled());
    }

    public  void signupAll(String state, int birthday, Boolean pregnant, Boolean tobacco, Boolean device, Boolean cancer,
                                 Boolean diabetes,Boolean aids,Boolean transplant,Boolean lung,
                                 Boolean heart,Boolean liver,Boolean lupus,Boolean blood,
                                 Boolean muscular,Boolean kidney, Boolean mental,Boolean athritis) throws Exception {
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        inputTextBy(SEARCHZIPSIGNUP, state);
        insertTextByXpath(FIRSTNAME, firstname);
        insertTextByXpath(LASTNAME, lastname);
        insertTextByXpath(BIRTHDAY, setAges(birthday));
        if (!driver.findElement(PREGNANTCHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(PREGNANT);
        }
        System.out.println(driver.findElement(PREGNANTCHBOX).getAttribute("value"));
        System.out.println(driver.findElement(CANCERCHBOX).getAttribute("value"));
        System.out.println(driver.findElement(DEPENDENTDEVICECHBOX).getAttribute("value"));
        if (!driver.findElement(CANCERCHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(CANCER);
        }
        if (!driver.findElement(DEPENDENTDEVICECHBOX).getAttribute("value").contains("false")) {
            clickByXpathJS(DEPENDENTDEVICE);
        }
        if (pregnant == true) {
            clickByXpathJS(FEMALE);
            clickByXpathJS(PREGNANT);
        } else {
            clickByXpathJS(MALE);
        }
        if (cancer == true) {
            clickByXpathJS(CANCER);
        }
        if (tobacco == true) {
            clickByXpathJS(TOBACCO);
        }
        if (device == true) {
            clickByXpathJS(DEPENDENTDEVICE);
        } if (diabetes == true) {
            clickByXpathJS(DIABETESCHBOX);
        }if (aids == true) {
            clickByXpathJS(AIDSCHBOX);
        }if (transplant == true) {
            clickByXpathJS(TRANSPLANTCHBOX);
        }if (lung == true) {
            clickByXpathJS(LUNGCHBOX);
        }
        if (heart == true) {
            clickByXpathJS(HEARTCHBOX);
        }
        if (liver == true) {
            clickByXpathJS(LIVERCHBOX);
        } if (lupus == true) {
            clickByXpathJS(LUPUSCHBOX);
        }
        if (blood == true) {
            clickByXpathJS(BLOODCHBOX);
        }
        if (muscular == true) {
            clickByXpathJS(MUSCULARCHBOX);
        }
        if (kidney == true) {
            clickByXpathJS(KIDNEYCHBOX);
        }
        if (mental == true) {
            clickByXpathJS(MENTALCHBOX);
        }
        if (athritis == true) {
            clickByXpathJS(ATHRITISCHBOX);
        }

        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
        if (device == true || cancer == true||diabetes == true || aids == true||transplant == true || lung == true||heart == true || liver == true||
                lupus == true || blood == true||muscular == true || kidney == true||mental == true || athritis == true) {
            verifyPopUpWeMayNotBe();
        }
    }


    public  void signupMaternity(Boolean pregnant, Boolean cancer, Boolean tobacco, Boolean device) throws Exception {
        driver.navigate().to(Configuration.URL);
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, "scqa.sidecar+tx@gmail.com");
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(SIGNUP2);
        if (pregnant == true) {
            clickByXpathJS(FEMALE);
            clickByXpathJS(PREGNANT);
        } else {
            clickByXpathJS(MALE);
        }
        if (cancer == true) {
            clickByXpathJS(CANCER);
        }
        if (tobacco == true) {
            clickByXpathJS(TOBACCO);
        }
        if (device == true) {
            clickByXpathJS(DEPENDENTDEVICE);
        }

        removeDependent();
        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
        if (device == true || cancer == true) {
            verifyPopUpWeMayNotBe();
        }
    }

    public  void signupMaternityAl(Boolean pregnant, Boolean cancer, Boolean tobacco, Boolean device) throws Exception {
        driver.navigate().to(Configuration.URL);
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, "scqa.sidecar+al+automation@gmail.com");
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(SIGNUP2);
        if (pregnant == true) {
            clickByXpathJS(FEMALE);
            clickByXpathJS(PREGNANT);
        } else {
            clickByXpathJS(MALE);
        }
        if (cancer == true) {
            clickByXpathJS(CANCER);
        }
        if (tobacco == true) {
            clickByXpathJS(TOBACCO);
        }
        if (device == true) {
            clickByXpathJS(DEPENDENTDEVICE);
        }
        removeDependent();
        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
        if (device == true || cancer == true) {
            verifyPopUpWeMayNotBe();
        }
    }

    public  void verifySignupUncoverStates(String state) throws Exception {
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        inputTextBy(SEARCHZIPSIGNUP, state);
        Assert.assertTrue(driver.findElement(THANKSMES).isDisplayed());
        Assert.assertTrue(driver.findElement(NOTAVAILMES).isDisplayed());
        Assert.assertTrue(driver.findElement(SHAREEMAILMES).isDisplayed());
        Assert.assertFalse(driver.findElement(CONTACTMELATER_BUTTON).isEnabled());
        insertTextByXpath(FIRSTNAMEDUNCOV, firstname);
        insertTextByXpath(LASTNAMEDUNCOV, lastname);
        int random_num = utils.DateUtils.RandomNum();
        String email = "test" + random_num + "scqa@yopmail.com";
        insertTextByXpath(EMAILUNCOV, email);
        scrollDownpage(SELECTSTATE);
        clickByXpath(CONTACTMELATER_BUTTON);
        Assert.assertTrue(driver.findElement(THANKSMES2).isDisplayed());
        Assert.assertTrue(driver.findElement(NOTAVAILMES2).isDisplayed());
        Assert.assertTrue(driver.findElement(SHAREEMAILMES2).isDisplayed());
    }

    public  void verifyUnavailableSignupOtherOptions(String state) throws Exception {
        clickByXpathJS(SIGNUP);
        inputTextBy(SEARCHZIPSIGNUP, state);
        org.testng.Assert.assertTrue(driver.findElement(THANKSMES).isDisplayed());
        org.testng.Assert.assertTrue(driver.findElement(NOTAVAILMES).isDisplayed());
        org.testng.Assert.assertTrue(driver.findElement(SHAREEMAILMES).isDisplayed());
        org.testng.Assert.assertFalse(driver.findElement(CONTACTMELATER_BUTTON).isEnabled());
        scrollDownpage(SELECTSTATE);
        clickByXpath(SELECTSTATE);
        Actions action = new Actions(driver);
        action.click(driver.findElement(SELECTSTATEFL)).build().perform();
        clickByXpath(SELECTSTATEBTN);
        Assert.assertTrue(driver.findElement(TELLUSABOUTYOU).isDisplayed());
    }

    public static String setAge(int age){
        int today = Calendar.getInstance().get(Calendar.YEAR);
        String a = "12/31/" + (today - age);
        return a;
    }

    public static String setAges(int age){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_WEEK, -7);
        cal.add(Calendar.YEAR, -age);
        Date birthday = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String inActiveDate = null;
        try {
            inActiveDate = format.format(birthday);
        } catch (Exception e) {
        }
        System.out.println("Set date: "+inActiveDate);
        return inActiveDate;
    }

    public  void verifyAge18_65ErrorMsg(int age, String state) throws Exception {
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        inputTextBy(SEARCHZIPSIGNUP, state);
        insertTextByXpath(FIRSTNAME, firstname);
        insertTextByXpath(BIRTHDAY, setAges(age));
        insertTextByXpath(LASTNAME, lastname);
        if(age<=18){
            Assert.assertTrue(driver.findElement(AGE_18_ERR).isDisplayed());
        }
        else if(age>=65){
            Assert.assertTrue(driver.findElement(AGE_65_ERR).isDisplayed());
        }
    }

    public  void removeDependent() {

        try {
            if (driver.findElements(By.xpath("//a[@data-qaid='btn_removeMember_1']")).size() != 0) {
                clickByXpathJS(By.xpath("//a[@data-qaid='btn_removeMember_1']"));
            } else if (driver.findElements(By.xpath("//a[@data-qaid='btn_removeMember_2']")).size() != 0) {
                clickByXpathJS(By.xpath("//a[@data-qaid='btn_removeMember_2']"));
            }
        }
        catch (Exception e){}
    }

    public  void signupGroup(String state, int age, int agedep1, int agedep2) throws Exception {
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        String firstnamedep1 = utils.FakeName.fakename();
        String firstnamedep2 = utils.FakeName.fakelastname();
        int today = Calendar.getInstance().get(Calendar.YEAR);
        String birthday = "12/31/" + String.valueOf(today - age);
        String birthdaydep1 = "12/30/" + String.valueOf(today - agedep1);
        String birthdaydep2 = "12/29/" + String.valueOf(today - agedep2);
        inputTextBy(SEARCHZIPSIGNUP, state);
        insertTextByXpath(FIRSTNAME, firstname);
        insertTextByXpath(LASTNAME, lastname);
        insertTextByXpath(BIRTHDAY, birthday);
        clickByXpathJS(MALE);
        removeDependent();
        if (agedep1 > 0 && agedep2 == 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(2000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, birthdaydep1);
            clickByXpathJS(MALEDEP1);
        } else if (agedep2 > 0 && agedep1 > 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(2000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, birthdaydep1);
            clickByXpathJS(MALEDEP1);
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(2000);
            insertTextByXpath(FIRSTNAMED2, firstnamedep2);
            insertTextByXpath(LASTNAMED2, lastname);
            insertTextByXpath(BIRTHDAYD2, birthdaydep2);
            clickByXpathJS(MALEDEP2);
        }

        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
    }


    public  void signupGroupMaternityAl(int agedep1, int agedep2) throws Exception {
//        driver.navigate().to(urlDevMaternity);
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, "scqa.sidecar+al+automation@gmail.com");
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(SIGNUP2);
        int today = Calendar.getInstance().get(Calendar.YEAR);
        String birthdaydep2 = "12/29/" + String.valueOf(today - agedep2);
        String lastname = utils.FakeName.fakelastname();
        String firstnamedep1 = utils.FakeName.fakename();
        String firstnamedep2 = utils.FakeName.fakename();
        removeDependent();
        Thread.sleep(3000);
        if (agedep1 > 0 && agedep2 == 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, setAges(agedep1));
            clickByXpathJS(MALEDEP1);
        } else if (agedep2 > 0 && agedep1 > 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, setAges(agedep2));
            clickByXpathJS(MALEDEP1);
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED2, firstnamedep2);
            insertTextByXpath(LASTNAMED2, lastname);
            insertTextByXpath(BIRTHDAYD2, birthdaydep2);
            clickByXpathJS(MALEDEP2);
        }
        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
    }


    public  void signupGroupMaternity(int agedep1, int agedep2) throws Exception {
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, "scqa.sidecar+tx@gmail.com");
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(SIGNUP2);
        String lastname = utils.FakeName.fakelastname();
        String firstnamedep1 = utils.FakeName.fakename();
        String firstnamedep2 = utils.FakeName.fakename();
        removeDependent();
        Thread.sleep(3000);
        if (agedep1 > 0 && agedep2 == 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, setAges(agedep1));
            clickByXpathJS(MALEDEP1);
        } else if (agedep2 > 0 && agedep1 > 0) {
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED1, firstnamedep1);
            insertTextByXpath(LASTNAMED1, lastname);
            insertTextByXpath(BIRTHDAYD1, setAges(agedep2));
            clickByXpathJS(MALEDEP1);
            clickByXpathJS(ADDMEMBER);
            Thread.sleep(3000);
            insertTextByXpath(FIRSTNAMED2, firstnamedep2);
            insertTextByXpath(LASTNAMED2, lastname);
            insertTextByXpath(BIRTHDAYD2, setAges(agedep2));
            clickByXpathJS(MALEDEP2);
        }
        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
    }

    public  void verifyPlanPage() {
        Assert.assertTrue(driver.findElement(BUDGET).isDisplayed(), "BUDGET");
        Assert.assertTrue(driver.findElement(STANDART).isDisplayed(), "STANDART");
        Assert.assertTrue(driver.findElement(PREMIUM).isDisplayed(), "PREMIUM");
        Assert.assertTrue(driver.findElement(CUSTOM).isDisplayed(), "CUSTOM");
        Assert.assertTrue(driver.findElements(SELECT).size() == 4, "SELECT");
    }

    public  void verifyPlanPagePrice(String budget, String standart, String premium, String custom) throws InterruptedException {
        verifyPlanPage();
        Assert.assertTrue(driver.findElement(BASICPRICE).getText().contains(budget), "BASICPRICE is :" + budget + " but found: " + driver.findElement(BASICPRICE).getText());
        Assert.assertTrue(driver.findElement(ESSINTIALPRICE).getText().contains(standart), "ESSINTIALPRICE is: " + standart + " but found: " + driver.findElement(ESSINTIALPRICE).getText());
        Assert.assertTrue(driver.findElement(PREMIUMPRICE).getText().contains(premium), "PREMIUMPRICE is :" + premium + " but found: " + driver.findElement(PREMIUMPRICE).getText());
        Assert.assertTrue(driver.findElement(CUSTOMPRICE).getText().contains(custom), "CUSTOMPRICE is :" + custom + " but found: " + driver.findElement(CUSTOMPRICE).getText());
    }

    public  void verifyPopUpWeMayNotBe() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElements(WEMAYNOTBE).size() == 1, "WEMAYNOTBE");//We may not be your best option
        Assert.assertTrue(driver.findElement(CALLUS).isDisplayed(), "CALLUS");
    }

    public  void verifyElementByTextBoolean(Boolean visible, String text) {
        if(visible==true){
            Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size() >= 1, text);
        }
        else if(visible==false){
            Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size() == 0, text);
        }
    }

    public  void verifyElementByAtributeBoolean(Boolean visible, String element, String text) {
        if(visible==true){
            Assert.assertTrue(driver.findElement(By.xpath(element)).getAttribute("innerText").contains(text), text);
        }
        else if(visible==false){
            Assert.assertFalse(driver.findElement(By.xpath(element)).getAttribute("innerText").contains(text), text);
        }
    }

    public  void verifyAutopayByAccount(String account, String autopay) throws Exception{
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, account);
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(ACCOUNT_BUTTON);
        clickByXpathElement(ACCOUNT_BUTTON);
        clickByXpathElement(PAYMENTCARD_BUTTON);
        if(autopay.contains("on")){
            Assert.assertFalse(driver.findElement(AUTOPAYENABLED_BUTTON).isSelected()); }
        else{
            Assert.assertTrue(driver.findElement(AUTOPAYENABLED_BUTTON).isSelected());}
    }

    public  void switchToNextWindow(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
            }
        }
    }

    public  void selectBankAccount()throws Exception{
        clickByXpath(BANKACCOUNTLINK);
        driver.switchTo().frame(driver.findElement(By.id("plaid-link-iframe-1")));
        clickByXpath(CONTINUEBUTTON);
        clickByXpath(CHASE);
        driver.findElement(CHASE_USER).sendKeys("user_good");
        driver.findElement(CHASE_PWD).sendKeys("pass_good");
        clickByXpath(CHASE_SUBMIT);
        clickByXpath(CHASE_SAVING);
        clickByXpath(CHASE_CONTINUE);
        driver.switchTo().defaultContent();
    }


    public  void navToCheckout() throws Exception{
        clickByXpathJS(SIGNUP);
        String firstname = utils.FakeName.fakename();
        String lastname = utils.FakeName.fakelastname();
        inputTextBy(SEARCHZIPSIGNUP, "TX 75006");
        insertTextByXpath(FIRSTNAME, firstname);
        insertTextByXpath(LASTNAME, lastname);
        insertTextByXpath(BIRTHDAY, "01/01/1980");
        clickByXpathJS(MALE);
        scrollDownpage(ADDMEMBER);
        clickByXpath(SEEQUOTES);
        clickByXpath(BASICPRICE);
    }

    public  void verifyAutopayTC() throws Exception{
        clickByXpathElement(ACCOUNT_lOGIN_LINK2);
        insertTextByXpath(INPUT_EMAIL, "scqa.sidecar+fl+active@gmail.com");
        insertTextByXpath(INPUT_PASSWORD, "Test1234!");
        clickByXpathElement(LOGIN_BUTTON);
        clickByXpathElement(ACCOUNT_BUTTON);
        clickByXpathElement(ACCOUNT_BUTTON);
        clickByXpathElement(PAYMENTCARD_BUTTON);
        clickByXpathElement(AUTOPAY_TC_BUTTON);
        switchToNextWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("automatic-payment-terms-and-conditions"));
        driver.switchTo().defaultContent();
    }
}
