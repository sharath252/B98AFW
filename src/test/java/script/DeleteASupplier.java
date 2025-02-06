package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;
import pages.SupplierPage;

public class DeleteASupplier extends BaseTest {
	
	@Test(priority = 6, groups= {"smoke","SupplierPage"})
	public void testDeleteASupplier() 
	{
		String un = Utility.getExcelData(XL_PATH, "DeleteASupplier",1,0);
		String pw = Utility.getExcelData(XL_PATH, "DeleteASupplier",1,1);
		
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
		
//		5. select parle checkBox
		test.info("select parle checkBox");
		SupplierPage supplierpage=new SupplierPage(driver);
		supplierpage.selectParleCheckBox();
		
//		6. delete selected Supplier
		test.info("delete selected Supplier");
		supplierpage.deleteSupplier(driver);
		
//		6. verify selected Supplier is deleted
		test.info("verify: selected Supplier is deleted");
		boolean result = supplierpage.verifySupplierParleIsCreated(wait);
		Assert.assertTrue(result);
		
		
		
	}

}
