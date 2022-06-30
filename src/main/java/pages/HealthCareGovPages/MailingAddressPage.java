package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class MailingAddressPage extends BasePage {

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'Yes')]")
    public WebElement Yes;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;

    public MailingAddressPage(WebDriver driver) {
        super(driver);
    }

    public MailingAddressPage verifymailingaddress() {
        wait.until(ExpectedConditions.visibilityOf(Yes));
        clickUsingJS(Yes);
        wait.until(ExpectedConditions.visibilityOf(scontinue));
        clickUsingJS(scontinue);
        return this;
    }

}
