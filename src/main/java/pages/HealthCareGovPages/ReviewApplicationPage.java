package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class ReviewApplicationPage extends BasePage {
    public ReviewApplicationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void clickSaveAndContinue() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        saveAndContinueBtn.click();
    }
}
