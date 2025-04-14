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


public class VerfiyAllIconsOfTabularColumn extends BaseTest {
	
	@Test
	public void testVerfiyAllIconsOfTabularColumn() {
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
		
//		4.click on supplier icon
		HomePage homePage=new HomePage(driver);
		test.info("click on supplier ICon");
		homePage.clickSuppliers();
		
		String id = "//div[text()='ID']";
		String companyName="//div[text()='Company Name']";
		String agencyName="//div[text()='Agency Name']";
		String category="//div[text()='Category']";
		String lastName="//div[text()='Last Name']";
		String firstName="//div[text()='First Name']";
		String eMail="//div[text()='Email']";
		String phoneNumber="//div[text()='Phone Number']";
		
		List<String> xpaths=new ArrayList<String>();
		xpaths.add(id);
		xpaths.add(companyName);
		xpaths.add(agencyName);
		xpaths.add(category);
		xpaths.add(lastName);
		xpaths.add(firstName);
		xpaths.add(firstName);
		xpaths.add(eMail);
		xpaths.add(phoneNumber);
		System.out.println(xpaths);
		
//		5.verify all the elements present in Supplier page
		SupplierPage supplierPage=new SupplierPage(driver);
		test.info("verify Elements in the Supplier page");
		boolean result = supplierPage.verifyElementsPresence(driver, xpaths);
		Assert.assertTrue(result);
	}
	
	

}
