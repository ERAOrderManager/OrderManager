package com.qa.Ordermanagement.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	PatientUserHomePage homePage;
	
public LoginPageTest()
{
	super();
}
@BeforeMethod
  public void setup() {
	initialization();
	loginPage = new LoginPage();
  }

@Test(priority=1)
public void loginPageLogoTest() {
	boolean flag=loginPage.validateLogo();
	//extentTest = extentReports.createTest("Test Case 2", "This test case has passed");
	Assert.assertTrue(flag);
	System.out.println(flag);
	
	if(flag==true) {
		extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");
	}
		else {
		extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");	
	}
}

@Test(priority=2)
public void loginPageTitleTest() {
	String title=loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Order Management");
	extentTest = extentReports.createTest("loginPageTitleTest", "View Test Result");
}


@Test(priority=3)
public void loginTest() throws Throwable {
	//extentTest = extentReports.createTest("Test Case 3", "This test case has passed");
	homePage=loginPage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
	extentTest = extentReports.createTest("loginTest", "View Test Result");
	Thread.sleep(3000);
}
/*@AfterMethod
public void tearoff() {
	driver.quit();
}
*/

}
