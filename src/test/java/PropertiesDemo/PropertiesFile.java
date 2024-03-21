package PropertiesDemo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		ReadConfig configFile = new ReadConfig();
		
		driver.get(configFile.getURL());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(configFile.getUsername());
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(configFile.getPassword());
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
		

	}

}
