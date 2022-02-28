package Homework.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateExistingIncident extends BaseClassServiceNow {

	@Test
	public void updateExistingIncident() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");// search indcident in fliter
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);// enter
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();// click 
		driver.switchTo().frame("gsft_main");
		String incNumber="INC0010107";
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incNumber);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);//search
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		
		  WebElement incidenturgency = driver.findElement(By.id("incident.urgency"));
		  Select urgency =new Select(incidenturgency);
		  urgency.selectByIndex(1);
		  
		  WebElement incidentstate = driver.findElement(By.id("incident.state"));
		  Select s=new Select(incidentstate); s.selectByIndex(1);
		  
		  String text = driver.findElement(By.id("incident.state")).getText();
		 System.out.println(text);
		 
		
		driver.findElement(By.xpath("(//option[@selected='SELECTED'])[2]")).getText();
		
		

	}

}

---------------------------------------------------------------------------------
	//testng.xml
	
	<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite" verbose="5">
  <test thread-count="5" name="Test">
    <classes>
      <class name="Homework.week5.CreateIncident"/>
      <class name="Homework.week5.UpdateExistingIncident"/>
      <class name="Homework.week5.DeleteIncident"/>
      
     
       
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

---------------------------------------------------------------------------------------------
//BaseClassServiceNow
	      
package Homework.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow 
{
	public ChromeDriver driver;
	
	
  @BeforeMethod
	public void preCondition() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev35942.service-now.com/");
		Thread.sleep(10000);
		driver.switchTo().frame("gsft_main");		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("London@2014");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");//search indcident
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);//enter
	}
	
	/*
	 * @AfterMethod public void postCondition() { driver.close(); }
	 */
}

	    	
