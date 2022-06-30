package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParentandCaretakerLocator {

    @FindBy(xpath="(//input[@name='ParentCaretakerRelativeStatusQuestion'])[2]/following-sibling::label")
    public WebElement no;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement saveandcontinue;
}
