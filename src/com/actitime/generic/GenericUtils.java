package com.actitime.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericUtils 
{
	static JavascriptExecutor jse= (JavascriptExecutor) BaseTest.driver;
	static WebDriverWait wait = new WebDriverWait(BaseTest.driver, 10);
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void selectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void clickElement(WebElement ele)
	{
	 ele.click();
	}
	
	public static void enterText(WebElement element,String text)
	{
		element.clear();
		element.sendKeys(text);
	}
	
	public static void mouseOver(WebElement we)
	{
		Actions actObj=new Actions(BaseTest.driver);
		actObj.moveToElement(we).build().perform();
	}
	
	public static void alertAcceptOrDismiss(String acceptOrDismiss)
	{
		
		Alert value = wait.until(ExpectedConditions.alertIsPresent());
		
		if(acceptOrDismiss.equalsIgnoreCase("accept"))
		{
			value.accept();
		}
		else if(acceptOrDismiss.equalsIgnoreCase("dismiss"))
		{
			value.dismiss();
		}
	}
	
	public static void waitForElement(WebElement element) 
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitAndClick(WebElement element) throws InterruptedException 
	{		
		tinyWait();
		element.click();
	}
	
	public static void waitTillPageLoad()
	{
	//	wait.until(ExpectedConditions.stalenessOf(element));
		wait.until(ExpectedConditions.visibilityOfAllElements(BaseTest.driver.findElements(By.xpath("//input"))));
		//wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}

	public static void waitTillElementVisible(WebElement element)
		{
	//	WebDriverWait wait = new WebDriverWait(BaseTest.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element is present",true);
		}
		
	public static void tinyWait() throws InterruptedException
		{
			Thread.sleep(1000);
		}
		
	public static WebElement dynamicXpathByText(String text)
	{
			String part1 = "//*[contains(text(),'";
			String part2 = "')]";
			String xpath = part1+text+part2;
			//return xpath;
			Reporter.log("dynamicXpathByText method -"+xpath);
		
			return BaseTest.driver.findElement(By.xpath(xpath));	
	}
	
	public static void elementPresent(WebElement ele)
	{
//		Boolean value = wait.until(ExpectedConditions.stalenessOf(ele));
		boolean value = wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		System.out.println(value);
	}
	
	public static void JSEXpathClick(String text)
	{
		String part1 = "//*[contains(text(),'";
		String part2 = "')]";
		String xpath = part1+text+part2;
		System.out.println(xpath);
		WebElement ele = BaseTest.driver.findElement(By.xpath(xpath));
		//System.out.println(ele);
		jse.executeScript("arguments[0].click()", ele);
	}
	
	public static void JSEWebElementClick(WebElement ele) 
	{
		jse.executeScript("arguments[0].click()", ele);
	}
	
//	public List<WebElement> getText(String xpath) throws Exception 
//	{
//	    return BaseTest.driver.findElements(By.xpath(xpath)).getText();
//	}
//
//	if(tool.getText("//\*[@id='contentText']//\*/table//\*/strong").contains("<yourtext>"))
//	{
//	    system.out.println("Your text is available in the particular xpath");
//	} else {
//	    system.out.println("Your text is not available in the particular xpath");
//	}

}
