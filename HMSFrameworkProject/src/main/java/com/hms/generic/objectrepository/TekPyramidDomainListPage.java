package com.hms.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TekPyramidDomainListPage {
	WebDriver driver;
	public TekPyramidDomainListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText="Health Care")
	private WebElement healthCareButton;
	
	public WebElement getHealthCareButton() {
		return healthCareButton;
	}
	public void clickHealthCareButton() {
		healthCareButton.click();
	}

}
