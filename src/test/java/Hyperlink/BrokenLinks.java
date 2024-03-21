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

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> linklist =  driver.findElements(By.tagName("a"));
		
		
		
		int resCode = 200;
		int brokenURLCount = 0;
		System.out.println("Total link :" + linklist.size());
		for (WebElement element : linklist) {
			
			String url = element.getAttribute("href");
			
			try {
				
				URL urlLink = new URL(url);
				
				HttpURLConnection huc = (HttpURLConnection)urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode = huc.getResponseCode();
				
				if(resCode >= 400) {
					System.out.println(url + "broken link");
					brokenURLCount++;
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("Total Broken Link: "+brokenURLCount);

	}

}
