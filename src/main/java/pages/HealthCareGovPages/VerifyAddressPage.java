package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class VerifyAddressPage extends BasePage {
        private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement saveContinue;

   // private VerifyAddressPage verifyAddressPage;


    public VerifyAddressPage(WebDriver driver) {
            super(driver);


    }

    public VerifyAddressPage verifyaddress() {
        wait.until(ExpectedConditions.visibilityOf(saveContinue));
        clickUsingJS(saveContinue);
       return this;

    }
}
