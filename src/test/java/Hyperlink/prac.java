package Hyperlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> linkList =  driver.findElements(By.tagName("a"));
		
		System.out.println("Total URL: "+linkList.size());
		
		int resCode = 200;
		for (WebElement element : linkList) {
			
			System.out.println("URL link"+element.getText());
			
			String link = element.getAttribute("href");
			
			try {
				
				URL urlLink = new URL(link);
				HttpURLConnection huc =  (HttpURLConnection) urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode = huc.getResponseCode();
				
				if(resCode >= 400) {
					System.out.println(link + "Broken link");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
