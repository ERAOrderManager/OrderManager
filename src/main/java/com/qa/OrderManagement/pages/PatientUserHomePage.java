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

public class PatientUserHomePage extends TestBase
{
	
    public PatientUserHomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    ////a[@class='flex items-center h-full w-full' and @href='/documentsRequest']
    
    
    @FindBy(xpath="//div[@role='dialog']")
    WebElement paymentDialog;
    
    @FindBy(xpath="//button[@type='button' and @tabindex=0]")
    WebElement ClosePaymentReminderBtn;
    
    @FindBy(xpath="//a[@href='/documentsRequest']")
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
    
    @FindBy(xpath="(//div/div/input[@type='file'])[2]")
    WebElement PassportBpage;
    
    @FindBy(xpath="(//div/div/input[@type='file'])[3]")
    WebElement Hiipadeclaration;
    
    @FindBy(xpath="//p[text()='Online']")
    WebElement PaymentTypeOnline;
    
    @FindBy(xpath="//p[text()='Check']")
    WebElement PaymentTypeCheck;
    
    @FindBy(xpath="//input[@name='termsAndConditions']")
    WebElement TermsandCondition;
    
    @FindBy(xpath="//button[@type='submit' and text()='Submit Request']")
    WebElement SubmitButton;
    
    @FindBy(xpath="//div[@class='notification-description']")
    WebElement ToastMessage;
    
    @FindBy(xpath="(//div/strong)[1]")
    WebElement RawOrderIDmessage;
    
    
    //(//input[contains(@class,'upload-input draggable') and @type='file' ])[1]
    //(//input[contains(@class,'upload-input draggable') and @type='file' ])[2]
    
    
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
	
	  public void paymentRemainder() 
	  { 
		  if(paymentDialog.isDisplayed())
		  {
		  paymentDialog.click();
	      ClosePaymentReminderBtn.click();
	      System.out.println("I am on Dialog");
		  }else
		  {System.out.println("No Dialog");}
	 }
   
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

public void clickonuploadpage(String page)
{
	JavascriptExecutor mjs = (JavascriptExecutor)driver;
	if(page.equalsIgnoreCase("PassportFrontPage"))
	{
	mjs.executeScript("arguments[0].click()", PassportFpage);
	//PassportFpage.click();
	}else if(page.equalsIgnoreCase("PassportBackPage")) {
		System.out.println("REached backpage");
		mjs.executeScript("arguments[0].click()", PassportBpage);
	}else if(page.equalsIgnoreCase("HippaDeclaration")) {
		System.out.println("HippaDeclaration");
		mjs.executeScript("arguments[0].click()", Hiipadeclaration);
	}
	
}

public void TermsandConditon()
{
	TermsandCondition.click();
}

public void ClickonSubmit()
{
	SubmitButton.click();
}

public String getToastMessage()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification-description']")));
	return ToastMessage.getText();
	
}
//Read from page,fetch OrderID
public String fetchOrderID()
{
	
	//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/strong")).getText();
		//New code
	  
	  String Ordernumber;
	  String fnlOrdernumber = null;
	try {
		String ordernumber = RawOrderIDmessage.getText();
		  String[] valSplit = ordernumber.split(":"); 
		  String rawval=valSplit[1].trim();
		  String[] fnlsplit = rawval.split("    "); 
		  fnlOrdernumber = fnlsplit[0].trim();
		  System.out.println("Order number "+ordernumber +"splited "+fnlOrdernumber);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fnlOrdernumber;
	 	
	//String Ordernumber ="VIQ-149";
}
	

}
