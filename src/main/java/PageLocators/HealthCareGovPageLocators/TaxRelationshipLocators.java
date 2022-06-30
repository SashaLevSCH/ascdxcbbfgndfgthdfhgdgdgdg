package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaxRelationshipLocators {


    @FindBy(xpath="(//input[@value='true']/following-sibling::label)[1]")
    public WebElement yes;

    @FindBy(xpath="(//fieldset[@class='ds-c-fieldset'])[2]/div[2]/label")
    public WebElement no;

    @FindBy(xpath="(//input[@name='claimedAsADependent'])[2]/following-sibling::label")
    public WebElement nodependent;

    @FindBy(xpath = "//span[contains(.,'Save & continue')]")
    public WebElement SaveAndcontinuebtn;

}
