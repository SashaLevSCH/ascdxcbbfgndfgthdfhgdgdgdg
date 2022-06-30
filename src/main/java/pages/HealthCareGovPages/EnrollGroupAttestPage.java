package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EnrollGroupAttestPage extends BasePage {


    public EnrollGroupAttestPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'I agree with the above statement')]")
    public WebElement iagree;

    @FindBy(xpath="//button[@class='ds-c-button ds-c-button--primary qa-continue-btn ds-u-margin-top--4'][contains(.,'Continue')]")
    public WebElement continecoverage;




    public EnrollGroupAttestPage clickGroupAttest() {
        wait.until(ExpectedConditions.visibilityOf(iagree));
        clickUsingJS(iagree);
        wait.until(ExpectedConditions.visibilityOf(iagree));
        clickUsingJS(continecoverage);
        return this;
    }

}
