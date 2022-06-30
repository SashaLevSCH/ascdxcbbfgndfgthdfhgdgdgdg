package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageLocators {


    @FindBy(xpath = "//select[contains(@class,'form-control state-dropdown form-control')]")
    public WebElement selectState;

    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    public WebElement firstName;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//select[@name='securityQuestions[0]']")
    public WebElement securityQuestion1;

    @FindBy(xpath = "//select[@name='securityQuestions[1]']")
    public WebElement securityQuestion2;

    @FindBy(xpath = "//select[@name='securityQuestions[2]']")
    public WebElement securityQuestion3;

    @FindBy(xpath = "//input[@name='securityAnswers[0]']")
    public WebElement securityAnswer1;

    @FindBy(xpath = "//input[@name='securityAnswers[1]']")
    public WebElement securityAnswer2;

    @FindBy(xpath = "//input[@name='securityAnswers[2]']")
    public WebElement securityAnswer3;

    @FindBy(xpath = "//input[@name='privacy']")
    public WebElement privacy;

    @FindBy(xpath = "//button[contains(@aria-label,'Create account')]")
    public WebElement createAccount;

}
