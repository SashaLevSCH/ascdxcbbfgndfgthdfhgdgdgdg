package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.Logs;

public class Retry implements IRetryAnalyzer {

	private int retryCnt = 0;

	// This method will be called every time a test fails.
	// It will return true if a test fails, else false

	public boolean retry(ITestResult result) {
		int maxRetryCnt = 0;
		if (retryCnt < maxRetryCnt) {
			retryCnt++;
			result.getTestContext().getSkippedTests().removeResult(result.getMethod());
			Logs.LOGGER.info("Retrying " + result.getName() + " again and the count is " + (retryCnt + 1));
			return true;
		}
		return false;
	}

}

	

