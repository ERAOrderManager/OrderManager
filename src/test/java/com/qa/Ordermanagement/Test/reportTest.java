package com.qa.Ordermanagement.Test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qa.OrderManagement.base.TestBase;

public class reportTest extends TestBase {
  @Test
  public void login() 
  {
	  extentTest = extentReports.createTest("Test Case 1", "This test case has passed");
      Assert.assertTrue(true);
  }
  @Test
  public void upload() 
  {
	  driver.get("https://www.google.com/");
	  String title=driver.getTitle();
	  extentTest = extentReports.createTest("Test Case 2", "This test case has failed");
      Assert.assertEquals(title, "The Title");
  }
  
  @Test
  public void testSkipped() {
      extentTest = extentReports.createTest("Test Case 3", "This test case has been skipped");
      throw new SkipException("The test has been skipped");
}
}