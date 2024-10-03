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

public class DoctorFacilityHomePage extends TestBase {
	
public DoctorFacilityHomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//a[@href='/admin/document-requests/New']")
WebElement NewRequest;

@FindBy(xpath="//div[1]/input[contains(@placeholder,'Search..') and @type='text']")
WebElement searchField;

@FindBy(xpath="(//a[contains(@href,'/admin/document-request/')])[1]")
WebElement openOrder;

@FindBy(xpath="//p[2][contains(@class,'text-white ')]")
WebElement RequestID;


public void clickonnewRequest()
{	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/admin/document-requests/New']")));
	NewRequest.click();
}

public void searchField(String orderID)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/input[contains(@placeholder,'Search..') and @type='text']")));
	searchField.sendKeys(orderID);
}

public void clickOrderid()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'/admin/document-request/')])[1]")));
	openOrder.click();
}

public String FetchRequestID()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[2][contains(@class,'text-white ')]")));
	String requestid=RequestID.getText();
	return requestid;
}

}