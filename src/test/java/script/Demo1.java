package script;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://pos.aksharatraining.in/pos/public/#");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("pointofsale");
		driver.findElement(By.name("login-button")).click();
		driver.findElement(By.xpath("//a[@title='Suppliers']")).click();
		driver.findElement(By.xpath("//button[@title='New Supplier']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("company_name_input")).sendKeys("parle");
		WebElement category = driver.findElement(By.name("category"));
		Select select=new Select(category);
		select.selectByIndex(1);
		driver.findElement(By.id("first_name")).sendKeys("Bhanu");
		driver.findElement(By.id("last_name")).sendKeys("Prakash");
		driver.findElement(By.id("submit")).click();
		WebElement toastMessage = driver.findElement(By.xpath("//span[@data-notify='message']"));
		System.out.println(toastMessage.getText());
		driver.quit();
		
		
		

	}

}
