package pages.LoginPages;

import Browser.Configuration;
import PageLocators.LoginPageLocators.LoginPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PaymentPages.PaymentPage;
import setup.BasePage;
import utils.Constants;

public class LoginPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public By inpUserName = By.xpath("//input[@id='email']");
    public By inpPassword = By.xpath("//input[@id='password']");
    public By btnLogin    = By.xpath("//button[@data-qaid='btn_login']");
    public By btnSignout  = By.xpath("//button[@label='Sign Out']");
    public By LinkAcct    = By.xpath("//a[contains(text(),'Account')]");
    public By LnkSignout   = By.xpath("//div[contains(text(),'Sign out')]");
    public By Reviews   =  By.xpath("//div[contains(@class,'Reviews')]");
    public static final By DASHBOARD = By.xpath("//*[@href=\"/dashboard\"]");
    public static final By EXPENSES = By.xpath("//*[@href=\"/expenses\"]");
    public static final By NEW_EXPESNE_TEXT = By.xpath("//*[contains(text(), 'Add receipt')]");
    public static final By NEW_EXPESNE_LOC = By.xpath("//*[contains(text(), 'New expense')]");
    public static final By CARE_BY_CATEGORY = By.xpath("//*[contains(text(), 'Search for care by category')]");
    public static final By SEARCH_DOCTORS_BY_SPECIALITY = By.xpath("//*[contains(text(), 'Search doctors by specialty')]");
    public static final By CHECK_DOCTORS_LISTING = By.xpath("//*[contains(@href, '/doctors')][3]");
    public static final By OVERVIEW_TEXT = By.xpath("//*[contains(text(), 'Overview')]");
    public static final By COST_TEXT = By.xpath("//*[contains(text(), 'Costs')]");
    public static final By REVIEWS_TEXT = By.xpath("//*[contains(text(), 'Reviews')]");
    public static final By BOOKMARK = By.xpath("//*[contains(text(), 'Bookmark')]");
    public static final By BOOKMARKED = By.xpath("//*[contains(text(), 'Bookmarked')]");
    public static final By DOCTORIMGCARD = By.xpath("//img[@alt='provider' and @src='https://qa-doctor-image.sidecarhealth.com/care-providers/1255383139.png']");
    public static final By BOOKMARKED_DOCTORS_NAMES = By.xpath("(//*[@class='Name-jQkLgH eHrImQ'])[1]");
    public static final By BOOKMARKED_DOCTORS_NAMES2 = By.xpath("(//*[@class='Name-jQkLgH eHrImQ'])[2]");
    public static final By RECEIPTLOC = By.xpath("//span[@class='Label-bBNSSk dFmOBq']");
    public static final By UPLOAD_IMG = By.xpath("//*[contains(@alt, 'upload bill')]");
    //	public static final By INPUT_EMAIL = By.xpath("//*[@id='email']");
//	public static final By INPUT_PASSWORD = By.xpath("//*[@id='password']");
//	public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Login')]");
    public static final By ACCOUNT_BUTTON = By.xpath("//a[contains(text(), 'Account')]");
    //Include group contributions to change coverage UI automation - SID-5001
    public static final By INPUT_EMAIL_GRP_CTRB_CC = By.xpath("//*[@id=\"email\"]");


    public LoginPage(WebDriver driver) {
        super(driver);

    }


    public void launchUrl(String url) {
        try {
            driver.get(url);
            System.out.println("URL Launched Successfully " + url);

        }catch(Exception e) { System.out.println("Exception Occured while launching URL" + e); }
    }

    public void login(String url, String grpuserName , String password) {
        try {
            launchUrl (url);
            waitForElement(this.inpUserName, "Username = " + grpuserName, "visible");
            clearNtypeValue(this.inpUserName, "UserName", grpuserName );
            clearNtypeValue(this.inpPassword, "Password", password );
            clickObject(this.btnLogin, "Login");

        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }


    public void logout() {
        try {
            Thread.sleep(5000);
            clickObject(this.LinkAcct, "Account");
            clickObject(this.LnkSignout, "Logout");
            clickObject(this.btnSignout, "Logout");

        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void TrustPilotCheck () {
        try {
            elementExistance(Reviews, "Checking for Reviews from TrustPilot", 10);
        }catch(Exception e) { System.out.println("Exception Occured" + e); }

    }



}