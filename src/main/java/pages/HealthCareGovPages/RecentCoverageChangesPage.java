package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class RecentCoverageChangesPage extends BasePage {

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public RecentCoverageChangesPage(WebDriver driver) {
        super(driver);
    }

    public RecentCoverageChangesPage verifymembercoverage() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        click(saveAndContinueBtn);
        return this;
    }
}
