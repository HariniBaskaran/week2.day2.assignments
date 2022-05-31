package week2.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Are you enjoying the classes?
		driver.findElement(By.xpath("//input[@id='yes']")).click();
		
		//Find default selected radio button
		List<WebElement> ischecked = driver.findElements(By.xpath("//input[@type='radio' and @name='news']"));
		System.out.println(ischecked.size());
		for(int i=0;i<ischecked.size();i++)
			if(ischecked.get(i).isSelected()) {
				System.out.println("Value: " + i + "is checked");
				}
	
		//Select your age group (Only if choice wasn't selected)
		if(!(driver.findElement(By.xpath("//input[@name='age' and @value='1']")).isSelected()))
		{
			driver.findElement(By.xpath("//input[@name='age' and @value='1']")).click();
		}
			
		
	}

}
