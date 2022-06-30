package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EnrollPlansPage extends BasePage {


    public EnrollPlansPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="(//a[@class='ds-c-button ds-c-button--primary pet-c-plan-card__action-button'][contains(.,'Enroll')])[1]")
    public WebElement Enroll;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;



    public EnrollPlansPage clickEnroll() {
        wait.until(ExpectedConditions.visibilityOf(Enroll));
        clickUsingJS(Enroll);
        return this;
    }

}
