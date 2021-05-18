package testlayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ListDOm {

	@Test	
	public void Listdemo() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Rohit/Desktop/dom.html");
		WebElement weblist = driver.findElement(By.className("caret"));
		System.out.println(weblist.getText());
		List<WebElement> listwebi= weblist.findElements(By.xpath("//ul[@id='myULmain']"));
		ArrayList <String> ar = new ArrayList<String>();
		for(WebElement e :listwebi) {
			ar.add(e.getText());
		}
		System.out.println(ar);
//		
//		listwebi.get(2).findElements(By.tagName("li"));
		
		

	}

}
