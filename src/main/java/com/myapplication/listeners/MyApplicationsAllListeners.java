package com.myapplication.listeners;

import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myapplication.Utility.ExtentReporter;
import com.myapplication.Utility.Utilities;

public class MyApplicationsAllListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	//String testName;
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtenReport();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//testName = result.getName();
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+ " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//testName = result.getName();
		extentTest.log(Status.PASS, result.getName()+" got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//testName = result.getName();
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		String destinationsreenShotLocation = Utilities.captureScreenshot(driver,result.getName());
		
		extentTest.addScreenCaptureFromPath(destinationsreenShotLocation);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" -got Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + "- got Skipped");
		
	}


	@Override
	public void onFinish(ITestContext context) {
		if(extentReport != null){
            extentReport.flush();
            
        }
	}
	
	

}
