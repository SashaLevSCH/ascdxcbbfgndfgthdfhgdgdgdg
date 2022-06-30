package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartMyApplicationLocators {

    @FindBy(id="stateDropdownview34")
    public WebElement stateSelectDropdwon;

    @FindBy(id = "guidingQuestionsNext")
    public WebElement startMyApplicationBtn;

    @FindBy(xpath = "//select[contains(@class,'ffmTenantStateDropdown')]")
    public WebElement selectState;

    @FindBy(xpath = "//button[contains(.,'START MY APPLICATION')]")
    public WebElement StartMyApplication;

}
