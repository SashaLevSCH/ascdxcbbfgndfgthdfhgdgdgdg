package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.logging.Level;

public class ExtentManager {

	private static ExtentReports extent;
	private static final String ERROR_MSG = "Unable to initialize reporting tools";

	private ExtentManager() {
		// no-op
	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			String fileName = "Reports/" + PropValue.MainConfig.getProperty("REPORT_NAME")+DateUtils.getCustomTimeStamp()+".html";

			createInstance(fileName);

		}

		return extent;
	}


	public static void createInstance(String fileName) {
		try {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			extent = new ExtentReports();
			htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			htmlReporter.config().setChartVisibilityOnOpen(false);
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle(PropValue.MainConfig.getProperty("REPORT_NAME"));
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName(PropValue.MainConfig.getProperty("REPORT_NAME"));
			extent.attachReporter(htmlReporter);
		} catch (Exception e) {
			Logs.LOGGER.log(Level.SEVERE,ERROR_MSG, e);
			throw new ExtentTestInterruptedException(ERROR_MSG, e);
		}
	}

}