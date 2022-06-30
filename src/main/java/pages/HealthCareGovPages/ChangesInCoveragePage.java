package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class ChangesInCoveragePage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public ChangesInCoveragePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='radio']/following-sibling::*")
    public List<WebElement> changeInCoverage;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void setChangesInCoverage(String value) {
        clickOnChildElementBasedOnText(changeInCoverage, value);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }
}
