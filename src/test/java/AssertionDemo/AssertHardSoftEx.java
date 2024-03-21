package AssertionDemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertHardSoftEx {

	@Test
	public void testMethod() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		System.out.println("Verifying title...........");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "Automation Testing Practice1");
		
		System.out.println("Verifying presence of wikipedia-icon");
		
		WebElement icon =  driver.findElement(By.className("wikipedia-icon"));
		
		softAssert.assertTrue(icon.isDisplayed());
		
		WebElement searchicon =  driver.findElement(By.className("wikipedia-search-button"));
		softAssert.assertTrue(searchicon.isDisplayed());
		
		softAssert.assertAll();

		
		
	}
	
}
