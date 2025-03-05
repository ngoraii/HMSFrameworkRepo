package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectListPage {
	WebDriver driver;
	public ProjectListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Hospital Management")
	private WebElement hmsProjectButton;
	
	public WebElement getHMSProjectButton() {
		return hmsProjectButton;
	}
	
	public void clickHMSProjectButton() {
		hmsProjectButton.click();
	}
}
