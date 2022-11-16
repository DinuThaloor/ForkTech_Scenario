package forktech.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author dinuh
 *
 */

public class ExcelUtility 
{
	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook=WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}

	public void insertDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook=WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream=new FileOutputStream(IConstants.excelPath);
		workbook.write(fileOutputStream);
	}

}
