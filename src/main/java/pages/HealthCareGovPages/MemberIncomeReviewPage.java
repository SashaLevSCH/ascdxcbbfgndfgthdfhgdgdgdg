package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class MemberIncomeReviewPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ContactInformationPage.class);

    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'Yes')]")
    public WebElement yes;

    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement SaveAndcontinuebutton;

    public MemberIncomeReviewPage(WebDriver driver) { super(driver);
    }

    public MemberIncomeReviewPage verifyincome() {
        wait.until(ExpectedConditions.visibilityOf(yes));
        clickUsingJS(yes);
        clickUsingJS(SaveAndcontinuebutton);
        return this;
    }

}
