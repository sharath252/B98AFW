package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SupplierPage {
	
	//span[conatins(text(),'You have successfully added Supplier ']
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-user']")
	private WebElement newsuppliericon;
	
	@FindBy(xpath="//label[text()='Company Name']")
	private WebElement companyName;
	
	@FindBy(xpath="//label[text()='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath="//label[text()='Last Name']")
	private WebElement lastName;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	
	@FindBy(xpath="//td[text()='Parle']")
	private WebElement parle;
	
	
	
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
	
	public void clickNewSupplier()
	{
		newsuppliericon.click();
	}
	
	public boolean verifyNewSupplierPageisDisplayed(WebDriverWait wait)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(companyName));
			Reporter.log("Appilcation is in NewSupplier Page",true);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Appilcation is not in NewSupplier Page",true);
			return false;
		}
	}
	public void setCompanyName(String CN)
	{
		companyName.sendKeys(CN);
	}
	
	public void setFirstName(String FN)
	{
		firstName.sendKeys(FN);
	}
	
	public void setlastName(String LN)
	{
		lastName.sendKeys(LN);	
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public boolean verifySupplierParleIsCreated(WebDriverWait wait)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(parle));
			Reporter.log("Supplier parle is created",true);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Supplier parle is created",true);
			return false;
		}
	}
}
