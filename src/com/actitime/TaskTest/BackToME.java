package com.actitime.TaskTest;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrack;

public class BackToME extends BaseTest
{
	@Test()
	public void BackToMe() throws InterruptedException
	{
	EnterTimeTrack et = new EnterTimeTrack(driver);
	
	GenericUtils.tinyWait();
	
	GenericUtils.waitAndClick(et.getElement("me"));	

	//GenericUtils.JSEWbElmentClick(et.getElement("me"));;
	
	GenericUtils.tinyWait();
	
	et.getElement("roy").click();
	
	GenericUtils.tinyWait();
	
	GenericUtils.dynamicXpathByText(et.backToME).click();;
	
	}

}
