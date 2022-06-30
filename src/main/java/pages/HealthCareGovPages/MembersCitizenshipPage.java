package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class MembersCitizenshipPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public MembersCitizenshipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    public List<WebElement> isNaturalizedOrDerivedCitizen;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void setIsNaturalizedOrDerived(String value) {
        clickOnChildElementBasedOnText(isNaturalizedOrDerivedCitizen, value);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }
}
