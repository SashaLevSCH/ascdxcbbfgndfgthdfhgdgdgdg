package pages.HealthCareGovPages;

import Browser.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class CareHomePage extends BasePage {

    private static final Logger log = LogManager.getLogger(CareHomePage.class);

    @FindBy(xpath = "//a[@href='/create-account'][contains(.,'TAKE THE FIRST STEP TO APPLY')]")
    private WebElement apply;

    @FindBy(xpath = "//a[contains(@class,'header-link')]")
    public WebElement loginlink;

    public CareHomePage(WebDriver driver) {
        super(driver);
    }


    public CareHomePage clickApply() {
        wait.until(ExpectedConditions.visibilityOf(apply));
        clickUsingJS(apply);
        return this;
    }

    public CareHomePage clickloginlink() {
        wait.until(ExpectedConditions.visibilityOf(loginlink));

        clickUsingJS(loginlink);
        return this;
    }

}
