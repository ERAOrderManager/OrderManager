package com.qa.OrderManagement.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.OrderManagement.base.TestBase;

public class PatientUserPaymentPage extends TestBase{
	
	public PatientUserPaymentPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Field-emailInput']")
	WebElement EmailIDField;
		
	@FindBy(xpath="//div[contains(@class,'p-Passcode-inner c-BlockPadding')]")
	WebElement Focuswnd;
		
	@FindBy(xpath="//input[@id='Field-numberInput']")
	WebElement CardDetails;
	
	@FindBy(xpath="//input[@id='Field-expiryInput']")
	WebElement CardExpiryDate;
	
	@FindBy(xpath="//input[@id='Field-cvcInput']")
	WebElement CVVfield;
	
	@FindBy(xpath="//button/span[@id='button-text'] ")
	WebElement PaynowBtn;
	
	@FindBy(xpath="//iframe[@title='Secure email input frame']")
	WebElement MyFrame1;
	
	@FindBy(xpath="//iframe[@title='Secure payment input frame']")
	WebElement MyFrame2;
	
	@FindBy(xpath="//div[@class='p-Field p-Field--labelResting' and @data-field='number']")
	WebElement Emailfocus;
	
	
	@FindBy(xpath="//select[@name='country']")
	WebElement selectcountry;
	
	
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement Zipcode;
	
	@FindBy(xpath="//button[contains(@class,'p-Passcode-closeTarget ')]")
	WebElement closebutton;
	
	//Actions
	
	public void enterEmailID(String emailid) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/strong")));
		driver.switchTo().frame(MyFrame1);
		EmailIDField.sendKeys(emailid);
		
	}
	
	public void closeextrapopup() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'p-Passcode-closeWrapper')]")));
		//Thread.sleep(2000);
		Focuswnd.click();
	    closebutton.click();
	
	    //JavascriptExecutor jsc = (JavascriptExecutor) driver;
	    //WebElement hiddenElement = (WebElement) jsc.executeScript("return document.querySelector(\"button[aria-label='Close'] svg path\");");
        //jsc.executeScript("arguments[0].click();", hiddenElement);
        driver.switchTo().defaultContent();
	}
	
	public void enterCardnumber(String cnum)
	{
		driver.switchTo().frame(MyFrame2);
		System.out.println("Switched to Frame2");
		Emailfocus.click();
		CardDetails.sendKeys(cnum);
	}
	
	public void cardexpiredDate(String cexpdate) {
		CardExpiryDate.sendKeys(cexpdate);
		
	}
	
	public void enterCVV(String cvv) {
		CVVfield.sendKeys(cvv);
	}

	
	
	  public void selectdropcntry(String cntryname)
	  {
	  Select dropdowncountry = new Select(selectcountry);  
	  dropdowncountry.deselectByVisibleText(cntryname); 
	  }
	 
	
	public void zipcode(String zcode) {
		
		Zipcode.sendKeys(zcode);
		driver.switchTo().defaultContent();
	}
	public void clickonPaynowbtn() {
		
		PaynowBtn.click();
		System.out.println("Payment button clicked");
		
	}
	
}
