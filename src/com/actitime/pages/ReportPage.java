package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class ReportPage extends BasePage
{
	public static String PreMnth="Previous month";
	public static String currentMnth="Current month";
	
	@FindBy(xpath="//a[@class='content reports']")
	private WebElement reports;
	
//	@FindBy(xpath="//a[@id='ext-gen424']//div[text()='Current month']")
	@FindBy(xpath="//a[@id='ext-gen424']/span")
	private WebElement CurrentMnt;
	
	@FindBy(xpath="//div[.='Monthly Team Performance']")
	private WebElement mnthlyPerf;
	
	@FindBy(xpath="//div[@class='reportPageFooter reportPageHeaderFooter']//td[@class='headerFooterCell clickableCell exportToCSV cellWithBorder']")
	private WebElement exportToCSV;
	
	public ReportPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getElement(String getEle)
	{
		WebElement e = null;
		
		if(getEle.equals("reports"))
		{
			return reports;
		}
		else if(getEle.equals("perf"))
		{
			return mnthlyPerf;
		}
		else if(getEle.equals("csv"))
		{
			return exportToCSV;
		}
		else if(getEle.equalsIgnoreCase("CurrentMonth"))
		{
			return CurrentMnt;
		}
		
	return e;
	}
		
}
