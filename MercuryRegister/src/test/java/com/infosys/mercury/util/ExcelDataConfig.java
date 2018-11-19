package com.infosys.mercury.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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
	
	public String getStringData(int sheetInd, int row, int col) {
		sheet = wb.getSheetAt(sheetInd);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	
	public int getIntData(int sheetInd, int row, int col) {
		sheet = wb.getSheetAt(sheetInd);
		return (int)sheet.getRow(row).getCell(col).getNumericCellValue();
	}
	
	public String getIntAsStringData(int sheetInd, int row, int col) {
		sheet = wb.getSheetAt(sheetInd);
		//used to convert cell from int to string
		DataFormatter objDefaultFormat = new DataFormatter();
		//get the cell value
		Cell cellValue = sheet.getRow(row).getCell(col);
		//convert
		String stringData = objDefaultFormat.formatCellValue(cellValue);
		return stringData;
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
	
	public int getColCount(int sheetInd,int rowInd) {
		return wb.getSheetAt(sheetInd).getRow(rowInd).getLastCellNum();
	}
	
	public void closeWB() {
		try {
			wb.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
