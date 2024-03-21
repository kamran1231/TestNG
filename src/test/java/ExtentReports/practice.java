package ExtentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	ExtentSparkReporter htmlReports;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void GenerateExtentReport() {

		htmlReports = new ExtentSparkReporter(System.getProperty("user.dir"+"/test-output/newExtentReport"));

		reports = new ExtentReports();
		reports.attachReporter(htmlReports);

		// Add Environment
		reports.setSystemInfo("Machine", "tcP1");
		reports.setSystemInfo("OS", "Window");
		reports.setSystemInfo("User", "Kamran");

		// Configuration report
		htmlReports.config().setDocumentTitle("Demo Extent Report");
		htmlReports.config().setTheme(Theme.DARK);
		htmlReports.config().setReportName("kamran");
		htmlReports.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm");

	}

	@AfterTest
	public void endReport() {
		reports.flush();
	}

	

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/marketplace");
	}

	WebDriver driver;
	@Test
	public void TestLogo() {

		test = reports.createTest("Test Logo");
		Boolean status = driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed();

		Assert.assertTrue(status);
	}

	@Test
	public void TestTitle() {
		test = reports.createTest("Test title");
		String tit = driver.getTitle();
		Assert.assertEquals(tit, "title of the page");

	}

	@Test
	public void TestLogin() {
		test = reports.createTest("Test Login");
		Assert.assertTrue(true);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Fail", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Pass", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skip", ExtentColor.BLUE));
		}

	}
}
