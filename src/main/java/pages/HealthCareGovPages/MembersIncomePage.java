package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;
import java.util.Map;

public class MembersIncomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public MembersIncomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "select[class='ds-c-field']")
    public WebElement incomeTypeDropDown;

    @FindBy(name = "employerName")
    public WebElement employerNameTxtBx;

    @FindBy(name = "incomeAmount")
    public WebElement incomeAmount;

    @FindBy(xpath = "//legend[@class='ds-c-label']/following-sibling::*")
    public List<WebElement> howOftenIncomePaid;

    @FindBy(xpath = "//label[@class='ds-c-label'][contains(.,'Yearly')]")
    public WebElement Paidby;

    @FindBy(name = "employerPhoneNumber")
    public WebElement phoneNumberTxtBx;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void selectMembersIncomeType(String incomeType) {
        selectByPartialVisibleText(incomeTypeDropDown, incomeType);
    }

    public void enterEmployerName(String employerName) {
        employerNameTxtBx.sendKeys(employerName);
    }
    public void enterEmployerName(Map<String, String> map) {
        employerNameTxtBx.sendKeys(map.get("EMPLOYER"));
    }


    public void enterIncomeAmount(String amount) {
        incomeAmount.sendKeys(amount);
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberTxtBx.sendKeys(phoneNumber);
    }

    public void clickSaveAndContinue() {
        click(saveAndContinueBtn);
    }

    public void setHowOftenIncomePaid(String value) {
        clickOnChildElementBasedOnText(howOftenIncomePaid, value);
    }

    public void HowOftenIncomePaid() {
        clickUsingJS(Paidby);
    }

}
