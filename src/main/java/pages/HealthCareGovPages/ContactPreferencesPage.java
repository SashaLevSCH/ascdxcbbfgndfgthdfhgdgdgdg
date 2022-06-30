package pages.HealthCareGovPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

import java.util.List;

public class ContactPreferencesPage extends BasePage {


    @FindBy(xpath="(//input[contains(@type,'radio')])[1]")
    private WebElement email;


    @FindBy(xpath="(//label[contains(@class,'ds-c-label')])[3]")


    @CacheLookup
    public WebElement emailMeAt;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;

    @FindBy(css = "button.ds-c-button.ds-c-button--primary.ds-u-margin-top--4")
    @CacheLookup
    private WebElement saveContinue;


    public ContactPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public ContactPreferencesPage setcontactpref() {

        clickUsingJS(email);
        hardWait(2);
        clickUsingJS(emailMeAt);
        clickUsingJS(saveContinue);
        return this;
    }

}
