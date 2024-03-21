package ParallelTestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ParallelTest {
	WebDriver driver;
	@BeforeTest
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 1)
	public void VerifyTitle() throws InterruptedException {
		
		String title = driver.getTitle();
		Thread.sleep(3000);
		AssertJUnit.assertEquals(title, "Swag Labs");
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void VerifyLogo() {
		
	WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));
	
	AssertJUnit.assertTrue(logo.isDisplayed());
	
	driver.quit();
	}
}
