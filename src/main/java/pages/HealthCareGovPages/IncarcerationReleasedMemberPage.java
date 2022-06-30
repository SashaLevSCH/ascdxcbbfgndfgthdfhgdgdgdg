package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BasePage;

import java.util.List;

import static utils.DateUtils.getCurrentDate;

public class IncarcerationReleasedMemberPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);
    public String[] date = null;

    public IncarcerationReleasedMemberPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndContinueBtn;

    @FindBy(xpath = "//legend[@class='ds-c-label']/following-sibling::*/div")
    public List<WebElement> incarcerationRelaseDateFields;

    public void enterIncarcerationReleaseDateAndContinue() {
        String incarDate = getCurrentDate(-40);
        date = incarDate.split("/");
        for (int i = 0; i < incarcerationRelaseDateFields.size(); i++) {
            wait.until(ExpectedConditions.visibilityOf(incarcerationRelaseDateFields.get(i).findElement(By.tagName("input"))));
            incarcerationRelaseDateFields.get(i).findElement(By.tagName("input")).sendKeys(date[i]);
        }
        clickSaveAndContinueBtn();
    }

    public void clickSaveAndContinueBtn() {
        wait.until(ExpectedConditions.visibilityOf(saveAndContinueBtn));
        saveAndContinueBtn.click();
    }
}
