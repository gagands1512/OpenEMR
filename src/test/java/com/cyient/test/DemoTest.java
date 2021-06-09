package com.cyient.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("src/test/resources/testdata/Book1.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("validCredentialTest");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] main = new Object[rowCount-1][cellCount];
		
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				
				main[i][j] = format.formatCellValue(cell);
			}
			System.out.println();
			}
		}
		

		

}
