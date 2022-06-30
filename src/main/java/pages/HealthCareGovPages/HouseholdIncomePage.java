package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class HouseholdIncomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public HouseholdIncomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='checkbox']+label")
    public WebElement memberOneIncomeChkBox;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::*")
    public List<WebElement> allMembersIncomeChkBox;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void setMemberOneIncome() {
        click(memberOneIncomeChkBox);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }

    public void selectIncomeForMembers(String[] value) {
        selectMultipleChildrenBasedOnText(allMembersIncomeChkBox, value);
    }
}
