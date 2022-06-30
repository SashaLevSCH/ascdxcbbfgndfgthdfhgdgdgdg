package pages.PartnerGroup;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.PaymentPages.PaymentPage;
import setup.BasePage;
import org.testng.Assert;

public class PartnerGroup extends BasePage {

    private static final Logger log = LogManager.getLogger(PaymentPage.class);


    public PartnerGroup(WebDriver driver) {
        super(driver);
    }
    // Get Quote
    public By butGetQuote= By.xpath("//a[contains(.,'Get quote')]");
    public By inpFirstName= By.xpath("//input[contains(@id,'firstName')]");
    public By inpLastName= By.xpath("//input[contains(@id,'lastName')]");
    public By inpEmail = By.xpath("//input[contains(@id,'email')]");
    public By inpDOB= By.xpath("//input[contains(@id,'dateOfBirth')]");
    public By inpZip= By.xpath("//input[contains(@id,'zip')]");
    public By inpGender= By.xpath("//label[@data-qaid='input_MALE-label']");
    public By inpState= By.xpath("//*[@class='Select-input']/input[@aria-activedescendant='react-select-3--value']");
    //public By inpState= By.className("Select-input");
    public By inpStatebox= By.cssSelector("#react-select-3--value > div.Select-value");
    public By butCalculateQuote = By.xpath("//button[@data-qaid='btn_calculateQuote']");
    public By linkPartner = By.xpath("//a[contains(@href,'qa-site.sidecarhealth.com/for/')]");
    public By viewLastQuote = By.xpath("//a[@href='/quotes/latest' and contains(.,'View last quote')]");
    public By uploadCensus = By.xpath("//input[@type='file']");
    public By uploadList = By.xpath("//a[contains(text(),'upload your list')]");
    public By account = By.xpath("//a[contains(.,'Account')]");
    public By myCoverage = By.xpath("//a[contains(.,'My coverage')]");
    public By notifications = By.xpath("//a[contains(.,'Notifications')]");
    public By paymentCard = By.xpath("//a[contains(.,'Benefit card')]");
    public By documents = By.xpath("//a[contains(.,'Documents')]");
    public By burgericon = By.xpath("//span[contains(@class,'sidecon-menu')]");
    public By editCoverage = By.xpath("//div[@data-qaid='list_editCoverage']");
    public By fullBenefits = By.xpath("//div[@data-qaid='list_fullBenefits']");
    public By changeCoverage = By.xpath("//button[@data-qaid='link_changeCoverage']");
    public By editMember = By.xpath("//div[@data-qaid='list_editMember']");
    public By signout = By.xpath("//div[contains(.,'Sign out')]");
    public By groups = By.xpath("//a[contains(.,'Groups')]");
    public By addGroup = By.xpath("//button[contains(text(),'Add group')]");
    public By closeGroup = By.xpath("//span[@data-qaid = 'btn_closeModal']");
    public By editfirstGroup = By.xpath("//span[@class='sc-jhAzac brXkFX sidecon-edit']");
    public By groupName = By.xpath("//input[contains(@id,'name')]");
    public By groupUrl = By.xpath("//input[contains(@id,'urlSlug')]");
    public By editGroup = By.xpath("//button[contains(text(),'Edit group')]");
    public By cancelPopup = By.xpath("//span[@data-qaid='btn_closeModal']");
    public By firstName = By.xpath("//input[contains(@id,'firstName')]");
    public By lastName = By.xpath("//input[contains(@id,'lastName')]");
    public By dob = By.xpath("//input[contains(@id,'dateOfBirth')]");
    public By zip = By.xpath("//input[contains(@id,'zip')]");
    public By policyId = By.xpath("//input[contains(@id,'policyId')]");
    public By continuebtn = By.xpath("//button[@data-qaid='btn_continue']");

