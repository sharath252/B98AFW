package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;
import pages.SupplierPage;

public class UpdateSupplierPopUp extends BaseTest {
	
	@Test
	public void testUpdateSupplierPopUp() {
		String un = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,0);
		String pw = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,1);
		
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
		
//		4.click on Suuplier icon in HomePage
		HomePage homePage=new HomePage(driver);
		test.info("click on Supplier button");
		homePage.clickSuppliers();
		
//		5.click on any update supplier icon
		SupplierPage supplierpage=new SupplierPage(driver);
		test.info("click on Update Supplier icon");
		supplierpage.clickUpdateSupplierIcon();
		
//		6.verify update Supplier page is displayed
		test.info("verfiy update supplier pop up is displayed");
		boolean result = supplierpage.verifyUpdateSuppilerIsDisplayed(wait);
		Assert.assertTrue(result);
	}

}
