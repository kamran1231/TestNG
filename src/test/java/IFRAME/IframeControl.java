package IFRAME;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		
		//switch to iframe
		driver.switchTo().frame("moneyiframe");
		
		String nsindex = driver.findElement(By.id("nseindex")).getText();
		
		System.out.println(nsindex);

	}

}
