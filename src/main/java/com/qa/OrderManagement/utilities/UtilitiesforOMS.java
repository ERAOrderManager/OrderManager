package com.qa.OrderManagement.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.qa.OrderManagement.Reports.TestListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;

@Listeners(TestListener.class)

public class UtilitiesforOMS
{
	   
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
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
    
    public void writetotextfile(String oID)
    {
           // Write the title to a text file
    	String OrderID =oID;
		/*
		 * String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 * //String destination = System.getProperty("user.dir") + "/Screenshots/" +
		 * screenshotName + dateName + ".png" String destination =
		 * System.getProperty("user.dir") + "/TextFile/" + OrderID +"-" + dateName +
		 * ".txt"; System.out.println("destination "+destination); File finalDestination
		 * = new File(destination);
		 * System.out.println("finalDestination "+finalDestination);
		 */
    	//"file"+OrderID+".txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file-"+ OrderID +".txt")))
        {
            writer.write(OrderID);
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
