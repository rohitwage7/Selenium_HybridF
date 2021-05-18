package testlayer;

import java.awt.desktop.SystemEventListener;
import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Gmail {
	
	public static WebDriver driver; 
	public FirefoxOptions options;
	@BeforeTest
	public void setup() 
	{

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		
		options = new FirefoxOptions();
		
//        Map < String, Object > prefs = new HashMap < String, Object > ();
//        prefs.put("profile.managed_default_content_settings.javascript", 2);
//        options.setExperimentalOption("prefs", prefs);
		driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
		
	@Test
	public void test() {
		driver.get("https://gmail.com/");
		WebElement username = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @name='identifier']"));  ////input[@class='whsOnd zHQkBf' and @name='identifier']
		WebElement nextbuttonElement = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")); 
		
		username.sendKeys("rohitwage07@gmail.com");
		nextbuttonElement.click();
		WebElement password = driver.findElement(By.xpath("//input[@name ='password']"));
		password.sendKeys("r@2015##");
	
		Assert.assertEquals(driver.getTitle().contains("Inbox"), "Inbox".contains("@gmail.com"));
		System.out.println("User logged in his account successfully");
		driver.findElement(By.className("T-I T-I-KE L3")).click();
		
		String email = "rohitwage02@gmail.com";
		
		driver.findElement(By.xpath("//textarea[@name='to' ]")).sendKeys(email);
		String sub = "E-mail | Automation Test";
		
		driver.findElement(By.name("subjectbox")).sendKeys(sub);
		driver.findElement(By.className("Am Al editable LW-avf tS-tW")).sendKeys("Hi,"+Keys.RETURN+"This is the email for testing Gmail functionality");
		driver.findElement(By.className("T-I J-J5-Ji aoO v7 T-I-atl L3")).click();
		driver.findElement(By.linkText("Sent")).click();
		boolean sentemail = driver.findElement(By.xpath("//span[text()='rohitwage']")).getText().contains("rohitwage02");
		
		
	}
}
