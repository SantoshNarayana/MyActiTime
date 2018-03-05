package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadColumndata implements AutoConstant
{
	public static void main(String args[]) throws Exception
    {
				
		File file=new File(ipFilePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(LoginPageDS);
		Row row = sheet.getRow(0);
 
        int col_num = -1,row_num=-1;
 
        // to get the row no using testScript id 
        for(int j=0;j<=sheet.getLastRowNum();j++)
        {
        	//System.out.println(sheet.getRow(j).getCell(0).getStringCellValue());
        	if(sheet.getRow(j).getCell(0).getStringCellValue().equals("InvalidLoginTest"))
        	{
        		row_num=j;
        		break;
        	}
        }
        
        
        //to get the column number using column Name 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
                col_num = i;
        }
        		
        
        row = sheet.getRow(row_num);
        Cell cell = row.getCell(col_num);
        String value = cell.getStringCellValue();
        System.out.println("Value of the Excel Cell is - "+ value);
   }

}
