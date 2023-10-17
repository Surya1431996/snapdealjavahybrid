package com.snapdeal.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.snapdeal.utils.ExtentReporter;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
    String testName;
    @SneakyThrows
    @Override
    public void onStart(ITestContext context){

        extentReport = ExtentReporter.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO,testName+" started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS,testName+" got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = null;

        try {
            driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationpath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
        try {
            FileHandler.copy(srcScreenshot, new File(destinationpath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(destinationpath);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL, testName+" got Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP, testName+" got Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        

    }
}