    public void calculateQuote(String FirstName, String LastName , String Email, String DOB, String Zip) {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.inpFirstName,"FirstName","Visible");
            clearNtypeValue(this.inpFirstName, "First Name", FirstName );
            clearNtypeValue(this.inpLastName, "Last Name", LastName );
            clearNtypeValue(this.inpEmail, "Email", Email );
            clearNtypeValue(this.inpDOB, "DOB", DOB );
            clearNtypeValue(this.inpZip, "ZIP", Zip);
            clickObject(this.inpGender,"MALE");

            clickObject(this.inpStatebox,"Click the dropdown button");
            explicitSleep(200);
            newinputTextBy(this.inpState, "FL");
            clickObject(this.butCalculateQuote,"Clicking Calculate Quote");
            waitForElement(this.linkPartner,"Estimate Starting Prices Page","Visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void viewLastQuote() {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.viewLastQuote,"viewLastQuote", "Visible");
            clickObject(this.viewLastQuote,"viewLastQuote");
            waitForElement(this.linkPartner,"Estimate Starting Prices Page","Visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void uploadNewCensus() {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.viewLastQuote,"viewLastQuote", "Visible");
            clickObject(this.viewLastQuote,"viewLastQuote");
            waitForElement(this.linkPartner,"Estimate Starting Prices Page","Visible");
            UploadFile(this.uploadCensus, "Vance.xlsx");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void uploadList() {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.viewLastQuote,"viewLastQuote", "visible");
            clickObject(this.uploadList, "Get Quote");
            FileToUpload("Vance.xlsx");
            waitForElement(this.linkPartner,"Estimate Starting Prices Page","Visible");
            explicitSleep(10000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void registeraccount(String FirstName, String LastName , String Dob, String Zip,String PolicyId) {
        try {
            explicitSleep(1000);
            waitForElement(this.firstName,"First Name", "visible");
            clearNtypeValue(this.firstName, "First Name", FirstName );
            clearNtypeValue(this.lastName, "Last Name", LastName );
            clearNtypeValue(this.dob, "Dob", Dob );
            clearNtypeValue(this.zip, "Zip", Zip );
            clearNtypeValue(this.policyId, "Policy ID", PolicyId );
            clickObject(this.continuebtn, "Continue Button");
            explicitSleep(4000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }
    public void navigatetoAccount() {
        try {
            explicitSleep(3000);
            waitForElement(this.account,"Account", "visible");
            clickObject(this.account, "Account");
            waitForElement(this.signout,"Signout", "visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigatetoMycoverage() {
        try {
            explicitSleep(3000);
            waitForElement(this.myCoverage,"Coverage", "visible");
            clickObject(this.myCoverage, "Coverage");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }
    public void navigateToNotification() {
        try {
            explicitSleep(3000);
            waitForElement(this.notifications,"Notification", "visible");
            clickObject(this.notifications, "Notification");

        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToPaymentCard() {
        try {
            explicitSleep(3000);
            waitForElement(this.paymentCard,"Benefit Card", "visible");
            clickObject(this.paymentCard, "Benefit Card");
        }
        catch(Exception e) {
            System.out.println("Exception Occured" + e);
        }
    }

    public void navigateToDocuments() {
        try {
            explicitSleep(3000);
            waitForElement(this.documents,"Documents", "visible");
            clickObject(this.documents, "Documents");
        }
        catch(Exception e) {
            System.out.println("Exception Occured" + e);
        }
    }

    public void navigateToEditMember() {
        try {
            explicitSleep(3000);
            waitForElement(this.editMember,"Edit Member", "visible");
            clickObject(this.editMember, "Edit Member");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void navigateToEditCoverage() {
        try {
            waitForElement(this.editCoverage,"Edit Coverage", "visible");
            clickObject(this.editCoverage, "Edit Coverage");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void cancelpopup() {
        try {
            clickObject(this.cancelPopup, "Cancel Pop Up");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void clickBurgerIcon() {
        try {
            explicitSleep(3000);
            waitForElement(this.burgericon,"Burger Icon", "visible");
            clickObject(this.burgericon, "Burger Icon");
            waitForElement(this.editCoverage,"EditCoverage", "visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void clickFullBenefits() {
        try {
            explicitSleep(3000);
            waitForElement(this.fullBenefits,"Full Benefits", "visible");
            clickObject(this.fullBenefits, "Full Benefits");
            waitForElement(this.changeCoverage,"Change Coverage", "visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void clickChangeCoverage() {
        try {
            waitForElement(this.changeCoverage,"Change Coverage", "visible");
            clickObject(this.changeCoverage, "Change Coverage");
            explicitSleep(2000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }


    public void navigatetoGroup() {
        try {
            clickObject(this.groups, "Groups");
            waitForElement(this.addGroup,"Add Group", "visible");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void addGroupLayout() {
        try {
            clickObject(this.groups, "Groups");
            waitForElement(this.addGroup,"Add Group", "visible");
            clickObject(this.addGroup, "Add Groups");
            Assert.assertTrue(driver.findElement(By.xpath("//span[@data-qaid = 'btn_closeModal']")).isDisplayed(), "Group title is displayed");
            clickObject(this.closeGroup, " CloseGroups");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }
    public void editGroup() {
        try {
            clickObject(this.groups, "Groups");
            clickObject(this.editfirstGroup, "Edit First Group");
            waitForElement(this.groupName,"Group Name", "visible");
            waitForElement(this.groupUrl,"Group URl", "visible");
            String name = generaterandomString(7);
            clearNtypeValue(this.groupName, "Group Name", name );
            clearNtypeValue(this.groupUrl, "Group Name", name );
            clickObject(this.editGroup, "Edit Group");
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),"+name+")]")).isDisplayed(), "Edited Group is displayed");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void urlTaken() {
        try {
            clickObject(this.groups, "Groups");
            clickObject(this.editfirstGroup, "Edit First Group");
            waitForElement(this.groupName,"Group Name", "visible");
            waitForElement(this.groupUrl,"Group URl", "visible");
            clearNtypeValue(this.groupUrl, "Group Name", "test" );
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void requiredFieldError(String FirstName, String LastName , String Email, String DOB, String Zip) {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.inpFirstName,"FirstName","Visible");
            clickObject(this.inpFirstName, "First Name");
            clickObject(this.inpLastName, "Last Name");
            Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'firstName')]//parent::div[@class='inputWrapper Wrapper-dyuznp bmlLLa']//following-sibling::div[text()='This is a required field']")).isDisplayed(), "Error is displayed");
            clickObject(this.inpEmail, "Email" );
            Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'lastName')]//parent::div[@class='inputWrapper Wrapper-dyuznp bmlLLa']//following-sibling::div[text()='This is a required field']")).isDisplayed(), "Error is displayed");
            clickObject(this.inpDOB, "DOB");
            Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'email')]//parent::div[@class='inputWrapper Wrapper-dyuznp bmlLLa']//following-sibling::div[text()='This is a required field']")).isDisplayed(), "Error is displayed");
            clearNtypeValue(this.inpZip, "ZIP", Zip);
            Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'dateOfBirth')]//parent::div[@class='inputWrapper Wrapper-dyuznp bmlLLa']//following-sibling::div[text()='This is a required field']")).isDisplayed(), "Error is displayed");

        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void uploadInvalidFilequote() {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.viewLastQuote,"viewLastQuote", "visible");
            clickObject(this.uploadList, "Get Quote");
            FileToUpload("doctor_db.json");
            explicitSleep(2000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void uploadInvalidFileestimate() {
        try {
            clickObject(this.butGetQuote, "Get Quote");
            waitForElement(this.viewLastQuote,"viewLastQuote", "Visible");
            clickObject(this.viewLastQuote,"viewLastQuote");
            waitForElement(this.linkPartner,"Estimate Starting Prices Page","Visible");
            UploadFile(this.uploadCensus,"doctor_db.json");
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void uploadLogo(String filename) {
        try {
            clickObject(this.account, "Account");
            waitForElement(this.signout,"Signout", "visible");
            FileToUpload(filename);
            explicitSleep(10000);
        } catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

}

