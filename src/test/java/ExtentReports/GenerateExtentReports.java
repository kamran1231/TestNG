package ExtentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class GenerateExtentReports {

	ExtentSparkReporter htmlReporter;
	//specify the location of the report
	ExtentReports reports; 
	//what details should be populated in the report
	ExtentTest test;
	
	@BeforeTest
	public void startReport() {
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+
				"/test-output/myReport.html");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//Add environment details
		reports.setSystemInfo("Machine", "testPC1");
		reports.setSystemInfo("OS", "Window10");
		reports.setSystemInfo("User", "Kamran");
		
		//Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("kamran");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm");
		
	}
	
	@AfterTest
	public void endReport() {
		
		reports.flush();
	}
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}
	
	WebDriver driver;
	@Test
	public void TitleOFPage() {
		
		test = reports.createTest("NoCommerseTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "eCommerce demo store");
	}
	
	@Test
	public void noCommerseLogoTest() throws InterruptedException {
		test = reports.createTest("noCommerseLogoTest");
		Thread.sleep(3000);
		Boolean status =  driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).
				isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test
	public void noCommerseLoginTest() {
		test = reports.createTest("noCommerseLoginTest");
		
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.GREEN));
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skip", ExtentColor.BLUE));
		}
	}
	
}
