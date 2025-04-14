package script;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;
import pages.SupplierPage;

public class VerifyFieldsDisplayedInUpdateSupplier extends BaseTest{
	
	@Test
	public void testVerifyFieldsDisplayedInUpdateSupplier() {
		
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
		
//		6.Verify All the Fields are displayed 
		String companyName = "//label[text()='Company Name']";
		String category="//label[text()='Category']";
		String agencyName="//label[text()='Agency Name']";
		String firstName="//label[text()='First Name']";
		String lastName="//label[text()='Last Name']";
		String gender="//label[text()='Gender']";
		String eMail="//label[text()='Email']";
		String phoneNumber="//label[text()='Phone Number']";
		String address1="//label[text()='Address 1']";
		String address2="//label[text()='Address 2']";
		String city="//label[text()='City']";
		String state="//label[text()='State']";
		String postalCode="//label[text()='Postal Code']";
		String country="//label[text()='Country']";
		String Comments="//label[text()='Comments']";
		
		List<String> xpaths=new ArrayList<String>();
		xpaths.add(companyName);
		xpaths.add(agencyName);
		xpaths.add(category);
		xpaths.add(firstName);
		xpaths.add(lastName);
		xpaths.add(gender);
		xpaths.add(eMail);
		xpaths.add(phoneNumber);
		xpaths.add(address1);
		xpaths.add(address2);
		xpaths.add(city);
		xpaths.add(state);
		xpaths.add(postalCode);
		xpaths.add(country);
		xpaths.add(Comments);
		test.info("Verify all the Fiedls are dsiplayed in update Supplier pop up");
		boolean result = supplierpage.verifyFieldsDisplayedInUpdateSupplier(driver, xpaths);
		Assert.assertTrue(result);
	}

}
