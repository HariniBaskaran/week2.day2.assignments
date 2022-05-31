package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Launch the browser
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
		
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8526413600");
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		//Capture lead ID of First Resulting lead
		String id = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext']")).getText();
		System.out.println(id);
		
		//Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext']")).click();
		
		//Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//Click Find leads
		driver.findElement(By.xpath("//a[contains(text() , 'Find Leads')]")).click();
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(id);
		
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[text()='No records to display']")).getText());
		if(driver.findElement(By.xpath("//div[text()='No records to display']")).getText().equals("No records to display"))
			System.out.println("Deletion Happened successfully");
		
		
		//Close the browser (Do not log out)
		//driver.close();
		
		
		
		
		
		
		
	}

}
