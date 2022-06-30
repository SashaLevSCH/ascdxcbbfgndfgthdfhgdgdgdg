package pages.AdminCarePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HealthCareGovPages.LoginPage;
import setup.BasePage;

public class AdminDashBoardPage extends BasePage {

    public By partners = By.xpath("//*[@href=\"/partners\" and @data-qaid='link_navigation_/partners']");
    public By members = By.xpath("//*[@href=\"/members\" and @data-qaid='link_navigation_/members']");
    public By headerMembers = By.xpath("//*[@data-qaid='info_pageheader' and text()='members']");
    public By sideArrow = By.xpath("//span[@class='undefined sidecon-dropdown']");
    public By subPartners = By.xpath("//a[@class='sc-dnqmqq iKyLFL' and @data-qaid='link_navigation_/partners']");
    public By subGroups = By.xpath("//a[@class='sc-dnqmqq jfMJyP' and @data-qaid='link_navigation_/partners/groups']");
    public By subASO = By.xpath("//a[@title='ASOs']");
    public By newPartner = By.xpath("//button[contains(text(),'New partner')]");
    public By selectAso = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/a/div");
    public By selectASOGroup = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[2]/div[58]/div[2]/div/div/div/a/h4");
    public By search = By.xpath("//input[@role='combobox']");
    public By partnerName = By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div/div/a/div[1]");
    public By partnerInvite = By.xpath("//a[contains(text(),'Resend invite')]");
    public By overrideDrawer = By.xpath("//div[@data-qaid='button_drawerTabOverrides']");
    public By other = By.xpath("//div[@data-qaid='button_drawerTabOther']");
    public By card = By.xpath("//div[@data-qaid='button_drawerTabCard']");
    public By viewPolicy = By.xpath("//button[@data-qaid='btn_viewPolicy']");
    public By accoundId = By.xpath("//div[@data-qaid='info_account-content']/a");

    public By otherPoliciesNumber = By.xpath("//a[contains(text(),'ACA2199965')]");
    public By otherPolicyContactDetail = By.xpath("//div[@data-qaid='info_accordionLabel' and text()='Contact info']");
    public By otherPolicyPolicyDetail = By.xpath("//div[@data-qaid='info_accordionLabel' and text()='Policy details']");
    public By otherPolicyServiceLimits = By.xpath("//div[@data-qaid='info_accordionLabel' and text()='Service limits']");
    public By otherPolicyTransactionLimits = By.xpath("//div[@data-qaid='info_accordionLabel' and text()='Transaction limits']");
    public By addPackage = By.xpath("//a[contains(text(),'+ Add package')]");
    public By addOverride = By.xpath("//button[contains(text(),'+ Add override')]");
    public By policyNumber = By.xpath("//a[contains(text(),'ACA2160509')]");
    public By policyHolderKey = By.xpath("//div[contains(text(),'Policy holder')]");
    public By intialYearPayout = By.xpath("//input[@id='firstYearPayout']");
    public By additionalYearPayout = By.xpath("//input[@id='additionalYearPayout']");
    public By firstYearOverridePayout = By.xpath("//input[@id='firstYearOverridePayout']");
    public By additionalYearOverridePayout = By.xpath("//input[@id='additionalYearOverridePayout']");
    public By addPackageButton = By.xpath("//button[contains(text(),'Add package')]");
    public By iyp = By.xpath("//td[contains(text(),'201')]");
    public By deletePackageIcon = By.xpath("//span[contains(@class,'sidecon-trash')]");
    public By deletePackageButton = By.xpath("//button[@label='Delete']");
    public By enrollingBroker = By.xpath("//input[@data-qaid='input_broker']");
    public By intialYearOverride = By.xpath("//input[@id='firstYearAmount']");
    public By additionalYearOverride = By.xpath("//input[@id='additionalYearAmount']");
    public By addOverrideButton = By.xpath("//button[@label='Add override']");
    public By deleteOverrideIcon = By.xpath("//table[@class='sc-cjHlYL dFsjjA Table-gSqoht dQemDa']//following-sibling::span[contains(@class, 'sidecon-trash')]");

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public AdminDashBoardPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[@class='sc-EHOje kstkRl sidecon-share']")
    public WebElement Share;

    @FindBy(xpath = "//span[@class='sc-EHOje kstkRl sidecon-currency']")
    public WebElement care;


    public void  clickmodule(WebElement element) {
        waitForElementToBeVisible(element);
        clickUsingJS(element);
    }

