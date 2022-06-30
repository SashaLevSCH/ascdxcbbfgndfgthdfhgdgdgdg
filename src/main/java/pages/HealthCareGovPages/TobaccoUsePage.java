package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class TobaccoUsePage extends BasePage {
    public TobaccoUsePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'No')]")
    public WebElement radioBtnYes;

    @FindBy(xpath = "//span[contains(text(),'No')]")
    public WebElement radioBtnNo;

    @FindBy(xpath = "//button[contains(text(), 'Save & Continue')]")
    public WebElement btnSaveAndContinue;

    public void setRadioBtnYes() {
        wait.until(ExpectedConditions.visibilityOf(radioBtnYes));
        radioBtnYes.click();
    }

    public void setRadioBtnNo() {
        wait.until(ExpectedConditions.visibilityOf(radioBtnNo));
        radioBtnNo.click();
    }

    public void clickSaveAndContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSaveAndContinue));
        btnSaveAndContinue.click();
    }

    public void reportNoTobaccoAndContinue() {
        hardWait(2);
        setRadioBtnNo();
        clickSaveAndContinue();
    }
}
