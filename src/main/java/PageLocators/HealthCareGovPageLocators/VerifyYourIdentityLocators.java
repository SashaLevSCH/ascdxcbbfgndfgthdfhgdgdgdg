package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyYourIdentityLocators {

    @FindBy(name = "tendon:phoneNumber")
    public WebElement phoneNumber;

    @FindBy(name = "tendon:dob")
    public WebElement dob;

    @FindBy(name = "tendon:streetName")
    public WebElement street;

    @FindBy(name = "tendon:city")
    public WebElement city;

    @FindBy(name = "tendon:zipCode")
    public WebElement zip;

    @FindBy(xpath="//button[text()='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath="//button[contains(.,'Verify my identity')]")
    public WebElement Verifymyidentity;

    @FindBy(xpath="//div[@class='question-label'][contains(.,'Please select the county for the address you provided.')]")
    public WebElement countyquestion;


    @FindBy(xpath="(//div[contains(@class,'question-label')])[1]")
    public WebElement firstquestion;

    @FindBy(xpath="//div[@class='question-label'])[2]")
    public WebElement secondquestion;
    @FindBy(xpath="//div[@class='question-label'])[3]")
    public WebElement thirdquestion;
    @FindBy(xpath="//div[@class='question-label'])[4]")
    public WebElement fourthquestion;






}
