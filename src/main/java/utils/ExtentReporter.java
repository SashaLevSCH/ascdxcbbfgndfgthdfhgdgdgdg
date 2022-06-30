package utils;

import org.testng.IExecutionListener;

import com.aventstack.extentreports.ExtentReports;

/**
 * A custom listener for Extent Reporting

 */
public class ExtentReporter implements IExecutionListener {

	static ExtentReports extent;

	@Override
	public void onExecutionStart() {
		extent = ExtentManager.getInstance();
	}

	@Override
	public void onExecutionFinish() {
		if (extent != null) {
			extent.flush();
		}
	}

}
