package Browser;

import utils.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.PropValue;
import utils.PropertiesReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the WebDriver related functions and actions to be performed
 * on browser.
 * 
 */
class Browser {

	private static WebDriver driver = null;
	private static final RemoteWebDriver remoteDriver = null;
	private final PropertiesReader prop = new PropertiesReader();

	public Browser() { }

	private WebDriver setLocalBrowser(String browserType) {

		String browserName = browserType.toUpperCase();
		switch (browserName) {
			case "FIREFOX":
				driver = getFirefoxDriver(System.getProperty("user.dir") + "/src" + File.separator + "resources" + File.separator
						+ "drivers" + File.separator + "geckodriver");
				break;
			case "CHROME":
				if (System.getProperty("os.name").startsWith("Mac")) {
					driver = getChromeDriver(System.getProperty("user.dir") + "/src" + File.separator + "resources" + File.separator
							+ "drivers" + File.separator + "chromedriver");
				} else {
					driver = getChromeDriver(System.getProperty("user.dir") + "/src" + File.separator + "resources" + File.separator
							+ "drivers" + File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
				}
				break;
			case "HEADLESS":
				driver = getHeadlessDriver(System.getProperty("user.dir") + "/src" + File.separator + "resources" + File.separator
						+ "drivers" + File.separator + "chromedriver");
				break;
			case "SAFARI":
				driver = getSafariDriver();
				break;
			default:
				driver = getChromeDriver(System.getProperty("user.dir") + "/src" + File.separator + "resources" + File.separator
						+ "drivers" + File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
				break;
		}

		return driver;
	}

	/**
	 * Initialize Driver with Parameter as "browser"
	 *
	 * @param browser the browser to use for this driver e.g. firefox, chrome
	 * @return WebDriver instance
	 *
	 */
	public WebDriver initializeDriver(String browser) {
		
		if (PropValue.MainConfig.getProperty("serverType").equalsIgnoreCase("local")) {
			driver = setLocalBrowser(browser);
		} else if (PropValue.MainConfig.getProperty("serverType").equalsIgnoreCase("remote")) {
			prop.loadPropertiesFile(Constants.MAIN_CONFIG_PATH);
			driver = remoteDriver;
		}
		return driver;
	}

	private WebDriver getEdgeDriver() {
		return new EdgeDriver();
	}

	/**
	 * Launch Safari Browser
	 * 
	 * @return SafariDriver
	 */
	private WebDriver getSafariDriver() {
		SafariOptions options = new SafariOptions();
		options.getAutomaticProfiling();
		return new SafariDriver(options);
	}

	/**
	 * Launching FireFox Browser
	 * 
	 * @return FirefoxDriver
	 */
	private WebDriver getFirefoxDriver(String driverPath) {
		 System.setProperty("webdriver.gecko.driver", driverPath);
		 return new FirefoxDriver();
	}

	/**
	 *
	 * Get the Chrome Driver
	 *
	 * @param driverPath filepath of chrome driver
	 * @return WebDriver instance for chrome driver
	 */
 	private WebDriver getChromeDriver(String driverPath) {
 		String deviceType = PropValue.MainConfig.getProperty("deviceType");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> mobileEmulation = new HashMap<>();

 		switch(deviceType) {
			case "desktop":
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.addArguments("start-maximized");
				options.addArguments("window-size=768,1024");
				break;
			case "mobile":
				mobileEmulation.put("deviceName", "Pixel 2 XL");
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.setExperimentalOption("mobileEmulation", mobileEmulation);
				break;
			case "tablet":
				mobileEmulation.put("deviceName", "iPad");
				System.setProperty("webdriver.chrome.driver", driverPath);
				options.setExperimentalOption("mobileEmulation", mobileEmulation);
				break;
			default:
				System.setProperty("webdriver.chrome.driver", driverPath);
				break;
		}

		return new ChromeDriver(options);
	}

	/**
	 * Get the Headless Driver
	 *
	 * @param driverPath filepath for headless driver
	 * @return WebDriver instance for headless driver
	 */
	private WebDriver getHeadlessDriver(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		options.addArguments("--ignore-certificate-errors");
		
		
		return new ChromeDriver(options);
	}

	// clear the cookies
	public void clearCookies() {
		driver.manage().deleteAllCookies();
	}

}
