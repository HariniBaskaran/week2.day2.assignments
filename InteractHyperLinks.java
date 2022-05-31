package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractHyperLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']")).getAttribute("href"));
		
		System.out.println(driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).getAttribute("href"));
		if(driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).getAttribute("href").contains("error.html")){
			System.out.println("Verified");
		}
		
		driver.findElement(By.xpath("//label//preceding-sibling::a[text()='Go to Home Page']")).click();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("There are "+list.size()+" available in this page");
	}

}
