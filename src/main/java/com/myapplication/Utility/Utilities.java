package com.myapplication.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String  generateTimeStamp() {
		SimpleDateFormat sdfTime = new SimpleDateFormat("MMddHHmmss");
	    Date now = new Date();
	    String strTime = sdfTime.format(now);
	    //System.out.println("Time: " + strTime);
	    return strTime;	
		
	}
	
	public static String generateEmailWithTimeStamp() {
		String generateEmail = "TestEmail_"+generateTimeStamp()+"@mail.com";
		return generateEmail;
	}
	
	public static String createTestPassword() {
		String generatedPwd = "Test@"+generateTimeStamp();
		return generatedPwd;
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\myapplication\\testdata\\TestDataMyApplication.xlsx");
		
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for (int i=0; i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				default:
					break;
				}
			}
		}
		return data;
	}
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationsreenShotLocation = System.getProperty("user.dir")+"\\Screenshots\\"+testName+"_"+getTimeStamp()+".png";
		
		try {
			FileHandler.copy(srcScreenShot, new File(destinationsreenShotLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationsreenShotLocation;
	}
	
	public static String getTestReportNameWithTimeStamp(){
        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);*/
		
        String reportName = "TestExecutionReport_" + getTimeStamp() + ".html";
        return reportName;
    }
	
	public static String getTimeStamp() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        return formattedTime;
	}
	
	
	
	
}
