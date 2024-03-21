package Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshotSpecific {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.uitestpractice.com/");
		
		WebElement section = driver.findElement(By.xpath("//div[@class='container red']"));
		
		File src = section.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\khanb\\eclipse-workspace\\TestNG_Pr\\test-output\\sectionScreenshot.png");
		
		FileUtils.copyFile(src, des);
	}

}
