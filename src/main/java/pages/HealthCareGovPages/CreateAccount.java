package pages.HealthCareGovPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class CreateAccount extends BasePage {

    private static final Logger log = LogManager.getLogger(CareHomePage.class);


    @FindBy(xpath = "//select[contains(@class,'form-control state-dropdown form-control')]")
    private WebElement selectState;

    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    private WebElement firstName;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    private WebElement lastName;




    public CreateAccount(WebDriver driver) {
        super(driver);
    }





    public CreateAccount selectState() {
        log.info("clicking the dropdown" );
        selectState.click();
        selectVisibleText(selectState,"Ohio");
        return this;
    }

    public CreateAccount enterfirstName(String firstname) {
        log.info("Entering firstName" );
        inputValues(firstName,firstname);


        return this;
    }


    public CreateAccount enterlastName(String lastname) {
        log.info("Entering lastName" );
        hitEnter(lastName);
        inputValues(lastName,lastname);

        return this;
    }

    public CreateAccount createaccount() {
        log.info("Creating account" );
        selectState();
        enterfirstName("sidecartest1");
        enterlastName("sidecartest1");

        return this;
    }

}
