package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.HouseholdInformationLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class HouseholdInformationPage extends BasePage {

    private static final Logger log = LogManager.getLogger(HouseholdInformationPage.class);

    private HouseholdInformationLocators houseHoldInformationLocatorPage;

    public HouseholdInformationPage(WebDriver driver) {
        super(driver);
        this.houseHoldInformationLocatorPage = new HouseholdInformationLocators();
        PageFactory.initElements(driver, houseHoldInformationLocatorPage);
    }

    public void clickOnCurrentlyInCarcerated() {
        clickUsingJS(houseHoldInformationLocatorPage.currentlyincarcerated);
        clickUsingJS(houseHoldInformationLocatorPage.saveandcontinuebutton);

    }

    public void clickOnYes() {
        wait.until(ExpectedConditions.visibilityOf(houseHoldInformationLocatorPage.isYes));
        clickUsingJS(houseHoldInformationLocatorPage.isYes);
        hardWait(2);
    }

    public void clickOnPendingDispositionAndContinue() {
        clickUsingJS(houseHoldInformationLocatorPage.Isdospositionstatus);
        clickUsingJS(houseHoldInformationLocatorPage.saveandcontinuebutton);
    }

}
