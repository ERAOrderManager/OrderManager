package com.qa.Ordermanagement.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.OrderManagement.pages.PatientUserPaymentPage;

import com.qa.OrderManagement.base.TestBase;

public class PatientUserPaymentPageTest extends TestBase {
		
	public PatientUserPaymentPageTest() 
	{
	 super();
	}
	@BeforeClass
	  public void setup() {
		this.driver=initialization();
		
	  }
	
  @Test
  public void EnterEmailIDTest()
  {
	  PatientUserPaymentPage ppp = new PatientUserPaymentPage(driver);
	  ppp.enterEmailID("krishnagajula@gmail.com");
	  
	  
  }
}
