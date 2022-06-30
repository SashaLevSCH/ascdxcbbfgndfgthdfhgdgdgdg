package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EnrollGroupPage extends BasePage {


    public EnrollGroupPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath="//button[normalize-space()='Select this plan']")
    public WebElement selectthisplan;




    public EnrollGroupPage clickEnrollgroup() {
        scrollingToElementofAPage(selectthisplan);
        wait.until(ExpectedConditions.visibilityOf(selectthisplan));
        clickUsingJS(selectthisplan);
        return this;
    }

}
