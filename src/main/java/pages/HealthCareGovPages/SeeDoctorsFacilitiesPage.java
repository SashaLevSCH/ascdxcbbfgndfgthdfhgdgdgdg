package pages.HealthCareGovPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BasePage;

public class SeeDoctorsFacilitiesPage extends BasePage {
    public SeeDoctorsFacilitiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Doctors')]")
    public WebElement chkBxDoctorsAndFacilities;

    @FindBy(xpath = "//span[contains(text(), 'Prescription')]")
    public WebElement chkBxPrescriptionDrugs;

    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    public WebElement btnContinue;

    @FindBy(xpath = "//button[contains(text(), 'Skip')]")
    public WebElement btnSkip;

    public void setChkBxDoctorsAndFacilities() {
        wait.until(ExpectedConditions.visibilityOf(chkBxDoctorsAndFacilities));
        chkBxDoctorsAndFacilities.click();
    }

    public void setChkBxPrescriptionDrugs() {
        wait.until(ExpectedConditions.visibilityOf(chkBxPrescriptionDrugs));
        chkBxPrescriptionDrugs.click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
        btnContinue.click();
    }

    public void clickSkip() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSkip));
        btnSkip.click();
    }

    public void continueWithDoctorsFacilities() {
        setChkBxDoctorsAndFacilities();
        clickContinue();
    }
}
