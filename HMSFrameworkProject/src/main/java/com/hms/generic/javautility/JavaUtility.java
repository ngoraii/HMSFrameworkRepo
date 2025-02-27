package com.hms.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JavaUtility {
	public int ramdomNum() {
		Random random=new Random();
		int nextInt = random.nextInt(2000);
		return nextInt;
	}
	
	public void selectByVisibleText(WebElement dp, String text) {
		Select s=new Select(dp);
		s.selectByVisibleText(text);
	}
	
	public String todayDateYYYYMMDD(){
		Date d=new Date();
		SimpleDateFormat sDate=new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = sDate.format(d);
		return todayDate;
	}
}
