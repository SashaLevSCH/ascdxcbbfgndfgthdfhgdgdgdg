package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class StartGuidingQuestionFlow  extends BasePage {

    public StartGuidingQuestionFlow(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//button[contains(@id,'guidingQuestionsNext')]")
    public WebElement finishmyapp;

    public void clickFinish() {
        wait.until(ExpectedConditions.visibilityOf( finishmyapp));
        finishmyapp.click();
    }
}
