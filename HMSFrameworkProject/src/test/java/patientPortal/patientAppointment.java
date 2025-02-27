package patientPortal;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.generic.baseclass.BaseClass;
import com.hms.generic.objectrepository.UserAppointmentHistory;
import com.hms.generic.objectrepository.UserBookAppointmentPage;
import com.hms.generic.objectrepository.UserDashboardPage;

/**
 * @author ngorai patient profile create account book and cancel appointment
 */
public class patientAppointment extends BaseClass {

	@Test
	public void bookAndCancelAppointment() throws IOException, ParseException {
		/*
		 * click book appointment
		 */
		UserDashboardPage userPage = new UserDashboardPage(driver);
		userPage.clickBookAppointmentLink();
		/*
		 * enter doctor details and submit
		 */
		UserBookAppointmentPage appPage = new UserBookAppointmentPage(driver);
		appPage.enterDoctorDetailsAndSubmit();
		/*
		 * verify the successful message
		 */
		Assert.assertEquals(wLib.switchToAlert().getText(), "Your appointment successfully booked");
		wLib.switchToAlert().accept();
		/*
		 * click on appointmentHistoryButton
		 */
		appPage.clickAppointmentHistoryButton();
		/*
		 * cancel the appointment
		 */
		String docName = appPage.doctorName;
		driver.findElement(By.xpath("//td[.='" + docName + "']/following-sibling::td[6]")).click();
		wLib.switchToAlert().accept();
		/*
		 * verify cancel message
		 */
		UserAppointmentHistory appHistory = new UserAppointmentHistory(driver);
		Assert.assertEquals(appHistory.getCancelMessage(), "Your appointment canceled !!");
	}
}
