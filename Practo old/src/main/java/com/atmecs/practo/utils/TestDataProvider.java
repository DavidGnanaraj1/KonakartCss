package com.atmecs.practo.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class TestDataProvider {

    String path;

	@DataProvider(name = "login")
	public Object[][] testData() throws IOException
	{
			ExcelFileReader readExcel = new ExcelFileReader(com.atmecs.practo.helpers.FilePath.TESTDATA_FILE);
			int sheetIndex = 0;
			
			int rowNum = readExcel.rowCounting(sheetIndex);
			int colNum = readExcel.columnCounting(sheetIndex);

		

			Object[][] details = new Object[rowNum][colNum];

			for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
				for (int colIndex = 0; colIndex < colNum; colIndex++) {

					details[rowIndex][colIndex] = readExcel.getData(sheetIndex, rowIndex + 1, colIndex);
				}
			}
			return details;
		}
	
}


