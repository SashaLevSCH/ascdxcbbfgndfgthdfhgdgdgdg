package pages.AdminCarePages;

import Browser.Configuration;
import PageLocators.HealthCareGovPageLocators.LoginPageLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HealthCareGovPages.LoginPage;
import setup.BasePage;
import utils.Constants;

public class AdminLoginPage extends BasePage{
        private static final Logger log = LogManager.getLogger(LoginPage.class);



    @FindBy(xpath = "//input[@id='email']")
    public WebElement Email;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement Password;
    @FindBy(xpath = "//button[contains(@data-qaid,'btn_login')]")
    public WebElement Login;


        public AdminLoginPage(WebDriver driver) {
            super(driver);

        }

        public void  login() {
            driver.get(Constants.adminloginPage);
            Email.sendKeys("rmcguirl@sidecarhealth.com");
            tabOut(Email);
            Password.sendKeys("Test1234!");
            clickUsingJS(Login);

            }

        }

