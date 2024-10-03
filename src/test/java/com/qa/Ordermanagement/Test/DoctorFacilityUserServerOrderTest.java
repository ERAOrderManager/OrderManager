package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.DoctorFacilityHomePage;

import com.qa.OrderManagement.base.TestBase;

public class DoctorFacilityUserServerOrderTest extends TestBase {
	//LoginPage loginpage = new LoginPage(driver);
	//DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	public String OrderID ="VIQ-93";
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
public void clickonNewRequestTest() throws InterruptedException
{
	  extentTest = extentReports.createTest("clickonNewRequestTest", "Got executed");
	  DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	  Dhomepage.clickonnewRequest();
	  Thread.sleep(3000);
	  
}
@Test(priority = 3,dependsOnMethods = {"clickonNewRequestTest"})
public void clickonSearchoption()

{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.searchField(OrderID);
	extentTest = extentReports.createTest("clickonSearchoption", "Got executed");
}

@Test(priority = 4,dependsOnMethods = {"clickonSearchoption"})
 public void clickonOrderID() throws InterruptedException
 {
	 DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	 Dhomepage.clickOrderid();
	 extentTest = extentReports.createTest("clickonOrderID", "Got executed");
	 Thread.sleep(3000);
 }
	
}

