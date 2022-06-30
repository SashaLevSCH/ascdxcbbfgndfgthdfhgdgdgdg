package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageLocators.HealthCareGovPageLocators.ContactInfoLocators;
import setup.BasePage;

public class ContactInfoPage  extends BasePage {


    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    private ContactInfoLocators contactInfoPage;


    public ContactInfoPage(WebDriver driver) {
        super(driver);
        this.contactInfoPage = new ContactInfoLocators();
        PageFactory.initElements(driver, contactInfoPage);
    }

    public void fillcontactinfo() {

        clickUsingJS(contactInfoPage.Yes);

        clickUsingJS(contactInfoPage.Male);
        hardWait(2);
        clickUsingJS(contactInfoPage.SaveAndcontinue);
        hardWait(2);

    }

}

