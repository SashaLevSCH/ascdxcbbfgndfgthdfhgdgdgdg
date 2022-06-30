package pages.HealthCareGovPages;

import Browser.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import PageLocators.HealthCareGovPageLocators.YopMailPageLocators;
import setup.BasePage;
import utils.Constants;

public class YopMailPage  extends BasePage {

    private static final Logger log = LogManager.getLogger(YopMailPage.class);

    private YopMailPageLocators yopMailPage;

    public YopMailPage(WebDriver driver) {
        super(driver);
        this.yopMailPage = new YopMailPageLocators();
        PageFactory.initElements(driver, yopMailPage);

    }


    public YopMailPage enterEmailAddress(String loginId) {
        try {
            inputValues(yopMailPage.loginId, loginId);
            System.out.println("Email address entered is: " + loginId);
            tabOut(yopMailPage.loginId);
        } catch (Exception e) {
            System.out.println("Email Address cannot be entered " + e.getMessage());
        }
        return this;
    }


    public YopMailPage clickSubmittButton() {
        clickUsingJS(yopMailPage.checkInbox);
        System.out.println("Clicked checkInbox button ");
        return this;
    }

    public YopMailPage clickCaptcha() {
        clickUsingJS(yopMailPage.captcha);
        System.out.println("Clicked Captcha button ");
        return this;
    }

    public YopMailPage clickVerifyEmail() {
        hardWait(2);
        javaScriptScrollIntoView(yopMailPage.clickVerifyLink);
        clickUsingJS(yopMailPage.clickVerifyLink);
        System.out.println("Clicked clickVerifyLink");
        return this;
    }


    public YopMailPage  clickContinuetologin()  {
        clickUsingJS(yopMailPage.Continuetologin);
        System.out.println("Clicked Continuetologin button");
        return this;
    }

    public YopMailPage maillogin(String loginId) {

        Object[] allWindows;

        String yopUrl = Constants.yopMailPageURL;
        hardWait(2);
        navigateToUrl(yopUrl);
        hardWait(5);
        allWindows = driver.getWindowHandles().toArray();
        SwitchToWindow(allWindows[allWindows.length - 1].toString());
        enterEmailAddress(loginId);
        hardWait(5);
        clickSubmittButton();
        hardWait(1);
        SwitchToFrame("ifmail");
        waitForElementToBeVisible(yopMailPage.clickVerifyLink);
        Constants.href1 =  yopMailPage.clickVerifyLink.getAttribute("href");
        clickVerifyEmail();
        driver.get(yopMailPage.clickVerifyLink.getAttribute("href"));
         switchToWindow(1);
         clickContinuetologin();
        return this;
    }



    public void verifyYourHealthCareAccount(String email) {
        driver.get(Configuration.YOPMAIL_URL);
        inputValues(yopMailPage.loginId,email);
        clickUsingJS(yopMailPage.checkInbox);
        driver.switchTo().frame(yopMailPage.ifmailFrame);
        driver.get(yopMailPage.clickVerifyLink.getAttribute("href"));
        clickContinuetologin();

    }

    public void clickOnContinueToLoginBtn(){
        clickUsingJS(yopMailPage.Continuetologin);
    }


}





