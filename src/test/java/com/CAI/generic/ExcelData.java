package com.CAI.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.STRadarStyleImpl;

public class ExcelData
{
	public static XSSFWorkbook wb;
	public static  FileInputStream fi;
	public static XSSFSheet sheet;
	
	//Method used to read the data from the excel file.
public static String getData(String path,int rowno,int columnno) throws IOException 
{
	fi = new FileInputStream(path);
	wb = new XSSFWorkbook(fi);
	Cell cell = wb.getSheet("sheet1").getRow(rowno).getCell(columnno);
	DataFormatter  df = new DataFormatter();
	String data = df.formatCellValue(cell);
	return data;
	
}
	//Method used to get the row size
public static int getRowSize(String path) throws IOException
{
	fi = new FileInputStream(path); 
	wb = new XSSFWorkbook(fi);
	int rowsize = wb.getSheet("sheet1").getLastRowNum();
	return rowsize;
	
}

	//Method used to get the column size
public static int columnSize(String path,int rowno) throws Exception
{
	fi = new FileInputStream(path); 
	wb = new XSSFWorkbook(fi);
	int colsize = wb.getSheet("sheet1").getRow(rowno).getLastCellNum();
	return colsize;

}

}
