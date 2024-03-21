package HandelToolTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demoSite/practice/tooltip/forms.html");
		
		String actualTooltip = driver.findElement(By.id("firstname")).getAttribute("title");
		
		String expectedTooltip = "Please provide your firstname.";
		
		if(actualTooltip.equals(expectedTooltip)) {
			
			System.out.println("Tooltip has been matched");
		}
		else {
			System.out.println("Test Failed");
		}

	}

}
