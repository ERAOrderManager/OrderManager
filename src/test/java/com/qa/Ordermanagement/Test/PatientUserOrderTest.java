package com.qa.Ordermanagement.Test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;

public class PatientUserOrderTest extends TestBase {
	LoginPage loginpage;
	PatientUserHomePage puhomepage;
	
	public PatientUserOrderTest()
	{
		super();
		
	}
	@BeforeMethod
	  public void setup() {
		initialization();
		loginpage = new LoginPage();
					
	  }
  @Test(priority=1)
  public void patientuserOrderCreationTest() throws Throwable {
	  
	  //System.out.println("from test method");
	  extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");
	  puhomepage=loginpage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
	  Thread.sleep(2000);
	  puhomepage = new PatientUserHomePage();
	  Thread.sleep(3000);
	  puhomepage.paymentRemainder();
	  Thread.sleep(3000);
	  System.out.print("reminderResult");
	  extentTest = extentReports.createTest("reminderResult", "View Test Result");
	  puhomepage.newdocumentRequest();
	  extentTest = extentReports.createTest("newdocumentRequest", "View Test Result");
  }
    
/*
  @Test(priority=2,dependsOnMethods= {"patientuserloginTest"})
  public void newdocumentRequestTest() 
  {
	   
	  extentTest = extentReports.createTest("newdocumentrequestTest", "View Test Result");
  }
 */
  
  }
