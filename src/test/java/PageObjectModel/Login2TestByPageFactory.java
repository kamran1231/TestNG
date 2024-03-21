package PageObjectModel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login2TestByPageFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		LoginPageByPageFactory LoginPGBYFact = new LoginPageByPageFactory(driver);
		
		driver.get("https://www.saucedemo.com/");
		
		LoginPGBYFact.enterUsername("standard_user");
		LoginPGBYFact.enterPassword("secret_sauce");
		LoginPGBYFact.clickOnLogin();
	}

}
