package pages.AdminCarePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.BasePage;

public class AdminCarePage extends BasePage {

    public AdminCarePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[contains(.,'Add care')]")
    public WebElement addCare;

    @FindBy(xpath = "//input[@id='sidecarCode']")
    public WebElement sidecarCode;

    @FindBy(xpath = "//span[contains(text(),'Search terms')]")
    public WebElement searchterms;

    @FindBy(xpath = "//div[@class='ModalHeader-gBXKsJ dYcqWN'][contains(.,'New care item')]")
    public WebElement Newcareitem;


    @FindBy(xpath = "//div[@class='Select-placeholder'][contains(.,'Search terms')]")
    public WebElement Searchtermss;

    @FindBy(xpath = "(//span[@class='Icon-gOzeRA bcBELB sidecon-dropdown'])[4]")
    public WebElement entersearchterms;

    @FindBy(xpath = "(//input[contains(@aria-expanded,'false')])[5]")
    public WebElement inputsearchterms;


    //div[contains(@class,'Select-placeholder')])[6]
    public void  clickmodule(WebElement element) {
        waitForElementToBeVisible(element);
        clickUsingJS(element);
    }


    public void  enterSearchTems() {
        javaScriptScrollIntoView(Searchtermss);
        waitForElementToBeVisible(Searchtermss);
        clickUsingJS(Searchtermss);
        javaScriptScrollIntoView(inputsearchterms);
        clickUsingJS(inputsearchterms);
        EnterMaskedFieldText(inputsearchterms,"careterm");
    }




}