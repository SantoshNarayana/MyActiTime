package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;


public class ExcelData implements AutoConstant
{
	public static String getData(String path,String sheetname,int rn, int cn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(path));
			 Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			//rn=sh.getLastRowNum();
			//System.out.println(rn);
			//cn=sh.getRow(rn).getLastCellNum();
			//System.out.println(rn);
			String data = sh.getRow(rn).getCell(cn).toString();
			//System.out.println(data);
			return data;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
//	to get the cell data with column name, TestScript id and the SheetName.
	public static String getDataCol(String SheetName,String ColumnName,String TSID)
    {
		
		try {
			File file=new File(ipFilePath);
			FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
        Row row = sheet.getRow(0);
 
        int col_num = -1,row_num=-1;
 
        //to get the column number using column Name 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(ColumnName))
                col_num = i;
        }
       // to get the row no using testScript id 
        for(int j=0;j<=sheet.getLastRowNum();j++)
        {
        	//System.out.println(sheet.getRow(j).getCell(0).getStringCellValue());
        	if(sheet.getRow(j).getCell(0).getStringCellValue().equals(TSID))
        	{
        		row_num=j;
        		break;
        	}
        		
        }
        row = sheet.getRow(row_num);
        Cell cell = row.getCell(col_num);
        String value = cell.getStringCellValue();
        return value;
		} 
		catch (Exception e) 
		{
			Reporter.log("no data to retrive from excel file");
		}
 return "";
       
      //  System.out.println("Value of the Excel Cell is - "+ value);
   }
	
}
