package com.testngrunner;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.drivermanager.DriverConfig;
import com.utils.ConfigrationReader;

public class OrangeHRMLogin {

	WebDriver driver;
	Properties properties;
	
	@BeforeTest
	public void intiBrowser()
	{
		properties = ConfigrationReader.initProperties();
		driver = DriverConfig.initBrowser();
	}
	
	@Test
	public void orangeHrmLogin()
	{
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(properties.getProperty("username"));
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(properties.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
