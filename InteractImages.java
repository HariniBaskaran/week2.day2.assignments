package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractImages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		//Am I Broken Image?
		//driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"))
		
		
		//Click me using Keyboard or Mouse
		//WebElement element = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
		//element.sendKeys(Keyboard);
		
	}

}
