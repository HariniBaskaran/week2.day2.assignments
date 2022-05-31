package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
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
		
		//Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']//input[@name='firstName']")).sendKeys("Harini");
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		
		Thread.sleep(3000);
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		
		// Verify title of the page
		System.out.println("Title of the page is "+driver.getTitle());
		
		
		//Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Accenture");
		
		// Click Update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		
		//Confirm the changed name appears
		System.out.println(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().split(" "));
		if(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().equals("Accenture"))
			System.out.println("Changed name appears");
		
		
		//Close the browser (Do not log out)
		//driver.close();
	}

}
