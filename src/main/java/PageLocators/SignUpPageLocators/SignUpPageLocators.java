package PageLocators.SignUpPageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageLocators {

    @FindBy(xpath="//*[@name='zip']")
    public WebElement searchZIP;

    @FindBy(xpath="//button[@class='styles__Button-s1vfu31u-2 kkhCio'][contains(.,'Get quote')])[1]")
    public WebElement btquote;

    @FindBy(xpath="//button[contains(@data-qaid,'btn_addMember')]")
    public WebElement BTNCOVERDEP;

    @FindBy(css="button[data-qaid='btn_continue']")
    public WebElement BTNSEEQUOTES;

    @FindBy(xpath="//input[contains(@data-qaid,'input_email')]")
    public WebElement TextByEmail;

    @FindBy(xpath="//input[contains(@data-qaid,'input_password')]")
    public WebElement TextByPassword;

    @FindBy(xpath="//button[@label='Create account']")
    public WebElement BTNCREATEACCOUNT;

    @FindBy(xpath="//label[1]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']")
    public WebElement CHKBOXConst1;

    @FindBy(xpath="//label[2]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']")
    public WebElement CHKBOXConst2;

    @FindBy(xpath="//label[3]//div[1]//label[1][@class='InputBool-jvxTUn rRgxn']")
    public WebElement CHKBOXConst3;

    @FindBy(xpath="//button[contains(@data-qaid,'buyNow')]")
    public WebElement Button_Buynow;

    @FindBy(xpath="//button[contains(@data-qaid,'Application')]")
    public WebElement Button_CompApplication;

    @FindBy(xpath="//input[@data-qaid='input_autopaymentExpense']/..//span")
    public WebElement chkbox_autopay;

    @FindBy(xpath="//div[contains(@class,'Reviews')]")
    public WebElement Reviews;

    @FindBy(xpath="//*[@id='zip']")
    public WebElement SEARCHZIPSIGNUP;

    @FindBy(xpath="//a[@href='/signup' and contains(.,'Sign up')]")
    public WebElement SIGNUP;

    @FindBy(xpath="//a[@href='/signup' and contains(.,'Sign Up')]")
    public WebElement SIGNUP2;

    @FindBy(xpath="//input[@data-qaid='input_firstName_0']")
    public WebElement FIRSTNAME;

    @FindBy(xpath="//input[@data-qaid='input_lastName_0']")
    public WebElement LASTNAME;

    @FindBy(xpath="//input[@data-qaid='input_dateOfBirth_0']")
    public WebElement BIRTHDAY;

    @FindBy(xpath="//input[@data-qaid='input_firstName_0'])[2]")
    public WebElement FIRSTNAMED1;

    @FindBy(xpath="//input[@data-qaid='input_lastName_0'])[2]")
    public WebElement LASTNAMED1;

    @FindBy(xpath="//input[@data-qaid='input_dateOfBirth_0'])[2]")
    public WebElement BIRTHDAYD1;





}
