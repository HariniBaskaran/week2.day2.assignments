package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username
		driver.findElement(By.xpath("//input[@class = 'inputLogin']")).sendKeys("DemoSalesManager");
		
		//Enter the password
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("crmsfa");
		
		//Click Login
		driver.findElement(By.xpath("//input[contains(@class ,'decorativeSubmit')]")).click();
		
		
		//Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text() , 'CRM/SFA')]")).click();
		
		//Click Leads link
		driver.findElement(By.xpath("//a[contains(text() , 'Leads')]")).click();
		
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text() , 'Find Leads')]")).click();
		
		Thread.sleep(3000);
		
		//Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		
		//Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("harini31195@gmail.com");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		//Capture name of First Resulting lead
		String name = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[@class='linktext']")).getText();
		System.out.println(name);
		
		Thread.sleep(3000);
		//Click First Resulting lead
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a[@class='linktext']")).click();
		
		//Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		//Verify the title as 'Duplicate Lead'
		if(driver.getTitle().equals("Duplicate Lead"))
		{
			System.out.println("Verified the title");
			
		}
		//Click Create Lead
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//Confirm the duplicated lead name is same as captured name
		if(driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText().equals(name))
		{
			System.out.println("Duplicate name is same as the captured name");
		}
		
		//Close the browser (Do not log out)
		//driver.close();
	}

}
