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

	public @FindBy(name="firstName")
	WebElement MFirstName;
	
	public @FindBy(name="middleName")
	WebElement MMiddleName;
	
	public @FindBy(name="lastName")
	WebElement MLastName;
	
	public @FindBy(name="email")
	WebElement Memail;
	
	public @FindBy(name="phoneNumber")
	WebElement MphoneNumber;
	
	public @FindBy(name="last4SSN")
	WebElement Olast4SSN;
	
	public @FindBy(name="password")
	WebElement Mpassword;
	
	public @FindBy(name="confirmPassword")
	WebElement MconfirmPassword;
	
	public @FindBy(name="acceptTerms")
	WebElement MacceptTermsCheckBox;
	
	public @FindBy(xpath="//button[contains(text(),'Next') and @type='submit']")
	WebElement NextButton;
	
	public @FindBy(xpath="//input[@name='addressLine1']")
	WebElement AddressLine1;
	
	public @FindBy(xpath="//input[@name='addressLine2']")
	WebElement AddressLine2;
	
	public @FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	public @FindBy(xpath="//div[@class='select-dropdown-indicator']")
	WebElement ListState;
	
	public @FindBy(xpath="//input[@name='state']")
	WebElement EnterState;
	
	public @FindBy(xpath="//input[@name='zipcode']")
	WebElement Zipcode;
	
	public @FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
//Actions
	public void enterPatientUserDetail(String details)
	{
		MFirstName.sendKeys(details);
	}
	
}
