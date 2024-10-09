package com.qa.OrderManagement.Reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.OrderManagement.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Base64;
import java.util.Date;


public class TestListener implements ITestListener{
	
	
	/*
	 * public TestListener(WebDriver driver) { super(driver); }
	 */
	 
	 

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Before starting all tests, below method runs.
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		// iTestContext.setAttribute("WebDriver", this.getWebDriver());
	}

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
		ReportManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		//WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("WebDriver");
		System.out.println(iTestResult.getTestName());
		String description = iTestResult.getMethod().getDescription();
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		if (iTestResult.getTestName() != null) {
			ReportTestManager.startTest(iTestResult.getTestName(),
					iTestResult.getInstance().getClass().getCanonicalName());
		}else if (description != null)
			ReportTestManager.startTest(iTestResult.getMethod().getMethodName() + "( " + description + ")",
					iTestResult.getInstance().getClass().getCanonicalName());
		else {
			ReportTestManager.startTest(iTestResult.getMethod().getMethodName(),
					iTestResult.getInstance().getClass().getCanonicalName());
		}
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		ReportTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("WebDriver");
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

		Object testClass = iTestResult.getInstance();
		//WebDriver webDriver = ((TestBase) testClass).initialization();
		

		/*
		 * // Take base64Screenshot screenshot. String base64Screenshot =
		 * "data:image/png;base64," + ((TakesScreenshot)
		 * webDriver).getScreenshotAs(OutputType.BASE64);
		 * 
		 * // Decode Base64 string and write to an image file byte[] decodedImg =
		 * Base64.getDecoder().decode(base64Screenshot); try (FileOutputStream fos = new
		 * FileOutputStream("screenshot.png")) { fos.write(decodedImg); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		//WebDriver driver =WebDriverManager.chromedriver().create();
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotName="ScreenDiscrp";
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".jpg";
        File finalDestination = new File(destination);
        try {
        	ReportTestManager.getTest().log(Status.FAIL, iTestResult.getThrowable());
		    ReportTestManager.getTest().fail("details",MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * ReportTestManager.getTest().log(Status.FAIL, iTestResult.getThrowable());
		 * ReportTestManager.getTest().fail("details",MediaEntityBuilder.
		 * createScreenCaptureFromPath(destination).build());
		 */
				//MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        //webDriver.quit();
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");

		// Extentreports log operation for skipped tests.
		ReportTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}