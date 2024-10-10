package com.qa.Ordermanagement.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;
import com.qa.OrderManagement.pages.PatientUserPaymentPage;
import com.qa.OrderManagement.utilities.UtilitiesforOMS;
@Listeners(TestListener.class)
public class PatientUserOrderTest extends TestBase {
	
	String fName2upload="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
	 

	public PatientUserOrderTest() {
		super();

	}

	@BeforeClass
	public void setup(ITestContext context) {
		this.driver=initialization();
		context.setAttribute("WebDriver", this.driver);
		}

	@Test(priority = 1)
	public void patientuserOrderCreationTest() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		loginpage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
		Thread.sleep(3000);
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		Thread.sleep(3000);
		puhomepage.paymentRemainder();
		Thread.sleep(3000);
		//driver.findElement(By.xpath(String.format("//p[normalize-space()='%s']",properties.getProperty("doctorFacility1")))).click();
		puhomepage.newdocumentRequest();
		Thread.sleep(2000);
		puhomepage.selectDType("DF");
		Thread.sleep(2000);
		puhomepage.ItemListclick();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format("//p[normalize-space()='%s']",properties.getProperty("doctorFacility1")))).click();
		puhomepage.requestTypeList();
		Thread.sleep(1000);
		driver.findElement(By.xpath(String.format("//span[normalize-space()='%s']",properties.getProperty("RequestType")))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		puhomepage.selectRecordType("Medical");
		Thread.sleep(1000);
		puhomepage.selectIdentity();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
	}

	
	  @Test(priority=2,dependsOnMethods= {"patientuserOrderCreationTest"}) 
	  public void uploadpassportfrontTest() throws InterruptedException, AWTException {
	  
		  PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		    //driver.getWindowHandles(); 
			puhomepage.clickonuploadpage("PassportFrontPage");
			Thread.sleep(2000);
		    fileupload(fName2upload);
			Thread.sleep(3000);
		    //driver.switchTo().defaultContent();
			System.out.println("Driver Switched to default Content");
	  }
	
	  @Test(priority=3,dependsOnMethods= {"uploadpassportfrontTest"}) 	  
	  public void uploadpassportbackpageTest() throws InterruptedException, AWTException {
	  
		   PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		    
			driver.findElement(By.xpath("(//div[@class='text-center p-2 relative'])[2]")).click();
			System.out.println("Clicked on the uploadlink");
			Thread.sleep(2000);
			puhomepage.clickonuploadpage("PassportBackPage");
			Thread.sleep(2000);
		    fileupload(fName2upload);
			Thread.sleep(3000);
			
	  }
	 
	@Test(priority=4,dependsOnMethods= {"uploadpassportbackpageTest"})
	public void uploadHippaDeclaration() throws InterruptedException, AWTException
	{
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(4000);
     	driver.findElement(By.xpath("(//div[@class='text-center p-2 relative'])[3]")).click();
     	Thread.sleep(2000);
		System.out.println("Clicked on the uploadlink"); 
		puhomepage.clickonuploadpage("HippaDeclaration"); 
		Thread.sleep(2000);
		fileupload(fName2upload);
		Thread.sleep(3000);
		 
	}
	@Test(priority=5,dependsOnMethods= {"uploadHippaDeclaration"})
	public void checkTermsandConditions() {
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		puhomepage.TermsandConditon();
		
	}
	
	@Test(priority=6,dependsOnMethods= {"checkTermsandConditions"})
	public void clickonsubmitTest() throws InterruptedException {
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		puhomepage.ClickonSubmit();
		Thread.sleep(5000);
	}
	@Test(priority=7,dependsOnMethods= {"clickonsubmitTest"})
	public void captureToastMessage()
	{
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		String Toastmsg=puhomepage.getToastMessage();
		String checkmsg="success";
		Assert.assertTrue(Toastmsg.contains(checkmsg));
	
	}
	
	@Test(priority=8,dependsOnMethods= {"captureToastMessage"})
	public void writetofileOrderId()
	{
		UtilitiesforOMS uoms = new UtilitiesforOMS();
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		
		//captureOrderID 
		String OrderID=puhomepage.fetchOrderID();
		//and write to text file
		if(OrderID!=null) {
		uoms.writetotextfile(OrderID);
		}else
		{System.out.println("order ID was empty");
		}
	}
	@Test(priority=9,dependsOnMethods= {"writetofileOrderId"})
	public void ProcesspaymentPage() throws InterruptedException 
	{
		PatientUserPaymentPage paymentpage = new PatientUserPaymentPage(driver);
		paymentpage.enterEmailID("krishnagajula@gmail.com");
		Thread.sleep(2000);
		paymentpage.closeextrapopup();
		Thread.sleep(2000);
		paymentpage.enterCardnumber("4242424242424242");
		paymentpage.cardexpiredDate("11/25");
		paymentpage.enterCVV("123");
		Thread.sleep(2000);
		//paymentpage.selectdropcntry("United States");
		driver.findElement(By.xpath(String.format("//select/option[normalize-space()='%s']","United States"))).click();
		Thread.sleep(2000);
		paymentpage.zipcode("30004");
		Thread.sleep(2000);
		paymentpage.clickonPaynowbtn();
		Thread.sleep(2000);
		
	}
	
		
	public void fileupload(String fname) throws AWTException
	{
		JavascriptExecutor jsf = (JavascriptExecutor)driver;
		Robot r = new Robot();
		r.setAutoDelay(1000);
		
		StringSelection ss = new StringSelection(fname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		r.setAutoDelay(2000);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.setAutoDelay(2000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		r.setAutoDelay(1000);
		jsf.executeScript("window.scrollBy(0,-100)");
		
		//driver.manage().window().minimize();
		//driver.manage().window().maximize();
		
	}
	 @AfterClass 
	  public void closebrowsers() 
	  { driver.quit(); 
	  }
}