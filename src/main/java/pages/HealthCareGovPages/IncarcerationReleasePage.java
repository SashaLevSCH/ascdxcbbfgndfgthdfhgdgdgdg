package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class IncarcerationReleasePage extends BasePage {

    public IncarcerationReleasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@class='ds-c-label']/span")
    public WebElement releasedMember;

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void setReleasedMember() {
        wait.until(ExpectedConditions.visibilityOf(releasedMember));
        releasedMember.click();
    }

    public void clickSaveAndContinue() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        saveAndContinueBtn.click();
    }

    public void selectMemberAndContinue() {
        hardWait(3);
        releasedMember.click();
        clickSaveAndContinue();
    }
}
