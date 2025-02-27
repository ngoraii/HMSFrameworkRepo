package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAppointmentHistory {
	WebDriver driver;
	public UserAppointmentHistory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[contains(.,'Your appointment canceled !!')]")
	private WebElement cancelMessage;
	
	
	
	public String getCancelMessage() {
		return cancelMessage.getText();
	}
}
