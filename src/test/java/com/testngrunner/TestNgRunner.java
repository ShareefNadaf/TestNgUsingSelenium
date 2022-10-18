package com.testngrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.drivermanager.DriverConfig;
import com.listners.TestNgListners;

@Listeners(value = TestNgListners.class)
public class TestNgRunner {

	DriverConfig driverconfig;
	WebDriver driver;
	
	@BeforeMethod
	public void intiBrowser()
	{
		driver= DriverConfig.initBrowser();
	}
	
	@Test
	public void getTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test
	public void getTitle2()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "gl");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
