package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class HRATypesPage extends BasePage {

    @FindBy(xpath="//button[@class='ds-c-button ds-c-button--primary ds-u-margin-top--4']/span")
    public WebElement Continue;

    public HRATypesPage(WebDriver driver) {super(driver);
    }
    public HRATypesPage verifyhra() {
        wait.until(ExpectedConditions.visibilityOf(Continue));
        click(Continue);
        return this;
    }
}
