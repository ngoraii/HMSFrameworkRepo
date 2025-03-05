package com.hms.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author ngorai
 */
public class WebDriverUtility {
	WebDriver driver;

	public WebDriver getDriver(String browser) {
		if (browser.contains("chrome"))
			driver = new ChromeDriver();
		else if (browser.contains("edge"))
			driver = new EdgeDriver();
		else if (browser.contains("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		return driver;
		

	}

	public void switchToTabByPartialurl(String partialURL) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialURL))
				break;
		}
	}

	public Alert switchToAlert() {
		Alert a = driver.switchTo().alert();
		return a;
	}

	public void waitToLoadPageImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void scrollByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	

}
