package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class FreeCRMLoginPage extends BaseClass {

	public FreeCRMLoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailinput; 	
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passinput;
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	WebElement subbutton;
	
	public void LoginPageTest(String Uname, String Password) {
		
		emailinput.sendKeys(Uname);
		passinput.sendKeys(Password);
		subbutton.click();
	}
}
