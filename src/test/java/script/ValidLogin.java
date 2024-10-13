package script;

import org.testng.Assert;
import org.testng.annotations.Test;


import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;

public class ValidLogin extends BaseTest 
{

	@Test(priority = 1)
	public void testValidLogin() 
	{
		String un = Utility.getExcelData(XL_PATH, "ValidLogin",1,0);
		String pw = Utility.getExcelData(XL_PATH, "ValidLogin",1,1);
//		1. enter valid username: admin
		test.info("enter valid username");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUsername(un);
		
//		2. enter valid password: pointofsale
		test.info("enter valid password");
		loginPage.setpassword(pw);
		
//		3. click on go button
		test.info("click on go button");
		loginPage.clickGoButton();
		
//		4. verification: Home page should be displayed
		test.info("verification: Home page should be displayed");
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyHomePageIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
