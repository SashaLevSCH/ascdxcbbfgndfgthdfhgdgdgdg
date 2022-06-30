package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class MaritalStatusPage extends BasePage{

        @FindBy(xpath="//input[@value='UNMARRIED']/following-sibling::label")
        public WebElement Single;


        @FindBy(xpath="//span[contains(.,'Save & continue')]")
        public WebElement saveandcontinue;

        public MaritalStatusPage(WebDriver driver) {
            super(driver);
        }

        public MaritalStatusPage setapplicationhelp() {
            wait.until(ExpectedConditions.visibilityOf(Single));
            clickUsingJS(Single);
            wait.until(ExpectedConditions.visibilityOf(saveandcontinue));
            clickUsingJS(saveandcontinue);

            return this;
        }

    }