package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class EnrollStatementsAgreePage extends BasePage {


    public EnrollStatementsAgreePage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);



    @FindBy(xpath="//label[@class='ds-c-label'][contains(.,'I agree with the above statements')]")
    public WebElement iagree;



    @FindBy(xpath="//button[@class='ds-c-button ds-c-button--primary'][contains(.,'Continue')]")
    public WebElement signAndContinueBtn;

    @FindBy(xpath="//ul[@class='ds-c-list ds-c-list--bare'][contains(.,'HAROLD SATER')]")
    public WebElement  memberNameLabel;


    @FindBy(name = "signature")
    public WebElement taxfilerssignaturTxtBx;


    @FindBy(xpath="//button[normalize-space()='Select this plan']")
    public WebElement selectthisplan;

    public void setiAgreeToThisStatementChkBx() {
        wait.until(ExpectedConditions.visibilityOf(iagree));
        clickUsingJS(iagree);
    }

    public void enterSignElectronicallyTxtBx(String memberName) {
        wait.until(ExpectedConditions.visibilityOf(taxfilerssignaturTxtBx));
        taxfilerssignaturTxtBx.sendKeys(memberName);
    }

    public void clickSignAndSubmit() {
        wait.until(ExpectedConditions.visibilityOf(signAndContinueBtn));
        signAndContinueBtn.click();
    }

    public void signAndSubmit() {
        wait.until(ExpectedConditions.visibilityOf(memberNameLabel));
        String name = memberNameLabel.getText().split(",")[0];
        enterSignElectronicallyTxtBx(name);
        clickSignAndSubmit();
    }




    public EnrollStatementsAgreePage clickAndAgreeStatements() {

        setiAgreeToThisStatementChkBx();
        wait.until(ExpectedConditions.visibilityOf(memberNameLabel));
        String name = memberNameLabel.getText().split(",")[0];
        System.out.println(name);
        enterSignElectronicallyTxtBx(name);
        clickSignAndSubmit();

        return this;
    }

}
