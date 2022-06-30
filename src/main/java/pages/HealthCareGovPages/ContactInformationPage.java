package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class ContactInformationPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ContactInformationPage.class);

      @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement saveandcontinue;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement continue1;

    public ContactInformationPage(WebDriver driver) {
        super(driver);
    }

    public ContactInformationPage ContactInformationPage() {
     if (scontinue.isDisplayed()) {
            clickUsingJS(scontinue);
        }
        hardWait(5);

        if (saveandcontinue.isDisplayed()) {
            clickUsingJS(saveandcontinue);
        }
        hardWait(3);

        if (continue1.isDisplayed()) {
            clickUsingJS(continue1);
        }
        return this;
    }
}
