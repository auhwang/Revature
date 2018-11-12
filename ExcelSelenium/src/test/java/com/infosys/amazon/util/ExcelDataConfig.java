package com.infosys.amazon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	File excelFile;
	public ExcelDataConfig(String path) {
		try {
			excelFile = new File(path);
			FileInputStream fis = new FileInputStream(excelFile);
			wb = new XSSFWorkbook(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetInd, int row, int col) {
		sheet = wb.getSheetAt(sheetInd);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public void putData(int sheetInd, int row, int col, String val) {
		sheet = wb.getSheetAt(sheetInd);
		sheet.getRow(row).createCell(col).setCellValue(val);
	}
	
	public void writeData() {
		try {
			FileOutputStream fos = new FileOutputStream(excelFile);
			wb.write(fos);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getRowCount(int sheetInd) {
		return wb.getSheetAt(sheetInd).getLastRowNum() + 1;
	}
	
	public void closeWB() {
		try {
			wb.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
