package script;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.IAutoConst;
import generic.Utility;

public class Demo2 implements IAutoConst {

	public static void main(String[] args) {
		String url = Utility.getProperty(CONFIG_PATH, "APPURL");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("input-username")).sendKeys("admin");
		driver.findElement(By.id("input-password")).sendKeys("pointofsale");
		driver.findElement(By.name("login-button")).click();
		
		driver.findElement(By.xpath(" //a[text()='Suppliers']" )).click();
		driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
		
		
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
		
		
		System.out.println(xpaths);
		
//		public static boolean verifyElementsPresence(WebDriver driver, List<String> xpaths) {
//	        boolean allElementsPresent = true;
//	       
	        for (String xpath : xpaths) {
	            try {
	                WebElement element = driver.findElement(By.xpath(xpath));
	                if (element.isDisplayed()) {
	                    System.out.println("Element found: " + xpath);
	                } else {
	                    System.out.println("Element not visible: " + xpath);
//	                    allElementsPresent = false;
	                }
	            } catch (Exception e) {
	                System.out.println("Element not found: " + xpath);
//	                allElementsPresent = false;
	            }
	        }
	        driver.quit();
//	        return allElementsPresent;
	    }
	}

//}
