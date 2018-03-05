package com.actitime.ReportsTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrack;
import com.actitime.pages.ReportPage;

public class ExtractMonthlyPerformanceCSV extends BaseTest
{
	@Test
	public void extractToCSV() throws AWTException, InterruptedException
	{
		ReportPage rp=new ReportPage(driver);
		EnterTimeTrack ett = new EnterTimeTrack(driver);
		
		String TSID=getClass().getSimpleName();	
		
		GenericUtils.tinyWait();
		
		ett.getElement("timeTrack").click();
		
		String time= ExcelData.getDataCol(ReportSheet,"Time",TSID);
		
		System.out.println("Testing :"+time);
		
		GenericUtils.enterText(ett.getElement("firstrow"), time);
		
		ett.getElement("submit").click();
		
		GenericUtils.tinyWait();
		
		rp.getElement("reports").click();
		
		GenericUtils.tinyWait();
	
		rp.getElement("perf").click();
		
		GenericUtils.tinyWait();
		
		GenericUtils.dynamicXpathByText(rp.PreMnth).click();
		
		GenericUtils.tinyWait();
		
		GenericUtils.dynamicXpathByText(rp.currentMnth).click();
		
		//rp.getElement("CurrentMonth").click();
		
		rp.getElement("csv").click();
		
		GenericUtils.tinyWait();
				
	Robot r = new Robot();
	
	r.keyPress(KeyEvent.VK_ALT);
	r.keyPress(KeyEvent.VK_S);
	r.keyRelease(KeyEvent.VK_S);
	r.keyRelease(KeyEvent.VK_ALT);	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
}
