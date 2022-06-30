package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class VerifyContactInfoPage extends BasePage {

    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'Yes')]")
    public WebElement Yes;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;

    public VerifyContactInfoPage(WebDriver driver) {
        super(driver);
    }

    public VerifyContactInfoPage verifycontactinfo() {

        clickUsingJS(scontinue);
        hardWait(5);
        return this;
    }

}
