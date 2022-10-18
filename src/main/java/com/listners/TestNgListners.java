package com.listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.drivermanager.DriverConfig;

public class TestNgListners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			DriverConfig.takeScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {

		}
	}

}
