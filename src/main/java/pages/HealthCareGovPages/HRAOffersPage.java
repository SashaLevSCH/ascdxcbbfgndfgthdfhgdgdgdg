package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class HRAOffersPage extends BasePage {
    @FindBy(xpath = "(//input[@name='hraOffersChoices'])[2]/following-sibling::label")
    public WebElement No;

    @FindBy(css = "form[method='post']>button[type='submit']")
    public WebElement saveAndContinueBtn;

    public HRAOffersPage(WebDriver driver) {
        super(driver);
    }

    public HRAOffersPage hraoffers() {
        wait.until(ExpectedConditions.visibilityOf(No));
        clickUsingJS(No);
        clickUsingJS(saveAndContinueBtn);
        return this;
    }
}
