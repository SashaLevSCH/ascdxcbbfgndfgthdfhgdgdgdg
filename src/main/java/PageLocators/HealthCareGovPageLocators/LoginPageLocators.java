package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    @FindBy(xpath = "//input[contains(@name,'username')]")
    public WebElement userName;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-submit btn-success'][contains(.,'Log in')]")
    public WebElement login;
}
