package EncodedPassword;

import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodedPasswordExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//encoded password
		String password = "admin123";
		
		byte[] encodedPassword =  Base64.encode(password.getBytes());
		
		System.out.println(new String(encodedPassword));
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(3000);

		//Decode password
		byte[] decodePassword = Base64.decode(encodedPassword);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(new String(decodePassword));

		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

}
