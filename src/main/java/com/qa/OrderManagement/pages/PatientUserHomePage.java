package com.qa.OrderManagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.OrderManagement.base.TestBase;

public class PatientUserHomePage extends TestBase
{
	
    public PatientUserHomePage() {
    	PageFactory.initElements(driver, this);
    	
    }
    
    @FindBy(xpath="//a[@class='flex items-center h-full w-full' and @href='/documentsRequest']")
    WebElement newDocumentRequest;
    
    @FindBy(xpath="//p[text()='Doctor Facility']")
    WebElement DRSelecTypeasDF;
    
    @FindBy(xpath="//p[text()='Attorney Office']")
    WebElement DRSelecTypeasAO;
    
    @FindBy(xpath="//div[contains(@class,' css-1wy0on6')]")
    WebElement DFList;
    
    @FindBy(xpath="//div[contains(@class,'select__indicators css-1wy0on6')]")
    WebElement RequestTypeList;
    
    @FindBy(xpath="//span[contains(@class,'text-sm font-semibold text-white') and starts-with(text(),'Medical')]")
    WebElement RecordTypeMedical;
    
    @FindBy(xpath="//span[contains(@class,'text-sm font-semibold text-white') and starts-with(text(),'Billing')]")
    WebElement RecordTypeBilling;
    
    @FindBy(xpath="//span[contains(@class,'text-sm font-semibold text-white') and starts-with(text(),'X-Ray')]")
    WebElement RecordTypeXray;
    
    @FindBy(xpath="//h6[text()='Passport']")
    WebElement PassportID;
    
    @FindBy(xpath="(//div/div/input[@type='file'])[1]")
    WebElement PassportFpage;
    //(//input[contains(@class,'upload-input draggable') and @type='file' ])[1]
    
    
	/*
	 * WebElement PaymentReminderPrmpt=driver.findElement(By.xpath(
	 * "/html/body/div[7]/div[3]/div")); WebElement
	 * ClosePaymentReminderBtn=driver.findElement(By.xpath(
	 * "/html/body/div[7]/div[3]/div/div[2]/button")); WebElement
	 * NewDocumentRequest=driver.findElement(By.xpath(
	 * "/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/nav/div[1]"));
	 */
	
	//@FindBy()
	/*
	 * WebElement SelectTypeDoctorFacility=driver.findElement(By.
	 * xpath("//input[@class='radio text-green-600' and @value='1' and @name='selectType']"
	 * )); WebElement SelectTypeAttorneyOffice=driver.findElement(By.
	 * xpath("//input[@class='radio text-green-600' and @value='2' and @name='selectType']"
	 * ));
	 */
	
	/*WebElement NewDocumentRequest1=driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/div/div[1]/div[2]/div/div[1]/nav/div[1]/a"));
	/*
	
	
	
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
    
    */

    
    //Actions
	/*
	 * public void paymentRemainder() { PaymentReminderPrmpt.click();
	 * ClosePaymentReminderBtn.click();
	 */  
   
    public void newdocumentRequest() 
    {
    	newDocumentRequest.click();
    }
    
    public void selectDType(String type)
    {
    	if(type.equalsIgnoreCase("DF"))
    	{
    	DRSelecTypeasDF.click();
    	}else if(type.equalsIgnoreCase("AO")) {
    		DRSelecTypeasAO.click();
    	}
    		
    }
public void ItemListclick() {
	DFList.click();
}

public void requestTypeList() 
{
	RequestTypeList.click();

}

public void selectRecordType(String rtype )
{
	if(rtype.equalsIgnoreCase("Medical"))
	{
	RecordTypeMedical.click();
}else if(rtype.equalsIgnoreCase("Billing"))
{
	RecordTypeBilling.click();
}else if(rtype.equalsIgnoreCase("XRAY"))
{
	RecordTypeXray.click();
}

}
public void selectIdentity() {
	PassportID.click();
	
}

public void clickonuploadpassportFpage()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", PassportFpage);
	//PassportFpage.click();

}

}
