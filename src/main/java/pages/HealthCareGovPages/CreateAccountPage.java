package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.CreateAccountPageLocators;
import setup.BasePage;

import java.util.Map;

public class CreateAccountPage extends BasePage {


    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);

    private CreateAccountPageLocators createAccountPage;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.createAccountPage = new CreateAccountPageLocators();
        PageFactory.initElements(driver, createAccountPage);
    }


    public CreateAccountPage selectState(String visibleText) {
        selectByText(createAccountPage.selectState, visibleText);
        System.out.println("selected State is: " + visibleText);
        tabOut(createAccountPage.selectState);
        return this;
    }


    public CreateAccountPage enterfirstName(String firstname) {
        System.out.println("Entering firstName : " + firstname);
        inputValues(createAccountPage.firstName, firstname);
        tabOut(createAccountPage.firstName);
        return this;
    }


    public CreateAccountPage enterlastName(String lastname) {
        System.out.println("Entering lastName : " + lastname);
        waitForElementToBeVisible(createAccountPage.lastName);
        try {
            inputValues(createAccountPage.lastName, lastname);
            System.out.println("last Name entered is: " + lastname);
            tabOut(createAccountPage.lastName);
        } catch (Exception e) {
            System.out.println("Last Name cannot be entered " + e.getMessage());
        }

        return this;
    }

    public void enterEmailAddress(String email) {
        try {
            inputValues(createAccountPage.email, email);
            System.out.println("Email address entered is: " + email);
            tabOut(createAccountPage.email);
        } catch (Exception e) {
            System.out.println("Email Address cannot be entered " + e.getMessage());
        }
    }


    public CreateAccountPage enterpassword(String passwd) {
        System.out.println("Entering password");
        waitForElementToBeVisible(createAccountPage.password);
        try {
            inputValues(createAccountPage.password, passwd);
            System.out.println("Password entered is: " + passwd);
            tabOut(createAccountPage.password);
        } catch (Exception e) {
            System.out.println("Password cannot be entered " + e.getMessage());
        }

        return this;
    }


    public CreateAccountPage enterconfirmpassword(String passwd) {
        System.out.println("Entering password");
        waitForElementToBeVisible(createAccountPage.password);
        try {
            inputValues(createAccountPage.confirmPassword, passwd);
            System.out.println("Password entered is: " + passwd);
            tabOut(createAccountPage.confirmPassword);
        } catch (Exception e) {
            System.out.println("Password cannot be entered " + e.getMessage());
        }

        return this;
    }

    public CreateAccountPage securityQuestion1(int index) {
        selectByIndex(createAccountPage.securityQuestion1, index);
        System.out.println("selected securityQuestion1  is: " + index);
        tabOut(createAccountPage.securityQuestion1);
        return this;
    }

    public void entersecurityAnswer1(String securityAnswer1) {
        try {
            inputValues(createAccountPage.securityAnswer1, securityAnswer1);
            System.out.println("securityAnswer1 entered is: " + securityAnswer1);
            tabOut(createAccountPage.securityAnswer1);
        } catch (Exception e) {
            System.out.println("securityAnswer1 cannot be entered " + e.getMessage());
        }
    }

    public CreateAccountPage securityQuestion2(int index) {
        selectByIndex(createAccountPage.securityQuestion2, index);
        System.out.println("selected securityQuestion2  is: " + index);
        tabOut(createAccountPage.securityQuestion2);
        return this;
    }

    public void entersecurityAnswer2(String securityAnswer2) {
        try {
            inputValues(createAccountPage.securityAnswer2, securityAnswer2);
            System.out.println("securityAnswer2 entered is: " + securityAnswer2);
            tabOut(createAccountPage.securityAnswer2);
        } catch (Exception e) {
            System.out.println("securityAnswer2 cannot be entered " + e.getMessage());
        }
    }

    public CreateAccountPage securityQuestion3(int index) {
        selectByIndex(createAccountPage.securityQuestion3, index);
        System.out.println("selected securityQuestion2  is: " + index);
        tabOut(createAccountPage.securityQuestion3);
        return this;
    }

    public void entersecurityAnswer3(String securityAnswer3) {
        try {
            inputValues(createAccountPage.securityAnswer3, securityAnswer3);
            System.out.println("securityAnswer3 entered is: " + securityAnswer3);
            tabOut(createAccountPage.securityAnswer3);
        } catch (Exception e) {
            System.out.println("securityAnswer3 cannot be entered " + e.getMessage());
        }
    }

    public CreateAccountPage clickprivacy() {
        clickUsingJS(createAccountPage.privacy);
        System.out.println("Clicked .privacy checkbox ");
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        clickUsingJS(createAccountPage.createAccount);
        System.out.println("Clicked createAccount button ");
        return this;
    }

    public CreateAccountPage createaccount(String State, String firstName, String lastName, String Email, String Passwd) {
        System.out.println("Creating account");
        selectState(State);
        enterfirstName(firstName);
        enterlastName(lastName);
        enterEmailAddress(Email);
        enterpassword(Passwd);
        enterconfirmpassword(Passwd);
        securityQuestion1(1);
        entersecurityAnswer1("station");
        securityQuestion2(1);
        entersecurityAnswer2("child");
        securityQuestion3(1);
        entersecurityAnswer3("cuisine");
        clickprivacy();
        clickCreateAccountButton();

        return this;
    }

    public CreateAccountPage createaccount(Map<String, String> map,String State,String Email, String Passwd) {
        System.out.println("Creating account");
        selectState(State);
        enterfirstName(map.get("FIRST NAME"));
        enterlastName(map.get("LAST NAME"));
        enterEmailAddress(Email);
        enterpassword(Passwd);
        enterconfirmpassword(Passwd);
        securityQuestion1(1);
        entersecurityAnswer1("station");
        securityQuestion2(1);
        entersecurityAnswer2("child");
        securityQuestion3(1);
        entersecurityAnswer3("cuisine");
        clickprivacy();
        clickCreateAccountButton();
        return this;

    }
}