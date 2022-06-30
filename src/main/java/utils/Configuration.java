package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class contains all the properties required to configure the driver
 *
 * @author siri
 */
public class Configuration {

    private static Properties prop;

    /* Browser Configuration */
    public static final Boolean IS_HEADLESS = Boolean.parseBoolean(getValue("execution.headless"));
    public static final String LOCAL_BROWSER = getValue("local.browser");
    public static final String URL = getValue("url");
    public static final String YOPMAIL_URL = getValue("yopmailurl");

    /* Driver Configuration */
    public static final long DEFAULT_IMPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.implicit"));
    public static final long DEFAULT_EXPLICIT_TIMEOUT = Long.parseLong(getValue("timeout.explicit"));

    private static Properties getProp() {
        if (prop == null) {
            prop = new Properties();
            InputStream input;
            try {
                input = new FileInputStream(new File("config.properties"));
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    /**
     * Gets the property value from the config file
     *
     * @param propertyName Property Key set from Environment variables/Maven command line/config
     * @return propertyValue
     */
    public static String getValue(String propertyName) {
        return getProp().getProperty(propertyName);
    }
}
