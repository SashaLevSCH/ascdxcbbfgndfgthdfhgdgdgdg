package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.PrivacyPolicyLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class PrivacyPolicyPage extends BasePage {
    private static final Logger log = LogManager.getLogger(VerifyYourIdentityPage.class);


    private PrivacyPolicyLocators PrivacyPolicyPage;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
        this.PrivacyPolicyPage = new PrivacyPolicyLocators();
        PageFactory.initElements(driver, PrivacyPolicyPage);
    }


    public void checkPrivacypolicy() {
        scrollingToBottomofAPage(driver);
        wait.until(ExpectedConditions.visibilityOf(PrivacyPolicyPage.iagree));
        clickUsingJS(PrivacyPolicyPage.iagree);
        clickUsingJS(PrivacyPolicyPage.iunderstand);
        clickUsingJS( PrivacyPolicyPage.Takemetotheapplication);
        hardWait(5);

    }

}
