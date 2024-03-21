package OneLineStatement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class OneLineExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Actions actions = new Actions(driver);
		
		Action seriesOFActions = actions.moveToElement(driver.findElement(By.id("user-name")))
				.click()
				.sendKeys("standard_user",Keys.TAB)
				.sendKeys("secret_sauce",Keys.ENTER).build();
		
		seriesOFActions.perform();
				
		
		

	}

}
