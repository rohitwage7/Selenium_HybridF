package UtilityPackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import TestBase.BaseClass;

public class Screenshot extends BaseClass
{

	public static void screenshotclick() throws IOException {
		String path = System.getProperty("user.dir");
		TakesScreenshot scr = (TakesScreenshot)driver;
		
		File Source = scr.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("ddMMyyyy HHmmss");
		FileUtils.copyFile(Source, new File(path+"/Screenshot/"+LocalDateTime.now().format(timeStampPattern)+".png"));
		
	}
	
	
}
