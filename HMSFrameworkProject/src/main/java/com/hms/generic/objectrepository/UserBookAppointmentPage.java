package com.hms.generic.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.javautility.JavaUtility;
import com.hms.generic.webdriverutility.WebDriverUtility;

public class UserBookAppointmentPage {
	WebDriver driver;
	public String doctorName="";
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	public UserBookAppointmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="Doctorspecialization")
	private WebElement doctorSpecializationDP;
	
	@FindBy(id="doctor")
	private WebElement doctorsDP;
	
	@FindBy(name="appdate")
	private WebElement appointmentDateInput;
	
	@FindBy(name="apptime")
	private WebElement appointmentTimeInput;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	@FindBy(partialLinkText = "Appointment History")
	private WebElement appointmentHistoryButton;
	
	public WebElement getAppointmentHistoryButton() {
		return appointmentHistoryButton;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDoctorSpecializationDP() {
		return doctorSpecializationDP;
	}

	public WebElement getDoctorsDP() {
		return doctorsDP;
	}

	public WebElement getAppointmentDateInput() {
		return appointmentDateInput;
	}

	public WebElement getAppointmentTimeInput() {
		return appointmentTimeInput;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void enterDoctorDetailsAndSubmit() throws EncryptedDocumentException, IOException {
		wLib.scrollByJS(driver);
		doctorName=eLib.getExcelData("docApp", 1, 1);
		jLib.selectByVisibleText(doctorSpecializationDP, eLib.getExcelData("docApp", 1, 0));
		jLib.selectByVisibleText(doctorsDP, doctorName);
		appointmentDateInput.sendKeys(jLib.todayDateYYYYMMDD());
		submitButton.click();
		
	}
	public void clickAppointmentHistoryButton() {
		appointmentHistoryButton.click();
	}
}
