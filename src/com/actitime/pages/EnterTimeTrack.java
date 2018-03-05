package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class EnterTimeTrack extends BasePage
{
	
	//@FindBy (className="popup_menu_icon tips_icon")
	@FindBy (xpath="//div[@class='popup_menu_icon tips_icon']")
	private WebElement TipOff;
		
	@FindBy (xpath="//div[@class='popup_menu_icon tips_icon_light_on']")
	private WebElement TipOn;
		
	@FindBy (xpath="//span[contains(text(),'Me')]")
	private WebElement me;
	
	@FindBy (xpath="//span[contains(text(),'Dowd, Roy')]")
	private WebElement roy;
	
	public static String backToME = "Back to me";
	
	@FindBy (id="logoutLink")
	private WebElement logoutBTN;
	
	@FindBy (name = "pwd")
	private WebElement pwd;

	@FindBy (xpath="//a[.='About your actiTIME']")
	private WebElement abtAtiTime;
	
	@FindBy (xpath="//div[@class='popup_menu_button popup_menu_button_support']")
	private WebElement help;
	
	@FindBy (xpath="//span[contains(.,'build')]")
	private WebElement build;
	
	@FindBy (xpath="//div[@id='aboutPopupCloseButtonId']")
	private WebElement closePopUp;
	
	//@FindBy(xpath="//tr[@id='taskRow72']//td[4]//input")
	@FindBy(xpath="//input[@id='spent_72_0']")
	private WebElement firstRowField;
	
	@FindBy(xpath="//tr[@id='taskRow72']//td[4]//a")
	private WebElement firstRowCommentLink;
	
	@FindBy(xpath="//textarea[@id='editDescriptionPopupText']")
	private WebElement CommentBox;
	
	@FindBy(id="SubmitTTButton")
	private WebElement SubmitBTM;
		
	@FindBy(xpath="//a[@class='content tt']")
	private WebElement timeTrack;
	
	
		
	public EnterTimeTrack(WebDriver driver)
	 {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyBuildNo(String eBuildNo)
	{
		String aBuildNo = build.getText();
		Reporter.log("Build no is: "+aBuildNo,true);
		Assert.assertEquals(eBuildNo, aBuildNo);
	//	Reporter.log("Build no is: "+aBuildNo,true);
	}
	
	public WebElement getElement(String getEle)
	{
		WebElement e = null;
		
		if(getEle.equalsIgnoreCase("logout"))
		{
			return logoutBTN;
		}
		else if(getEle.equalsIgnoreCase("about"))
		{
			return abtAtiTime;
		}
		else if(getEle.equals("help"))
		{
			return help;
		}
		else if(getEle.equalsIgnoreCase("close"))
		{
			return closePopUp;
		}
		else if(getEle.equalsIgnoreCase("build"))
		{
			return build;
		}
		else if(getEle.equalsIgnoreCase("me"))
		{
			return me;
		}
		else if(getEle.equalsIgnoreCase("roy"))
		{
			return roy;
		}
		else if(getEle.equalsIgnoreCase("tipof"))
		{
			return TipOff;
		}
		else if(getEle.equalsIgnoreCase("tipon"))
		{
			return TipOn;
		}
		else if(getEle.equalsIgnoreCase("timeTrack"))
		{
			return timeTrack;
		}
		else if(getEle.equalsIgnoreCase("submit"))
		{
			return SubmitBTM;
		}
		else if(getEle.equalsIgnoreCase("firstrow"))
		{
			return firstRowField;
		}
		else if(getEle.equalsIgnoreCase("firstcommentlink"))
		{
			return firstRowCommentLink;
		}
		else if(getEle.equalsIgnoreCase("firstrow"))
		{
			return firstRowField;
		}
		return e;
	}

	
	
}
