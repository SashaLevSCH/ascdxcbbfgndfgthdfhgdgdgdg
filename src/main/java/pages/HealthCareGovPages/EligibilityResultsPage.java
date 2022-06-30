package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

import java.util.List;

public class EligibilityResultsPage extends BasePage {
    public EligibilityResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#viewEligibility")
    public WebElement viewEligibilityNoticeBtn;

    @FindBy(css = "#proceedToEnrollBtn")
    public WebElement continueToEnrollBtn;

    @FindBy(xpath = "//fieldset[@class='sectionSimple last']/legend/following-sibling::*")
    public List<WebElement> fullMedicAidDeterminationSection;

    @FindBy(css = "#sendToMedicaidButton")
    public WebElement sendToMedicAidBtn;

    public void viewNoticeAndContinue() {
        waitForPageToLoad();
        clickViewEligibilityNotice();
        clickOnContinueToEnroll();
    }

    public void clickViewEligibilityNotice() {
        wait.until(ExpectedConditions.visibilityOf(viewEligibilityNoticeBtn));
        viewEligibilityNoticeBtn.click();
    }

    public void clickOnContinueToEnroll() {
        wait.until(ExpectedConditions.visibilityOf(continueToEnrollBtn));
        continueToEnrollBtn.click();
    }

    public void clickOnSendToMedicAid() {
        wait.until(ExpectedConditions.visibilityOf(sendToMedicAidBtn));
        sendToMedicAidBtn.click();
    }
}
