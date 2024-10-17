package com.qa.OrderManagement.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

@FindBy(xpath="(//p[contains(@class,'text-white')])[1]")
WebElement RequestID;

@FindBy(xpath="(//div[@class='select__indicators css-1wy0on6'] )[3]")
WebElement clickListItem;

@FindBy(xpath="//span[text()='Approved' and @class='ml-2'] ")
WebElement SelectApproved;

@FindBy(xpath="//button[@type='submit' and text()='Update Order Details']")
WebElement updateOrderDetails;

@FindBy(xpath="//div[text()='Files']")
WebElement clickFilesTab;

@FindBy(xpath="//button[text()='Confirm']")
WebElement popupConfirmButton;

@FindBy(xpath="//button[text()='Cancel']")
WebElement popupCancelButton;

@FindBy(xpath="//span[text()='Upload']")
WebElement upload;

@FindBy(xpath="//div[@class='uppy-Dashboard-inner']")
WebElement uploadfilewindow;

public void readorderIDfromfile()
{

}

public void clickonnewRequest()
{	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'/admin/document-request/')])[1]")));
	openOrder.click();
}

public String FetchRequestID()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(@class,'text-white')])[1]")));
	String requestid=RequestID.getText();
	return requestid;
}

public void selectInternalStatus()
{
	clickListItem.click();
	SelectApproved.click();
}

public void updateOrderDetailsDetailspage()

{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and text()='Update Order Details']")));
	updateOrderDetails.click();
}

public void clickonFileTab()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Files']")));
	clickFilesTab.click();
}

public void clickonuploadbutton()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload']")));
	upload.click();
}

public void browsefile()
{
	uploadfilewindow.click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload']")));
	//upload.click();
	
	JavascriptExecutor bjs = (JavascriptExecutor)driver;
	bjs.executeScript("arguments[0].click()", upload);
}

}