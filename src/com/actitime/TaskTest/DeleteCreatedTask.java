package com.actitime.TaskTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.TaskPage;

public class DeleteCreatedTask extends BaseTest
{
	@Test
	public void deleteTask() throws InterruptedException
	{
	String TSID=getClass().getSimpleName();	
	
	TaskPage tp = new TaskPage(driver);
	
	GenericUtils.tinyWait();
	
	tp.getElement("task").click();
	
	String custName= ExcelData.getDataCol(TaskSheet,"CustomerName",TSID);

	tp.getElement("TaskSearch").sendKeys(custName);
	
	GenericUtils.tinyWait();
	
	String xp=tp.part1+custName+tp.part2;
	
	WebElement CreatedTaskName = driver.findElement(By.xpath(xp));
	
	GenericUtils.waitTillElementVisible(CreatedTaskName);
	
	CreatedTaskName.click();
	
	String openTask =ExcelData.getDataCol(TaskSheet,"NameOfTask",TSID);
	
	System.out.println(openTask);
	
	GenericUtils.tinyWait();
	
	driver.findElement(By.xpath(openTask)).click();
	
	GenericUtils.tinyWait();
	tp.getElement("open").click();
	
	GenericUtils.tinyWait();
	tp.getElement("complete").click();
	
	
	tp.getElement("action").click();
	GenericUtils.tinyWait();
	
	tp.getElement("delete").click();
	
	}
	


}
