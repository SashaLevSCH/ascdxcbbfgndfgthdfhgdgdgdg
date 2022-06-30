package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EnrollGroupConfirmPage extends BasePage {



    public EnrollGroupConfirmPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="//input[contains(@id,'radio_dental-prompt')]")
    public WebElement yesdentalplan;

    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'No, complete health plan enrollment.')]")
    public WebElement nodentalplan;

    @FindBy(xpath="//button[contains(text(),'Continue')]")
    public WebElement continueenroll;


//button[@class='ds-c-button ds-c-button--primary qa-btn-continue ds-u-radius ds-u-margin-top--2'][contains(.,'Continue')]

    public EnrollGroupConfirmPage clickgroupconfirm() {
        wait.until(ExpectedConditions.visibilityOf(nodentalplan));
        clickUsingJS(nodentalplan);
        wait.until(ExpectedConditions.visibilityOf(continueenroll));
        clickUsingJS(continueenroll);
        return this;
    }

}
