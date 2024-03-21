package DataDriven;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExcel {

	WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		
	}
	
	@Test(dataProvider = "searchData")
	public void searchKeyword(String keyword) throws InterruptedException {
		Thread.sleep(3000);
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys(keyword);
		
		Thread.sleep(3000);

		searchBox.sendKeys(Keys.ENTER);
	}
	
	@DataProvider(name = "searchData")
	public Object[][] searchDataprovider() {
		
		Object[][] searchD = new Object[2][1];
		searchD[0][0] = "Taj Mahal";
		searchD[1][0] = "India gate";
		return searchD;
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
