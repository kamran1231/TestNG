package Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/");
		
		
		//Capture full page screenshot
		
		//Step1: convert webDriver object to TakesScreenshot interface
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		//Step2: call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\khanb\\eclipse-workspace\\TestNG_Pr\\test-output\\fullpage.png");
		
		
		//Copy image file to destination
		FileUtils.copyFile(src, des);
		
		
		

	}

}
