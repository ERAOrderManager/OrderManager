package OrderManagement.Newera;

import java.util.Properties;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class serverOrder  {
	WebDriver driver = WebDriverManager.chromedriver().create();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Properties properties = new Properties();
	//OrderManagement.Newera.placeOrder placeOrder;
	
	
		
	@Test(priority=0)
	public void logintoapp() throws IOException, InterruptedException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties.load(fileInputStream);
		
		String username = properties.getProperty("DFUserName");
		String password = properties.getProperty("Password");
		String url = properties.getProperty("AppURL");
		
		//driver.get("https://green-beach-0caa2f210.3.azurestaticapps.net/sign-in");
		System.out.println("URL.."+url);
		Thread.sleep(2000);
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/admin/document-requests/New']")).click();
				//+ "/html/body/div[1]/div/div/div[1]/div[2]/div/div[1]/nav/div[1]/ul/div[1]")).click();
				//"//a[@href='/orders/orderReceived' and @xpath='1']")).click();
		
		Thread.sleep(6000);
		//String OrdID=placeOrder.keyinpaymentdetails();
		//System.out.println("The orderID from Place order "+OrdID);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/div[1]/input")).sendKeys("VIQ-91");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]")).click();
		Thread.sleep(6000);
		
		String OrdID=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[1]/div/div/div/div[1]/div[1]/div[1]/p[2]")).getText();
		
		System.out.println("Request ID "+OrdID);
		
		Thread.sleep(2000);
		
		 js.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
		 //TO select Approved/Reject
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[2]/div[1]/form/div/div/div[1]/div/div[2]/div[3]/div[3]/div/div/div[1]")).click();
		 Thread.sleep(2000);
		WebElement InternalStatus=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[2]/div[1]/form/div/div/div[1]/div/div[2]/div[3]/div[3]/div/div/div[2]/div/div[2]"));
				//+ "/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div[3]/form/div/div[1]/div[5]/div/div/div[1]/div[1]/div[2]/input"));
		
	    InternalStatus.click();
		
		Thread.sleep(4000);
		//upload button
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[2]/div[1]/form/div/div/div[1]/div/div[2]/div[5]/button")).click();
	
		Thread.sleep(3000);
		String toastmsg=driver.findElement(By.xpath("//div[@class='notification-description']")).getText();
		System.out.println("Toast Message "+toastmsg);
		Thread.sleep(9000);
		
	} 
	@Test(priority=1,dependsOnMethods = {"logintoapp"})
	public void uploaddocs() throws InterruptedException, AWTException {
		
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[1]/div[2]")).click();
		Thread.sleep(2000);
		System.out.println("File tab is clicked successfully");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div[2]/div/div/div/div[2]/div[5]/div/div[2]/div/div/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[10]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]")).click();
		WebElement fup=driver.findElement(By.xpath("//div/button[@type='button']"));
				//("/html/body/div[10]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/button"));
		js.executeScript("arguments[0].click()",fup);
		Thread.sleep(3000);
		
        String fname3="C:\\Users\\krish\\OneDrive\\Desktop\\sep5_EC.pdf";
		
		fileupload(fname3);
		Thread.sleep(4000);
		
		
		WebElement uploadfile = driver.findElement(By.xpath("//button[@aria-label='Upload 1 file' and text()='Upload 1 file']"));
				//+ "/html/body/div[10]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[2]/button"));
		uploadfile.click();
		
		Thread.sleep(4000);
		
		WebElement done = driver.findElement(By.xpath("//button[@type='button' and text()='Done']"));
				//(By.xpath("/html/body/div[10]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[3]/button"));
		done.click();
		
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
		//js.executeScript("window.scrollBy(0,100)");
		
		//driver.manage().window().minimize();
		//driver.manage().window().maximize();
		
	}
	
}
