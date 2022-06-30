package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.LoginPageLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class LoginPage extends BasePage {


    private static final Logger log = LogManager.getLogger(LoginPage.class);

    private LoginPageLocators loginPage;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPageLocators();
        PageFactory.initElements(driver, loginPage);
    }


    public LoginPage enterUserName(String Email) {
        System.out.println("Entering Email : " + Email );
        javaScriptScrollIntoView(loginPage.userName);
        inputValues(loginPage.userName,Email);
        //tabOut(loginPage.userName);
        return this;
    }


    public LoginPage enterPassword(String passwd) {
        System.out.println("Entering passwd : " + passwd );

            loginPage.password.click();
            loginPage.password.sendKeys(passwd);
            System.out.println("passwd entered is: " + passwd);
            //tabOut(loginPage.password);

        return this;
    }


    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.login));
        javaScriptScrollIntoView(loginPage.login);
        clickUsingJS(loginPage.login);
        System.out.println("Clicked login button ");
        return this;
    }

    public LoginPage login(String Email, String passwd) {

        enterUserName(Email);
        enterPassword(passwd);
        clickLoginButton();
        return this;
    }

    public void loginPage(String email, String password) {
        inputValues(loginPage.userName,email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
}
