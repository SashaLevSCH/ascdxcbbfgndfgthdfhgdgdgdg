package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class ValidateHomeAddressPage extends BasePage {
    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);


    @FindBy(xpath ="(//input[contains(@class,'ds-c-choice')])[1]")
    public WebElement USPSrecord;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement saveandContinue;




    public ValidateHomeAddressPage(WebDriver driver) {
        super(driver);
    }

    public ValidateHomeAddressPage verifyHomeaddress() {
        wait.until(ExpectedConditions.visibilityOf(USPSrecord));
        clickUsingJS(USPSrecord);
        wait.until(ExpectedConditions.visibilityOf(saveandContinue));
        clickUsingJS(saveandContinue);

        return this;
    }

}
