package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopMailPageLocators {

    @FindBy(xpath = "//input[contains(@id,'login')]")
    public WebElement loginId;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    public WebElement checkInbox;

    @FindBy(xpath = "//a[contains(.,'HealthCare.gov')]")
    public WebElement clickVerifyLink;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement captcha;

    @FindBy(xpath = "//a[contains(.,'Continue to login')]")
    public WebElement Continuetologin;

    @FindBy(id = "ifmail")
    public WebElement ifmailFrame;
}
