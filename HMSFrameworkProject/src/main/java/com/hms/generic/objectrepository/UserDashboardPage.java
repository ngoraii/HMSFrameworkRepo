package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {
	WebDriver driver;
	public UserDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Book Appointment")
	private WebElement bookAppointmentLink;
	
	@FindBy(partialLinkText = "View Appointment")
	private WebElement viewAppointmentLink;
	
	@FindBy(partialLinkText = "pdate Profile")
	private WebElement updateProfileLink;

	public WebElement getBookAppointmentLink() {
		return bookAppointmentLink;
	}

	public WebElement getViewAppointmentLink() {
		return viewAppointmentLink;
	}

	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}
	
	@FindBy(css=".username")
	private WebElement userProfileLink;
	
	@FindBy(partialLinkText = "My Profile")
	private WebElement myProfileButton;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutButton;
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getUserProfileLink() {
		return userProfileLink;
	}


	public WebElement getMyProfileButton() {
		return myProfileButton;
	}


	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}
	@FindBy(partialLinkText = "Change Password")
	private WebElement changePasswordButton;
	
	
	public void clickBookAppointmentLink() {
		bookAppointmentLink.click();
	}
	
	public void clickViewAppointmentLink() {
		viewAppointmentLink.clear();
	}
	
	public void clickUpdateProfileLink() {
		updateProfileLink.click();
	}
	public void logout() {
		userProfileLink.click();
		logoutButton.click();
	}
}
