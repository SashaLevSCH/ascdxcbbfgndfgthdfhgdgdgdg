package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class LifeChangesPage extends BasePage {

    @FindBy(xpath = "(//input[@name='doesSEPApply' and @value='releasedFromJailOrPrison'])/following-sibling::label")
    public WebElement detentionorjail;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public LifeChangesPage(WebDriver driver) {
        super(driver);
    }
    public LifeChangesPage lifechanges() {
        wait.until(ExpectedConditions.visibilityOf(detentionorjail));
        clickUsingJS(detentionorjail);
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        clickUsingJS(saveAndContinueBtn);
        return this;
    }

}
