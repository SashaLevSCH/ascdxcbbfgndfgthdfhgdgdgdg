package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationHelpLocator {

    @FindBy(xpath="//span[text()='No']")
    public WebElement No;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement scontinue;

}
