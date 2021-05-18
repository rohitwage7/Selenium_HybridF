package testlayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultiLevelDrop {
	
	@Test
	public void abc() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cssscript.com/demo/create-a-multi-level-drop-down-menu-with-pure-css/");
		WebElement listElement = driver.findElement(By.partialLinkText("Front End Design"));
		Actions a = new Actions(driver);
		a.moveToElement(listElement).build().perform();
		List<WebElement> ls =	listElement.findElements(By.xpath("//ul[@class='main-navigation']/li"));
		List<WebElement> ls2= ls.get(1).findElements(By.tagName("li"));
		System.out.println(ls2.size());
		ArrayList<String> ar = new ArrayList<String>(); 
		for(WebElement e : ls2) {
			ar.add(e.getText());
		}
		System.out.println(ar);
		List<WebElement> CSS= ls2.get(1).findElements(By.tagName("li"));
		a.moveToElement(ls2.get(1)).build().perform();
		ArrayList<String> ar1 = new ArrayList<String>(); 
		for(WebElement e : CSS) {
			ar1.add(e.getText());
		}
		System.out.println(ar1);
	
	}
	
}
