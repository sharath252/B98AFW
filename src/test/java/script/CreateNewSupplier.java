package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;
import pages.SupplierPage;

public class CreateNewSupplier extends BaseTest {
	
	@Test(priority = 5, groups= {"smoke","SupplierPage"})
	public void testCreateNewSupplier() 
	{
		String un = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,0);
		String pw = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,1);
		String CN = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,2);
		String FN = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,3);
		String LN = Utility.getExcelData(XL_PATH, "CreateNewSupplier",1,4);
		
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
		
//		5. click on NewSuppliers button
		test.info("click on Suppliers button");
		SupplierPage supplierpage=new SupplierPage(driver);
		supplierpage.clickNewSupplier();
		
//		6. verify: new Supplier is displayed 
//		supplierpage.verifyNewSupplierPageisDisplayed(wait);
		
//		7. enter  companyname: parle
		test.info("enter  companyname");
		supplierpage.setCompanyName(CN);
		
		
//		8. enter  FirstName: Bhanu
		test.info("enter  FirstName");
		supplierpage.setFirstName(FN);
		
//		9. enter  lastName: Prakash
		test.info("enter  lastName");
		supplierpage.setlastName(LN);
		
		
//		10. click on submit button
		test.info("click on submit button");
		supplierpage.clickSubmitButton();
		
//		11 verify: new Supplier parle is displayed 
		supplierpage.verifyNewSupplierPageisDisplayed(wait);
		
		
		
	}

}
