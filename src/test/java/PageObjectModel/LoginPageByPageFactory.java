package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
public class LoginPageByPageFactory {

	WebDriver driver;
	
		LoginPageByPageFactory(WebDriver d) {
		// TODO Auto-generated constructor stub
		
		driver = d;
		
		//this method will create web Elements
		PageFactory.initElements(driver, this);
	}
	
	//Identify web Elements
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement logBtn;
	
	
	public void enterUsername(String usrnm) {
		
		username.sendKeys(usrnm);
	}
	
	public void enterPassword(String psw) {
		
		password.sendKeys(psw);
	}
	
	public void clickOnLogin() {
		
		logBtn.click();
	}
}
