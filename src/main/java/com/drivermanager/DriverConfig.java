package com.drivermanager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.utils.ConfigrationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfig 
{
	 private static WebDriver driver;
	 private static Properties properties;
   public static WebDriver initBrowser()
   {
	   properties = ConfigrationReader.initProperties();
	   String browser=properties.getProperty("browser");
	   String websiteUrl = properties.getProperty("websiteurl");
	   if(browser.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver= new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   driver.get(websiteUrl);
	   }
	   else if(browser.equalsIgnoreCase("edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   driver.get(websiteUrl);
	   }
	   else if(browser.equalsIgnoreCase("explorer"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   driver.get(websiteUrl);
	   }
	   else
	   {
		   throw new UnreachableBrowserException(browser+" IS NOT A VALID BROWSER PLEASE ENTER CORRECT BROWSER IN PROP FILE.");
	   }
	  return driver;
   }
   
   public static void takeScreenshot(String methodName) throws IOException
   {
	   File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File fis=new File(".\\src\\test\\resultimages\\"+methodName+".png");
	   FileUtils.copyFile(file, fis);
   }
}
