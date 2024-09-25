package com.qa.Ordermanagement.Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;

public class PatientUserOrderTest extends TestBase {
	//LoginPage loginpage;
	//PatientUserHomePage puhomepage;

	public PatientUserOrderTest() {
		super();

	}

	@BeforeClass
	public void setup() {
		this.driver=initialization();
		
		//loginpage = new LoginPage();
		// puhomepage = new PatientUserHomePage();
	}

	@Test(priority = 1)
	public void patientuserOrderCreationTest() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);

		// System.out.println("from test method");
		//extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");
		loginpage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
		Thread.sleep(2000);
		// puhomepage = new PatientUserHomePage();
		Thread.sleep(3000);
		PatientUserHomePage puhomepage = new PatientUserHomePage();
		puhomepage.paymentRemainder();
		Thread.sleep(3000);
		System.out.print("reminderResult");
		//extentTest = extentReports.createTest("reminderResult", "View Test Result");
		Thread.sleep(2000);
		puhomepage.newdocumentRequest();
		//extentTest = extentReports.createTest("newdocumentRequest click", "View Test Result");
		Thread.sleep(2000);
		/*
		 * puhomepage.selectType(); extentTest =
		 * extentReports.createTest("newdocumentrequestTest", "View Test Result");
		 */
	}

	/*
	 * @Test(priority=2,dependsOnMethods= {"patientuserOrderCreationTest"}) public
	 * void newdocumentRequestTest() {
	 * 
	 * puhomepage.selectType(); extentTest =
	 * extentReports.createTest("newdocumentrequestTest", "View Test Result");
	 * 
	 * }
	 */
	 @AfterClass 
	  public void closebrowsers() 
	  { driver.quit(); 
	  }
}