package script;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://pos.aksharatraining.in/pos/public/#");
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("pointofsale");
		driver.findElement(By.name("login-button")).click();
		driver.findElement(By.xpath("//a[@title='Suppliers']")).click();
		driver.findElement(By.xpath("//button[@title='New Supplier']")).click();
		Set<String> allWH = driver.getWindowHandles();
		System.out.println(allWH.size());
		System.out.println(allWH);
		
		

	}

}
