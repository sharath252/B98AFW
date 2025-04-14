package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[@title='Customers']/../../li[4]")
	private WebElement supplierIcon;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(logoutLink));
			Reporter.log("Homepage is Dislpayed",true);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Homepage is NotDislpayed",true);
			return false;
		}
	}
	
	public boolean VerfiyPositionofSupplier(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(supplierIcon));
			Reporter.log("Suppliers icon is present as 4th icon",true);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("HSuppliers icon is present as 4th icon",true);
			return false;
		}
		
	}
	
	public void clickSuppliers()
	{
		supplierIcon.click();
	}
	
	public boolean VerifyAllIconsOfHomePage(WebDriver driver, List<String> xpaths) {
		boolean allElementsPresent = true;
		for(String xpath:xpaths)
		{
			try
			{
				WebElement element = driver.findElement(By.xpath(xpath));
				if(element.isDisplayed())
				{
					System.out.println("Element is found: "+xpath);
				}
				else
				{
					System.out.println("Element not  found: "+xpath);
					allElementsPresent = false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Element not  found: "+xpath);
				allElementsPresent = false;
			}
		}
		return allElementsPresent;
	}
}
