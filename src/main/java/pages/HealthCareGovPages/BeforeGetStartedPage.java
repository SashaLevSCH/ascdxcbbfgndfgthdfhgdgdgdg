package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.BeforeGetStartedLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class BeforeGetStartedPage extends BasePage {


    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    private BeforeGetStartedLocators beforeGetStartedPage;


    public BeforeGetStartedPage(WebDriver driver) {
        super(driver);
        this.beforeGetStartedPage = new BeforeGetStartedLocators();
        PageFactory.initElements(driver, beforeGetStartedPage);
    }

    public void apply() {
        wait.until(ExpectedConditions.visibilityOf(beforeGetStartedPage.single));
        clickUsingJS(beforeGetStartedPage.single);
        selectByIndex(beforeGetStartedPage.includeAllOfYourDependentsOn,1);
        hardWait(5);
        clickUsingJS(beforeGetStartedPage.orLess54000);
       // clickUsingJS(beforeGetStartedPage.yes);
        clickUsingJS(beforeGetStartedPage.Continue);
        hardWait(5);



    }



}
