package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyLocators {

    @FindBy(id = "checkbox_1")
    public WebElement iagree;

    @FindBy(id = "checkbox_2")
    public WebElement iunderstand;

    @FindBy(css = "button.btn.btn-lg.btn-submit.btn-success")
    public WebElement Takemetotheapplication;



}
