package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		//Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on Create New Account button
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		
		//Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Harini");
		
		//Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Baskaran");
		
		//Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8526413600");
		
		//Enter the password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("janahari");
		
		//Handle all the three drop downs
		Select s = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		s.selectByIndex(2);
		
		s = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		s.selectByValue("11");
		
		s = new Select(driver.findElement(By.xpath("//select[@title='Year']")));
		s.selectByVisibleText("1995");
		
		//Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		//driver.close();
		
		
	}

}
