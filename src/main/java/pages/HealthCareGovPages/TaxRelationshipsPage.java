package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.TaxRelationshipLocators;
import setup.BasePage;

public class TaxRelationshipsPage extends BasePage {


    private static final Logger log = LogManager.getLogger(TaxRelationshipsPage.class);

    private TaxRelationshipLocators taxRelationshipsLocatorPage;


    public TaxRelationshipsPage(WebDriver driver) {
        super(driver);
        this.taxRelationshipsLocatorPage = new TaxRelationshipLocators();
        PageFactory.initElements(driver, taxRelationshipsLocatorPage);
    }

    public void clickOnFederal() {
        clickUsingJS(taxRelationshipsLocatorPage.yes);
        hardWait(5);
    }

    public void clickOnDependent() {
        clickUsingJS(taxRelationshipsLocatorPage.no);
        hardWait(5);
    }

    public void clickOnDependent2() {
        {
            click(taxRelationshipsLocatorPage.nodependent);
            hardWait(5);
            clickUsingJS(taxRelationshipsLocatorPage.SaveAndcontinuebtn);

        }
    }
}


