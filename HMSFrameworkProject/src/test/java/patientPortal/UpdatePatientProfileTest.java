package patientPortal;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseclass.BaseClass;
import com.hms.generic.objectrepository.EditUserProfile;
import com.hms.generic.objectrepository.HospitalManagementSystemPage;
import com.hms.generic.objectrepository.UserChangePassPage;
import com.hms.generic.objectrepository.UserDashboardPage;
import com.hms.generic.objectrepository.UserLoginPage;
import com.hms.generic.objectrepository.UserRegistrationPage;

public class UpdatePatientProfileTest extends BaseClass {

	@Test
	public void updateCityTest() throws EncryptedDocumentException, IOException, ParseException {
		
		/*
		 * goto profile update page
		 */
		UserDashboardPage userDashboard = new UserDashboardPage(driver);
		userDashboard.getUserProfileLink().click();
		userDashboard.getMyProfileButton().click();
		/*
		 * update city
		 */
		EditUserProfile editProfile = new EditUserProfile(driver);
		editProfile.updateCity(eLib.getExcelData("editProf", 1, 0));
		Assert.assertEquals(editProfile.getsuccessfulMessagS(), "Your Profile updated Successfully");
		
	}

	@Test
	public void updatePatientPasswordTest() throws EncryptedDocumentException, IOException, ParseException, InterruptedException {
		
		/*
		 * goto profile update page and click change password
		 */
		UserDashboardPage userDashboard = new UserDashboardPage(driver);
		userDashboard.getUserProfileLink().click();
		userDashboard.getChangePasswordButton().click();
		/*
		 * change password
		 */
		UserChangePassPage changePass = new UserChangePassPage(driver);
		String newPass = UserRegistrationPage.password + jLib.ramdomNum();
		changePass.changePass(UserRegistrationPage.password, newPass);
		/*
		 * Verify success message
		 */
		changePass.getUserIcon().click();
		Assert.assertEquals(changePass.getValidationMessage(), "Password Changed Successfully !!");
		/*
		 * logout
		 */
		userDashboard.logout();
		/*
		 * Login with newPass
		 */
		UserLoginPage loginPage = new UserLoginPage(driver);
		HospitalManagementSystemPage hms = new HospitalManagementSystemPage(driver);
		hms.clickPatientLoginButton();
		String un = UserRegistrationPage.randomEmail;
		loginPage.loginAsUser(un, newPass);
		}

}
