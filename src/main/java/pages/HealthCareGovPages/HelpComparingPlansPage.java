package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class HelpComparingPlansPage extends BasePage {
    public HelpComparingPlansPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='ds-c-dialog-wrap']>div>div>header>button[type='button']")
    public WebElement btnClose;

    @FindBy(css = "div[class='ds-c-dialog-wrap']>div>div>aside>button[type='button']")
    public WebElement btnNext;

    public void clickCloseBtn() {
        wait.until(ExpectedConditions.visibilityOf(btnClose));
        btnClose.click();
    }

    public void clickNextBtn() {
        wait.until(ExpectedConditions.visibilityOf(btnNext));
        btnNext.click();
    }
}
