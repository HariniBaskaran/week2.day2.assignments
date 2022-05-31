package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Enter UserName and Password
		driver.findElement(By.xpath("//input[@class = 'inputLogin']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("crmsfa");
		
		//Click on Login Button 
		driver.findElement(By.xpath("//input[contains(@class ,'decorativeSubmit')]")).click();
		
		
		//Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text() , 'CRM/SFA')]")).click();
		
		// Click on contacts Button
		driver.findElement(By.xpath("//a[contains(text() , 'Contacts')]")).click();
		
		//Click on Create Contact
		driver.findElement(By.xpath("//a[contains(text() , 'Create Contact')]")).click();
		
		
		//Enter FirstName Field
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Harini");
		
		//Enter LastName Field
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Baskaran");
		
		
		//Enter FirstName(Local) Field 
		driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("Hari");
		//Enter LastName(Local) Field
		driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("Sundar");
		
		// Enter Department Field
		driver.findElement(By.xpath("//input[@class='inputBox' and @name='departmentName']")).sendKeys("SSES");
		
		
		//Enter Description Field 
		driver.findElement(By.xpath("//textarea[@class='inputBox' and @name='description']")).sendKeys("Skilled in java programming");
		
		//Enter your email in the E-mail address Field
		driver.findElement(By.xpath("//input[@class='inputBox' and @name='primaryEmail']")).sendKeys("harini31195@gmail.com");
		
		//Select State/Province as NewYork Using Visible Text
		Select s=new Select(driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")));
		s.selectByVisibleText("Indiana");
		
		//Click on Create Contact
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		// Click on edit button 
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']/preceding-sibling::a")).click();
		
		//Clear the Description Field using .clear
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		
		//Fill ImportantNote Field with Any text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Good Programmer");
		
		//Click on update button using Xpath locator
		driver.findElement(By.xpath("//textarea[@name='importantNote']/following::input[@value='Update']")).click();
		
		//Get the Title of Resulting Page
		System.out.println(driver.getTitle());
		
		
		
	}

}
