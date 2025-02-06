package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority = 2, groups= {"login"})
	public void testInvalidLogin()
	{
		String un = Utility.getExcelData(XL_PATH, "InvalidLogin",1,0);
		String pw = Utility.getExcelData(XL_PATH, "InvalidLogin",1,1);
		
		test.info("Enter Invalid username");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername(un);
		
		test.info("Enter Invalid password");
		loginPage.setpassword(pw);
		
		test.info("Click Go Buttton");
		loginPage.clickGoButton();
		
		test.info("validation: errMsg is Displayed");
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);
		
		
	}

}
