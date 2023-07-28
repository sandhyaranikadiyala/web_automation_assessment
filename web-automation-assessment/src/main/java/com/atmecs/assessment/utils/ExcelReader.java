package com.atmecs.assessment.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static Object[][] readExcelData(String filePath, String sheetName) {
		Object[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new Object[rowCount][columnCount];
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i + 1);
				for (int j = 0; j < columnCount; j++) {
					Cell cell = row.getCell(j);
					data[i][j] = cell.toString();
				}
			}
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
