package DatePicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo2 {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectMonthYear = "May 2023";
		String expectedDay = "12";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		Thread.sleep(3000);
		driver.findElement(By.id("onward_cal")).click();
		
		String t = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		System.out.println(t);
		
		while(true) {
			
			String MonthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			if(MonthYear.equals(expectMonthYear)) {
				
				//1st Method
//				List<WebElement> dayList =  driver.findElements(By.xpath("//table/tbody/tr/td"));
//				
//				for (WebElement element : dayList) {
//					
//					String calenderday = element.getText();
//					
//					if(calenderday.equals(expectedDay)) {
//						
//						element.click();
//						break;
//					}
//				}
//				break;
				
				//Second Method
				driver.findElement(By.xpath("//td[text()='8']")).click();
				
			}
			else {
				
				driver.findElement(By.xpath("(//button[normalize-space()='>'])[1]")).click();
			}
		}
		
	}

}
