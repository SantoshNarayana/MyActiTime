package com.actitime.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrack;
import com.actitime.pages.LoginPage;

@Listeners(com.actitime.generic.ListenersTest.class)
public class LoginTest extends BaseTest
{
	// creating the instance of the POM
	@Test
	public void loginTest() throws InterruptedException
	{
		//String UserName = "admin";
		//String pwd = "manager";
		
		// to get the class name
		String TSID=getClass().getSimpleName();
		
		String UserName= ExcelData.getDataCol(LoginPageDS,"UserName",TSID);
		String pwd = ExcelData.getDataCol(LoginPageDS,"Password",TSID);		
		String etitle = ExcelData.getDataCol(LoginPageDS,"Title",TSID);		
		String BuildNo = ExcelData.getDataCol(LoginPageDS,"BuildNo",TSID);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrack et=new EnterTimeTrack(driver);
				
		//Getting the element from the getElemnt() and using generic method to enter the text
		WebElement userElement = lp.getElement("un");		
		GenericUtils.enterText(userElement, UserName);
		
		WebElement pwdElement = lp.getElement("pwd");
		GenericUtils.enterText(pwdElement, pwd);
		
		
		WebElement LoginBTn = lp.getElement("login");
		LoginBTn.click();
		
		
		
		//verifying the title page
		lp.verifyLoginTitle(etitle);
		
		GenericUtils.tinyWait();
				
		WebElement help = et.getElement("help");
		help.click();
		
		WebElement abtAtiTime = et.getElement("about");
		abtAtiTime.click();
		
//		GenericUtils.tinyWait();
		
		//verifying the build no
		et.verifyBuildNo(BuildNo);
		
//			String aBuildNo = et.getElement("build").getText();
//		//	Reporter.log("Build no is: "+aBuildNo+eBuildNo,true);
//			Assert.assertEquals(BuildNo, aBuildNo);
//			Reporter.log("Build no is: "+aBuildNo,true);
//		
	
		WebElement closePopUp = et.getElement("close");
		closePopUp.click();
		
		GenericUtils.tinyWait();
		
		WebElement lgoutElement = et.getElement("logout");
		lgoutElement.click();
				
	}
}
