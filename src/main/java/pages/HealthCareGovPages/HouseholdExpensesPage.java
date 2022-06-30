package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class HouseholdExpensesPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public HouseholdExpensesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='hasDeductionChoices']+label")
    public WebElement memberOneExpenseChkBox;

    @FindBy(xpath = "//input[@type='checkbox']/following-sibling::*")
    List<WebElement> allMembersExpense;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }

    public void selectExpenseForMember() {
        click(memberOneExpenseChkBox);
    }

    public void selectExpenseForMultipleMembers(String[] value) {
        selectMultipleChildrenBasedOnText(allMembersExpense, value);
    }
}
