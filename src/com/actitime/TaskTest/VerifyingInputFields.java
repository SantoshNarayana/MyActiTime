package com.actitime.TaskTest;

import org.testng.annotations.Test;
import com.actitime.pages.EnterTimeTrack;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;

public class VerifyingInputFields extends BaseTest
{
	@Test
	public void verifyfields() throws InterruptedException
	{
		EnterTimeTrack ett=new EnterTimeTrack(driver);
		
		String TSID=getClass().getSimpleName();
		
		GenericUtils.tinyWait();
		
		String letters = ExcelData.getDataCol(ETTSheet, "Charaters", TSID);
		ett.getElement("firstrow").sendKeys(letters);
	}

}
