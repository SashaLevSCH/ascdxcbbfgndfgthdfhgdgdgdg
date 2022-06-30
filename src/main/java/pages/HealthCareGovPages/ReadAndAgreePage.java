package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class ReadAndAgreePage extends BasePage {
    public ReadAndAgreePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='reuseTaxDataPermissionIndicator']/following-sibling::*//span[contains(text(), 'I agree')]")
    public WebElement agree;

    @FindBy(xpath = "//input[@name='reuseTaxDataPermissionIndicator']/following-sibling::*//span[contains(text(), 'I disagree')]")
    public WebElement disagree;

    @FindBy(xpath = "//span[contains(text(),'Yes, I reconciled')]")
    public WebElement yesIReconciled;

    @FindBy(xpath = "//label[@class='ds-c-label']/span[contains(text(),'I agree to allow the Marketplace')]")
    public WebElement agreeMarktPlaceToEnCoverage;

    @FindBy(xpath = "//label[@class='ds-c-label']/span[contains(text(),'don’t give the Marketplace permission')]")
    public WebElement dontGiveMarketPlacePermission;

    @FindBy(xpath = "//label[@class='ds-c-label']/span[contains(text(),'I agree to this statement')]")
    public WebElement iAgreeToThisStatement;

    @FindBy(css = "button[type='submit']")
    public WebElement saveAndContinueBtn;

    public void agreeAndProceed() {
        click(agree);
        click(yesIReconciled);
        click(agreeMarktPlaceToEnCoverage);
        click(iAgreeToThisStatement);
        click(saveAndContinueBtn);
    }
}
