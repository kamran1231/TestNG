package CustomListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(CustomListeners.ListenersNew.class)
public class DemoListeners {
	
	WebDriver driver;

	@BeforeTest
	public void setupLogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	
	@Test
	public void login() {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	
	}
	
	@Test
	public void testFail() {
		
		System.out.println("Failed test case");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testSkipped() {
		
		System.out.println("Skipped test case");
		
		throw new SkipException("Skip Exception throw....");
	}

	
}
