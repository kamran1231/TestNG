package IFRAME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframeControlEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java"
				+ "/index.html?overview-summary.html");
		
		driver.switchTo().frame(0);
		String a = driver.findElement(By.linkText("org.openqa.selenium")).getText();

		System.out.println(a);
	}

}
