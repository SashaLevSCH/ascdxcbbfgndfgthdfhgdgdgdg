package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class LifeEventsAndCoverageChangesPage extends BasePage {
    @FindBy(xpath = "//span[contains(.,'Continue')]")
    public WebElement Continue;

    public LifeEventsAndCoverageChangesPage(WebDriver driver) {
        super(driver);
    }
    public LifeEventsAndCoverageChangesPage verify() {
        wait.until(ExpectedConditions.visibilityOf(Continue));
        clickUsingJS(Continue);
        return this;
    }
}
