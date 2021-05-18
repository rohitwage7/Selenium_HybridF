package testlayer;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import TestBase.BaseClass;
import pagelayer.FreeCRMLoginPage;

public class LoginTest extends BaseClass {

	public LoginTest() throws IOException {
		super();		
	}
	
@BeforeClass
public void setup()	{ 
	initilization();
	
}
	
@Test	(priority = 1)
public void Logintest() {
	
	logger = report.createTest("Login Test Using valid username and valid password");
	logger.info("Application is loggin in");
	FreeCRMLoginPage obj = new FreeCRMLoginPage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	obj.LoginPageTest(prop.getProperty("username"),prop.getProperty("pass"));
			
}
@Test(priority = 2)
public void Title() {
	System.out.println(driver.getTitle());;
	
}


}
