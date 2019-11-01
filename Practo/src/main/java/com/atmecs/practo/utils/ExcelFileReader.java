package com.atmecs.practo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileReader {
	
		XSSFWorkbook workbook;
		 XSSFSheet sheet1;
		 File file;
		 String path;

		public ExcelFileReader(String filePath) throws IOException
		{
				File file = new File(filePath);
				FileInputStream fileInput = new FileInputStream(file);
				
				workbook = new XSSFWorkbook(fileInput);
		}
		public  String getData(int index, int rowNum, int cellNum) 
		{
			sheet1 = workbook.getSheetAt(index);
			String data = sheet1.getRow(rowNum).getCell(cellNum).getStringCellValue();

			return data;
		}
		public int rowCounting(int sheet)
		{
			int rowCount = workbook.getSheetAt(sheet).getLastRowNum();
			//System.out.println(" Row Count  is: " + rowCount);
			return rowCount;
		}
		public int columnCounting(int sheetIndex) 
		{
			int colCount = workbook.getSheetAt(sheetIndex).getRow(1).getLastCellNum();
             //System.out.println("Column count is:"+ colCount);
			return colCount;
		}
		public  String getExcelData(int sheet,int rownum,int colnum) {
			int i;
			
			String[]array=new String[30];
			for(i=rownum;i<array.length;i++) {
			 array[i-1] =getData(sheet,i,colnum);
		
			}
			return array[i-1];
		}

		
		public static void main(String[] args) throws IOException 
		
		{
			ExcelFileReader readexcel = new ExcelFileReader(com.atmecs.practo.helpers.FilePath.TESTDATA_FILE);
			readexcel.rowCounting(0);
			readexcel.columnCounting(0);

		}

	
}


