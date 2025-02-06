package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;
import pages.SupplierPage;

public class VerifySupplierPage extends BaseTest{
	
	@Test(priority = 4, groups= {"smoke","Supplierpage"})
	public void testVerifySupplierPage() 
	{
		String un = Utility.getExcelData(XL_PATH, "VerifySupplierPage",1,0);
		String pw = Utility.getExcelData(XL_PATH, "VerifySupplierPage",1,1);
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
		
//		4. click on Suppliers button
		test.info("click on Suppliers button");
		HomePage homepage=new HomePage(driver);
		homepage.clickSuppliers();
		
//		5. verification: Application should navigate to Supplier Page
		test.info("verification: Application should navigate to Supplier Page");
		SupplierPage supplierpage=new SupplierPage(driver);
		boolean result = supplierpage.verifySupplierPageisDisplayed(wait);
		Assert.assertTrue(result);
		
	}

}
