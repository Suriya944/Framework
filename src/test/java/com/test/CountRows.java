package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRows {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\DELL\\eclipse-workspace\\FrameWorkClass\\excel\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				
				CellType type = cell.getCellType();
				
				switch (type) {
				case STRING:
					String value = cell.getStringCellValue();
					System.out.println(value);
					
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
					String format = dateFormat.format(dateCellValue);
					System.out.println(format);
					}else {
					double d = cell.getNumericCellValue();
				//	BigDecimal decimal = BigDecimal.valueOf(d);
					BigDecimal decimal = BigDecimal.valueOf(d);
					String num = decimal.toString();
					System.out.println(num);
					
					
					
					break;
					
					}

				default:
					break;
				}
				
			}
		}
			
		}
	}

