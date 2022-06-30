package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.StartMyApplicationLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class StartMyApplicationPage extends BasePage {
    private static final Logger log = LogManager.getLogger(StartMyApplicationPage.class);

    private StartMyApplicationLocators startMyApplicationLocators;

    public StartMyApplicationPage(WebDriver driver) {
        super(driver);
        this.startMyApplicationLocators = new StartMyApplicationLocators();
        PageFactory.initElements(driver, startMyApplicationLocators);
    }

    public StartMyApplicationPage selectState(String visibleText) {
        selectByText(startMyApplicationLocators.selectState, visibleText);
        System.out.println("selected State is: " + visibleText);
        tabOut(startMyApplicationLocators.selectState);
        return this;
    }





    public void selectStateAndStartApplication(String state){
        waitForElementToBeVisible(startMyApplicationLocators.stateSelectDropdwon);
        javaScriptScrollIntoView(startMyApplicationLocators.stateSelectDropdwon);
       selectByText(startMyApplicationLocators.stateSelectDropdwon,state);
        wait.until(ExpectedConditions.visibilityOf(startMyApplicationLocators.startMyApplicationBtn));

        javaScriptScrollIntoView(startMyApplicationLocators.startMyApplicationBtn);
       clickUsingJS(startMyApplicationLocators.startMyApplicationBtn);
    }
}
