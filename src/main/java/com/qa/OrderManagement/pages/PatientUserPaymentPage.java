package com.qa.OrderManagement.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	@FindBy(xpath="//input[@id='Field-numberInput']")
	WebElement CardDetails;
	
	@FindBy(xpath="//input[@id='Field-expiryInput']")
	WebElement CardExpiryDate;
	
	@FindBy(xpath="//input[@id='Field-cvcInput']")
	WebElement CVVfield;
	
	@FindBy(xpath="//button/span[@id='button-text'] ")
	WebElement PaynowBtn;
	
	@FindBy(xpath="//iframe[@title='Secure email input frame']")
	WebElement MyFrame;
	//Actions
	
	public void enterEmailID(String emailid) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/strong")));
		driver.switchTo().frame(MyFrame);
		EmailIDField.sendKeys(emailid);
	}
	

}
