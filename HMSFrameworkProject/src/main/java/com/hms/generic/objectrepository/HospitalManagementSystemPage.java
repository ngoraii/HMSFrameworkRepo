package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.webdriverutility.WebDriverUtility;

public class HospitalManagementSystemPage {
	WebDriver driver;
	WebDriverUtility wLib= new WebDriverUtility();
	public HospitalManagementSystemPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='hms/user-login.php']")
	private WebElement patientLoginButton;
	
	public WebElement getPatientLoginButton() {
		return patientLoginButton;
	}
	
	public void clickPatientLoginButton() {
		wLib.scrollByJS(driver);
		patientLoginButton.click();
	}
}
