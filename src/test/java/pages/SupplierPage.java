package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SupplierPage {
	
	//span[conatins(text(),'You have successfully added Supplier ']
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-user']")
	private WebElement newsuppliericon;
	
	@FindBy(id="company_name_input")	
	private WebElement companyName;
	
	@FindBy(name="category")
	private WebElement category;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	
	@FindBy(xpath="//span[@data-notify='message']")
	private WebElement toastMessage;
	
	@FindBy(xpath=" //input[@data-index='3']")
	private WebElement parleCheckBox;
	
	@FindBy(id="delete")
	private WebElement delete;
	
	
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
	public void selectCategory(String index)
	{
		Select select=new Select(category);
		select.selectByVisibleText(index);;
	}
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public boolean verifySupplierParleIsCreated(WebDriverWait wait)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(toastMessage));
			Reporter.log(toastMessage.getText(),true);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Supplier parle is not created",true);
			return false;
		}
	}
	
	public void selectParleCheckBox()
	{
		parleCheckBox.click();
	}
	
	public void deleteSupplier(WebDriver driver)
	{
		delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean verifySupplierParleIsDeleted(WebDriverWait wait)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(toastMessage));
			Reporter.log(toastMessage.getText(),true);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Supplier parle is not created",true);
			return false;
		}
	}
	
	public  boolean verifyElementsPresence(WebDriver driver, List<String> xpaths) {
        boolean allElementsPresent = true;
       
        for (String xpath : xpaths) {
            try {
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) {
                    System.out.println("Element found: " + xpath);
                } else {
                    System.out.println("Element not visible: " + xpath);
                    allElementsPresent = false;
                }
            } catch (Exception e) {
                System.out.println("Element not found: " + xpath);
                allElementsPresent = false;
            }
        }
        return allElementsPresent;
    }
}
