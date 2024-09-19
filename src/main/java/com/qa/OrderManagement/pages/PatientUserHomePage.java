package com.qa.OrderManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.OrderManagement.base.TestBase;

public class PatientUserHomePage extends TestBase{
	
	WebElement PaymentReminderPrmpt=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div"));
	WebElement ClosePaymentReminderBtn=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/button"));
	WebElement NewDocumentRequest=driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/div/div[1]/div[2]/div/div[1]/nav/div[1]/a"));
	WebElement SelectTypeDoctorFacility=driver.findElement(By.xpath("//input[@class='radio text-green-600' and @value='1' and @name='selectType']"));
	WebElement SelectTypeAttorneyOffice=driver.findElement(By.xpath("//input[@class='radio text-green-600' and @value='2' and @name='selectType']"));
	
	WebElement ListboxDoctorFacilty=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div"));
	WebElement IndexvalueDFname=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[126]"));
	
	WebElement SelectDFName=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/input"));
	WebElement ActionDFName=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div"));
	
	WebElement RequestTypeListbox=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[1]/div[2]/div"));
    WebElement RqstTypeSelectAuth =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[1]"));
    WebElement RqstTypeSelectCivilS =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[2]"));
    WebElement RqstTypeSelectFederalS =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[3]"));

    WebElement RqstTypeSelectWorkersComp =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[4]"));
    WebElement RqstTypeSelectOthers =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[5]"));
    
    WebElement RushDeliveryDate=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[10]/div/div/div/input"));
    
    WebElement RecordTypeMedical=driver.findElement(By.xpath("//span[starts-with(text(),'Medical') and @class='text-sm font-semibold text-white']"));
    WebElement RecordTypeBilling=driver.findElement(By.xpath("//span[starts-with(text(),'Billing') and @class='text-sm font-semibold text-white']"));
    WebElement RecordTypeXRay=driver.findElement(By.xpath("//span[starts-with(text(),'X-Ray') and @class='text-sm font-semibold text-white']"));
    

}

