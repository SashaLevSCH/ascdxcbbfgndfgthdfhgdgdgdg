package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class DisabilitiesAndHelpPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public DisabilitiesAndHelpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='blindOrDisabled']+label")
    public WebElement disabledMemberOne;

    @FindBy(css = "input[name='longTermCare']+label")
    public WebElement helpNeededMemberOne;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    @FindBy(xpath = "//div/input[@name='blindOrDisabled']/following-sibling::*")
    public List<WebElement> disabledMembers;

    @FindBy(xpath = "//div/input[@name='longTermCare']/following-sibling::*")
    public List<WebElement> helpNeededMembers;

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }

    public void selectFirstDisabledMember() {
        click(disabledMemberOne);
    }

    public void selectFirstHelpNeededMember() {
        click(helpNeededMemberOne);
    }

    public void setDisabledMembers(String[] values) {
        selectMultipleChildrenBasedOnText(disabledMembers, values);
    }

    public void setHelpNeededMembers(String[] values) {
        selectMultipleChildrenBasedOnText(helpNeededMembers, values);
    }
}
