package script;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import pages.HomePage;
import pages.LoginPage;

public class VerfiyAllIconsInHomePage extends BaseTest {
	
	@Test(priority = 3)
	public void testVerfiyAllIconsInHomePage() {
		
		String un = Utility.getExcelData(XL_PATH, "VerfiyAllIconOfHomepage",1,0);
		String pw = Utility.getExcelData(XL_PATH, "VerfiyAllIconOfHomepage",1,1);
		
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
		
		String customers = "//a[text()='Customers']";
		String items="//a[text()='Items']";
		String itemsKit="//a[text()='Item Kits']";
		String suppliers="//a[text()='Suppliers']";
		String reports="//a[text()='Reports']";
		String receivings="//a[text()='Receivings']";
		String sales="//a[text()='Sales']";
		String giftCards="//a[text()='Gift Cards']";
		String messages="//a[text()='Messages']";
		String expenses="//a[text()='Expenses']";
		String cashUps="//a[text()='Cashups']";
		String office="//a[text()='Office']";
		
		List<String> xpaths=new ArrayList<String>();
		xpaths.add(customers);
		xpaths.add(items);
		xpaths.add(itemsKit);
		xpaths.add(suppliers);
		xpaths.add(reports);
		xpaths.add(receivings);
		xpaths.add(sales);
		xpaths.add(giftCards);
		xpaths.add(messages);
		xpaths.add(expenses);
		xpaths.add(cashUps);
		xpaths.add(office);
		System.out.println(xpaths);
		
//		4.verify all the Icons presnt in Homepage
		HomePage homepage=new HomePage(driver);
		test.info("Verify All The Icons present in Homepage");
		boolean result = homepage.VerifyAllIconsOfHomePage(driver, xpaths);
		Assert.assertTrue(result);
		
	}

}
