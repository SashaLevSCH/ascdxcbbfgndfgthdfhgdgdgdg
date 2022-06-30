package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;
import utils.Constants;

public class EnrollPayForHealthPlanPage extends BasePage {


    public EnrollPayForHealthPlanPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="//a[@class='ds-c-button ds-c-button--success ds-u-margin-top--2 qa-pay-link'][contains(.,'Pay For Health Plan Now')]")
    public WebElement PayForHealthPlanNow;


    @FindBy(xpath="//a[@class='ds-c-button ds-c-button--primary'][contains(.,'OK')]")
    public WebElement Ok;



    public EnrollPayForHealthPlanPage PayForHealthPlan() {
        wait.until(ExpectedConditions.visibilityOf(PayForHealthPlanNow));
        clickUsingJS(PayForHealthPlanNow);
        wait.until(ExpectedConditions.visibilityOf(Ok));
        Constants.SAML_LINK =PayForHealthPlanNow.getAttribute("href");
        System.out.println(Constants.SAML_LINK);
        clickUsingJS(Ok);

        return this;
    }




}
