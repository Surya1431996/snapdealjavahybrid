package com.snapdeal.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {
    public static ExtentReports generateExtentReport() throws IOException {
        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Snapdeal Automation Tests");
        sparkReporter.config().setDocumentTitle("SD Automation report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
        extentReport.attachReporter(sparkReporter);
        Properties configProp = new Properties();
        File configPropFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\snapdeal\\config\\config.properties");

        try {
            FileInputStream fisConfigProp  = new FileInputStream(configPropFile);
            configProp.load(fisConfigProp);
        }catch(Throwable e){
            e.printStackTrace();
        }
        extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
        extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));

        return extentReport;
    }
}
