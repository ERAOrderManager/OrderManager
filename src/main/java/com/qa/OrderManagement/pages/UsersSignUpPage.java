package com.qa.OrderManagement.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.OrderManagement.base.TestBase;

public class UsersSignUpPage extends TestBase {
	
public UsersSignUpPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}



@FindBy(xpath="(//button[contains(text(),'Select')])[1]")
WebElement ProfessionalUser;

@FindBy(xpath="(//button[contains(text(),'Select')])[2]")
WebElement PatientUser;

@FindBy(xpath="(//button[contains(text(),'Select')])[3]")
WebElement DoctorFacilityUser;

@FindBy(xpath="(//button[contains(text(),'Select')])[4]")
WebElement BackOfficeUser;

@FindBy(xpath="(//button[contains(text(),'Select')])[5]")
WebElement AttorneyOffice;

@FindBy(xpath="(//button[contains(text(),'Select')])[6]")
WebElement InsuranceCompany;

//Actions

public void clickonPatientUserSignup()
{
	PatientUser.click();
}

}