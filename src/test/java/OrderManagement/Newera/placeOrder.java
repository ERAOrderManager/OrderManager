package OrderManagement.Newera;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.datatransfer.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Iterator;
import java.util.Properties;



public class placeOrder {

	String fNameupld="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
	WebDriver driver =WebDriverManager.chromedriver().create();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	String parentId;
	String MainWindow;
	public static String Ordernumber;
	Properties properties = new Properties();
	
	
	@Test(priority = 0)
	public void appsetup() throws IOException
	{
		
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties.load(fileInputStream);
		
		String username = properties.getProperty("patientuser");
		String password = properties.getProperty("Password");
		String url = properties.getProperty("AppURL");
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Open the URL");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Patient User is able to login successfully");

		/*Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		parentId = it.next();
		String childId = it.next();*/
		
	}
	@Test(priority = 1)
	public void patietflow() throws InterruptedException, AWTException
	
	{
		/*
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Patient User is able to login successfully");*/
		
		Thread.sleep(5000);
		//driver.switchTo().alert().dismiss();
		//driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/div[2]")).click();
		
		//Payment Reminder window
		
		if (driver.findElement(By.xpath("/html/body/div[7]/div[3]/div")).isDisplayed());
		{
	    System.out.println("Dialog appeared :"+driver.findElement(By.xpath("/html/body/div[7]/div[3]/div")).isDisplayed());
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div")).click();
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/button")).click();
		}
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div[1]/nav/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@class='radio text-green-600' and @value='2' and @name='selectType']")).click();
		driver.findElement(By.xpath("//input[@class='radio text-green-600' and @value='1' and @name='selectType']")).click();
		Thread.sleep(2000);
		
		
		WebElement df = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/input"));
		df.sendKeys("Doctorfacility Name");
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/div")).click();
				//+ "//div[contains(@class,' css-15lsz6c-indicatorContainer')]")).click();
		Thread.sleep(4000);
		
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[1]/div[1]")).click();
		//df.sendKeys("Doctorfacility Name");
		

		WebElement dfn=	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div"));
		js.executeScript("arguments[0].click()", dfn);
		//dfn.click();
		
				//xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[110]"));
		
				//("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[124]")).click();
				//+ "//div[contains(@class,'dark:bg-gray-900 css-tr4s17-option')]/p[text()='Doctorfacility Name']")).click();
		
		//df.sendKeys(Keys.ENTER);
		
		//span[contains(@class,'text-blue-500') and (text()='browse')]
		
		Thread.sleep(3000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        
        Thread.sleep(3000);             
        /*WebElement rt = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div/div[1]/div[2]"));
        		//"//*[contains(@id,'react-select-5-') and @class='css-7pg0cj-a11yText']"));
        		//+ "//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div"));
        rt.sendKeys("Others");
		rt.sendKeys(Keys.ARROW_DOWN);*/
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[1]/div[2]/div")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[2]/div[8]/div/div/div[2]/div/div[1]")).click();
				//+ "//div[contains(@class,'select-option false false')]/span[text()='Others']")).click();
		
		/*rt.sendKeys("Others");
		Thread.sleep(3000);
		rt.sendKeys(Keys.ENTER);*/
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//span[starts-with(text(),'Medical') and @class='text-sm font-semibold text-white']")).click();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority = 2,dependsOnMethods= {"patietflow"})
	public void identity() throws InterruptedException, AWTException
		{
		
		//MainWindow = driver.getWindowHandle();
		driver.getWindowHandles();
		//document.querySelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
		WebElement pid = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		js.executeScript("arguments[0].click()", pid);
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,100)");
		
			
		WebElement fpage=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[5]/div[3]/div[1]/div/div/div[1]/input"));
		System.out.println("fpage..displayed..."+fpage.isDisplayed());
		js.executeScript("arguments[0].click()", fpage);
		
		Thread.sleep(2000);
		String fname1="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
		
		fileupload(fname1);
		
		driver.switchTo().defaultContent();
		System.out.println("Back to default content");
			
		js.executeScript("window.scrollBy(0,90)");
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
						
	}
	
	@Test(priority = 3,dependsOnMethods = {"identity"})
	public void bpageupload() throws InterruptedException, AWTException
	{
		System.out.println("backpage upload");
		WebElement pageclk=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[5]/div[3]/div[2]/div/div/div[1]"));
		pageclk.click();
		
		WebElement bpage=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[5]/div[3]/div[2]/div/div/div[1]/input"));
				//+ "//label[text()='Passport Back']/..//input[@type='file' and @accept='image/jpeg,image/png,application/pdf']"));
		System.out.println("bpage..displayed..."+bpage.isDisplayed());
		js.executeScript("arguments[0].click()", bpage);
				
		Thread.sleep(2000);
		String fname2="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
		
		fileupload(fname2);
		Thread.sleep(2000);
	}
	
	@Test(priority = 4,dependsOnMethods = {"identity"})
	public void uploadfileHippa() throws InterruptedException, AWTException 
	{
					
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
		
		WebElement hppageclck = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[6]/div[2]/div/div/div/div[1]"));
		hppageclck.click();
		
		WebElement hp = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[2]/div[6]/div[2]/div/div/div/div[1]/input"));
				//+ "//label[text()='Passport Back']/..//input[@type='file' and @accept='image/jpeg,image/png,application/pdf']"));
		js.executeScript("arguments[0].click()",hp);
		
		String fname3="C:\\Users\\krish\\OneDrive\\Documents\\Vantashala\\3sep.pdf";
		
		fileupload(fname3);
		Thread.sleep(2000);
		//hp.click();
		
		driver.findElement(By.xpath("//input[@name='paymentMode' and @ value='1']")).click();
		driver.findElement(By.xpath("//input[@name='termsAndConditions' and @ value='false']")).click();

	
	}
	@Test(priority = 5,dependsOnMethods = {"uploadfileHippa"})
	public void performsubmit() throws InterruptedException
	
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div/form/div/div[5]/button")).click();
		//Thread.sleep(9000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification-description']")));
		
		
		String toast=driver.findElement(By.xpath("//div[@class='notification-description']")).getText();
		System.out.println("Toast Message "+toast);
		
		
	}
	@Test(priority = 6,dependsOnMethods = {"performsubmit"})
	public void keyinpaymentdetails() throws InterruptedException	
		{
		//Thread.sleep(9000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/strong")));
		
		Thread.sleep(5000);
		
		String ordernumber = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/strong")).getText();
		
		String[] valSplit = ordernumber.split(":");
		String rawval =valSplit[1].trim();
		String[] fnlsplit = rawval.split("    ");
		Ordernumber=fnlsplit[0].trim();
		System.out.println("Order number "+ordernumber +"splited "+Ordernumber);
		WebElement eframe = driver.findElement(By.xpath("//iframe[@title='Secure email input frame']"));
		driver.switchTo().frame(eframe);
        //driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/input")).click();
		WebElement email=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div/div[1]/input"));
		email.click();
		Thread.sleep(2000);
		email.sendKeys("krishnagajula@gmail.com");
		Thread.sleep(2000);
		
		WebElement cclse = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/button"));
		cclse.click();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		driver.switchTo().defaultContent();
		
		WebElement cframe=driver.findElement(By.xpath("//iframe[@title='Secure payment input frame']"));
		driver.switchTo().frame(cframe);
		//WebElement cbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[1]/button[1]"));
		//cbutton.click();
		Thread.sleep(2000);
		//System.out.println("Selected card mode"+driver.findElement(By.xpath("//button[@id='card-tab' and @type='button']")).isSelected());
		//WebElement labl = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/div/label"));
		//labl.click();
		//Thread.sleep(2000);
		WebElement cnumber = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/div/div[1]/div/div[1]/input"));
		cnumber.click();
		Thread.sleep(2000);
		cnumber.sendKeys("4242424242424242");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/div/div[1]/div/div[1]/input")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/div/div[1]/div/div[1]/input")).sendKeys("4242424242424242");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[2]/div/div[1]/div/div/input")).sendKeys("11/25");
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div/div/form/div/div[1]/div[3]/div/div[1]/div/div[1]/input")).sendKeys("444");
		
	    driver.switchTo().defaultContent();
	    Thread.sleep(6000);
	    
	    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/form/div[3]/button")).click();
	    
	   // return Ordernumber;
	}
	
	public void fileupload(String fname) throws AWTException
	{
		Robot r = new Robot();
		r.setAutoDelay(1000);
		
		StringSelection ss = new StringSelection(fname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		r.setAutoDelay(2000);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.setAutoDelay(2000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		r.setAutoDelay(2000);
		js.executeScript("window.scrollBy(0,100)");
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		
	}
	
		
	}
	

	 


