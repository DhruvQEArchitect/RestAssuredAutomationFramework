package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY_MM_DD_HH_MM_SS");
        LocalDateTime localDateTime = LocalDateTime.now();
        return System.getProperty("user.dir") + "/Reports/" +
                Helper.getProperty("reportName") + dateTimeFormatter.format(localDateTime) + ".html";
    }
}
