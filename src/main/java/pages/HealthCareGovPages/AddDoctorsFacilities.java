package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class AddDoctorsFacilities extends BasePage {
    public AddDoctorsFacilities(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    public WebElement txtBxFindDoctors;

    @FindBy(xpath = "//button[contains(text(), 'Find')]")
    public WebElement btnFind;

    @FindBy(xpath = "//button[contains(text(), 'Skip')]")
    public WebElement btnSkip;

    public void clickOnSkip() {
        wait.until(ExpectedConditions.visibilityOf(btnSkip));
        btnSkip.click();
    }
}
