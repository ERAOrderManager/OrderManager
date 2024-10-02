package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.DoctorFacilityHomePage;

import com.qa.OrderManagement.base.TestBase;

public class DoctorFacilityUserServerOrderTest extends TestBase {
	//LoginPage loginpage = new LoginPage(driver);
	//DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	public DoctorFacilityUserServerOrderTest() {
		super();
		
	}
  @BeforeClass
  public void setup() {
	 this.driver= initialization();
	  
  }
  
  @Test(priority=1)
  public void DoctorFacilityUserLoginTest() throws InterruptedException
  {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.login(properties.getProperty("doctorFacilityUser"), properties.getProperty("Password"));
	  extentTest = extentReports.createTest("DoctorFacilityUserLoginTest", "Got executed");
	  Thread.sleep(2000);	  
  }
  
  @Test(priority = 2,dependsOnMethods = {"DoctorFacilityUserLoginTest"})
public void clickonNewRequestTest()
{
	  extentTest = extentReports.createTest("clickonNewRequestTest", "Got executed");
	  DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	  Dhomepage.clickonnewRequest();
	  
}

	
}

