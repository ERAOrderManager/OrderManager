package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.qa.OrderManagement.Reports.TestListener;
import com.qa.OrderManagement.base.TestBase;
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
	@Test
	public void PersonalInformation()
	{
		PatientNewRegistrationPage Pnrp = new PatientNewRegistrationPage(driver);
		
	}
}
