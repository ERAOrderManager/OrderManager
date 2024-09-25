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
import com.qa.OrderManagement.utilities.Utilities;

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
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String fName2upload="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";

		// System.out.println("from test method");
		//extentTest = extentReports.createTest("loginPageLogoTest", "View Test Result");
		loginpage.login(properties.getProperty("patientuser"), properties.getProperty("Password"));
		Thread.sleep(2000);
		// puhomepage = new PatientUserHomePage();
		//Thread.sleep(3000);
		PatientUserHomePage puhomepage = new PatientUserHomePage();
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
		puhomepage.clickonuploadpassportFpage();
		Thread.sleep(2000);
		//Utilities util = new Utilities();
		fileupload(fName2upload);
		Thread.sleep(2000);

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
	
	public void fileupload(String fname) throws AWTException
	{
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
		
		r.setAutoDelay(2000);
		js.executeScript("window.scrollBy(0,100)");
		
		//driver.manage().window().minimize();
		//driver.manage().window().maximize();
		
	}
	 @AfterClass 
	  public void closebrowsers() 
	  { //driver.quit(); 
	  }
}