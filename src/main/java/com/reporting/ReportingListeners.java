package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportingListeners implements ITestListener {

    private static ExtentReports extentReports

    @Override
    public void onStart(ITestContext context) {
        extentReports = Reporting.initReport("Rest Assured Execution Results", "Execution Report");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
