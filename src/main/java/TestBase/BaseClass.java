package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilityPackage.HTMLListener;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report ;
	public ExtentTest logger;
	EventFiringWebDriver E_driver;
	HTMLListener eventlist;
	
	@BeforeSuite
	public void extentreport() {
		
		ExtentHtmlReporter htmlreport   = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-output/freecrm.html"));
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		
	}
	// Rohit
	public BaseClass() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Rohit\\eclipse-workspace\\HybridFrame\\Configuration\\Config.propertise");
			prop.load(fis);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void initilization( ) {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium_Projects\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		E_driver = new EventFiringWebDriver(driver);
		eventlist = new HTMLListener();
		E_driver.register(eventlist);
		driver=E_driver;
		
	}	
	@BeforeMethod
	public void flushmethod() 
	{
		report.flush();
	}	
}
