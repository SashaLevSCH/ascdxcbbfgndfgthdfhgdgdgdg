
package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class PreferredLanguagePage extends BasePage {

    private static final Logger log = LogManager.getLogger(PreferredLanguagePage.class);

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndContinueBtn;

    public PreferredLanguagePage(WebDriver driver) {
        super(driver);
    }

    public void Languageselection() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));

        click(saveAndContinueBtn);

    }

}
