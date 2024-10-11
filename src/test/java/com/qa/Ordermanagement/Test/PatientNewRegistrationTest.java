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
	public void PersonalInformation()
	{
		PatientNewRegistrationPage Pnrp = new PatientNewRegistrationPage(driver);
		Pnrp.enterPatientUserDetail("KRISHNA");
	}
}
