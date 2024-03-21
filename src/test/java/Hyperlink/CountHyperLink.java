package Hyperlink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.calculator.net/");
		
		List<WebElement> linkElements =  driver.findElements(By.tagName("a"));
		
		System.out.println("Total links on webPage :"+ linkElements.size());
		
		for (WebElement webElement : linkElements) {
			
			System.out.println(webElement.getText());
			
		}

	}

}
