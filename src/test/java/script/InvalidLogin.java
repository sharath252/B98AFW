package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.LoginPage;

public class InvalidLogin extends BaseTest

{
	@Test(priority=2)
	public void testInvalidLogin()
	{
		
		String un=Utility.getExcelData(XL_PATH,"InvalidLogin",1,0);
		String pw=Utility.getExcelData(XL_PATH,"InvalidLogin",1,1);
		
		test.info("enter inValid Username");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername(un);
		
		test.info("enter inValid password");
		loginPage.setpassword(pw);
		
		test.info("click on GoButton");
		loginPage.clickGoButton();
		
		test.info("verify err msg is displayed");
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);	
	}
	
}
