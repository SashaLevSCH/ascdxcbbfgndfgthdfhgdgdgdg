package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class MedicaidPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public MedicaidPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='radio']/following-sibling::*")
    public List<WebElement> medicaidDenial;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void setMedicaidDenial(String value) {
        clickOnChildElementBasedOnText(medicaidDenial, value);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }
}
