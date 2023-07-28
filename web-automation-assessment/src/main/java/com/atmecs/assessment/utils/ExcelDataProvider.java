package com.atmecs.assessment.utils;

import com.atmecs.assessment.constants.Constants;

public class ExcelDataProvider {
	ExcelReader excelReader = new ExcelReader();

	static Object[][] testData = ExcelReader.readExcelData(Constants.filepath, "TestData");
	public static final String URL = (String) testData[0][0];
	public static final String USERNAME = (String) testData[0][1];
	public static final String PASSWORD = (String) testData[0][2];

}
