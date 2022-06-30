package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class JobBasedHealthCoverageOffersPage extends BasePage {

    @FindBy(xpath = "//span[contains(.,'Continue')]")
    public WebElement Continue;

    @FindBy(xpath = "(//input[@name='hasEscOffer'])[2]/following-sibling::label")
    public WebElement No;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public JobBasedHealthCoverageOffersPage (WebDriver driver) {
        super(driver);
    }
    public JobBasedHealthCoverageOffersPage verify() {
        wait.until(ExpectedConditions.visibilityOf(Continue));
        clickUsingJS(Continue);
        wait.until(ExpectedConditions.visibilityOf(No));
        clickUsingJS(No);
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        clickUsingJS(saveAndContinueBtn);
        return this;
    }

}

