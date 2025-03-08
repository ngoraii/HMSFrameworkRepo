package com.hms.generic.objectrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.webdriverutility.WebDriverUtility;

public class HospitalManagementSystemPage {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();

	public HospitalManagementSystemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Patients']/parent::div/descendant::a[text()='Click Here']")
	private WebElement patientLoginButton;

	public WebElement getPatientLoginButton() {
		return patientLoginButton;
	}

	public void clickPatientLoginButton() throws InterruptedException {
		
//		Actions act=new Actions(driver);
//		act.scrollToElement(patientLoginButton);
//		patientLoginButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", patientLoginButton);

	}
}
