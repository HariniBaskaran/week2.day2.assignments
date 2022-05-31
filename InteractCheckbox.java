package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']//following-sibling::input[@type='checkbox'][1]")).click();
		
		//Confirm Selenium is checked
		if(driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following-sibling::input[@type='checkbox']")).getAttribute("checked")=="true")
		    System.out.println("Selenium is checked");
		
		//DeSelect only checked
		String attribute = driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[@type='checkbox']")).getAttribute("checked");
		if(attribute=="true")
			driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[@type='checkbox']")).clear();
		
		//Select all below checkboxes
		List<WebElement> list = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following-sibling::input"));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
		}
			
	}

}
