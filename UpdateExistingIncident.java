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