    public void navigateToPartner() {
        try {
            clickObject(this.partners, "Partner Button");
            waitForElement(this.sideArrow,"Side Arrow", "Visible");
            clickObject(this.sideArrow,"Aide Arrow");
            waitForElement(this.subPartners,"Sub Button for Partner","Visible");
            clickObject(this.subPartners,"Sub Button for Partner");
            mouseHover(this.sideArrow);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToMembers() {
        try {
            clickObject(this.members, "Members Button");
            waitForElement(this.headerMembers,"Header members","Visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToGroups() {
        try {
            clickObject(this.partners, "Partner Button");
            waitForElement(this.sideArrow,"Side Arrow", "Visible");
            clickObject(this.sideArrow,"Aide Arrow");
            waitForElement(this.subGroups,"Sub Button for Group","Visible");
            clickObject(this.subGroups,"Sub Button for Group");
        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToASO() {
        try {
            clickObject(this.partners, "Partner Button");
            waitForElement(this.sideArrow,"Side Arrow", "Visible");
            clickObject(this.sideArrow,"Side Arrow");
            waitForElement(this.subASO,"Sub Button for ASO","Visible");
            clickObject(this.subASO,"Sub Button for ASO");
            clickObject(this.sideArrow,"Side Arrow");
        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void search(String Search) {
        try {
            newinputTextBy(this.search, Search);
            explicitSleep(3000);
            waitForElement(this.partnerName,"Invite", "Visible");
            clickObject(this.partnerName, "Invite");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void searchASOGroup(String Search) {
        try {
            newinputTextBy(this.search, Search);
            waitForElement(this.selectASOGroup,"Select Searched ASO Group", "Visible");
            clickObject(this.selectASOGroup, "Select Searched ASO Group");
            explicitSleep(3000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void searchMember(String Search) {
        try {
            newinputTextBy(this.search, Search);
            waitForElement(this.selectAso,"Select Searched ASO", "Visible");
            clickObject(this.selectAso, "Select Searched ASO");
            explicitSleep(3000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToOther() {
        try {
            waitForElement(this.other,"Other Drawer", "Visible");
            clickObject(this.other, "Other Drawer");
            explicitSleep(3000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToAccounts() {
        try {
            waitForElement(this.viewPolicy,"View Policy", "Visible");
            clickObject(this.viewPolicy, "View Policy");
            explicitSleep(1000);
            waitForElement(this.accoundId,"Account ID", "Visible");
            clickObject(this.accoundId, "Account ID");
            explicitSleep(1000);

        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToCard() {
        try {
            waitForElement(this.card,"Card", "Visible");
            clickObject(this.card, "Card");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToOtherPoliciesDetail() {
        try {
            waitForElement(this.otherPoliciesNumber,"Other Drawer Policies Number", "Visible");
            clickObject(this.otherPoliciesNumber, "Other Drawer Policies Number");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToOtherPoliciyContactDetail() {
        try {
            waitForElement(this.otherPolicyContactDetail,"Other Drawer Contact Detail", "Visible");
            clickObject(this.otherPolicyContactDetail, "Other Drawer Contact Detail");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToOtherPoliciyPolicyDetail() {
        try {
            waitForElement(this.otherPolicyPolicyDetail,"Other Drawer Policy Detail", "Visible");
            clickObject(this.otherPolicyPolicyDetail, "Other Drawer Policy Detail");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void resendInvitePartner(){
        try {
            waitForElement(this.partnerInvite,"Invite", "Visible");
            clickObject(this.partnerInvite, "Invite");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void addPackagePartner(String IYP, String AYP, String FYOP, String AYOP ){
        try {
            waitForElement(this.overrideDrawer,"Override Drawer", "Visible");
            clickObject(this.overrideDrawer, "Override Drawer");
            waitForElement(this.addPackage,"Add Package", "Visible");
            clickObject(this.addPackage, "Add Package");
            waitForElement(this.addPackageButton,"Inital Year Payout", "Visible");
            explicitSleep(1000);
            clearNtypeValue(this.intialYearPayout, "Inital Year Payout", IYP );
            clearNtypeValue(this.additionalYearPayout, "Inital Year Payout", AYP );
            clearNtypeValue(this.firstYearOverridePayout, "Inital Year Payout", FYOP );
            clearNtypeValue(this.additionalYearOverridePayout, "Inital Year Payout", AYOP );
            clickObject(this.addPackageButton, "Add Package Button");
            waitForElement(this.iyp,"Initial Year Payout Price", "Visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void deletePackagePartner(){
        try {
            waitForElement(this.overrideDrawer,"Override Drawer", "Visible");
            clickObject(this.overrideDrawer, "Override Drawer");
            waitForElement(this.deletePackageIcon,"Delete Package", "Visible");
            clickObject(this.deletePackageIcon, "Delete Package");
            waitForElement(this.deletePackageButton,"Delete package Button", "Visible");
            explicitSleep(1000);
            clickObject(this.deletePackageButton, "Delete package Button");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void addOverridePartner(String groupname, String IYP, String AYP){
        try {
            waitForElement(this.overrideDrawer,"Override Drawer", "Visible");
            clickObject(this.overrideDrawer, "Override Drawer");
            waitForElement(this.addOverride,"Add Override", "Visible");
            clickObject(this.addOverride, "Add Override");
            waitForElement(this.enrollingBroker,"Enrolling broker", "Visible");
            newinputTextBy(this.enrollingBroker, groupname);
            explicitSleep(1000);
            clearNtypeValue(this.intialYearOverride, "Inital Year Override", IYP );
            clearNtypeValue(this.additionalYearOverride, "Inital Year Payout", AYP );
            clickObject(this.addOverrideButton, "Add Override");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void deleteOverridePartner(){
        try {
            waitForElement(this.overrideDrawer,"Override Drawer", "Visible");
            clickObject(this.overrideDrawer, "Override Drawer");
            waitForElement(this.deleteOverrideIcon,"Delete Override", "Visible");
            clickObject(this.deleteOverrideIcon, "Delete Override");
            waitForElement(this.deletePackageButton,"Delete package Button", "Visible");
            explicitSleep(1000);
            clickObject(this.deletePackageButton, "Delete package Button");
            explicitSleep(1000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

}
