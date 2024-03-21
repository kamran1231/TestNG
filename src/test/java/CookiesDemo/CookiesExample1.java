package CookiesDemo;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesExample1 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		//Capture all the cookies
		Set<Cookie> cookieList = driver.manage().getCookies();
		
		//print size/number of cookies
		System.out.println(cookieList.size());
		
		for(Cookie ck: cookieList) {
			
			System.out.println(ck.getName()+ ":" + ck.getValue());
		}
		
		
		//get specific cookie according to name
		System.out.println(driver.manage().getCookieNamed("i18n-prefs"));
		
		//Create cookie
		Cookie cokObj = new Cookie("TestCookie1", "www.amazon.in");
		driver.manage().addCookie(cokObj);
		
		Set<Cookie> Aftercok = driver.manage().getCookies();
		System.out.println(Aftercok.size());
		driver.quit();

	}
	

}
