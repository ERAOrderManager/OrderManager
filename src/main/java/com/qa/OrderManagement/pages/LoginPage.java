package com.qa.OrderManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.OrderManagement.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory -OR - page Elements
	WebElement Username=driver.findElement(By.xpath("//input[@name='userName']"));
	WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
	WebElement SignIn=driver.findElement(By.xpath("//button[@type='submit']"));
	WebElement Logo=driver.findElement(By.xpath("//img[contains(@class,'w-40 h-7')]"));
	
	public LoginPage() 
	{
		
	}

	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return Logo.isDisplayed();
	}
	public PatientUserHomePage login(String uname,String pwd) {
		Username.sendKeys(uname);
		Password.sendKeys(pwd);
		SignIn.click();
		return new PatientUserHomePage();
	}
}
