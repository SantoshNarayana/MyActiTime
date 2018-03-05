package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	@FindBy (id="username")
	private WebElement UnName;
	
	@FindBy (name = "pwd")
	private WebElement pwd;

	@FindBy (xpath="//div[.='Login ']")
	private WebElement LoginBTn;
	
	@FindBy (xpath="//span[contains(.,'invalid')]")
	private WebElement errMSg;
	
	public LoginPage (WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyErrMsg(String eMsg)
	{
		String aMSg = errMSg.getText();
		Assert.assertEquals(eMsg, aMSg);
		Reporter.log("Error msg is: "+eMsg,true);
	}
	
	public void verifyVersion(String eVersion)
	{
		String aVersion = errMSg.getText();
		Assert.assertEquals(eVersion, aVersion);
		Reporter.log("version no is: "+eVersion,true);
	}
	
	public void verifyLoginTitle(String etitle)
	{
		verifyTitle(etitle);
	}
	
	public WebElement getElement(String getEle)
	{
		WebElement e = null;
		
		if(getEle.equals("un"))
		{
			return UnName;
		}
		else if(getEle.equals("pwd"))
		{
			return pwd;
		}
		else if(getEle.equals("login"))
		{
			return LoginBTn;
		}
		else if(getEle.equals("msg"))
		{
			return errMSg;
		}
		else if(getEle.equals("pwd"))
		{
			return pwd;
		}
		
		return e;
	}
	
	public void enterusername()
	{
	
	}

}
