package DatePicker;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expectMonthYear = "May 2023";
		String expectedDay = "12";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='sc-dvQaRk fchrvX fswDownArrow']")).click();
		
		while(true) {
			
			String calenerMonYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			
			if(calenerMonYear.equals(expectMonthYear)) {
				
				driver.findElement(By.xpath("//p[normalize-space()='31']")).click();
				break;
			}
			else {
				
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		

	}

}
