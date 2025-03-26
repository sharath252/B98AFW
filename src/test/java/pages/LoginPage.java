package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id = "input-username")
	private WebElement unTB;

	@FindBy(id = "input-password")
	private WebElement pwTB;

	@FindBy(name = "login-button")
	private WebElement goButton;

	@FindBy(xpath = "//div[@class='error']")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String un) {
		unTB.sendKeys(un);
	}

	public void setpassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickGoButton() {
		goButton.click();
	}

	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("errMsg is Dislpayed:" + errMsg.getText(), true);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("errMsg is not displayed", true);
			return false;
		}

	}

}
