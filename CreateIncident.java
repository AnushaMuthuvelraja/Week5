package Homework.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends BaseClassServiceNow {

	@Test
	public void createIncident() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='filter']")).clear();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");//search indcident in fliter
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);//enter
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();//click all

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();//click New
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test incident");//enter value for short descrip
		String incNumber= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");//Read incident number
		System.out.println(incNumber);

		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();//caller lookup
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String>l=new ArrayList<String>(windowHandles);

		System.out.println( driver.getCurrentUrl());
		driver.switchTo().window(l.get(1));    
		System.out.println(l.get(1));
		driver.findElement(By.linkText("survey user")).click();
		Thread.sleep(2000);
		driver.switchTo().window(l.get(0)) ;
		System.out.println( driver.getCurrentUrl());
		System.out.println(l.get(0));

		driver.switchTo().frame("gsft_main");//switch to frame before clicking submit 
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();//submit button
		//driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incNumber);//search incident
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);//click enter
		Thread.sleep(2000);

		String SearchIncNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(SearchIncNumber);
		if(incNumber.equals(SearchIncNumber))
		{
			System.out.println("Incident : " + SearchIncNumber + " created and verified successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
	}
}

