package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class WhoNeedsCoveragePage extends BasePage {

    @FindBy(xpath="//button[@class='ds-c-button ds-c-button--primary ds-u-margin-top--4']/span")
    public WebElement scontinue;

    public WhoNeedsCoveragePage(WebDriver driver) {
        super(driver);
    }

    public WhoNeedsCoveragePage setcoverage() {
        wait.until(ExpectedConditions.visibilityOf(scontinue));
        click(scontinue);
        return this;
    }

}
