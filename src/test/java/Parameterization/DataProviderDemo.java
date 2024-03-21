package Parameterization;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

	
//	@BeforeTest
//	public void SetUP() {
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//	}
//	
//	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "getData")
	public void TestCaseGoogleSearch(String country,String monument) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement searchBox =  driver.findElement(By.cssSelector("#APjFqb"));
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		searchBox.sendKeys(country + " " + monument);
		

		driver.findElement(By.name("btnK")).submit();
		
	}
	
	@DataProvider(name = "getData")
	public Object[][] getData() {
		
		Object[][] obj = new Object[3][2];
		obj[0][0] = "India";
		obj[0][1] = "Qutub Minar";
		obj[1][0] = "Agra";
		obj[1][1] = "Taj Mahal";
		obj[2][0] = "Hyderabad";
		obj[2][1] = "Charminar";
		
		return obj;


		
	}
}
