package utils;

import java.util.*;
import java.util.logging.Level;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.Logs;

//**A custom listener for Extent Reporting

public class ReportListener extends TestListenerAdapter {
	private static Map<String, ExtentTest> extentTestMap = new HashMap<>();
	private static Map<String, Object[]> paramsMap = new HashMap<>();
	private static final String OVERALLRESULT = "Overall Test Case Result: ";
	private StringBuilder testInfo;

	/**
	 * default constructor
	 */
	public ReportListener() {
		super();
	}

	public static Map<String, ExtentTest> getExtentTestMap() {
		return extentTestMap;
	}

	@Override
	public void onStart(ITestContext testContext) {
		// no-op
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extentTest;
		Long threadId = Thread.currentThread().getId();
		Logs.LOGGER.info("Started Test: " + result.getMethod().getMethodName());
		extentTest = ExtentReporter.extent.createTest(ClassUtils.getShortClassName(result.getTestClass().getName())
				+ "---" + result.getMethod().getMethodName());
		extentTest.getModel().setStartTime(DateUtils.getTime(result.getStartMillis()));
		extentTestMap.put(result.getMethod().getMethodName() + threadId, extentTest);
		paramsMap.put(result.getMethod().getMethodName() + threadId, result.getParameters());

		for (String group : result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
	}

	/**
	 * report for passed tests
	 */
	@Override
	public synchronized void onTestSuccess(ITestResult tr) {
		logReportStatus(Status.PASS, tr);
	}

	/**
	 * report for failed tests
	 */
	@Override
	public synchronized void onTestFailure(ITestResult tr) {
		logReportStatus(Status.FAIL, tr);
	}

	/**
	 * report for skipped tests
	 */
	@Override
	public void onTestSkipped(ITestResult tr) {
		ExtentTest extentTest = ExtentReporter.extent.createTest(ClassUtils.getShortClassName(tr.getTestClass().getName())
				+ "---" + tr.getMethod().getMethodName());
		Long threadId = Thread.currentThread().getId();
		extentTestMap.put(tr.getMethod().getMethodName() + threadId, extentTest);
		logReportStatus(Status.SKIP, tr);
	}

	@Override
	public synchronized void onFinish(ITestContext testContext) {
		for (String s : Reporter.getOutput()) {
			ExtentReporter.extent.setTestRunnerOutput(s);
		}
	}

	/**
	 * This method is used to write to the Extent report.
	 *
	 */
	private synchronized void setTestAttributes(ITestResult tr, ExtentTest test, Object[] params) {
		Set<String> attributes;
		String[] paramsArray = null;
		// excluded params from the test name
		String[] excludedParameters = { "URL", "BrowserType", "BrowserVersion", "Platform" };
		if (params != null && params.length != 0) {
			paramsArray = params[0].toString().split(",");
		}
		StringBuilder testName = new StringBuilder();
		String testNameDescription = null;
		attributes = tr.getAttributeNames();
		testInfo = new StringBuilder();

		if (!attributes.isEmpty()) {
			for (String attribute : attributes) {
				if (tr.getAttribute(attribute) != null && !StringUtils.isBlank(tr.getAttribute(attribute).toString())) {
					testInfo.append(attribute + ": " + tr.getAttribute(attribute) + "<br>");
				}
			}
		}

		// print custom test case name from excel file in the report.
		if (params != null) {
			if (params.length == 1 && paramsArray.length >= 3) {
				for (String parameter : paramsArray) {
					if (parameter.contains("url")) {
						testInfo.append("URL" + ": " + parameter.replaceAll("url=", "").replace("}", "") + "<br>");
					}
					if (parameter.contains("TestDescription")) {
						testNameDescription = parameter.replaceAll("TestDescription=", "").replace("{", "");
					}
				}
				if (!StringUtils.isBlank(testNameDescription)) {
					test.getModel().setName(test.getModel().getName() + " - " + testNameDescription);
				}
			} else if (params.length > 1 && !attributes.isEmpty()) {
				testName.append(test.getModel().getName()).append(" with parameters - ");
				for (String attribute : attributes) {
					if (!Arrays.asList(excludedParameters).contains(attribute)) {
						testName.append(attribute + ": " + tr.getAttribute(attribute) + ", ");
					}
				}
				if (testName.toString().contains(",")) {
					String name = testName.toString().substring(0, testName.toString().lastIndexOf(','));
					test.getModel().setName(name);
				}
			}
		}

		// print test description
		if (!StringUtils.isBlank(testInfo.toString())) {
			test.getModel().setDescription(testInfo.toString());
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * Method to print/log the status in the extent report.
	 *
	 * @param status
	 * @param tr
	 */
	private void logReportStatus(Status status, ITestResult tr) {
		Long threadId = Thread.currentThread().getId();
		ExtentTest test = extentTestMap.get(tr.getMethod().getMethodName() + threadId);
		Object[] params = paramsMap.get(tr.getMethod().getMethodName() + threadId);
		if (test != null) {
			test.getModel().setEndTime(DateUtils.getTime(tr.getEndMillis()));
			setTestAttributes(tr, test, params);
			switch (status) {
				case SKIP:
					test.skip(tr.getThrowable());
					break;
				case FAIL:
					if (params.length == 1) {
						testInfo.append("parameters: " + Arrays.toString(params) + "<br>");
					}
					test.fail(tr.getThrowable());
					break;
				case PASS:
					test.pass(OVERALLRESULT + tr.getMethod().getMethodName() + " - Passed");
					break;
				default:
					break;
			}
		} else {
			Logs.LOGGER.log(Level.SEVERE,"Test report instance is null; Test result will not be printed in the report.");
		}
		if (extentTestMap.containsKey(tr.getMethod().getMethodName() + threadId)) {
			extentTestMap.remove(tr.getMethod().getMethodName() + threadId);
		}
	}

}
