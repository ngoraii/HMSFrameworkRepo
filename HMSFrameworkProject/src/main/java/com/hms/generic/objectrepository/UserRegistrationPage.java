package com.hms.generic.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.javautility.JavaUtility;

public class UserRegistrationPage {
	WebDriver driver;
	public static String randomEmail="";
	public static String password="";
	ExcelUtility eLib = new ExcelUtility();
	JavaUtility jLib = new JavaUtility();

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "full_name")
	private WebElement fullNameTextField;

	@FindBy(name = "city")
	private WebElement cityTextField;

	@FindBy(name = "address")
	private WebElement addressTextField;

	@FindBy(css = "label[for='rg-male']")
	private WebElement maleRadioButton;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "password_again")
	private WebElement password_againTextField;

	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy(partialLinkText = "Log-in")
	private WebElement loginLink;
	
	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getFullNameTextField() {
		return fullNameTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getPassword_againTextField() {
		return password_againTextField;
	}

	public void enterDetails() throws EncryptedDocumentException, IOException {
		String full_name = eLib.getExcelData("reg", 1, 0);
		String city = eLib.getExcelData("reg", 1, 1);
		String address = eLib.getExcelData("reg", 1, 2);
		// String genderRadioButton = eLib.getExcelData("reg",1, 3);
		String email = eLib.getExcelData("reg", 1, 4);
		password = eLib.getExcelData("reg", 1, 5);
		randomEmail=jLib.ramdomNum() + email;
		fullNameTextField.sendKeys(full_name);
		cityTextField.sendKeys(city);
		addressTextField.sendKeys(address);
		maleRadioButton.click();
		emailTextField.sendKeys(randomEmail);
		passwordTextField.sendKeys(password);
		password_againTextField.sendKeys(password);

	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void clicLoginLink() {
		loginLink.click();
	}
	public String getEmail() {
		return randomEmail;
	}
	
	public String getPassword() {
		return password;
	}
}
