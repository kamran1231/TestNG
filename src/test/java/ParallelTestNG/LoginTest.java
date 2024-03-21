package ParallelTestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@BeforeTest
	public void setupLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void VerifyLogin() throws InterruptedException {

		WebElement user= driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		
		Thread.sleep(2000);
		WebElement psw= driver.findElement(By.id("password"));
		psw.sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		AssertJUnit.assertEquals(driver.getTitle(), "Swag Labs");
	}
}
