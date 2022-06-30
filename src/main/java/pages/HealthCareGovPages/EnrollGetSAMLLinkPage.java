package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;
import utils.Constants;

public class EnrollGetSAMLLinkPage extends BasePage {


    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);


    public EnrollGetSAMLLinkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[@class='ds-c-button ds-c-button--success ds-u-margin-top--2 qa-pay-link'][contains(.,'Pay For Health Plan Now')]")
    public WebElement iagree;


    public EnrollGetSAMLLinkPage GgetSAMLinfo() {

        Constants.SAML_LINK =  iagree.getAttribute("href");
        System.out.println(Constants.SAML_LINK);
        return this;
    }


}
