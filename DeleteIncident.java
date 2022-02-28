package Homework.week5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClassServiceNow{

	@Test
	public  void DeleteIncident() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@id='filter']")).clear();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");// search indcident in fliter
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);// enter
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();// click open
		driver.switchTo().frame("gsft_main");
		String incNumber="INC00000015";
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incNumber);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);//search
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		//driver.findElement(By.id("//button[@id='sysverb_delete_bottom']")).click();
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		//driver.findElement(By.id("sysverb_delete_bottom"));
		Thread.sleep(2000);
		driver.findElement(By.id("ok_button")).click();
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		

	}

}

