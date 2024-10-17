package com.qa.Ordermanagement.Test;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.DoctorFacilityHomePage;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.utilities.UtilitiesforOMS;


@Listeners(TestListener.class)

public class DoctorFacilityUserServerOrderTest extends TestBase {
	public List<String> OrderID ;
	public String Rfilenamepath ="InputTextFiles\\file-OrderID.txt";
	public String sOrderID;
	public DoctorFacilityUserServerOrderTest()
	{
		super();
		
	}
  @BeforeClass
  public void setup(ITestContext context) {
	 this.driver= initialization();
	 context.setAttribute("WebDriver", this.driver);
	  
  }
  
 
  
  @Test(priority=1)
  public void DoctorFacilityUserLoginTest() throws InterruptedException
  {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.login(properties.getProperty("doctorFacilityUser"), properties.getProperty("Password"));
	  Thread.sleep(2000);	  
  }
  
@Test(priority = 2,dependsOnMethods = {"DoctorFacilityUserLoginTest"})
public void clickonNewRequestTest() throws InterruptedException
{
	  DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	  Dhomepage.clickonnewRequest();
	  Thread.sleep(3000);
	  
}
@Test(priority = 3,dependsOnMethods = {"clickonNewRequestTest"})
public void fetchorderidfromfileandsearch()
{
	
	  UtilitiesforOMS uOMS = new UtilitiesforOMS(); DoctorFacilityHomePage
	  Dhomepage= new DoctorFacilityHomePage(driver);
	  OrderID=uOMS.readfromtextfile(Rfilenamepath); 
	  for(String order :OrderID)
	  {
	  System.out.println("Fetched Order ID: "+order +OrderID.size());
	  
	  String sOrderID=order.trim(); 
	  Dhomepage.searchField(sOrderID); 
	  }
	 
}

@Test(priority = 4,dependsOnMethods = {"fetchorderidfromfileandsearch"})
 public void clickonOrderID() throws InterruptedException
 {
	 DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	 Dhomepage.clickOrderid();
	 Thread.sleep(3000);
 }

@Test(priority = 5,dependsOnMethods = {"clickonOrderID"})
public void fetchOrderID()
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	String rID=Dhomepage.FetchRequestID();
	System.out.println("RequestID: "+rID);
	  
	UtilitiesforOMS uOMS = new UtilitiesforOMS();
	OrderID=uOMS.readfromtextfile(Rfilenamepath);
	  
	for(String order :OrderID)
	  {
	  System.out.println("Fetched Order ID: "+order +OrderID.size());

       String sOrderID=order.trim();
       Assert.assertEquals(rID.trim(), sOrderID.trim());
  
	  }
 
}
@Test(priority = 6,dependsOnMethods = {"fetchOrderID"})
public void selectInternalstatusTest() throws InterruptedException
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.selectInternalStatus();
	Thread.sleep(3000);
	
}

@Test(priority = 7,dependsOnMethods = {"selectInternalstatusTest"})
public void updateOrderDetails() throws InterruptedException
{
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.updateOrderDetailsDetailspage();
	Thread.sleep(4000);
}

@Test(priority = 8,dependsOnMethods = {"updateOrderDetails"})
public void clickonfiletab() throws InterruptedException 

{   JavascriptExecutor jsf = (JavascriptExecutor)driver;
	jsf.executeScript("window.scrollBy(0,-600)");
	Thread.sleep(3000);
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.clickonFileTab();
}

@Test(priority = 9,dependsOnMethods = {"clickonfiletab"})
public void uploadbutton() throws InterruptedException
{   Thread.sleep(2000);
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.clickonuploadbutton();
}
@Test(priority = 10,dependsOnMethods = {"uploadbutton"})
public void clickonbrowsefiles() throws InterruptedException 

{
	Thread.sleep(2000);
	DoctorFacilityHomePage Dhomepage= new DoctorFacilityHomePage(driver);
	Dhomepage.browsefile();
}

}
