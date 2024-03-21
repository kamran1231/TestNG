package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenEx1 {

	public static void main(String[] args) throws IOException {
		
		//Excel --> Workbook --> sheet --> row --> cell
		
		XSSFWorkbook excelWBook;
		XSSFSheet excelSheet;
		XSSFRow row;
		XSSFCell cell;
		
		//Create an object of file class to open file
		File excelFile = new File("C:\\Users\\khanb\\Downloads\\demonew.xlsx");
		
		//Create an object of fileInputStream to read data from file
		FileInputStream fi = new FileInputStream(excelFile);
		
		//Create object of XSSFWorkbook to handle xlsx file
		excelWBook = new XSSFWorkbook(fi);
		
		//to access workbook sheet
		excelSheet = excelWBook.getSheetAt(0);
		
		//get total row count
		int total_rows = excelSheet.getLastRowNum() + 1;
		
		//get total no. of cells in a row
		int total_cells = excelSheet.getRow(0).getLastCellNum();
		
		for(int currentRow=0;currentRow<total_rows;currentRow++) {
			
			for(int currentcol=0;currentcol<total_cells;currentcol++) {
				
				System.out.print(excelSheet.getRow(currentRow).getCell(currentcol).toString());
				System.out.print("\t");
			}	
			
			System.out.println("  ");
			excelWBook.close();
		}
		
		
	}
	
	
}
