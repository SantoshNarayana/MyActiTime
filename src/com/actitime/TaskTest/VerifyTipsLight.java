package com.actitime.TaskTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrack;

public class VerifyTipsLight extends BaseTest
{

	@Test
	public void verifyTips() throws InterruptedException
	{
		EnterTimeTrack et = new EnterTimeTrack(driver);
		
		GenericUtils.tinyWait();
		WebElement tipOff = et.getElement("tipof");
		
		GenericUtils.elementPresent(tipOff);
		tipOff.click();

		GenericUtils.tinyWait();
		WebElement tipOn = et.getElement("tipon");
		
		GenericUtils.elementPresent(tipOn);
		tipOn.click();
		GenericUtils.waitTillElementVisible(et.getElement("tipof"));
		
	}
	
}
