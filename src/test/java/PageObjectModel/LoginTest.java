package PageObjectModel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Create object of LoginPage
		LoginPage LoginPG = new LoginPage(driver);
		
		
		driver.get("https://www.saucedemo.com/");
		
		LoginPG.enterUsername("standard_user");
		LoginPG.enterPassword("secret_sauce");
		LoginPG.ClickOnLogin();
		

	}

}
