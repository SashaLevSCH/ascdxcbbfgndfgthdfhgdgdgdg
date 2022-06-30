package Browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.HealthCareGovPages.CareHomePage;

import java.util.concurrent.TimeUnit;

/**
 * Class Contains local driver setup
 *
 * @author siri
 */
public class LocalDriverInstance {

    private final String HEADLESS_ARGUMENT = "--headless";
    private WebDriver webDriver;
    private WebDriver driver;
    protected final Logger log = LogManager.getLogger(LocalDriverInstance.class);


    /**
     * Common method to initialize the driver for all Browsers
     */
    private void initializeDriver() {
        String browser = Configuration.LOCAL_BROWSER;
        log.info("Initializing browser: " + browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                initializeChrome();
                break;
            case "firefox":
                initializeFirefox();
                break;
            default:
                throw new RuntimeException("Invalid Browser Input. Valid Browsers are chrome, firefox");
        }
    }

    /**
     * Initialize ChromeDriver
     */
    private void initializeChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
      //  chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1920x1080");
        chromeOptions.addArguments("--ignore-certificate-errors");
         chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--user-data-dir=~/chromeTemp");
       if (Configuration.IS_HEADLESS) {
            chromeOptions.addArguments(HEADLESS_ARGUMENT);
        }
        webDriver = new ChromeDriver(chromeOptions);
    }

    /**
     * Initialize FireFoxDriver
     */
    private void initializeFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Configuration.IS_HEADLESS) {
            firefoxOptions.addArguments(HEADLESS_ARGUMENT);
        }
        webDriver = new FirefoxDriver(firefoxOptions);
    }

    /**
     * Configures the Driver by maximizing and Setting implicit Wait time
     */
    protected void configureDriver() {
        log.info("Maximizing Browser and Setting Implicit Wait Timeout to :" + Configuration.DEFAULT_IMPLICIT_TIMEOUT);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Configuration.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * Launches the specified URL
     */
  protected void launchUrl(String url) {
        log.info("Launching URL: " + url);
        webDriver.get(url);
    }



    public CareHomePage start() {
        initializeDriver();
        configureDriver();
        webDriver.get(Configuration.URL);
        return new CareHomePage(webDriver);
    }





    public WebDriver getWebDriver() {
        return webDriver;
    }



}
