package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class implements logic to generate extent report
 * various methods are implemented, based upon usage any of them could be utilised
 */
public class Reporting {

    public static ExtentReports extentReports;

    public static ExtentReports initReport(String reportName, String documentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(generateReportName());
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setReportName(reportName);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String generateReportName() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return System.getProperty("user.dir") + "/Reports/" +
                Helper.getProperty("reportName") + "_" + dateTimeFormatter.format(localDateTime) + ".html";
    }

    public static void logPassStatus(String msg) {
        ReportingListeners.extentTestThreadLocal.get().pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
    }

    public static void logFailStatus(String msg) {
        ReportingListeners.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
    }

    public static void logInfo(String msg) {
        ReportingListeners.extentTestThreadLocal.get().info(MarkupHelper.createLabel(msg, ExtentColor.GREY));
    }

    public static void logWarningStatus(String msg) {
        ReportingListeners.extentTestThreadLocal.get().warning(MarkupHelper.createLabel(msg, ExtentColor.ORANGE));
    }

    public static void logJsonData(String jsonData) {
        ReportingListeners.extentTestThreadLocal.get().info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
    }

    public static void logStackTraceStatus(String msg) {
        ReportingListeners.extentTestThreadLocal.get().fail(msg);
    }
}
