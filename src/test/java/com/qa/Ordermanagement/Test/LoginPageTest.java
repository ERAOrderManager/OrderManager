package com.qa.Ordermanagement.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;

public class LoginPageTest extends TestBase {
	WebDriver driver;
	
	
public LoginPageTest()
{
	super();
}
@BeforeClass
  public void setup() {
	this.driver=initialization();
	
  }

@Test(priority=1)
public void loginPageLogoTest() {
	LoginPage loginPage = new LoginPage(driver);
	boolean flag=loginPage.validateLogo();
	//extentTest = extentReports.createTest("Test Case 2", "This test case has passed");
	Assert.assertTrue(flag);
	System.out.println(flag);
	
	/*
	 * if(flag==true) { extentTest = extentReports.createTest("loginPageLogoTest",
	 * "View Test Result"); } else { extentTest =
	 * extentReports.createTest("loginPageLogoTest", "View Test Result"); }
	 */
}

@Test(priority=2)
public void loginPageTitleTest() {
	LoginPage loginPage = new LoginPage(driver);
	String title=loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Order Management");
	//extentTest = extentReports.createTest("loginPageTitleTest", "View Test Result");
}


@Test(priority=3)
public void loginTest() throws Throwable {
	LoginPage loginPage = new LoginPage(driver);
	
	//extentTest = extentReports.createTest("Test Case 3", "This test case has passed");
	loginPage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
	
	//extentTest = extentReports.createTest("loginTest", "View Test Result");
	Thread.sleep(3000);
}

  @AfterClass 
  public void closebrowsers() 
  { driver.quit(); 
  }
 
}
