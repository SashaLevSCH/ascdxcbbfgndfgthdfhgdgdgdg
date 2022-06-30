package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HealthCareGovPages.VerifyAddressPage;

import java.util.List;

public class ContactInfoLocators {

    @FindBy(xpath = "//label[@class='ds-c-label'][contains(.,'Female')]")
    public WebElement Female;

    @FindBy(xpath = "//label[@class='ds-c-label'][contains(.,'Male')]")
    public WebElement Male;

    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement SaveAndcontinue;

    @FindBy(xpath = "//label[@class='ds-c-label'][contains(.,'Yes')]")
    public WebElement Yes;

    @FindBy(name = "sex")
    public List<WebElement> male;

    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement SaveAndcontinuebutton;


    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement SaveAndcontinuebtn;

    @FindBy(css = "button.ds-c-button.ds-c-button--primary.ds-u-margin-top--4")
    public WebElement confirmsaveContinue1;



}
