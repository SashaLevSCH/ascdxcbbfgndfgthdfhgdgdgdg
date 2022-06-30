package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HouseholdInformationLocators {

    @FindBy(xpath="//input[@value='currentlyIncarcerated']/following-sibling::label")
    public WebElement currentlyincarcerated;

    @FindBy(xpath="(//input[@name='incarceratedStatuses'])[1]/following-sibling::label")
    public WebElement isYes;

    @FindBy(xpath="(//input[@class='ds-c-choice'])[3]/following-sibling::label")
    public WebElement Isdospositionstatus;

    @FindBy(xpath="//span[contains(.,'Save & continue')]")
    public WebElement saveandcontinuebutton;
}
