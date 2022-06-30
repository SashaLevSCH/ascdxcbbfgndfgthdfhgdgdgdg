package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class IndividualCoverageHRAPage extends BasePage {

    @FindBy(xpath = "(//input[@name='hraAffordabilityCurrentBenefits'])[2]/following-sibling::label")
    public WebElement No;

    @FindBy(xpath = "(//input[@name='hraAffordabilityCurrentOffers'])[2]/following-sibling::label")
    public WebElement OptoutNo;

    @FindBy(xpath = "//button[@class='ds-c-button ds-c-button--primary ds-u-margin-top--4']/span")
    public WebElement scontinue;

    public IndividualCoverageHRAPage(WebDriver driver) {
        super(driver);
    }

    public IndividualCoverageHRAPage individualhra() {
        wait.until(ExpectedConditions.visibilityOf(No));
        clickUsingJS(No);
        clickUsingJS(OptoutNo);
        clickUsingJS(scontinue);
        return this;
    }

}