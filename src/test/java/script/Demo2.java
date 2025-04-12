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
