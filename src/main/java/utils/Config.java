package utils;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class Config {
	private static Properties configProperties;

	private static void getConfig() {
		if (configProperties == null) {
			initConfig();
		}
	}

	private static Properties getAllProperties() {
		Properties prop = new Properties();
		String fileName = Constants.TEST_CONFIG_PATH;
		System.out.println("file" + fileName);
		try (InputStream input = new FileInputStream(fileName)) {
			prop.load(input);
		} catch (Exception e) {
			System.out.println("unable to find the property file" + e);
		}
		return prop;
	}

	/**
	 * method to initialize properties
	 */
	private static synchronized void initConfig() {
		configProperties = new Properties();

		// Read the testdata properties file.
		Map<Object, Object> userConfig = new HashMap<>();
		try {
			userConfig = getAllProperties();
		} catch (Exception e) {
			System.out.println("We could not read the config file testdata.properties. Only default properties are available");
		}

		// Load the testdata properties values if found.
		if (!userConfig.isEmpty()) {
			for (Map.Entry<Object, Object> entry : userConfig.entrySet()) {
				configProperties.put(entry.getKey(), entry.getValue());
			}
		}

		configProperties = getAllProperties();
	}

	/**
	 * Get the property value from the property key
	 *
	 * @param key the key pair from the property
	 * @return value of the property
	 */
	public static String getConfigProperty(String key) {
		if (configProperties == null && key != null) {
			getConfig();
		}
		return (String) Objects.requireNonNull(configProperties).get(key);
	}


}
