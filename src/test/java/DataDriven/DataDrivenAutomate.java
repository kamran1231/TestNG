package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenAutomate {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
		File excelFile = new File("C:\\Users\\khanb\\Downloads\\demonew.xlsx");
		
		FileInputStream fi = new FileInputStream(excelFile);
		
		workbook = new XSSFWorkbook(fi);
		
		sheet = workbook.getSheetAt(0);
		
		int totalnumofRows = sheet.getLastRowNum()+1;
		int totalnumofCells = sheet.getRow(0).getLastCellNum();
		
		for(int currentRow=0;currentRow<totalnumofRows;currentRow++) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(currentRow).getCell(0).toString());
			driver.findElement(By.id("password")).sendKeys(sheet.getRow(currentRow).getCell(1).toString());
			driver.findElement(By.id("login-button")).click();
			
			Thread.sleep(3000);

		}

	}

}
