package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class MemberInfoSSNPage extends BasePage {

    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public MemberInfoSSNPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "ssn")
    public WebElement ssnTxtBx;

    @FindBy(css = "input[name='doesnothavessn']+label")
    public WebElement doesntHvSSN;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    public List<WebElement> doesSsnMatch;

    public void enterSSN(String ssn) {
        ssnTxtBx.sendKeys(ssn);
    }

    public void clickNoSsn() {
        doesntHvSSN.click();
    }

    public void selectSsnMatchName(String value) {
        clickOnChildElementBasedOnText(doesSsnMatch, value);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }

}
