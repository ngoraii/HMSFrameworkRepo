package com.hms.generic.baseclass;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hms.generic.fileutility.ExcelUtility;
import com.hms.generic.fileutility.JSONUtility;
import com.hms.generic.javautility.JavaUtility;
import com.hms.generic.objectrepository.HospitalManagementSystemPage;
import com.hms.generic.objectrepository.ProjectListPage;
import com.hms.generic.objectrepository.TekPyramidDomainListPage;
import com.hms.generic.objectrepository.UserDashboardPage;
import com.hms.generic.objectrepository.UserLoginPage;
import com.hms.generic.objectrepository.UserRegistrationPage;
import com.hms.generic.utilityclassobject.UtilityClassObject;
import com.hms.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	/*
	 * creating generic classes objects
	 */
	public WebDriverUtility wLib = new WebDriverUtility();
	public JSONUtility jsonLib = new JSONUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;

	@BeforeSuite
	public void configBS() {
		System.out.println("====BS , Report config====");
	}

	@BeforeClass
	public void configBC() throws IOException, ParseException {
		/*
		 * launching browser
		 */
		String browser = System.getProperty("browser", jsonLib.getJSONData("browser"));
		driver = wLib.getDriver(browser);
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		wLib.waitToLoadPageImplicitWait();
		/*
		 * Open the browser and enter the url
		 */
		String url = System.getProperty("url", jsonLib.getJSONData("url"));
		driver.get(url);
		/*
		 * Navigate to patient portal
		 */
		TekPyramidDomainListPage domainList = new TekPyramidDomainListPage(driver);
		domainList.clickHealthCareButton();
		ProjectListPage projList = new ProjectListPage(driver);
		projList.clickHMSProjectButton();
		wLib.switchToTabByPartialurl("Hospital_Management_System");
	}

	@BeforeMethod
	public void configBM() throws IOException, ParseException {
		/*
		 * click on patient login click here button
		 */

		HospitalManagementSystemPage hms = new HospitalManagementSystemPage(driver);
		hms.clickPatientLoginButton();

		/*
		 * click on link Create an account
		 */
		UserLoginPage loginPage = new UserLoginPage(driver);
		loginPage.clickCreateAnAccountButton();
		/*
		 * Enter the details
		 */
		UserRegistrationPage regPage = new UserRegistrationPage(driver);
		regPage.enterDetails();

		/*
		 * click on submit button
		 */
		wLib.scrollByJS(driver, 100);
		regPage.clickSubmitButton();
		/*
		 * successfully registered pop up should be displayed
		 */
		Alert switchToAlert = wLib.switchToAlert();
		Assert.assertEquals(switchToAlert.getText(), "Successfully Registered. You can login now");
		switchToAlert.accept();
		/*
		 * login as user
		 */
		wLib.scrollByJS(driver, 100);
		regPage.clicLoginLink();
		String un = regPage.getEmail();
		String pwd = regPage.getPassword();
		loginPage.loginAsUser(un, pwd);
		System.out.println(un + pwd);
	}

	@AfterMethod
	public void configAM() {
		/*
		 * logout
		 */
		UserDashboardPage userDashboard = new UserDashboardPage(driver);
		userDashboard.logout();
	}

	@AfterClass
	public void configAC() {
		/*
		 * exit browser
		 */
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("====AS , Flush Report====");
	}

}
