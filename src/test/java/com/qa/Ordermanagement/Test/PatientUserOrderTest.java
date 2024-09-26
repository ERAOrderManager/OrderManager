package com.qa.Ordermanagement.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientUserHomePage;
import com.qa.OrderManagement.pages.PatientUserPaymentPage;
import com.qa.OrderManagement.utilities.Utilities;

public class PatientUserOrderTest extends TestBase {
	//LoginPage loginpage;
	//PatientUserHomePage puhomepage;
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	String fName2upload="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
	 

	public PatientUserOrderTest() {
		super();

	}

	@BeforeClass
	public void setup() {
		this.driver=initialization();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//loginpage = new LoginPage();
		// puhomepage = new PatientUserHomePage();
	}

	@Test(priority = 1)
	public void patientuserOrderCreationTest() throws Throwable {
		LoginPage loginpage = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		

		// System.out.println("from test method");
		//extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");
		loginpage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
		Thread.sleep(2000);
		// puhomepage = new PatientUserHomePage();
		//Thread.sleep(3000);
		PatientUserHomePage puhomepage = new PatientUserHomePage(driver);
		//puhomepage.paymentRemainder();
		//driver.findElement(By.xpath(String.format("//p[normalize-space()='%s']",properties.getProperty("doctorFacility1")))).click();
		
		//Thread.sleep(3000);
		//System.out.print("reminderResult");
		//extentTest = extentReports.createTest("reminderResult", "View Test Result");
		Thread.sleep(2000);
		puhomepage.newdocumentRequest();
		puhomepage.selectDType("DF");
		//extentTest = extentReports.createTest("newdocumentRequest click", "View Test Result");
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
		js.executeScript("window.scrollBy(0,400)");
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
	public void paymentPage() 
	{
		PatientUserPaymentPage paymentpage = new PatientUserPaymentPage(driver);
		paymentpage.enterEmailID("krishnagajula@gmail.com");
		
		
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
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
	}
	 @AfterClass 
	  public void closebrowsers() 
	  { driver.quit(); 
	  }
}