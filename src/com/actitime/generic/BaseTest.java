package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.actitime.tests.LoginTest;

public abstract class BaseTest implements AutoConstant
{
	public static WebDriver driver ;
	
	@BeforeSuite
	public void OpenDBConnection()
	{
		Reporter.log("open connection",true);
	}
	
	@AfterSuite
	public void CloseDBConnection()
	{
		Reporter.log("open connection",true);
	}
	
	@BeforeTest
	public void preConditions()
	{
		System.setProperty(gecko_key, gecko_value);
		System.setProperty(chrome_key, chrome_value);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
		
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
	}
	
	@AfterTest
	public void postCondition()
	{
		driver.close();
	}
	
}
