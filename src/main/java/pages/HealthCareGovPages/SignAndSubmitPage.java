package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class SignAndSubmitPage extends BasePage {
    public SignAndSubmitPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='checkbox']+label")
    public WebElement iAgreeToThisStatement;

    @FindBy(name = "applicationSignatureText")
    public WebElement signElectronicallyTxtBx;

    @FindBy(css = "button[type='submit']")
    public WebElement signAndSubmitBtn;

    @FindBy(xpath = "//span[contains(text(),'electronically')]")
    public WebElement memberNameLabel;

    public void setiAgreeToThisStatementChkBx() {
        wait.until(ExpectedConditions.visibilityOf(iAgreeToThisStatement));
        iAgreeToThisStatement.click();
    }

    public void enterSignElectronicallyTxtBx(String memberName) {
        wait.until(ExpectedConditions.visibilityOf(signElectronicallyTxtBx));
        signElectronicallyTxtBx.sendKeys(memberName);
    }

    public void clickSignAndSubmit() {
        wait.until(ExpectedConditions.visibilityOf(signAndSubmitBtn));
        signAndSubmitBtn.click();
    }

    public void signAndSubmit() {
        setiAgreeToThisStatementChkBx();
        wait.until(ExpectedConditions.visibilityOf(memberNameLabel));
        String name = memberNameLabel.getText().split(",")[0];
        enterSignElectronicallyTxtBx(name);
        clickSignAndSubmit();
    }
}
