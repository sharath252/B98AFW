package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SupplierPage {
	
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-user']")
	private WebElement newsuppliericon;
	
	public SupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySupplierPageisDisplayed(WebDriverWait wait)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(newsuppliericon));
			Reporter.log("Appilcation is in Supplier Page",true);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Appilcation is not in Supplier Page",true);
			return false;
		}
	}
	
}
