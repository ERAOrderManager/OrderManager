package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;
import com.qa.OrderManagement.pages.UsersSignUpPage;
import com.qa.OrderManagement.pages.LoginPage;
import com.qa.OrderManagement.pages.PatientNewRegistrationPage;
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
		PatientNewRegistrationPage Pnrp = new PatientNewRegistrationPage(driver);
		//Personal Info Tab
		Pnrp.MFirstName.sendKeys("Krishna");
		Pnrp.MMiddleName.sendKeys("Prasad");
		Pnrp.MLastName.sendKeys("Gajula");
		Pnrp.Memail.sendKeys("test@testmail.com");
		Pnrp.MphoneNumber.sendKeys("470-981-9474");
		Pnrp.Olast4SSN.sendKeys("4321");
		Pnrp.Mpassword.sendKeys("Test@123");
		Pnrp.MconfirmPassword.sendKeys("Test@123");
		Pnrp.MacceptTermsCheckBox.click();
		Pnrp.NextButton.click();
		//Address Tab
		Thread.sleep(3000);
		Pnrp.AddressLine1.sendKeys("AddressLine1");
		Pnrp.AddressLine2.sendKeys("AddressLine2");
		Pnrp.City.sendKeys("Atlanta");
		Pnrp.ListState.click();
		Pnrp.EnterState.sendKeys("Georgia");
		Pnrp.Zipcode.sendKeys("30004");
		Pnrp.Submit.click();
		
	}
}
