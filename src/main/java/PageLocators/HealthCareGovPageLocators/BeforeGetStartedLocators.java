package PageLocators.HealthCareGovPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BeforeGetStartedLocators {


    @FindBy(id = "single-married-0")
    public  WebElement single;

    @FindBy(css = "#main-body-content div.lite-card.basic-info-screener.blue-bg div.lite-card-inner div:nth-of-type(2) form.form-inline div:nth-of-type(3) div:nth-of-type(1) div:nth-of-type(1) div:nth-of-type(2) div.toggle-buttons.form-group a:nth-of-type(2)")
    public WebElement married;

    @FindBy(name = "tendon:numDependents")
    public WebElement includeAllOfYourDependentsOn;


    @FindBy(css = "a.btn.btn-lg.btn-success.btn-submit.btn-continue-existing")
    public WebElement continueYourApplication;

    @FindBy(css = "#main-body-content div.lite-card.basic-info-screener.blue-bg div.lite-card-inner div:nth-of-type(2) form.form-inline div:nth-of-type(3) div:nth-of-type(1) div:nth-of-type(4) div.form-group.col-sm-6.col-sm-offset-3.col-md-offset-3.sign-button-wrapper button.btn.btn-lg.btn-success.btn-submit")
    public WebElement Continue;

    @FindBy(id = "income-0")
    public WebElement orLess54000;

    @FindBy(css = "#main-body-content div.lite-card.basic-info-screener.blue-bg div.lite-card-inner div:nth-of-type(2) form.form-inline div:nth-of-type(3) div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div:nth-of-type(2) div.toggle-buttons.form-group a:nth-of-type(2)")
    public WebElement moreThan54000;

    @FindBy(id = "fa-choice-0")
    public WebElement yes;


    @FindBy(css = "a.dependent-applying.btn.radio-label.hidden")
    public WebElement myDependent;

    @FindBy(css = "a.spouse-applying.btn.radio-label.hidden")
    public WebElement mySpouse;

    @FindBy(css = "a.btn.btn-primary.radio-label.prefill-false.active")
    public WebElement no;

    @FindBy(id = "who-is-applying-0")
    public WebElement me;





}
