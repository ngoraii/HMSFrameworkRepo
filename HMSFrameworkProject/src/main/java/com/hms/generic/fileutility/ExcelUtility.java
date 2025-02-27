package com.hms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getExcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/HMSProjectTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		String data = sh.getRow(row).getCell(cell).toString();
		wb.close();
		return data;
		
	}
	public void writeToExcel(String sheet, int row, int cell, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testData/HMSProjectTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell cel = r.createCell(cell, CellType.STRING);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./testData/HMSProjectTestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
