package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utils.ResultsZipper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

/**
 * This class serves as a listening agent for all the tests executed, by testng tests
 */
public class ReportingListeners implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extentReports = Reporting.initReport("Rest Assured Execution Results", "Execution Report");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest("Test Name: " + result.getMethod().getMethodName());
        extentTestThreadLocal.set(extentTest);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ResultsZipper.zipFiles();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporting.logFailStatus(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String stackTraceDetails = "<details>\n" +
                "<summary>Expand for detailed error trace</summary>\n" +
                "" + stackTrace + "\n" +
                "</details>";
        Reporting.logStackTraceStatus(stackTraceDetails);
    }
}
