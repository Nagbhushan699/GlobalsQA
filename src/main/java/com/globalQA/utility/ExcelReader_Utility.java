package com.globalQA.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_Utility {
	File file;
	XSSFWorkbook xb;
	XSSFSheet sheet;
	public ExcelReader_Utility(String path,String name) throws InvalidFormatException, IOException {
		file=new File(path);
		xb=new XSSFWorkbook(file);
		sheet=xb.getSheet(name);
	}
	public int getRowCount() {
		return sheet.getLastRowNum();
	}
	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	public Object[][] getAllData1()
	{  
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[rowCount-1][this.getColumnCount()];

		for (int i = 1; i < rowCount; i++) {
			Row row1=sheet.getRow(i);
			for (int j = 0; j <colCount; j++) {
				switch(row1.getCell(j).getCellType()) {
				case NUMERIC:
					double d1=row1.getCell(j).getNumericCellValue();
					int value = (int)Math.round(d1);
					obj[i-1][j]=value;
					break;
				case STRING:obj[i-1][j]=row1.getCell(j).getStringCellValue();
				break;
				}
			}
		}

		return obj;
	}
	public Object[][] getAllData()
	{  
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[rowCount-1][this.getColumnCount()];

		for (int i = 1; i < rowCount; i++) {
			Row row1=sheet.getRow(i);
			for (int j = 0; j <colCount; j++) {
				obj[i-1][j]=row1.getCell(j).getStringCellValue();
			}
		}

		return obj;
	}
}
