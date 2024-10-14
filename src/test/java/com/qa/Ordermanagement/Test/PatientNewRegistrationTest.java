package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.UsersSignUpPage;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientNewRegistrationPage;
import com.qa.OrderManagement.utilities.UtilitiesforOMS;
import java.util.List;

@Listeners(TestListener.class)
public class PatientNewRegistrationTest extends TestBase {
	
	public PatientNewRegistrationTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup(ITestContext context)
	{
		this.driver=initialization();
		context.setAttribute("WebDriver", this.driver);
	}
	
	@Test(priority=1 )
	public void clickonUserSignup() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.newUserSignup();
		Thread.sleep(3000);
	}
		
	
	@Test(priority=2,dependsOnMethods= {"clickonUserSignup"})
	public void patientuserSignup() throws InterruptedException
	{
		UsersSignUpPage Usup = new UsersSignUpPage(driver);
		Usup.clickonPatientUserSignup();
		Thread.sleep(3000);
	}
	

	@Test(priority=3,dependsOnMethods= {"patientuserSignup"})
	public void PersonalInformation() throws InterruptedException
	{
		UtilitiesforOMS uoms = new UtilitiesforOMS();
		List<String[]> testData=uoms.getData("C:\\Users\\krish\\OneDrive\\Documents\\DataOcean.xlsx","PatientUser");
		PatientNewRegistrationPage Pnrp = new PatientNewRegistrationPage(driver);
		
		for (String[] data : testData) {
			/*
			 * driver.findElement(By.id("username")).sendKeys(data[0]);
			 * driver.findElement(By.id("password")).sendKeys(data[1]);
			 * driver.findElement(By.id("loginButton")).click();
			 */
			
            System.out.println("Data1 :"+data[0]);
            System.out.println("Data2 :"+data[1]);
            System.out.println("Data3 :"+data[2]);
            System.out.println("Data4 :"+data[3]);
            System.out.println("Data5 :"+data[4]);
            System.out.println("Data6 :"+data[5]);
            System.out.println("Data7 :"+data[6]);
            System.out.println("Data8 :"+data[7]);
            System.out.println("Data9 :"+data[8]);
            System.out.println("Data10 :"+data[9]);
            System.out.println("Data11 :"+data[10]);
            
            Pnrp.MFirstName.sendKeys(data[1]);
    		Pnrp.MMiddleName.sendKeys(data[2]);
    		Pnrp.MLastName.sendKeys(data[3]);
    		Pnrp.Memail.sendKeys(data[4]);
    		Pnrp.MDOB.sendKeys(data[5]);
    		Pnrp.MphoneNumber.sendKeys(data[6]);
    		Pnrp.Olast4SSN.sendKeys(data[7]);
    		Pnrp.Mpassword.sendKeys(data[8]);
    		Pnrp.MconfirmPassword.sendKeys(data[9]);
    		Pnrp.MacceptTermsCheckBox.click();
    		Pnrp.NextButton.click();
    		//Address Tab
    		Thread.sleep(3000);
    		Pnrp.AddressLine1.sendKeys(data[10]);
    		Pnrp.AddressLine2.sendKeys(data[11]);
    		Pnrp.City.sendKeys(data[12]);
    		Pnrp.ListState.click();
    		Thread.sleep(2000);
    		//Pnrp.EnterState.sendKeys("Georgia");
    		driver.findElement(By.xpath(String.format("//span[normalize-space()='%s']",data[13]))).click();
    		Pnrp.Zipcode.sendKeys(data[14]);
    		Pnrp.Submit.click();
            

            // Add assertions or further test steps here
        }
		//Personal Info Tab
		/*
		 * Pnrp.MFirstName.sendKeys(data[1]); Pnrp.MMiddleName.sendKeys("Prasad");
		 * Pnrp.MLastName.sendKeys("Gajula"); Pnrp.Memail.sendKeys("test@testmail.com");
		 * Pnrp.MDOB.sendKeys("12/12/1982"); Pnrp.MphoneNumber.sendKeys("470-981-9474");
		 * Pnrp.Olast4SSN.sendKeys("4321"); Pnrp.Mpassword.sendKeys("Test@123");
		 * Pnrp.MconfirmPassword.sendKeys("Test@123");
		 * Pnrp.MacceptTermsCheckBox.click(); Pnrp.NextButton.click(); //Address Tab
		 * Thread.sleep(3000); Pnrp.AddressLine1.sendKeys("AddressLine1");
		 * Pnrp.AddressLine2.sendKeys("AddressLine2"); Pnrp.City.sendKeys("Atlanta");
		 * Pnrp.ListState.click(); Thread.sleep(2000);
		 * //Pnrp.EnterState.sendKeys("Georgia");
		 * driver.findElement(By.xpath(String.format("//span[normalize-space()='%s']",
		 * "Georgia"))).click(); Pnrp.Zipcode.sendKeys("30004"); Pnrp.Submit.click()
		 */;
		
	}
}
