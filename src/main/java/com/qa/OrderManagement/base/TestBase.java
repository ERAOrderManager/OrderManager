package com.qa.OrderManagement.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.OrderManagement.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TestBase {
   public static WebDriver driver;
   public static JavascriptExecutor js = (JavascriptExecutor)driver;
   public static Properties properties = new Properties();
   public ExtentSparkReporter extentSparkReporter;
   public ExtentReports extentReports;
   public ExtentTest extentTest;
   
   public TestBase()
   {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("config.properties");
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
   
   public static void initialization()
   {
	   String browserName = properties.getProperty("browser");
	   long PAGE_LOAD_TIMEOUT = Long.parseLong(properties.getProperty("PAGE_LOAD_TIME_OUT"));
	   long IMPLICIT_WAIT = Long.parseLong(properties.getProperty("IMPLICIT_WAIT"));
	   
	   if (browserName.equals("chrome"))
	   {
		   driver= WebDriverManager.chromedriver().create();
	   }else if(browserName.equals("firefox"))
	   {
		   driver=WebDriverManager.firefoxdriver().create();
	   }else if(browserName.equals("edge"))
	   {
		   driver=WebDriverManager.edgedriver().create();
	   }
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	   driver.get(properties.getProperty("AppURL"));
   }
   @BeforeTest
   public void startReporter()
   {
       extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
       extentReports = new ExtentReports();
       extentReports.attachReporter(extentSparkReporter);
       //configuration items to change the look and feel
       //add content, manage tests etc
       extentSparkReporter.config().setDocumentTitle("Order Management Test Report");
       extentSparkReporter.config().setReportName("Order Management Test Report Summary");
       extentSparkReporter.config().setTheme(Theme.STANDARD);
       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
   }
  
   @AfterMethod
   public void getResult(ITestResult result) {
	   try {
		String screenshotPath = Utilities.getScreenshot(driver, "exampleScreenshot");
		if(result.getStatus() == ITestResult.FAILURE) {
	          extentTest.log(Status.FAIL,result.getThrowable());
	          extentTest.fail("Screenshot captured",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        		  
	       }
	       else if(result.getStatus() == ITestResult.SUCCESS) {
	           extentTest.log(Status.PASS, result.getTestName());
	       }
	       else {
	           extentTest.log(Status.SKIP, result.getTestName());
	       }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       driver.quit();
   }
   @AfterTest
   public void tearDown() {
       //to write or update test information to the reporter
       extentReports.flush();
   }
}