package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class TaskPage extends BasePage
{
	public static String AddTask="Add New Task";
	public static String SelCust="- Select Customer -";
	public static String NewCust="- New Customer -";
	public static String NewTask="Create new tasks";
	public static String CreateTask="Create Tasks";
	public static String part1="//span[contains(text(),'";
	public static String part2="')]";
	
	@FindBy(xpath="//*[@class='statusCell']//div[@class='open' and contains(text(),'Open')]")
	private WebElement open;
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy(xpath="//div[@id='cpTreeBlock']//input[@placeholder='Start typing name ...']")
	private WebElement searchbox;

	@FindBy(id="createTasksPopup_newCustomer")
	private WebElement custName;
	
	@FindBy(id="createTasksPopup_newProject")
	private WebElement projName;
	
	//@FindBy(className="inputFieldWithPlaceholder")
	@FindBy(xpath="//div[@id='createTasksPopup_createTasksTableContainer']//tr[2]/td[1]/input[1]")
	private WebElement taskName;
	
	@FindBy(id="createTasksPopup_commitBtn")
	private WebElement createTask;
	
	@FindBy(xpath="//div[@class='item completedContainer']/*[contains(text(),'Completed')]")
	private WebElement completeBTN;
	
	@FindBy(xpath="//div[@class='edit_task_sliding_panel sliding_panel']//div[contains(text(),'ACTIONS')]")
	private WebElement actionBTN;
	
	@FindBy(xpath="//div[@class='edit_task_sliding_panel sliding_panel']//div[contains(text(),'Delete')]")
	private WebElement deleteBTN;
	
	public TaskPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getElement(String getEle)
	{
		WebElement e = null;
		
		if(getEle.equalsIgnoreCase("complete"))
		{
			return completeBTN;
		}
		else if(getEle.equalsIgnoreCase("delete"))
		{
			return deleteBTN;
		}
		else if(getEle.equalsIgnoreCase("task"))
		{
			return task;
		}
		else if(getEle.equalsIgnoreCase("open"))
		{
			return open;
		}
		else if(getEle.equalsIgnoreCase("action"))
		{
			return actionBTN;
		}
		else if(getEle.equals("TaskSearch"))
		{
			return searchbox;
		}
				
		else if(getEle.equals("custName"))
		{
			return custName;
		}
		else if(getEle.equals("projName"))
		{
			return projName;
		}
		else if(getEle.equals("taskName"))
		{
			return taskName;
		}
		else if(getEle.equals("createTask"))
		{
			return createTask;
		}
		
	return e;
	}
}
