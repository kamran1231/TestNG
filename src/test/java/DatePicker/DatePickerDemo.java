package DatePicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// 02-may-2022
		String expectedDay = "2";
		String expectedMonth = "June";
		String expectedYear = "2023";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(0);
		WebElement datepicker = driver.findElement(By.id("datepicker"));
		datepicker.click();

		while (true) {
			
			String calenderMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			String calenderYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			
			if(calenderMonth.equals(expectedMonth) && calenderYear.equals(expectedYear)) {
				
				
				
				List<WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td"));
				
				for (WebElement element : daysList) {
					
					String calenderday = element.getText();
					if(calenderday.equals(expectedDay)) {
						
						element.click();
						break;
					}
				}
				break;
			}
			
			else {
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
				
			
		}
		
		
	}
}
