package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

import java.util.List;

public class UseYourTaxPage extends BasePage {
    public UseYourTaxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//fieldset[@class='ds-c-fieldset']/div")
    public List<WebElement> lowerPremiumOptions;

    @FindBy(xpath = "//input[@type='radio' and @value='ALL']/parent::div[1]")
    public WebElement radioBtnAll;

    @FindBy(xpath = "//input[@type='radio' and @value='SOME']/parent::div[1]")
    public WebElement radioBtnSome;

    @FindBy(xpath = "//input[@type='radio' and @value='NONE']/parent::div[1]")
    public WebElement radioBtnNone;

    @FindBy(xpath = "//button[contains(text(),'Save & Continue')]")
    public WebElement saveAndContinueBtn;

    public void selectRadioBtnAll() {
        wait.until(ExpectedConditions.visibilityOf(radioBtnAll));
        radioBtnAll.click();
    }

    public void selectRadioBtnSome() {
        wait.until(ExpectedConditions.visibilityOf(radioBtnSome));
        radioBtnSome.click();
    }

    public void selectRadioBtnNone() {
        wait.until(ExpectedConditions.visibilityOf(radioBtnNone));
        radioBtnNone.click();
    }

    public void clickSaveAndContinue() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        saveAndContinueBtn.click();
    }

    public void selectAllAndContinue() {
        selectRadioBtnAll();
        clickSaveAndContinue();
    }
}
