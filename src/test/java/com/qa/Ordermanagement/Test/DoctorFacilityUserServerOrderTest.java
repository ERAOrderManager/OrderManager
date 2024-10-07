package com.qa.Ordermanagement.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.DoctorFacilityHomePage;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;

@Listeners(TestListener.class)

public class DoctorFacilityUserServerOrderTest extends TestBase {
	//LoginPage loginpage = new LoginPage(driver);
	//DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	public String OrderID ="VIQ-95";
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
	  //extentTest = extentReports.createTest("DoctorFacilityUserLoginTest", "Got executed");
	  Thread.sleep(2000);	  
  }
  
@Test(priority = 2,dependsOnMethods = {"DoctorFacilityUserLoginTest"})
public void clickonNewRequestTest() throws InterruptedException
{
	  //extentTest = extentReports.createTest("clickonNewRequestTest", "Got executed");
	  DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	  Dhomepage.clickonnewRequest();
	  Thread.sleep(3000);
	  
}
@Test(priority = 3,dependsOnMethods = {"clickonNewRequestTest"})
public void clickonSearchoption()

{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.searchField(OrderID);
	//extentTest = extentReports.createTest("clickonSearchoption", "Got executed");
}

@Test(priority = 4,dependsOnMethods = {"clickonSearchoption"})
 public void clickonOrderID() throws InterruptedException
 {
	 DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	 Dhomepage.clickOrderid();
	 //extentTest = extentReports.createTest("clickonOrderID", "Got executed");
	 Thread.sleep(3000);
 }

@Test(priority = 5,dependsOnMethods = {"clickonOrderID"})
public void fetchOrderID()
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	String rID=Dhomepage.FetchRequestID();
	System.out.println("RequestID: "+rID);
	//extentTest = extentReports.createTest("fetchOrderID not Matched", "Got executed");
	Assert.assertEquals(rID, OrderID);


}
@Test(priority = 6,dependsOnMethods = {"fetchOrderID"})
public void selectInternalstatusTest() throws InterruptedException
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	//extentTest = extentReports.createTest("selectInternalstatusTest", "Got executed");
	Dhomepage.selectInternalStatus();
	Thread.sleep(3000);
	
}

@Test(priority = 7,dependsOnMethods = {"selectInternalstatusTest"})
public void updateOrderDetails()
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.updateOrderDetailsDetailspage();
}

@Test(priority = 8,dependsOnMethods = {"updateOrderDetails"})
public void clickonfiletab() 

{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.clickonFileTab();
}

@Test(priority = 9,dependsOnMethods = {"clickonfiletab"})
public void uploadfiles() 

{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.uploadfromfiletab();
}

}
