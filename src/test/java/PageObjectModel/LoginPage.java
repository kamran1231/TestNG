package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Without Page Factory
public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver = d;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	
	public void enterUsername(String uname) {
		
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String psw) {
		
		driver.findElement(password).sendKeys(psw);
	}
	
	public void ClickOnLogin() {
		
		driver.findElement(loginbtn).click();
	}

}
