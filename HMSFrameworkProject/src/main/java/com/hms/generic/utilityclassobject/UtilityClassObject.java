package com.hms.generic.utilityclassobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}

}
