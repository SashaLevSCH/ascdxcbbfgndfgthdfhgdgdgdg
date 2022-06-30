package pages.DoctorsPages;

import org.json.JSONArray;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setup.BasePage;

import static java.lang.Thread.sleep;

public class DoctorsPage extends BasePage {

    public DoctorsPage(WebDriver driver) {
        super(driver);
    }


    public static final String USERNAME = "sidecarhealth";
    public static final String ACCESS_KEY = "9dc2c607-ad6c-4e99-8c29-c2724ac26ed4";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static final By DOCTORIMG = By.xpath("//img[@alt='doctor' and @src='https://qa-doctor-image.sidecarhealth.com/care-providers/1255383139.png']");
    public static final By DOCTORNAME = By.xpath("(//div[@class='Name-jQkLgH eHrImQ'])[1]");
    public static final By DOCTORCARDNAME = By.xpath("(//div[contains(@class, 'List-')])[1]");
    public static final By DOCTORADDRESS = By.xpath("(//div[@class='Address-cVCaJT vheAw'])[1]");
    public static final By DOCTORSTARS = By.xpath("(//span[@class='Star-faDzQZ blWDVQ sidecon-star'])[1]");
    public static final By DOCTORREVIEW = By.xpath("(//div[@class='Reviews-kSXolH knPoqi'])[1]");
    public static final By DOCTORCARDMAP = By.xpath("//div[@class='gmnoprint' and contains(., 'Map data ©2021')]");
    public static final By PRIMARYADDRESS = By.xpath("//h3[contains(., 'Primary address')]");
    public static final By OTHERADDRESS = By.xpath("(//h3[contains(., 'Other address')])[1]");
    public static final By DOCTORADDRESSMAP = By.xpath("//a[contains(@href,'https://maps.google.com')]");
    public static final By DOCTORPHONEMAP = By.xpath("(//a[contains(@href,'tel:')])[2]");
    public static final By DOCTORFIRST = By.xpath("((//div[contains(@class, 'List-')])[2]//div)[1]");
    public static final By DOCTORSlINK = By.xpath("//*[@href=\"/doctors\"]");
    public static final By FAMILYPRACTISE = By.xpath("//*[contains(text(), 'Family Practice')]");
    public static final By CARDIOLOGY = By.xpath("//*[contains(text(), 'Cardiology')]");
    public static final By ADDICTIONCOUSELLING = By.xpath("//*[contains(text(), 'Addiction Counseling')]");
    public static final By DENTISTRY = By.xpath("//*[contains(text(), 'Dentistry')]");
    public static final By SHOWMORESPECILALITY = By.xpath("//*[contains(text(), 'Show more specialties')]");
    public static final By RHEUMATOLOGY = By.xpath("//*[contains(text(), 'Rheumatology')]");
    //    public static final By SEARCH_DOCTORS = By.xpath("//*[contains(text(), 'Search doctors by name or specialty')]");
    public static final By SEARCH_DOCTORS = By.xpath("//div[@class='Select-placeholder']");
    public static final By SEARCH_DOCTORS_AGAIN = By.xpath("//div[@class='Select-value']");
    public static final By SEARCH_LOCATION = By.xpath("//*[@data-qaid=\"input_location\"]");
    public static final By SELECT_LOCATION_DRPDOWN = By.xpath("//*[@data-qaid=\"info_locSuggestion_0\"]");
    public static final By SELECT_DOCTOR_DRPDOWN = By.xpath("//*[contains(@class, \"is-focused\")]/descendant::*[contains(@class, 'sc-dWcDbm')]");
    public static final By DOCTOR_DROPDOWN_ARROW = By.xpath("//*[@class=\"Select-option is-focused\"]/descendant::*[contains(@class, 'sidecon-forward')]");
    public static final By VALIDATE_DOCTOR = By.xpath("//*[starts-with(@class, 'List-fNDiNc k')]/descendant::*[3]");
    public static final By SEARCH_DOCTORS_CLICK = By.xpath("//*[contains(@class, 'Select-multi-value-wrapper')][1]");
    public static final By SEARCH_DOCTORS_COSTS = By.xpath("/descendant::*[contains(text(), 'Costs')][1]");
    public static final By SEARCH_DOCTORS_REVIEWS = By.xpath("/descendant::*[contains(text(), 'Reviews')]");
    public static final By CLICK_DOCTORS = By.xpath("/descendant::*[starts-with(@class, 'InfoColumn-')][1]");
    public static final By DOCTOR_REVIEW = By.xpath("//textarea[@name='description']");
    public static final By REVIEW_BUTTON = By.xpath("//*[@label='Post review']");
    public static final By DOCTOR_OVERALL_RATING = By.xpath("/descendant::*[@data-qaid=\"input_overall\"]/descendant::*[contains(@class, 'sidecon-star')][1]");
    public static final By BEDSIDE_OVERALL_RATING = By.xpath("/descendant::*[@data-qaid=\"input_bedside\"]/descendant::*[contains(@class, 'sidecon-star')][1]");
    public static final By GOTO_DASHBOARD = By.xpath("//*[@data-qaid=\"link_dashboard\"]");
    public static final By BOOKMARKED_DOCTORS = By.xpath("//*[contains(text(), 'Bookmarked Doctors')]");
    public static final By PRINTCOVERAGE = By.xpath("//*[contains(text(), 'Print a copy of your coverage')]");


