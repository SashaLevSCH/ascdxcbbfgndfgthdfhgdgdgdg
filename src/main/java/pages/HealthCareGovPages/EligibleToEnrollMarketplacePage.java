package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EligibleToEnrollMarketplacePage extends BasePage {
    public EligibleToEnrollMarketplacePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='ds-c-step__actions']/a)[1]")
    public WebElement startBtn;

    @FindBy(xpath = "(//div[@class='ds-c-step__actions']/a)[2]")
    public WebElement startBtnOptionalEstimate;

    public void decideToLowerPremium() {
        wait.until(ExpectedConditions.visibilityOf(startBtn));
        startBtn.click();
    }

    public void getOptionalEstimate() {
        wait.until(ExpectedConditions.visibilityOf(startBtnOptionalEstimate));
        startBtnOptionalEstimate.click();
    }
}
