package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//To verify the title
	public void verifyTitle(String etitle)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("Title is matching: "+etitle,true);
		}
		catch(Exception e)
		{
			String title=driver.getTitle();
			Reporter.log("Tile is not matching: "+title+true);
			Assert.fail();
		}
	}
	
	//To verify the Element
	public void verifyElement(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present: ",true);
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present: ",true);
			Assert.fail();
		}
	}
}
