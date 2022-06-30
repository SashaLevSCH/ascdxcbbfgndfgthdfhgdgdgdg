package pages.PaymentPages;

import PageLocators.HealthCareGovPageLocators.BeforeGetStartedLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HealthCareGovPages.CreateAccountPage;
import setup.BasePage;

public class PaymentPage extends BasePage {

    private static final Logger log = LogManager.getLogger(PaymentPage.class);


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    //Payment by Card
    public By inpCardHoldName= By.xpath("//input[@id='name_expense']");
    public By CARD_NUMBER = By.xpath("//input[@name='cardnumber']");
    public By INPUT_EXPIRY = By.xpath("//input[@name='exp-date']");
    public By INPUT_ZIPCODE = By.xpath("//input[@name='postal']");
    public By INPUT_CVC = By.xpath("//input[@name='cvc']");

    public By inputSSN = By.xpath("//label[contains(.,'SSN')]");


    //Payment By Bank Account

    public By LnkBankAcc = By.xpath("//a[contains(text(),'bank account')]");

    // Address
    public By inpStreetName= By.xpath("//input[@id='street']");
    public By inpUnitNumber= By.xpath("//input[@id='street2']");
    public By inpCity= By.xpath("//input[@id='city']");
    public By inpzip= By.xpath("//input[@id='zip']");
    public By inpphonenum= By.xpath("//input[@id='phoneNumber']");

    public By btncompApplication= By.xpath("//button[@label='Complete application']");
    public By btnBuyNow= By.xpath("//button[@data-qaid='btn_buyNow']");
    public By btnDashboard= By.xpath("//a[contains(text(),'Go to dashboard')]");







    public void ContactInfo(String Address, String Unit,String State, String zip ) {
        try {

            clearNtypeValue(this.inpStreetName, "Address", Address );
            clearNtypeValue(this.inpUnitNumber, "Unit", Unit );
            clearNtypeValue(this.inpCity, "State", State );
            clearNtypeValue(this.inpzip, "Zip Code", zip );
            clearNtypeValue(this.inpphonenum, "Phone Number", "2133334567");
        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void PaymentByCard (String CardHolderName , String CardNo , String CVC, String Exp , String zip  ) {

        try {

            clearNtypeValue(this.inpCardHoldName, "Card Holder Name", "Anand Thampi");

            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure card number input frame']")));
            clearNtypeValue(this.CARD_NUMBER, "Enter Card Number", CardNo );

            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure expiration date input frame']")));
            clearNtypeValue(this.INPUT_EXPIRY, "Enter the Expiration Date", Exp );


            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure CVC input frame']")));
            clearNtypeValue(this.INPUT_CVC, "Enter the CVC Number", CVC );



            driver.switchTo().defaultContent();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure postal code input frame']")));
            clearNtypeValue(this.INPUT_ZIPCODE, "Enter the Zip code", zip );
            driver.switchTo().defaultContent();

        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void PaymentByBankAccount () {
        try {

            clickObject(this.LnkBankAcc, "Login");
            driver.switchTo().frame("plaid-link-iframe-1");
            driver.findElement(By.cssSelector("button.Button")).click();

            driver.findElement(By.cssSelector(".InstitutionSearchInput__input")).sendKeys("Chase");
            driver.findElement(By.cssSelector(".InstitutionSearchBrandResult__name")).click();

            driver.findElement(By.id("username")).sendKeys("User_Good");
            driver.findElement(By.id("password")).sendKeys("Pass_good");
            driver.findElement(By.cssSelector("button.Button")).click();
            driver.switchTo().defaultContent();


        }catch(Exception e) { System.out.println("Exception Occured" + e); }
    }

    public void Address(String Address) {
        try {
            clearNtypeValue(this.inpStreetName, "Enter the Street Address", Address );
            clearNtypeValue(this.inpphonenum, "Enter the Street Address", "222-222-2222" );
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

