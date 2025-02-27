package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.webdriverutility.WebDriverUtility;

public class EditUserProfile {
	WebDriver driver;
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	public EditUserProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "city")
	private WebElement cityTextField;

	public WebElement getCityTextField() {
		return cityTextField;
	}

	@FindBy(name = "fname")
	private WebElement fullNameTextField;

	@FindBy(name = "address")
	private WebElement addressTextField;

	@FindBy(name = "submit")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getFullNameTextField() {
		return fullNameTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	@FindBy(xpath = "//h5[contains(., 'Your Profile updated Successfully')]")
	private WebElement successfulMessage;

	public String getsuccessfulMessagS() {
		return successfulMessage.getText();
	}

	public void updateCity(String newCity) {
		cityTextField.clear();
		cityTextField.sendKeys(newCity);
		wLib.scrollByJS(driver, 500);
		submitButton.click();
	}

}
