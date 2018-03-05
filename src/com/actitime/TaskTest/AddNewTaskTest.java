package com.actitime.TaskTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.TaskPage;

public class AddNewTaskTest extends BaseTest
{
	@Test
	public void addNewTask() throws InterruptedException
	{
		String TSID=getClass().getSimpleName();	
		
		TaskPage tp = new TaskPage(driver);
		
		GenericUtils.tinyWait();
		
		tp.getElement("task").click();
		
		GenericUtils.dynamicXpathByText(tp.AddTask).click();
		
	GenericUtils.dynamicXpathByText(tp.NewTask).click();
		
		GenericUtils.tinyWait();
		
		GenericUtils.dynamicXpathByText(tp.SelCust).click();

		GenericUtils.dynamicXpathByText(tp.NewCust).click();
		
		String custName= ExcelData.getDataCol(TaskSheet,"CustomerName",TSID);

		tp.getElement("custName").sendKeys(custName);

		String projName= ExcelData.getDataCol(TaskSheet,"ProjectName",TSID);

		tp.getElement("projName").sendKeys(projName);

		String taskName= ExcelData.getDataCol(TaskSheet,"TaskName",TSID);

		tp.getElement("taskName").sendKeys(taskName);
		
		tp.getElement("createTask").click();
		GenericUtils.dynamicXpathByText(tp.CreateTask).click();
		
		tp.getElement("TaskSearch").sendKeys(custName);
				
		GenericUtils.tinyWait();
		
		String xp=tp.part1+custName+tp.part2;
		
		WebElement CreatedTaskName = driver.findElement(By.xpath(xp));
		
		GenericUtils.waitTillElementVisible(CreatedTaskName);
		
//		CreatedTaskName.click();
//		
//		String openTask =ExcelData.getDataCol(ETTSheet,"NameOfTask",TSID);
//		
//		GenericUtils.tinyWait();
//		
//		driver.findElement(By.xpath(openTask)).click();
//		
//		GenericUtils.tinyWait();
//		tp.getElement("open").click();
//		
//		GenericUtils.tinyWait();
//		tp.getElement("complete").click();
//		
//		
//		tp.getElement("action").click();
//		GenericUtils.tinyWait();
//		
//		tp.getElement("delete").click();
//		
//				
	}

}
