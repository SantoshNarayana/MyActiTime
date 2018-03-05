package com.actitime.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test()
	public void invalidLoginTest()
	{
		// to get the class name
		String TSID=getClass().getSimpleName();				
		
		LoginPage lp = new LoginPage(driver);
		
		//System.out.println(UserName + pwd);
		
		String UserName= ExcelData.getDataCol(LoginPageDS,"UserName",TSID);
		WebElement userElement = lp.getElement("un");		
		GenericUtils.enterText(userElement, UserName);
		
		String pwd = ExcelData.getDataCol(LoginPageDS,"Password",TSID);	
		WebElement pwdElement = lp.getElement("pwd");
		GenericUtils.enterText(pwdElement, pwd);
		
		WebElement LoginBTn = lp.getElement("login");
		LoginBTn.click();
		
		String errmsg= ExcelData.getDataCol(LoginPageDS,"ErrorMsg",TSID);
		lp.verifyErrMsg(errmsg);
		
				
	}

}
