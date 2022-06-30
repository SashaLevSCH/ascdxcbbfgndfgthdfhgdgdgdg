package setup;

import Browser.Configuration;

import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import utils.Constants;
import utils.Logs;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Abstract class contains all the common methods used in screen classes
 *
 * @author siri
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected FluentWait<WebDriver> Wait;
    private long explicitWaitTime = 15;

    private static final String ERROR_MESSAGE = "Web Element not available ";


    private static final Logger log = LogManager.getLogger(BasePage.class);
    private boolean isMulti;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Configuration.DEFAULT_EXPLICIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    protected void switchToLatestWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
        }
    }

    protected void clickUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
        executor.executeScript("arguments[0].click();", element);

    }

    protected void findelementtextUsingJS(WebElement element) {
        String value = null;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
        executor.executeScript("arguments[0].click();", element);


    }

    /**
     * Method to check checkbox or click Button.
     * Passing Checkbox or Button Locator (by xpath).
     * Utilized for Referrals page.
     * Utilizes Java script for scroll function.
     */
    public static void CheckboxBtnClickByXpathLocator(WebDriver driver, String CheckboxLocator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement CheckboxBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckboxLocator)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", CheckboxBtn);
        js.executeScript("arguments[0].click();", CheckboxBtn);
    }


    public void SwitchToFrame(String frameName) {
        driver.switchTo().frame(frameName);

    }

    /**
     * Switch out of the frame.
     */

    public void SwitchOutOfFrame() {
        driver.switchTo().defaultContent();
        waitForPageToLoad();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    protected WebDriver SwitchToWindow(String windowHandle) {
        WebDriver windowToSwitchTo = null;
        try {
            windowToSwitchTo = driver.switchTo().window(windowHandle);
        } catch (Exception e) {
            System.out.println("Error: Window " + windowHandle + " could not be found");
        }
        return windowToSwitchTo;
    }


    protected String getPageSource() {
        return driver.getPageSource();
    }


    public void selectByText(WebElement webElement, String text) {
        if (isElementPresent(webElement) && text != null) {
            Select oSelect = new Select(webElement);
            oSelect.selectByVisibleText(text);
        }
    }

    public void selectByValue(WebElement webElement, String value) {
        if (isElementPresent(webElement)) {
            Select oSelect = new Select(webElement);
            oSelect.selectByValue(value);
        } else
            System.out.println("The WebElement to select is not available");
    }

    public void selectByIndex(WebElement webElement, int index) {
        if (isElementPresent(webElement)) {
            Select oSelect = new Select(webElement);
            oSelect.selectByIndex(index);
            log.info("Select first in the dropdown : ");
        }
    }

    public static void selectVisibleText(WebElement element, String visibleText) {
        Select se = new Select(element);
        se.selectByVisibleText(visibleText);
        log.info("Select visible text in the dropdown : ");
    }

    private void setSelected(WebElement element, boolean select) {
        boolean isSelected = element.isSelected();
        if (!isSelected && select || isSelected && !select) {
            element.click();
        }

    }

    public boolean isMultiple() {
        return this.isMulti;
    }

    // Method to select option with containing text
    public void selectByPartialVisibleText(WebElement element, String text) {
        List<WebElement> options = element
                .findElements(By.xpath(".//option[contains(normalize-space(.) , " + Quotes.escape(text) + ")]"));
        boolean matched = false;

        for (Iterator<WebElement> subStringWithoutSpace = options.iterator(); subStringWithoutSpace.hasNext(); matched = true) {
            WebElement candidates = (WebElement) subStringWithoutSpace.next();
            this.setSelected(candidates, true);
            if (!this.isMultiple()) {
                return;
            }
        }

        if (!matched) {
            throw new NoSuchElementException("Cannot locate element with text: " + text);
        }

    }

    public void divselectByPartialVisibleText(WebElement element, String text) {
        List<WebElement> options = element
                .findElements(By.xpath(".//div[contains(normalize-space() , " + Quotes.escape(text) + ")]"));
        boolean matched = false;

        for (Iterator<WebElement> subStringWithoutSpace = options.iterator(); subStringWithoutSpace.hasNext(); matched = true) {
            WebElement candidates = (WebElement) subStringWithoutSpace.next();
            this.setSelected(candidates, true);
            if (!this.isMultiple()) {
                return;
            }
        }

        if (!matched) {
            throw new NoSuchElementException("Cannot locate element with text: " + text);
        }

    }

    public void clickOnChildElementBasedOnText(List<WebElement> element, String text) {
        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().trim().equalsIgnoreCase(text.trim())) {
                hardWait(3);
                click(element.get(i));
            }
        }

    }

    public void selectMultipleChildrenBasedOnText(List<WebElement> element, String[] options) {
        for (int i = 0; i < options.length; i++) {
            for (int j = 0; j < element.size(); j++) {
                if (element.get(j).getText().trim().equalsIgnoreCase(options[i].toString().trim())) {
                    hardWait(3);
                    click(element.get(j));
                }
            }
        }
    }

    protected void inputValues(WebElement element, String text) {
        Actions actions = new Actions(driver);
        waitForElementToBeVisible(element);
        actions.moveToElement(element).sendKeys(text).perform();
    }


    public static boolean isCheckBoxSelected(WebDriver driver, WebElement element) {
        boolean isSelected = element.isSelected();
        return isSelected;
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void resetImplicitTimeout(int newTimeOut) {
        try {
            driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
        } catch (Exception ignored) {
        }
    }


    private void initializeWait() {
        if (this.Wait == null) {
            this.Wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);
        }
    }

    /**
     * @param webElement The {@link WebElement} element is present and found.
     * @return A {@link Boolean} value
     */
    protected boolean isElementPresent(WebElement webElement) {
        boolean isAvailable = false;
        if (this.wait == null) {
            initializeWait();
        }
        try {
            if (wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed()
                    && wait.until(ExpectedConditions.visibilityOf(webElement)).isEnabled()) {
                isAvailable = true;
            }
        } catch (Exception e) {

        }
        return isAvailable;
    }

    public void hitEnter(WebElement element) {
        if (isElementPresent(element)) {
            element.sendKeys(Keys.ENTER);
        }
    }

    protected void tabOut(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    protected void waitForPageToLoad() {
        waitForPageToLoad(25);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Wait for the Page to load by looping x times and checking after every 1
     * second if the page is ready.
     *
     * @param numLoops the number of times loop.
     */
    private void waitForPageToLoad(int numLoops) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // This loop will rotate for 25 times to check If page Is ready after
        // every 1 second.
        // You can replace your value If you wants to Increase or decrease wait
        // time.
        for (int i = 0; i < numLoops; i++) {
            try {
                System.out.println("Waiting for Page to Load - " + getCurrentUrl());
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Waiting for page to load failed");
            }
            // To check page ready state.
            if ("complete".equals(js.executeScript("return document.readyState").toString())) {
                break;
            }
        }
    }


    protected void click(WebElement element) {
        waitForElementToBeVisible(element);
        if (isElementPresent(element)) {
            element.click();
            waitForPageToLoad(20);
        }
    }

    /**
     * Implement Wait for page load for page synchronizations
     **/

    protected void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected void explicitSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    protected void javaScriptOpenNewWindow(String url) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('" + url + "')");
        waitForPageToLoad();
    }

    protected void javaScriptCloseNewWindow(String url) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.close('" + url + "')");
    }


    /**
     * Javascript executor for scrolling view for element .
     */
    protected void javaScriptScrollIntoView(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        waitForElementToBeVisible(element);
        executor.executeScript("arguments[0].scrollIntoView({block: \"center\"})", element);
    }


    public void scrollingToElementofAPage(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        waitForElementToBeVisible(element);
        //executor.executeScript("arguments[0].scrollIntoView();", element);
        executor.executeScript("javascript:window.scrollBy(250, 350)");
        executor.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';", element);


    }

    /**
     * Method to scroll down the page,
     * using javascript
     */
    public static void scrollingToBottomofAPage(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }


    /**
     * Javascript executor for entering text for element .
     */
    protected void EnterUsingJs(WebElement element, String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        waitForElementToBeVisible(element);
        executor.executeScript("arguments[0].value=" + text, element);
    }

    /**
     * Javascript executor for entering text for element .
     */
    protected void EnterMaskedFieldText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        if (isElementPresent(element)) {
            if (text == null || text.isEmpty())
                System.out.println("the search input is null");
            else {
                //Added try-catch as chromedriver for some versions is failing for clear()
                try {
                    element.clear();
                } catch (Exception e) {
                    System.out.println("Error in clearing element : " + String.format("id : %s, type: %s, currentUrl: %s",
                            element.getAttribute("id"), element.getTagName(), getCurrentUrl()));
                }
                explicitSleep(1000);
                element.sendKeys(Keys.HOME, text);
            }
        }
    }


    /**
     * Method to get number and names of frames on page,
     * passing id of the element/frame
     */
    public static void getIframe(WebDriver driver, final String id) {
        final List<WebElement> iframes = driver.findElements(By.tagName(id));
        for (WebElement iframe : iframes) {
            if (iframe.getAttribute("id").equals(id)) {
                out.print("\nThe frame name is" + iframe + "\n");
            }
        }
    }

    /**
     * Method to return number of frames on page,
     * write number on console for troubleshooting
     */
    public static void NumberOrFramewOnPage(WebDriver driver) {
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (int i = 0; i < frames.size(); i++) {
            out.print(MessageFormat.format("frame[{0}]: {1}", i, frames.get(i).getAttribute("id").toString()));
            out.print("\nNumber of Frames: " + frames + "\n");
        }
        out.print("\nNumber of Frames: " + frames.size() + "\n");
    }


    protected void getHref(WebElement element) {
        waitForElementToBeVisible(element);
        if (isElementPresent(element)) {
            String href1 = element.getAttribute("href");
            out.print("\nThe href  is : " + href1 + "\n");
        }
    }


    public String getLinkHref(WebElement element) {
        waitForElementToBeVisible(element);
        Constants.href1 = element.getAttribute("href");
        out.print("\nThe href  is : " + Constants.href1 + "\n");
        return Constants.href1;


    }

    public void switchToWindow(int index) {
        Set<String> windows = driver.getWindowHandles();
        int totalWin = windows.size();
        String winTitle = null;
        for (int i = 0; i < totalWin; i++) {
            if (i == index) {
                winTitle = windows.toArray()[i].toString();
            }
        }
        driver.switchTo().window(winTitle);
        System.out.println(winTitle);
    }

    public void switchToWindow(String windowTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().contains(windowTitle)) {
                return;
            }
        }
    }


    /**
     * refresh the current page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        waitForPageToLoad();
    }

    protected void waitForElementAndRefresh(WebElement element) throws Exception {
        int timer = 1;
        boolean isElementVisible = false;

        while (!isElementVisible) {
            out.println("Waiting for element " + element.toString() + " to appear....");
            refreshPage();
            try {
                isElementVisible = (element.isDisplayed() && element.isEnabled());
            } catch (Exception e) {
            }
            timer = timer + 1;

            if (timer == 20) {
                throw new Exception("Element " + element.toString()
                        + " was not found after refreshing the page and waiting 20 seconds");
            }
        }
        out.println("Element " + element.toString() + " finally appeared!");
    }

    protected boolean isElementClickable(WebElement element) {
        return element.isEnabled() && element.isDisplayed();
    }

    /**
     * @param webElement The {@link WebElement} element is present and found.
     * @return A {@link Boolean} value
     */
    public boolean isElementPresentInstant(WebElement webElement) {
        boolean isAvailable = false;
        this.explicitWaitTime = 2;
        initializeWait();
        try {
            if (wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed()
                    && wait.until(ExpectedConditions.visibilityOf(webElement)).isEnabled()) {
                isAvailable = true;
            }
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e);
        }
        this.explicitWaitTime = 30;
        return isAvailable;
    }

    /**
     * Check if WebElement exist.
     * This is to check if a WebElement exist based off a boolean value.
     *
     * @param webElement Element to check
     * @return A {@link Boolean} value
     */

    protected boolean doesElementExist(WebElement webElement) {
        boolean doesExist = false;
        if (this.wait == null) {
            initializeWait();
        }
        try {
            if (wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed()) {
                doesExist = true;
            }
        } catch (Exception e) {
            System.out.println("Expected: " + webElement.toString() + " was not found.");
        }
        return doesExist;
    }


    /**
     * Input the text when the element is visible
     *
     * @param element The {@link WebElement} element to use.
     * @param text    The text to type.
     */
    protected void inputText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        if (isElementPresent(element)) {
            if (text == null || text.isEmpty())
                System.out.println("the search input is null");
            else {
                //Added try-catch as chromedriver for some versions is failing for clear()
                try {
                    element.clear();
                } catch (Exception e) {
                    System.out.println("Error in clearing element : " + String.format("id : %s, type: %s, currentUrl: %s",
                            element.getAttribute("id"), element.getTagName(), getCurrentUrl()));
                }
                explicitSleep(1000);
                element.sendKeys(text);
            }
        }
    }

    /**
     * Input non-printable keys to a visible element. Ex: Keys.BACKS_PACE or
     * Keys.ENTER
     *
     * @param element The {@link WebElement} element to use.
     * @param k       the key to input
     */
    public void inputKey(WebElement element, Keys k) {
        if (isElementPresent(element)) {
            element.sendKeys(k);
        }
    }

    protected void clearText(WebElement element) {
        if (isElementPresent(element)) {
            element.clear();
        }
    }

    protected String getText(WebElement element) {
        String value = null;
        if (isElementPresent(element)) {
            value = element.getText();
        }
        return (value == null) ? "" : value;
    }


    public String getAttribute(WebElement element, String attribute) {
        String value = null;
        if (isElementPresent(element)) {
            value = element.getAttribute(attribute);
        }
        return (value == null) ? "" : value;
    }

    public String getCSSValues(WebElement element, String attribute) {

        String value = null;
        if (isElementPresent(element)) {
            value = element.getCssValue(attribute);
        }
        return (value == null) ? "" : value;

    }

    public String getTagName(WebElement element) {
        String value = null;
        if (isElementPresent(element)) {
            value = element.getTagName();
        }
        return (value == null) ? "" : value;

    }

    public Boolean isEnabled(WebElement element) {
        if (isElementPresent(element)) {
            return element.isEnabled();
        }
        return false;
    }

    protected Boolean isDisplayed(WebElement element) {
        if (isElementPresent(element)) {
            return element.isDisplayed();
        }
        return false;
    }

    public Boolean isSelected(WebElement element) {
        if (isElementPresent(element)) {
            return element.isSelected();
        }
        return false;
    }

    public List<String> getSelectedValues(List<WebElement> listElements) {
        boolean selected;
        List<String> selectedValues = new ArrayList<>();
        if (listElements != null) {
            for (WebElement listElement : listElements) {
                selected = listElement.isSelected();
                if (selected) {
                    selectedValues.add(listElement.getAttribute("value"));
                }
            }
        }
        return selectedValues;
    }

    /**
     * Select a single radio button or checkboxes provided in the input String
     * param.
     *
     * @param listElements the list of web elements
     * @param sValue       the value
     */
    public void selectBox(List<WebElement> listElements, String sValue) {
        if (listElements != null && sValue != null) {
            for (WebElement listElement : listElements) {
                String labelValue = listElement.getAttribute("value");
                if (labelValue.equalsIgnoreCase(sValue)) {
                    listElement.click();
                    break;
                }
            }
        }
    }


    /**
     * Select the radio button or checkboxes provided in the list param.
     *
     * @param listElements The {@link WebElement} element to use.
     * @param sValues      the list of values
     */
    public void selectBoxes(List<WebElement> listElements, List<String> sValues) {
        if (listElements != null && sValues != null) {
            for (WebElement listElement : listElements) {
                String labelValue = listElement.getAttribute("value");
                for (String sValue : sValues) {
                    if (labelValue.equalsIgnoreCase(sValue)) {
                        listElement.click();
                        break;
                    }
                }
            }
        } else {
            out.println("Unable to select values from down");
        }
    }

    protected String getSelectedText(WebElement webElement) {
        String value = null;
        if (isElementPresent(webElement)) {
            Select oSelect = new Select(webElement);
            value = oSelect.getFirstSelectedOption().getText();
        }
        return (value == null) ? "" : value;
    }


    public void FileToUpload(String FileName) {
        File currentDirectory = new File(new File("").getAbsolutePath());
        String uploadFilePath = currentDirectory + "\\src\\test\\resources\\TestData\\" + FileName;
        out.println(uploadFilePath);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(uploadFilePath);
    }

    public void UploadFile(By element, String FileName) throws Exception {
        try {
            File currentDirectory = new File(new File("").getAbsolutePath());
            String uploadFilePath = currentDirectory + "\\src\\test\\resources\\TestData\\" + FileName;
            driver.findElement(element).sendKeys(uploadFilePath);
            out.println("Uploaded");
        } catch (Exception e) {
        }
    }

    public static String httpPost(String url, JSONObject json, boolean attachFile, String respCode) throws Exception {
        try {
            int statusCode = 0;
            String responseString = "";
            String basicAuth = "athampi@sidecarhealth.com:Iamthebest09!";
            String encodeBasicAuth = Base64.getEncoder().encodeToString((basicAuth).getBytes());

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            System.out.println(url);

            if (attachFile) {
                httpPost.setHeader("Content-Type", "multipart/form-data");
                File fileToUpload = new File("./Results/SeleniumTestReport.html");

                MultipartEntityBuilder entity = MultipartEntityBuilder.create();
                entity.addPart("file", new FileBody(fileToUpload));
                httpPost.setEntity(entity.build());
            } else {
                StringEntity entity = new StringEntity(json.toString());
                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setEntity(entity);
            }

            httpPost.setHeader("Authorization", "Basic " + encodeBasicAuth);  // For Jira Ticket Creation

            CloseableHttpResponse closableHttpResponse = httpClient.execute(httpPost);

            statusCode = closableHttpResponse.getCode();

            System.out.println(statusCode);
            if (statusCode == 200 || statusCode == 201)
                responseString = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");

            httpClient.close();

            return responseString;
        } catch (Exception e) {
            System.out.println("Exception Occured in HTTP POST CALL " + e);
            return "";
        }
    }


    public static String httpGet(String url, String respCode) throws Exception {
        try {
            int statusCode = 0;
            String responseString = "";
            String basicAuth = "athampi@sidecarhealth.com:Iamthebest09!";

            String encodeBasicAuth = Base64.getEncoder().encodeToString((basicAuth).getBytes());
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);

            httpGet.setHeader("Content-Type", "application/json");
            httpGet.setHeader("Authorization", "Basic " + encodeBasicAuth);
            CloseableHttpResponse closableHttpResponse = httpClient.execute(httpGet);

            statusCode = closableHttpResponse.getCode();

            System.out.println(statusCode);
            if (statusCode == 200 || statusCode == 201)
                responseString = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");

            httpClient.close();

            return responseString;
        } catch (Exception e) {
            System.out.println("Exception Occured in HTTP GET CALL " + e);
            return "";
        }
    }


    public void clearNtypeValue(By element, String description, Object valueToType) throws Exception {
        try {
            WebElement objElement = driver.findElement(element);
            objElement.clear();
            objElement.sendKeys(valueToType.toString());
            explicitSleep(1000);
        } catch (Exception e) {
            //  objHtmlReport.reportPassFail(description + " typed with value "+ valueToType, "true", e.toString());
        }
    }


    public void clickObject(By element, String description) throws Exception {
        try {
            driver.findElement(element).click();
            out.println(description + " Clicked");
        } catch (Exception e) {
            out.println(description + " Not Clicked");
        }
    }

    public void mouseHover(By element) throws Exception {
        try {
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(element);
            action.moveToElement(we).click().perform();
            out.println("Clicked");
        } catch (Exception e) {
        }
    }


    public Boolean elementExistance(By strFindElementBy, String strObjectName, int intWaitTime) throws Exception {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(strFindElementBy));
            wait(intWaitTime);
            // objHtmlReport.reportPassFail("Element " + strObjectName + " is  displayed in the expected time","True", "True");
            return true;
        } catch (Exception objException) {
            //  objHtmlReport.reportPassFail("Element " + strObjectName + " is NOT displayed in the expected time","true", "False");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return false;
        }
    }


    public void waitForElement(By element, String description, String waitFor) throws Exception {
        try {
            WebElement objElement = driver.findElement(element);

            switch (waitFor) {
                case "visible":
                    wait.until(ExpectedConditions.visibilityOf(objElement));
                    break;
                case "invisible":
                    wait.until(ExpectedConditions.invisibilityOf(objElement));
                    break;
                case "clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(objElement));
                    break;
                default:
                    wait.until(ExpectedConditions.visibilityOf(objElement));
            }

            // objHtmlReport.reportPassFail("wait succesfull for " + description, "true", "true");
        } catch (Exception e) {
            //  objHtmlReport.reportPassFail("wait succesfull for " + description, "true", e.toString());
        }
    }


    public void searchJS(String by, String locator, String search) throws InterruptedException {
        String expect = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (by.equalsIgnoreCase("id")) {
            WebElement element = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
            element.isDisplayed();
            js.executeScript("document.getElementById('" + locator + "').value = '" + search + "';");
            expect = driver.findElement(By.id(locator)).getText();
        } else if (by.equalsIgnoreCase("class")) {
            WebElement element = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
            element.isDisplayed();
            js.executeScript("document.getElementByClass('" + locator + "').value = '" + search + "';");
            expect = driver.findElement(By.className(locator)).getText();
        } else if (by.equalsIgnoreCase("name")) {
            WebElement element = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
            element.isDisplayed();
            js.executeScript("document.getElementByName('" + locator + "').value = '" + search + "';");
            expect = driver.findElement(By.name(locator)).getText();
        }
        Assert.assertTrue(expect.contains(search));
    }


    public void clickByText(String text) {
        WebElement element = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'" + text + "')])[1]")));
        driver.findElement(By.xpath("(//*[contains(text(),'" + text + "')])[1]")).click();
    }

    public void clickByXpathElement(By element) throws Exception {
        WebElement el = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        Thread.sleep(3000);
    }

    public void insertTextByXpath(By xpath, String text) throws InterruptedException {
        WebElement el = (new WebDriverWait(driver, 60))
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
        WebElement el = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", el);
    }

    public void newinputTextBy(By element, String search) throws Exception {
        Thread.sleep(7000);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(search);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void inputTextBy(By element, String search) throws Exception {
        Thread.sleep(5000);
        WebElement el = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(search);
        Actions actions = new Actions(driver);
        //actions.moveToElement(el);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
    }

    public void inputTextByJs(String id, String search) throws Exception {
        WebElement el = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('" + id + "').defaultValue = '" + search + "';");
        System.out.println("New value should be: " + search + " and equials: " + el.getAttribute("defaultValue"));
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
    }


    public void scrollDownpage(By page_locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement((page_locator));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToMiddle(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight/2,document.body.scrollHeight,document.documentElement.clientHeight/2));");
        executor.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';", element);

    }

    public static void scrollToBottom(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        js.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';", element);

    }

    public static void scrollToTop(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,0));");
        js.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';", element);

    }

    public static void captureScreenShot(WebDriver driver, String browser, String tname, String timeday) throws Exception {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("Screenshots\\" + browser + "_" + tname + "_" + GetTimeStampValue() + ".png"));
    }

    /**
     * Method to get time stamp,
     * returning formated date/time
     */
    private static String GetTimeStampValue() throws Exception {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String timestamp = time.toString();
        out.println(timestamp);
        String sysTime = timestamp.replace(":", "-");
        out.println(sysTime);
        return sysTime;
    }

    public static String generaterandomString(int n) {
        int lowerLimit = 97;
        // lower limit for LowerCase Letters
        int upperLimit = 122;
        Random random = new Random();
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            // take a random value between 97 and 122
            int nextRandomChar = lowerLimit
                    + (int) (random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            // append a character at the end of bs
            r.append((char) nextRandomChar);
            // return the resultant string
        }
        //System.out.println(r.toString());
        return  r.toString();
    }
}


