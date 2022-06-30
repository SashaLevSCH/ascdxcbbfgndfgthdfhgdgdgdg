package utils;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import com.aventstack.extentreports.ExtentTest;
import utils.Logs;

/**
 * Soft Assert which allows the test to continue even in event of failure
 *
 */
public class SoftAssert extends Assertion {
	private final Map<AssertionError, IAssert> failedAsserts = Maps.newHashMap();
	private ExtentTest test;
	private static final String ERROR_REPORT_LOG = "Unable to print assertion status in the report";

	public SoftAssert() {
		// no-op
	}

	@Override
	public void executeAssert(IAssert assertCommand) {
		// Test Method Name is the 6th element in StackTrace Array
		test = ReportListener.getExtentTestMap()
				.get(Thread.currentThread().getStackTrace()[4].getMethodName() + Thread.currentThread().getId());
		try {
			assertCommand.doAssert();
			onAssertSuccess(assertCommand);
		} catch (AssertionError ex) {
			onAssertFailure(assertCommand, ex);
			failedAsserts.put(ex, assertCommand);
		}
	}

	@Override
	protected void doAssert(IAssert assertCommand) {
		executeAssert(assertCommand);
	}

	@Override
	public void onAssertSuccess(IAssert assertCommand) {
		printAssertionLog(assertCommand);
		try {
			String pas = ": Test Pass";
			test.pass(assertCommand.getMessage() + pas);
		} catch (Exception e) {
			Reporter.log(ERROR_REPORT_LOG + " " + e.getMessage());
		}
	}

	/**
	 * Method to print the info messages in the report
	 * 
	 * @param description message to be logged
	 */
	public void info(String description) {
		test = ReportListener.getExtentTestMap()
				.get(Thread.currentThread().getStackTrace()[2].getMethodName() + Thread.currentThread().getId());
		test.info(description);
	}

	/**
	 * assert all the individuals asserts
	 * 
	 */
	public void assertAll() {
		StringBuilder sb = new StringBuilder();
		if (failedAsserts.isEmpty()) {
			return;
		}
		ITestResult result = Reporter.getCurrentTestResult();
		String msg = String.format("Following soft asserts failed in %s.%s(): ", result.getTestClass().getName(),
				result.getMethod().getMethodName());
		sb.append(msg);
		sb.append("/n");
		for (Entry<AssertionError, IAssert> eachEntry : failedAsserts.entrySet()) {
			IAssert<?> eachAssert = eachEntry.getValue();
			if (!eachAssert.getMessage().trim().isEmpty()) {
				sb.append(" \"").append(eachAssert.getMessage()).append("\" ");
			}
			sb.append("failed because the expected value of [").append(eachAssert.getExpected()).append("] ")
					.append("was different from the actual value [").append(eachAssert.getActual()).append("]");
		}
		//Reporter.log(sb.toString());
		throw new AssertionError(sb.toString());
	}

	private void printAssertionLog(IAssert<?> assertCommand) {
		String methodName = Reporter.getCurrentTestResult().getMethod().getMethodName();
		StringBuilder sb = new StringBuilder();
		sb.append("Assert ");
		if (assertCommand.getMessage() != null && !assertCommand.getMessage().trim().isEmpty()) {
			sb.append("\"").append(assertCommand.getMessage()).append("\"");
		}
		sb.append(" passed in ");
		sb.append(methodName).append("()");
		Logs.LOGGER.info(sb.toString());
	}

}
