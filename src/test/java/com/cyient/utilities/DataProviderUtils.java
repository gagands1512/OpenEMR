package com.cyient.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	/*
	 * FileInputStream file = new
	 * FileInputStream("src/test/resources/testdata/Book1.xlsx");
	 * 
	 * XSSFWorkbook book = new XSSFWorkbook(file); XSSFSheet sheet =
	 * book.getSheet("validCredentialTest");
	 * 
	 * Object [][] main = new Object[3][4];
	 * 
	 * for(int i=0;i<3;i++) { for(int j=0;j<4;j++) { XSSFRow row = sheet.getRow(i);
	 * XSSFCell cell = row.getCell(j); DataFormatter format = new DataFormatter();
	 * 
	 * main[i][j] = format.formatCellValue(cell); } System.out.println(); } }
	 */
	
	
	@DataProvider
	public Object[][] validCredentialData() throws IOException{
		
		FileInputStream file = new FileInputStream("src/test/resources/testdata/Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("validCredentialTest");
		Object[][] main = new Object[2][4];
		
		for(int i=1;i<3;i++) {
			for(int j=0;j<4;j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				
				main[i-1][j] = format.formatCellValue(cell);
			}
		}
		
	/*	main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="English (Indian)";
		main[1][3]="OpenEMR";
		
		main[2][0]="accountant";
		main[2][1]="accountant";
		main[2][2]="English (Indian)";
		main[2][3]="OpenEMR";*/
		
		return main;
	}
	
	@DataProvider
	public Object [][] invalidCredentialData(){
		Object[][] main = new Object[2][4];
		
		main[0][0]="john";
		main[0][1]="john123";
		main[0][2]="Dutch";
		main[0][3]="Invalid username or password";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		main[1][2]="German";
		main[1][3]="Invalid username or password";
		
		return main;
	}
	
	@DataProvider
	public Object[][] validCredentialExcelData() throws IOException{
		Object[][] main = ExcelUtils.sheetIntObjectArray("src/test/resources/testdata/Book1.xlsx","validCredentialTest");
		return main;
	}

}
