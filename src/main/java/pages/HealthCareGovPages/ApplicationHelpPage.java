package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.ApplicationHelpLocator;
import setup.BasePage;

public class ApplicationHelpPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ApplicationHelpPage.class);

    private ApplicationHelpLocator applicationHelpLocatorpage;

    public ApplicationHelpPage(WebDriver driver) {
        super(driver);
        this.applicationHelpLocatorpage = new ApplicationHelpLocator();

        PageFactory.initElements(driver, applicationHelpLocatorpage);

    }

    public void professionalHelpAndContinue(){

        clickUsingJS(applicationHelpLocatorpage.No);
        clickUsingJS(applicationHelpLocatorpage.scontinue);
    }
}
