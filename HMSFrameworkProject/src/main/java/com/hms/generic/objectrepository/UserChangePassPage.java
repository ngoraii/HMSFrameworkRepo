package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserChangePassPage {
	WebDriver driver;
	public UserChangePassPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="cpass")
	private WebElement currentPassTextField;
	
	public WebElement getCurrentPassTextField() {
		return currentPassTextField;
	}
	

	@FindBy(name="npass")
	private WebElement newPassTextField;
	
	public WebElement getNewPassTextField() {
		return newPassTextField;
	}
	
	@FindBy(xpath="//img[@src='assets/images/images.jpg']")
	private WebElement userIcon;
	
	public WebElement getUserIcon() {
		return userIcon;
	}
	
	@FindBy(xpath="//p[.='Password Changed Successfully !!								']")
	private WebElement validationMessage;
	
	public String getValidationMessage() {
		return validationMessage.getText();
	}

	@FindBy(name="cfpass")
	private WebElement confPassTextField;
	
	public WebElement getConfPassTextField() {
		return confPassTextField;
	}
	@FindBy(name="submit")
	private WebElement submitButton;
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void changePass(String currentPass, String newPass) throws InterruptedException {
		currentPassTextField.sendKeys(currentPass);
		Thread.sleep(2000);
		newPassTextField.sendKeys(newPass);
		confPassTextField.sendKeys(newPass);
		submitButton.click();
	}
}
