package com.qa.OrderManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.OrderManagement.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory -OR - page Elements
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Doctor Facility']")
	WebElement rdoDoctorFacility;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SignIn;
	
	@FindBy(xpath="//img[contains(@class,'w-40 h-7')]")
	WebElement Logo;
	
	@FindBy(xpath="")
	WebElement SignUp;
	
	//WebElement Username=driver.findElement(By.xpath("//input[@name='userName']"));
	//WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
	//WebElement SignIn=driver.findElement(By.xpath("//button[@type='submit']"));
	//WebElement Logo=driver.findElement(By.xpath("//img[contains(@class,'w-40 h-7')]"));
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return Logo.isDisplayed();
	}
	public void login(String uname,String pwd) {
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		SignIn.click();
		//return new PatientUserHomePage();
	}
	
	public void signup()
	{
		SignUp.click();
	}
}
