package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class HealthCareBenefitsThroughJobPage extends BasePage {

    @FindBy(xpath = "//span[contains(.,'Continue')]")
    public WebElement Continue;

    public HealthCareBenefitsThroughJobPage(WebDriver driver) {
        super(driver);
    }
    public HealthCareBenefitsThroughJobPage verify() {

        clickUsingJS(Continue);
        return this;
    }


}

