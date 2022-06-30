package pages.CarePages;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BasePage;
import utils.JsonReader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarePage extends BasePage {

    public CarePage(WebDriver driver) {
        super(driver);
    }

    public By lnkEstimateCare= By.xpath("//a[contains(@data-qaid,'link_care')]");
    public By caresearch= By.xpath("//*[@data-qaid='input_searchQuery']");
    public By btnsearch= By.xpath("//button[@data-qaid='btn_search']");
    public By lnkDashbaord= By.xpath("//a[contains(@data-qaid,'link_dashboard')]");
    public static final String USERNAME = "sidecarhealth";
    public static final String ACCESS_KEY = "9dc2c607-ad6c-4e99-8c29-c2724ac26ed4";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static final By SHOULDCOST = By.xpath("(//*[@data-qaid='info_shouldCost'])[1]");
    public static final By PLANPAYS = By.xpath("(//*[@data-qaid='info_benefitAmount'])[1]");
    public static final By SEARCHZIP = By.xpath("//*[@id='searchLocation.address']");
    public static final By INPUT_EMAIL = By.xpath("//*[@id='email']");
    public static final By INPUT_PASSWORD = By.xpath("//*[@id=\"password\"]");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(), 'Login')]");
    public static final By ESTIMATElINK = By.xpath("//*[@href=\"/care\"]");
    public static final By DOCTORS_VISIT = By.xpath("//*[contains(text(), 'Doctor visits')]");
    public static final By PRESCRIPTIONS = By.xpath("//*[contains(text(), 'Prescriptions')]");
    public static final By IMAGING = By.xpath("//*[contains(text(), 'Imaging')]");
    public static final By LABWORKS = By.xpath("//*[contains(text(), 'Lab work')]");
    public static final By MEDICINE = By.xpath("//*[contains(text(), 'Medicine')]");
    public static final By SURGERY = By.xpath("//*[contains(text(), 'Surgery')]");
    public static final By EQUIPMENT = By.xpath("//*[contains(text(), 'Equipment')]");
    public static final By TRANSPORTATION = By.xpath("//*[contains(text(), 'Transportation')]");
    public static final By ANESTHISYA = By.xpath("//*[contains(text(), 'Anesthesia')]");

    public static final By CARESEARCHRESULT = By.xpath("//*[@data-qaid=\"list_careSearchResultItem\"][1] | //*[contains(text(), 'No care was found')]");
    public static final By CARERESULT = By.xpath("//*[@data-qaid=\"list_careSearchResultItem\"][1]");
    //public static final By SHOULDCOST = By.xpath("//descendant::*[@data-qaid=\"info_shouldCost\"][2]");
    //public static final By SHOULDCOST = By.xpath("//*/descendant::*[contains(@class, 'sc-iQNlJl hkNWJI') and text() = 'Should cost'][2]");
    public static final By SHOULDCOST2 = By.xpath("//descendant::*[@data-qaid=\"info_shouldCost\"][3]");
    public static final By PLANPAYS2 = By.xpath("//descendant::*[@data-qaid=\"info_planPays\"][3]");
    //public static final By PLANPAYS = By.xpath("//descendant::*[@data-qaid=\"info_sidecarCovers\"][2]");
    public static final By CARENOTFOUND = By.xpath("//*[contains(text(), 'No care was found')]");

    public static final By SEARCHQUERYOBGYN = By.xpath("//*[@data-qaid=\"input_searchQuery\"]");
    public static final By GENDERANY = By.xpath("//*/descendant::*[contains(text(), 'Any')][2]");
    public static final By OBGYNVISIT = By.xpath("//*[contains(text(), 'OBGYN visit')]");
    public static final By GENDERFEMALE = By.xpath("//*[contains(@class,'sidecon-female')]");
    public static final By MAPS = By.xpath("//div[@class='MapFilter-WSrhd fpyySR']");

    public void estimatecare(JSONArray careTypes , String PreviewCoverage, String zip) {
        try {
            if (PreviewCoverage == "No")
                clickObject(this.lnkEstimateCare, "Click on the Link Estimate Care");


            for (int type=0 ; type < careTypes.length(); type++) {

                clearNtypeValue(this.caresearch, "Enter Care name",careTypes.getJSONObject(type).getString("careName"));
                if (PreviewCoverage == "No") {


                    clickObject(this.btnsearch, "Click on the Link Search Estimate Care (Arrow)");}
                else {
                    driver.findElement(By.xpath("//*[@data-qaid='input_searchQuery']")).sendKeys(Keys.ENTER);

                }

                driver.findElement(By.xpath("//div[contains(text(),'"+careTypes.getJSONObject(type).getString("careName")+"')]")).click();
                if (PreviewCoverage == "No") {
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).clear();
                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(zip);
                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).clear();
                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(zip);


                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(Keys.ENTER);
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(Keys.ENTER);


                }

                switch(careTypes.getJSONObject(type).getString("SetType"))  {

                    case "SET4":
                        String Count4 = driver.findElement(By.xpath("//span[text() = 'Form']/..")).getAttribute("data-count");
                        System.out.println(Count4);
                        int Formcnt = Integer.parseInt(Count4);

                        for ( int i = 0; i<= Formcnt-1; i++ )
                        {



                            String Form = driver.findElement(By.xpath("//input[@name='form']")).getAttribute("value");

                            String currentReactId = driver.findElement(By.xpath("//input[@name='form']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                            String cssSelector = currentReactId.replace("value", "option-"+i);
                            driver.findElement(By.xpath("//input[@name='form']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                            driver.findElement(By.cssSelector(".Select-option#"+cssSelector)).click();

                            String Count5 = driver.findElement(By.xpath("//span[text() = 'Dosage']/..")).getAttribute("data-count");
                            System.out.println(Count5);
                            int Dosagecnt = Integer.parseInt(Count5);
                            for ( int j = 0; j<= Dosagecnt-1; j++ )
                            {
                                Thread.sleep(2000);

                                String currentReactId1 = driver.findElement(By.xpath("//input[@name='dosage']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                                String cssSelector1 = currentReactId1.replace("value", "option-"+j);
                                driver.findElement(By.xpath("//input[@name='dosage']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                                driver.findElement(By.cssSelector(".Select-option#"+cssSelector1)).click();
                                String Dosage = driver.findElement(By.xpath("//input[@name='dosage']")).getAttribute("value");

                                System.out.println("j= " + j);
                                String Count6 = driver.findElement(By.xpath("//span[text() = 'Quantity']/..")).getAttribute("data-count");
                                System.out.println(Count6);
                                int Quantitycnt = Integer.parseInt(Count6);
                                for ( int k = 0; k<= Quantitycnt-1; k++ )
                                {
                                    System.out.println("k= " + k);
                                    Thread.sleep(2000);

                                    String currentReactId2 = driver.findElement(By.xpath("//input[@name='quantity']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                                    String cssSelector2 = currentReactId2.replace("value", "option-"+k);
                                    driver.findElement(By.xpath("//input[@name='quantity']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                                    driver.findElement(By.cssSelector(".Select-option#"+cssSelector2)).click();

                                    Thread.sleep(2000);
                                    String Quantity = driver.findElement(By.xpath("//input[@name='quantity']")).getAttribute("value");


                                    double shouldPay = Double.valueOf((driver.findElement(By.xpath(" (//*[@data-qaid='info_shouldCost'])[2] | //*[@data-qaid='info_shouldCost']"))).getText().split("\\$")[1].replace(",", ""));

                                    int shoulPay1 = (int)Math.floor(shouldPay* 80/100);
                                    int shoulPay123 = (int)Math.round(shouldPay* 80/100);
                                    String ShouldPayExpected = "$"+shoulPay1;
                                    String ShouldPayExpectedRound1 = "$"+shoulPay123;
                                    System.out.println(ShouldPayExpected);

                                    String ShouldPayActual = driver.findElement(By.xpath(" (//*[@data-qaid='info_benefitAmount'])[2] | //*[@data-qaid='info_planPays']")).getText();
                                    if (PreviewCoverage == "No") {
                                        String CoverageDescription1 = driver.findElement(By.xpath("//div[contains(@class, 'StickyWrap')]//p")).getText();
                                        System.out.println(CoverageDescription1);
                                        if (CoverageDescription1.contains(ShouldPayExpected) | CoverageDescription1.contains(ShouldPayExpectedRound1)) {
                                            //objHtmlReport.reportPassFail("CoverageDescription display "+ShouldPayExpected +" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Form+" "+ Dosage+ " "+Quantity , "true", "true");

                                        }else {
                                           // objHtmlReport.reportPassFail("CoverageDescription does not display "+ShouldPayActual + " For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Form+" "+ Dosage+ " "+Quantity , "true", "false");

                                        }
                                    }
                                    System.out.println(ShouldPayActual);
                                    if (ShouldPayExpected.equalsIgnoreCase(ShouldPayActual) | ShouldPayExpectedRound1.equalsIgnoreCase(ShouldPayActual) )
                                    {
                                       // objHtmlReport.reportPassFail("Actual Value of Should pay "+ShouldPayActual + " matched the Displayed value " + ShouldPayExpected+" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Form+" "+ Dosage+ " "+Quantity , "true", "true");
                                    }
                                       // objHtmlReport.reportPassFail("Actual Value of Should pay "+ShouldPayActual + " did Not match the Displayed value " + ShouldPayExpected+" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Form+" "+ Dosage+ " "+Quantity , "true", "false");


                                }

                            }
                        }

                        break;

                    case "SET3":
                        String Count = driver.findElement(By.xpath("//span[text() = 'Type']/..")).getAttribute("data-count");
                        System.out.println(Count);
                        int typecnt = Integer.parseInt(Count);
                        for ( int i = 0; i<= typecnt-1; i++ )
                        {
                            System.out.println("entered*********");

                            String currentReactId3 = driver.findElement(By.xpath("//input[@name='type']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                            String cssSelector3 = currentReactId3.replace("value", "option-"+i);
                            driver.findElement(By.xpath("//input[@name='type']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                            driver.findElement(By.cssSelector(".Select-option#"+cssSelector3)).click();


                            String Type = driver.findElement(By.xpath("//input[@name='type']")).getAttribute("value");

                            String Count1 = driver.findElement(By.xpath("//span[text() = 'Receive at']/..")).getAttribute("data-count");
                            int RecieveAtCnt = Integer.parseInt(Count1);
                            System.out.println("i***************** " +i);

                            for ( int j = 0; j<= RecieveAtCnt-1; j++ )
                            {

                                String currentReactId4 = driver.findElement(By.xpath("//input[@name='receiveAt']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                                String cssSelector4 = currentReactId4.replace("value", "option-"+j);
                                driver.findElement(By.xpath("//input[@name='receiveAt']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                                driver.findElement(By.cssSelector(".Select-option#"+cssSelector4)).click();


                                String ReceiveAt = driver.findElement(By.xpath("//input[@name='receiveAt']")).getAttribute("value");

                                System.out.println("j= " + j);

                                String Count2 = driver.findElement(By.xpath("//span[text() = 'Version']/..")).getAttribute("data-count");
                                System.out.println(Count2);
                                int VersionCnt = Integer.parseInt(Count2);

                                for ( int k = 0; k<= VersionCnt-1; k++ )
                                {

                                    String currentReactId5 = driver.findElement(By.xpath("//input[@name='version']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'wrapper')]")).getAttribute("id");
                                    String cssSelector5 = currentReactId5.replace("value", "option-"+k);
                                    driver.findElement(By.xpath("//input[@name='version']/ancestor::div[contains(@class, 'Select')]//span[contains(@class, 'sidecon-dropdown')]")).click();
                                    driver.findElement(By.cssSelector(".Select-option#"+cssSelector5)).click();



                                    String Version = driver.findElement(By.xpath("//input[@name='version']")).getAttribute("value");





                                    double shouldPay = Double.valueOf((driver.findElement(By.xpath(" (//*[@data-qaid='info_shouldCost'])[2] | //*[@data-qaid='info_shouldCost']"))).getText().split("\\$")[1].replace(",", ""));
                                    int shoulPay = (int)Math.floor(shouldPay* 80/100);
                                    int shoulPay12 = (int)Math.round(shouldPay* 80/100);
                                    System.out.println("***MATH ROUND======" +shoulPay12);
                                    String ShouldPayExpected = "$"+shoulPay;
                                    String ShouldPayExpectedRound = "$"+shoulPay12;
                                    System.out.println(ShouldPayExpected);

                                    String ShouldPayActual = driver.findElement(By.xpath(" (//*[@data-qaid='info_benefitAmount'])[2] | //*[@data-qaid='info_planPays']")).getText();
                                    System.out.println(ShouldPayActual);
                                    if (PreviewCoverage == "No") {
                                        String CoverageDescription = driver.findElement(By.xpath("//div[contains(@class, 'StickyWrap')]//p")).getText();
                                        System.out.println(CoverageDescription);
                                        if (CoverageDescription.contains(ShouldPayExpected) |  CoverageDescription.contains(ShouldPayExpectedRound))
                                        {
                                          //  objHtmlReport.reportPassFail("CoverageDescription display "+ShouldPayExpected +" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Type+" "+ ReceiveAt+ " "+Version , "true", "true");

                                        }else {
                                           // objHtmlReport.reportPassFail("CoverageDescription does not display "+ShouldPayActual + " For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Type+" "+ ReceiveAt+ " "+Version , "true", "false");

                                        }
                                    }
                                    if (ShouldPayExpected.equalsIgnoreCase(ShouldPayActual) | ShouldPayExpectedRound.equalsIgnoreCase(ShouldPayActual) )
                                    {
                                       // objHtmlReport.reportPassFail("Actual Value of Should pay "+ShouldPayActual + " matched the Displayed value " + ShouldPayExpected+" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Type+" "+ ReceiveAt+ " "+Version , "true", "true");
                                    }
                                      //  objHtmlReport.reportPassFail("Actual Value of Should pay "+ShouldPayActual + "  Did Not Matchthe Displayed value " + ShouldPayExpected+" For the care type  "+careTypes.getJSONObject(type).getString("careName")+"for the options"+Type+" "+ ReceiveAt+ " "+Version , "true", "true");

                                }
                            }


                        }


                }

                if (PreviewCoverage == "Yes") {
                    driver.navigate().refresh();
                    System.out.println("Refreshed**********");
                    Actions builder = new Actions(driver);
                    builder.sendKeys(Keys.ENTER);
                }else {
                    clickObject(this.lnkDashbaord, "Click on the Link Dashboard");
                    clickObject(this.lnkEstimateCare, "Click on the Link Estimate Care");
                    driver.navigate().refresh();
                    System.out.println("Refreshed**********");
                }
            }


        }catch(Exception e) { System.out.println("Exception Occured " + e); }
    }



    public void CareItemSearch(String Gender,Boolean IsDisplayed,JSONArray careTypes, String PreviewCoverage, String zip) {

        try {
            clickObject(By.xpath("(//label[@data-qaid='input_"+Gender+"-label'])"), "Select Gender as " +Gender);


            for (int type=0 ; type < careTypes.length(); type++)
            {
                //Enter Zip Code
                driver.findElement(By.xpath("//input[@data-qaid='input_location']")).clear();
                driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(zip);
                driver.findElement(By.xpath("//input[@data-qaid='input_location']")).clear();
                driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(zip);
                driver.findElement(By.xpath("//input[@data-qaid='input_location']")).sendKeys(Keys.ENTER);


                //Select Gender
                clearNtypeValue(this.caresearch, "Enter Care name",careTypes.getJSONObject(type).getString("careName"));
                driver.findElement(By.xpath("//*[@data-qaid='input_searchQuery']")).sendKeys(Keys.ENTER);
                Boolean Displayed =driver.findElements(By.xpath("//div[contains(text(),'"+careTypes.getJSONObject(type).getString("careName")+"')]")).size() >0;

                if (Displayed == false)
                {
                    //objHtmlReport.reportPassFail("The Care Item Search for  "+careTypes.getJSONObject(type).getString("careName") + "matched the Displayed value  For the Gender "+Gender , "true", "true");
                }
                else {
                    //objHtmlReport.reportPassFail("The Care Item Search for  "+careTypes.getJSONObject(type).getString("careName") + "did not matched the Displayed value  For the Gender "+Gender , "true", "true");
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public  void inputEmail(int cnt) throws IOException {
        JsonReader t = new JsonReader();
        String userEmail = t.readTxt(cnt);
        driver.findElement(INPUT_EMAIL).sendKeys(userEmail);
    }

    public void readRandomfFile() throws IOException {

    }

    public static String decodePwd(){
        byte[] decodedstring = Base64.decodeBase64("VGVzdDEyMzQh");
        String decodePwd = new String(decodedstring);
        return decodePwd;
    }

    public  void inputPassword() {
        String password = decodePwd();
        System.out.println(password);
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }

    public  void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void clickSeachQueryObgyn() {
        WebElement element = (new WebDriverWait(driver,30))
                .until(ExpectedConditions.elementToBeClickable(SEARCHQUERYOBGYN));
        driver.findElement(SEARCHQUERYOBGYN).sendKeys("obgyn");

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void clickGenderAnyBtn() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(GENDERANY));
        driver.findElement(GENDERANY).click();

        WebElement validationTxtelement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(OBGYNVISIT));
        String textValidation = validationTxtelement.getText();
        Assert.assertEquals(textValidation,"OBGYN visit provider fee");
    }


    public void clickGenderFemaleBtn() {
       /* WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(GENDERFEMALE));
        driver.findElement(GENDERFEMALE).click();
*/

        WebElement element = (new WebDriverWait(driver,30))
                .until(ExpectedConditions.elementToBeClickable(GENDERFEMALE));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.sendKeys(Keys.ENTER).build().perform();


        WebElement validationTxtelement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(OBGYNVISIT));
        String textValidation = validationTxtelement.getText();
        Assert.assertEquals(textValidation,"OBGYN visit provider fee");
    }

    public  void clickCareSearch(String care_text) {
        WebElement element = (new WebDriverWait(driver,30))
                .until(ExpectedConditions.elementToBeClickable(SEARCHQUERYOBGYN));
        driver.findElement(SEARCHQUERYOBGYN).clear();
        driver.findElement(SEARCHQUERYOBGYN).sendKeys(care_text);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void careSearchResult() {
        WebElement element = (new WebDriverWait(driver,30))
                .until(ExpectedConditions.visibilityOfElementLocated(CARERESULT));
        driver.findElement(CARERESULT).click();
    }

    public String careSearchDisplay() {
        String care_searchDisplay = null;
        WebElement care_search_display = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(CARESEARCHRESULT));
        care_searchDisplay = care_search_display.getText();
        //   if (care_searchDisplay == "No care was found"){
        //      System.out.println("No NDC CODE Found");
        //  }
        return care_searchDisplay;
    }

    public  void inputTextBy(By element, String search) throws Exception{
        Thread.sleep(5000);
        WebElement el = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(search);
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
    }

    public void inputTextByJs(String id, String search) throws Exception{
        WebElement el = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('"+id+"').defaultValue = '"+search+"';");
        System.out.println("New value should be: "+search+" and equials: "+el.getAttribute("defaultValue"));
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
    }

    public void insertTextByXpath(By xpath, String text) throws InterruptedException {
        WebElement el = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
        el.click();
        el.sendKeys(text);
    }

    public void clickByXpath(By xpath) {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    public void clickByXpathJS(By xpath) {
        WebElement el = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", el);
    }

    public  void clickEstimateLink() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(ESTIMATElINK));
        driver.findElement(ESTIMATElINK).click();
    }

    public void clickDoctorsVisit() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(DOCTORS_VISIT));
        driver.findElement(DOCTORS_VISIT).click();
    }

    public void clickPrescription() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(PRESCRIPTIONS));
        driver.findElement(PRESCRIPTIONS).click();
    }

    public  void acctLoginPage(int cnt1){
        try {
            inputEmail(cnt1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputPassword();
        clickLoginButton();
    }

    public String shouldCost() {
        WebElement shouldCost = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SHOULDCOST2));
        String should_cost = shouldCost.getText();
        return should_cost;
    }


    public String planPays() {
        WebElement planPays = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(PLANPAYS2));
        String should_cost = planPays.getText();
        return should_cost;
    }


    public  void clickFromListCareByText(String text) throws Exception{
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-qaid='list_careSearchResultItem' and contains(., '" + text + "')]")));
        Thread.sleep(3000);
        element.click();
//		if(!driver.getCurrentUrl().contains("previewCoverage")) {
        Thread.sleep(3000);
//			driver.navigate().refresh();
//			Thread.sleep(50000);
//			}
    }

    public void verifyVisibleElementByTextWait(int wait, String element, String text) {
        WebElement el = (new WebDriverWait(driver, wait))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-qaid='" + element + "' and contains(., '" + text + "')])[1]")));
        Assert.assertTrue(el.isDisplayed());
    }

    public  void verifyVisibleElementByText(String element, String text) {
        Assert.assertTrue(driver.findElements(By.xpath("(//*[@data-qaid='" + element + "' and contains(., '" + text + "')])[1]")).size() == 1);
    }

    public  void verifyElementByText(String text) {
        Assert.assertTrue(driver.findElements(By.xpath("//*[contains(text(), '"+text+"')]")).size() == 1);
    }

    public void waitForPageLoadAndTitleContains(int timeout, String pageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, timeout, 1000);
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    public void waitForElementPresence(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public  void jsWaitForPageToLoad(int timeOutInSeconds) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsCommand = "return document.readyState";

        // Validate readyState before doing any waits
        if (js.executeScript(jsCommand).toString().equals("complete")) {
            return;
        }

        for (int i = 0; i < timeOutInSeconds; i++) {
            TimeUnit.SECONDS.sleep(3);
            if (js.executeScript(jsCommand).toString().equals("complete")) {
                break;
            }
        }
    }

    public  void verifyPercentage(String priceDiscounted, int percentage) throws Exception{
        int first = getPrice(1);
        int second = getPrice(2);
//		int first = 0;
//		int second = 0;
//		String firstEl;
//		String secondEl;
//		if(driver.getCurrentUrl().contains("previewCoverage")){
//			secondEl="(//div[contains(@data-qaid,'info_planPays') and contains(., '$')])[1]";
//		}
//		else {
//			secondEl="(//*[@data-qaid='" + priceDiscounted + "' and contains(., '$')])[1]";
//		}
//		firstEl="(//div[contains(@data-qaid,'info_shouldCost') and contains(., '$')])[1]";
//		first = Integer.parseInt((driver.findElement(By.xpath(firstEl)).getAttribute("innerText")).replace("$", "").replace(",", "").replace(".", "").replace("*", ""));
//		second = Integer.parseInt((driver.findElement(By.xpath(secondEl)).getAttribute("innerText")).replace("$", "").replace(",", "").replace(".", ""));
//		System.out.println(first+" - first price");
//		System.out.println(second+" - second price");
        System.out.println(Math.round(first*percentage/100)+" - "+percentage+"%");
        if(first<=0){
            Assert.assertFalse(true, "prices should be not 0");
        }
        else{
            Assert.assertTrue(Math.round(first*percentage/100)==second||Math.round(first*percentage/100)==second-1||Math.round(first*percentage/100)==second+1, "Should be equial: "+ second);}
    }

    public  void verifyCarePriceWithSideCar(int order) throws Exception{
        int info_benefitAmount = Integer.parseInt((driver.findElement(By.xpath("(" + ("//*[@data-qaid='info_benefitAmount']") + ")[" + order + "]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
        int pharmacyrate = 0;
        int infomemberpays = 0;
        System.out.println(info_benefitAmount + " - Benefit Amount");
        if(driver.findElements(By.xpath("(" + ("//*[@data-qaid='info_pharmacyRate']") + ")[" + order + "]")).size()!=0) {
            pharmacyrate = Integer.parseInt((driver.findElement(By.xpath("(" + ("//*[@data-qaid='info_pharmacyRate']") + ")[" + order + "]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
            infomemberpays = Integer.parseInt((driver.findElement(By.xpath("(" + ("//*[@data-qaid='info_memberPays']") + ")[" + order + "]")).getAttribute("innerText")).replace("$", "").replace(",", "")); }
        else {
            pharmacyrate = Integer.parseInt((driver.findElement(By.xpath("(" + ("//*[@data-qaid='info_rate']") + ")[" + order + "]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
            infomemberpays = Integer.parseInt((driver.findElement(By.xpath("(" + ("//*[@data-qaid='info_costAfter']") + ")[" + order + "]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
        }
        System.out.println(pharmacyrate + " - pharmacy rate or Info Rate");
        System.out.println(infomemberpays + " - infomember pays or Info Cost After");
        System.out.println(Math.round(pharmacyrate - info_benefitAmount) + " Should be equial: " + infomemberpays + " infomemberpays");
        Assert.assertTrue(Math.round(pharmacyrate - info_benefitAmount) == infomemberpays, "Should be equial: " + infomemberpays);
    }

    public  void verifyBenefitAmountInText(String amount) throws Exception{
        Thread.sleep(8000);
        int benefit = getPrice(2);
        String deductText = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[3]")).getText();
        String afterBenText = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[4]")).getText();
        System.out.println("Found benefit deduct text is: "+deductText);
        System.out.println("Found deductible after Ben Text is : "+afterBenText);
        int deductible = getPriceFromText(deductText);
        int afterBenefit = getPriceFromText(afterBenText);
        int total = benefit-deductible;
        System.out.println("Found benefit amount is: "+benefit);
        System.out.println("Found deductible amount is : "+deductible);
        System.out.println("Found afterBenefit amount is : "+afterBenefit);
        String second = (driver.findElement(By.xpath("(//*[@data-qaid='info_benefitAmount' and contains(., '$')])[1]")).getAttribute("innerText")).replace("$","").replace(",","");
        System.out.println("Found benefit amount value: " + second);
        System.out.println("Found total after discount amount value: " + total);
        if(amount.contains("$0")) {
//			if (amount.isEmpty()) {
//				Assert.assertTrue(deductText.contains(second), "Should be: " + second);
//			} else {
//				Assert.assertTrue(deductText.contains(amount), "Should be equial: " + amount);
//			}
        }
        else{
            Assert.assertTrue(amount.contains(String.valueOf(total)),  total+ ": should be equial: " + amount);
        }
    }

    public  void verifyBenefitModuleAmounts(int shouldcost, int benefit, int deduct, int maxBenefit) throws Exception{
        Thread.sleep(8000);
        int shouldcostAm = getPrice(1);
        int benefitAm = getPrice(2);
        Boolean bool = driver.findElements(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[3]")).size()!=0;
        if(bool==true){
            String deductText = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[3]")).getText();
            String afterBenText = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[4]")).getText();
            System.out.println("Found benefit deduct text is: "+deductText);
            System.out.println("Found deductible after benefit text is : "+afterBenText);
            int deductible = getPriceFromText(deductText);
            int afterBenefit = getPriceFromText(afterBenText);
            int total = benefit-deductible;
            System.out.println("Found deductible amount is : "+deductible);
            System.out.println("Found afterBenefit amount is : "+afterBenefit);
            System.out.println("Found total after discount amount value: " + total);
            Assert.assertEquals(deduct, deductible,  deduct+ ": should be equial: " + deductible);
            Assert.assertEquals(maxBenefit, afterBenefit,  maxBenefit+ ": should be equial: " + afterBenefit);
            Assert.assertEquals(total, afterBenefit,  total + ": should be equial: " + afterBenefit);
        }
        else{
            Assert.assertEquals(shouldcost, shouldcostAm,  shouldcost + ": should be equial: " + shouldcostAm);
            Assert.assertEquals(benefit, benefitAm,  benefit + ": should be equial: " + benefitAm);
            Assert.assertEquals(maxBenefit, benefitAm,  maxBenefit + ": should be equial: " + benefitAm);
        }
        System.out.println("Found benefit amount is: "+benefit);
        Assert.assertEquals(shouldcost, shouldcostAm,  shouldcost+ ": should be equial: " + shouldcostAm);
        Assert.assertEquals(benefit, benefitAm,  benefit+ ": should be equial: " + benefitAm);
    }

    public static int getPriceFromText(String text) {
        Pattern p = Pattern.compile("(?<=\\$)(.*?)(?=\\s)");
        Matcher m = p.matcher(text);
        String benefit ="";
        if (m.find()) { benefit= m.group(0).replace(",","");}
        int total = Integer.valueOf(benefit);
        return total;
    }

    public  int getPrice(int order) throws Exception {
        int first = 0;
        int second = 0;
        int price = 0;
        String firstEl;
        String secondEl;
        if (driver.getCurrentUrl().contains("previewCoverage")) {
            secondEl = "(//div[contains(@data-qaid,'info_planPays') and contains(., '$')])[1]";
        } else {
            secondEl = "(//*[@data-qaid='info_benefitAmount' and contains(., '$')])[1]";
        }
        firstEl = "(//div[contains(@data-qaid,'info_shouldCost') and contains(., '$')])[1]";
        first = Integer.parseInt((driver.findElement(By.xpath(firstEl)).getAttribute("innerText")).replace("$", "").replace(",", "").replace(".", "").replace("*", ""));
        second = Integer.parseInt((driver.findElement(By.xpath(secondEl)).getAttribute("innerText")).replace("$", "").replace(",", "").replace(".", ""));
        if(order==1){
            price=first;
            System.out.println(first + " - first price");
        }
        else if (order==2){
            price=second;
            System.out.println(second + " - second price");
        }
        return price;
    }

    public  String benefitAmount() {
        String textprice = "";
        Boolean prbol = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[2]")).isDisplayed();
        if (prbol == true) {
            textprice = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[2]")).getText();
        } else {
            textprice = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[3]")).getText();
        }
        return textprice;
    }

    public  String deductAmount() {
        String textprice = driver.findElement(By.xpath("(//p[contains(@data-qaid,'info_benefitDisclaimer')])[4]")).getText();
        return textprice;
    }

    public  void verifyBenefitAmountPriceBox(String status) throws Exception{
        Thread.sleep(8000);
        int first = getPrice(1);
        int second = getPrice(2);
        String textprice=benefitAmount();
        String textbuttom = "Covered only with valid prescription. None of these prices include the cost of any additional care provided along side this one.";
        String textcoupon = "Requires coupon for this price";
        String textapply = " will apply to your max benefit";
        String textApplyDed = " will apply to your deductible";
        String textapplynoactive = "because your policy is not active";
//		Assert.assertTrue(driver.findElement(By.xpath("(//p[contains(text(), '"+textcoupon+"')])[2]")).isDisplayed(),"should have: "+ textcoupon);
//		Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(), '"+textbuttom+"')])[2]")).isDisplayed(),"should have: "+ textbuttom);
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(), '"+textapply+"')])[2]")).isDisplayed(),"should have: "+ textapply);
        if(status.equalsIgnoreCase("active")){
//			Assert.assertTrue(textprice.replace(",","").contains(String.valueOf(second)), textprice+" should have: "+ second);
        }
        else if(status.equalsIgnoreCase("not active")){
            Assert.assertTrue(textprice.contains("$0"), textprice+" should have: $0");
            Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(text(), '"+textapplynoactive+"')])[2]")).isDisplayed(),"should have: "+ textapplynoactive);
        }
        else if(status.equalsIgnoreCase("has deductible")){
            Assert.assertTrue(textprice.contains(String.valueOf(second)), textprice+" should have: "+ second);
        }
        else if(status.equalsIgnoreCase("threshold met")){
            Assert.assertTrue(textprice.contains(String.valueOf(second)), textprice+" should have: "+ second);
            Assert.assertTrue(first==second, first+" should equals: "+ second);
        }
        else if(status.equalsIgnoreCase("allowance met")){
            Assert.assertTrue(first!=second, first+" should not equals: "+ second);
        }
    }

    public  void verifyPriceRXOnMap() throws Exception{
        Assert.assertTrue(driver.findElement(MAPS).getAttribute("outerHTML").contains("cursor: url(&quot;https://maps.gstatic.com/mapfiles/openhand_8_8.cur&quot;)"), "Should have line: maps.gstatic.com");
        Assert.assertTrue(!driver.findElement(MAPS).getAttribute("outerText").isEmpty(), "Price should be on map");
        Assert.assertTrue(driver.findElement(MAPS).isDisplayed(), "Maps should be visible");
        int discount = Integer.parseInt((driver.findElement(By.xpath("(//*[@data-qaid='info_benefitAmount'])[1]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
        System.out.println("Plan pays amount: "+discount);
        WebElement element = driver.findElement(By.xpath("(//div[@class='Wrap-ehpYKc bRyyQK' and contains(.,'$')])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        int price = Integer.parseInt((driver.findElement(By.xpath("(//div[@data-qaid='info_modalBackground']//div[4]//div[2])[2]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
        int afterDiscount = Integer.parseInt((driver.findElement(By.xpath("(//div[@data-qaid='info_modalBackground']//div[4]//div[2])[4]")).getAttribute("innerText")).replace("$", "").replace(",", ""));
        System.out.println("Price before Sidecar Health benefit: "+ price);
        System.out.println("Price after Sidecar Health benefit: "+ afterDiscount);
        Assert.assertTrue(price-discount==afterDiscount, price-discount + " should be equal: "+afterDiscount);
    }

    public void verifyCarePinOnMap() throws Exception{
        Assert.assertTrue(driver.findElement(MAPS).getAttribute("outerHTML").contains("cursor: url(&quot;https://maps.gstatic.com/mapfiles/openhand_8_8.cur&quot;),"), "Should have line: maps.gstatic.com");
        Assert.assertTrue(!driver.findElement(MAPS).getAttribute("outerText").isEmpty(), "Price should be on map");
        Assert.assertTrue(driver.findElement(MAPS).isDisplayed(), "Maps should be visible");
        WebElement element = driver.findElement(By.xpath("(//div[@data-qaid='btn_priceOverlay' and contains(.,'$')])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("(//div[@class='Name-jQkLgH eHrImQ'])[1]")).size()==1);
        Assert.assertTrue(driver.findElements(By.xpath("(//span[contains(@class,'Cost') and contains(.,'$')])[1]")).size()==1);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='SingleDoctorInfo-eVBZNC gEAYSl' and contains(.,'$')])[1]")).isDisplayed());
    }
}





