package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		
		File file=new File("./data/input.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("sheet2");
		
		Row row = sh.getRow(0);
		
		//Cell c = row.getCell(0);
		
		//System.out.println(c.getStringCellValue());
		
		int rowCount = sh.getLastRowNum();
		
		//System.out.println(rowCount);
		
		int colCount=row.getLastCellNum();
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				System.out.print(sh.getRow(i).getCell(j).getStringCellValue());
				System.out.print("\t");
			}
			System.out.println();
		}
		
		wb.close();
		fis.close();
		
		//String s =getData(path, sheetname, rn, cn)
		
	}
	
	public static String getData(String path,String sheetname,int rn, int cn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(path));
			 Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			rn=sh.getLastRowNum();
			System.out.println(rn);
			cn=sh.getRow(rn).getLastCellNum();
			System.out.println(rn);
			String data = sh.getRow(rn).getCell(cn).toString();
			System.out.println(data);
			return data;
		}
		catch(Exception e)
		{
			return "";
		}
	}
}