    public void clickDoctorsLink() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(DOCTORSlINK));
        driver.findElement(DOCTORSlINK).click();
    }

    public void clickFamilyPractise() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(FAMILYPRACTISE));
        driver.findElement(FAMILYPRACTISE).click();
    }

    public void clickCardiology() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(CARDIOLOGY));
        driver.findElement(CARDIOLOGY).click();

    }

    public void clickDentistry() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(DENTISTRY));
        driver.findElement(DENTISTRY).click();

    }

    public void clickPostReview() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(REVIEW_BUTTON));
        element.click();

    }

    public void clickAddictionCounselling() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(ADDICTIONCOUSELLING));
        driver.findElement(ADDICTIONCOUSELLING).click();

    }

    public void scrollDownpage(By page_locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement((page_locator));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void showMoreSpeciality() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SHOWMORESPECILALITY));
        driver.findElement(SHOWMORESPECILALITY).click();

    }

    public void doctorReview(String comment) {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(DOCTOR_REVIEW));
        element.clear();
        element.sendKeys(comment);
    }

    public void clickRheumatology() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(RHEUMATOLOGY));
        driver.findElement(RHEUMATOLOGY).click();

    }

    public void locationSearch(String loc_text) throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SEARCH_LOCATION));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        //   actions.click();
        sleep(2000);
        //  actions.sendKeys(Keys.CLEAR);
        element.clear();
        actions.sendKeys(Keys.CLEAR);
        sleep(2000);
        actions.sendKeys(loc_text);
        element.click();
        actions.build().perform();

        //   WebElement element1 = (new WebDriverWait(driver, 20))
        //         .until(ExpectedConditions.visibilityOfElementLocated(SELECT_LOCATION_DRPDOWN));
        Actions actionsa = new Actions(driver);
        //   actionsa.moveToElement(element1).moveToElement(driver.findElement(SELECT_LOCATION_DRPDOWN));
        actionsa.click();
        actionsa.sendKeys(Keys.DOWN);
        actionsa.sendKeys(Keys.DOWN);
        actionsa.click();
        actionsa.build().perform();

        WebElement element2 = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SELECT_LOCATION_DRPDOWN));

        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element);
        //  actions1.click();
        element2.click();
    }

    public void DoctorsSearchClick() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SEARCH_DOCTORS_CLICK));
        driver.findElement(SEARCH_DOCTORS_CLICK).click();
    }

    public void DoctorVisibility() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(VALIDATE_DOCTOR));
        element.isDisplayed();

    }

    public void clickDoctors() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(CLICK_DOCTORS));
        element.click();

    }

    public void clickDoctorCost() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(SEARCH_DOCTORS_COSTS));
        element.click();

    }

    public void clickReviews() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(SEARCH_DOCTORS_REVIEWS));
        element.click();

    }

    public void docotorOverallRating() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(DOCTOR_OVERALL_RATING));
        element.click();

    }

    public void docotorBedSideRating() {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(BEDSIDE_OVERALL_RATING));
        element.click();

    }

    public void doctorsSearchAgain(String text) throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SEARCH_DOCTORS_AGAIN));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
        sleep(2000);

        WebElement element1 = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(DOCTOR_DROPDOWN_ARROW));

        Actions actionsa = new Actions(driver);
        actionsa.moveToElement(element1).moveToElement(driver.findElement(DOCTOR_DROPDOWN_ARROW));
        actionsa.click();
        actionsa.sendKeys(Keys.DOWN);
        actionsa.sendKeys(Keys.DOWN);
        actionsa.build().perform();
        sleep(2000);
    }


    public void doctorsSearch(String text) throws InterruptedException {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(SEARCH_DOCTORS));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
        sleep(2000);
        WebElement element1 = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(DOCTOR_DROPDOWN_ARROW));
        Actions actionsa = new Actions(driver);
        actionsa.moveToElement(element1).moveToElement(driver.findElement(DOCTOR_DROPDOWN_ARROW));
        actionsa.click();
        actionsa.sendKeys(Keys.DOWN);
        actionsa.sendKeys(Keys.DOWN);
        actionsa.build().perform();
        sleep(2000);
    }

    public void searchDoctor(int account, String zip, String doctorname) throws Exception {
        //acctLoginPage(account);
        clickDoctorsLink();
        locationSearch(zip);
        doctorsSearch(doctorname);
//        Assert.assertTrue(driver.findElement(DOCTORIMG).isDisplayed(), "Doctor image");
        Assert.assertTrue(driver.findElement(DOCTORNAME).isDisplayed(), "Doctor name");
        Assert.assertTrue(driver.findElement(DOCTORADDRESS).isDisplayed(), "Doctor address");
        Assert.assertTrue(driver.findElement(DOCTORSTARS).isDisplayed(), "Doctor stars");
        Assert.assertTrue(driver.findElement(DOCTORREVIEW).isDisplayed(), "Doctor review");
        String doctor = driver.findElement(DOCTORFIRST).getAttribute("textContent");
        System.out.println(doctor);
        if (!doctor.contains(doctorname)) {
            doctorsSearchAgain(doctorname);
        }
        String doctor_after = driver.findElement(DOCTORFIRST).getAttribute("textContent");
        System.out.println(doctor_after);
        Assert.assertTrue(doctor_after.contains(doctorname));
    }


    public By lnkDoctor = By.xpath("//a[contains(text(),'Doctors')]");


    public void SearchBySpecialities(JSONArray specialities) {
        try {
            clickObject(this.lnkDoctor, "Click on the link Doctor");
            //driver.findElement(By.xpath("//*[contains(text(), 'Search doctors by name ')]")).click();
            //driver.findElement(By.xpath("//*[contains(text(), 'Search doctors by name ')]")).sendKeys("David Wallis");
            // driver.findElement(By.cssSelector(".Select-option#react-select-2--option-0")).click();
            System.out.println(specialities);
            for (int i = 0; i < specialities.length(); i++) {

                System.out.println(specialities.get(i));

                clickObject(By.xpath("//*[contains(text(),'" + specialities.get(i) + "')]"), "Click on Speciality " + specialities.get(i));

                int temp = driver.findElements(By.xpath("//*[contains(text(),'" + specialities.get(i) + "')]")).size();
                System.out.println(temp);
                if (temp > 0) {
                    //  objHtmlReport.reportPassFail("Search with  " + specialities.get(i) + " works as  expected ","True", "True");

                }


                clickObject(this.lnkDoctor, "Click on the link Doctor");

            }
        } catch (Exception e) {
            System.out.println("Exception Occured" + e);
        }


    }

    public void LnkDoctor(String Doctorname, String zip) throws Exception {
        clickObject(this.lnkDoctor, "Click on the link Doctor");
        driver.findElement(By.xpath("//*[contains(text(), 'Search doctors by name ')]")).sendKeys("David Wallis");
        driver.findElement(By.cssSelector(".Select-option#react-select-2--option-0")).click();

    }
}