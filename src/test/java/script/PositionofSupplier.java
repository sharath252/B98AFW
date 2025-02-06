package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;

public class PositionofSupplier extends BaseTest {
	
	@Test(priority = 3, groups= {"smoke","HomePage"})
	public void testPositionofSupplier() 
	{
		String un = Utility.getExcelData(XL_PATH, "PositionofSupplier",1,0);
		String pw = Utility.getExcelData(XL_PATH, "PositionofSupplier",1,1);
		
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
		
//		4. verification: Suppliers icon should be present as 4th icon
		test.info("verification: Suppliers icon should be present as 4th icon");
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.VerfiyPositionofSupplier(wait);
		Assert.assertTrue(result);
	}

}
