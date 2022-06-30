package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class MemberInformationPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    public MemberInformationPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//span[text()='Save & continue']")
    public WebElement saveAndContinueBtn;

    @FindBy(xpath = "//label[@class='ds-c-label']/preceding-sibling::input[@type='radio']")
    public List<WebElement> spanishOrLatinOption;

    @FindBy(css = "form[method='post'] >:nth-child(3)")
    public List<WebElement> raceOptions;

    @FindBy(xpath = "//label[@class='ds-c-label']")
    public List<WebElement> memberInfoOptions;

    /* Following method will click/select/check any options in the page based on input text
       e.g. for selecting the radio button "No" for the question about Spanish/Latino origin call the method with string argument "No"
       for selecting the checkbox "White" call the method with string arg "White"
    * */
    public void inputMemberInfo(String value) {
        clickOnChildElementBasedOnText(memberInfoOptions, value);
    }

    public void saveAndContinue() {
        click(saveAndContinueBtn);
    }

}
