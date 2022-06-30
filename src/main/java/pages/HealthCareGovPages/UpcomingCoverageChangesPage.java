package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class UpcomingCoverageChangesPage extends BasePage {
    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public UpcomingCoverageChangesPage(WebDriver driver) {
        super(driver);
    }

    public UpcomingCoverageChangesPage verifymembercoverage() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));

        clickUsingJS(saveAndContinueBtn);
        return this;
    }
}
