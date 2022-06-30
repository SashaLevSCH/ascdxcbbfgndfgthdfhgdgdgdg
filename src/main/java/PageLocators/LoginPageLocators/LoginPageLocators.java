package PageLocators.LoginPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {


    @FindBy(xpath = "//input[@id='email']")
    public WebElement inpUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inpPassword;

    @FindBy(xpath = "//button[@label='Login']")
    public WebElement btnLogin;

    @FindBy(xpath = "//button[@label='Sign Out']")
    public WebElement btnSignout;

    @FindBy(xpath = "//a[contains(text(),'Account')]")
    public WebElement LinkAcct;

    @FindBy(xpath = "//div[contains(text(),'Sign out')]")
    public WebElement LnkSignout;

    @FindBy(xpath = "//div[contains(@class,'Reviews')]")
    public WebElement Reviews ;
}
