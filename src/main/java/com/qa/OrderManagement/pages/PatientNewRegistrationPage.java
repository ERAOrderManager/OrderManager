package com.qa.OrderManagement.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.OrderManagement.base.TestBase;

public class PatientNewRegistrationPage extends TestBase{
	
	public PatientNewRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(name="firstName")
	WebElement MFirstName;
	
	@FindBy(name="middleName")
	WebElement MMiddleName;
	
	@FindBy(name="lastName")
	WebElement MLastName;
	
	@FindBy(name="email")
	WebElement Memail;
	
	@FindBy(name="phoneNumber")
	WebElement MphoneNumber;
	
	@FindBy(name="last4SSN")
	WebElement Olast4SSN;
	
	@FindBy(name="password")
	WebElement Mpassword;
	
	@FindBy(name="confirmPassword")
	WebElement MconfirmPassword;
	
	@FindBy(name="acceptTerms")
	WebElement MacceptTermsCheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Next') and @type='submit']")
	WebElement NextButton;
	
//Actions
	public void enterPatientUserDetail(String details)
	{
		MFirstName.sendKeys(details);
	}
	
}
