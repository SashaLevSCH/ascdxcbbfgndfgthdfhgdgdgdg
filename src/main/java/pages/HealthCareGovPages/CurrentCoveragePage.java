package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class CurrentCoveragePage extends BasePage {

    @FindBy (css = "form[method='post']>button[type='submit']")
    public WebElement scontinue;

    public CurrentCoveragePage(WebDriver driver) {
        super(driver);}

        public CurrentCoveragePage memberscoverage() {
            hardWait(3);
            click(scontinue);
            return this;
        }
    }
