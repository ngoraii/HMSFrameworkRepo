package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	WebDriver driver;
	public UserLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Create an accou")
	private WebElement createAnAccountButton;
	
	public WebElement getCreateAnAccountButton() {
		return createAnAccountButton;
	}
	public void clickCreateAnAccountButton() {
		createAnAccountButton.click();
	}
	
	@FindBy(name="username")
	private WebElement usernameTextFied;
	
	public WebElement getUsernameTextFied() {
		return usernameTextFied;
	}
	
	@FindBy(name="submit")
	private WebElement loginLink;
	
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	@FindBy(name="password")
	private WebElement passwordTextFied;
	
	public WebElement getpasswordTextFied() {
		return passwordTextFied;
	}
	public void loginAsUser(String un, String pwd) {
		usernameTextFied.sendKeys(un);
		passwordTextFied.sendKeys(pwd);
		loginLink.click();
	}
}
