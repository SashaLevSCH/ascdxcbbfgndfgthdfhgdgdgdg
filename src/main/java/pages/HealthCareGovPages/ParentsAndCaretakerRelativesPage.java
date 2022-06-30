package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.ParentandCaretakerLocator;
import setup.BasePage;

public class ParentsAndCaretakerRelativesPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ParentsAndCaretakerRelativesPage.class);

    private ParentandCaretakerLocator caretakerLocatorPage;


    public ParentsAndCaretakerRelativesPage(WebDriver driver) {
        super(driver);
        this.caretakerLocatorPage = new ParentandCaretakerLocator();
        PageFactory.initElements(driver, caretakerLocatorPage);
    }

    public void clickOnFederal() {
        click(caretakerLocatorPage.no);
      }

    public void clickOnSavebtn() {
        clickUsingJS(caretakerLocatorPage.saveandcontinue);
    }
}
