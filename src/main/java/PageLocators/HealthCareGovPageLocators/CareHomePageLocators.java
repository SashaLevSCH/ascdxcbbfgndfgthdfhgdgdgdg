package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareHomePageLocators {

    @FindBy(xpath = "//a[@href='/create-account'][contains(.,'TAKE THE FIRST STEP TO APPLY')]")
    public WebElement apply;



}
