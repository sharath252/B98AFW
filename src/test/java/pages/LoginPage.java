package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="input-username")
	private WebElement unTB;
	
	@FindBy(id="input-password")
	private WebElement pwTB;
	
	@FindBy(name="login-button")
	private WebElement goButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setpassword(String pw)
	{
		unTB.sendKeys(pw);
	}
	
	public void clickGoButton()
	{
		goButton.click();
	}

}
