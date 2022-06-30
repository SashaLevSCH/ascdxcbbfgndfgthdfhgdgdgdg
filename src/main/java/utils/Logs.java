
package utils;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Logs {

	public static Logger LOGGER;

	private static String currentDateTime;

	static {
		try {
			// log file name
			FileHandler logFileName = new FileHandler(Constants.LOGS_DIR + "/" + Constants.LOG_FILENAME, true);
			Formatter logFormatter = new Formatter() {
				@Override
				public String format(LogRecord record) {
					Date now = new Date();
					currentDateTime = DateFormat.getInstance().format(now);
					if (record.getLevel().toString().equalsIgnoreCase("SEVERE")) {
						return "*****************************************" + "********* \n" + currentDateTime + " "
								+ record.getLevel() + "  :  " + record.getSourceClassName() + "."
								+ record.getSourceMethodName() + " >> " + record.getMessage() + "\n"
								+ "****************************************" + "********** \n";
					} else {
						return currentDateTime + " " + record.getLevel() + "  :  " + record.getMessage() + "\n";
					}
				}
			};
			logFileName.setFormatter(logFormatter);
			LOGGER = Logger.getLogger("Automation");
			LOGGER.addHandler(logFileName);
			LOGGER.setLevel(Level.ALL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
