
//CreateLead
package Homework.week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass 
{
@Test

	public void createLead() throws InterruptedException
	{
		
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HP");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anu");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
			driver.findElement(By.name("submitButton")).click();
			
}
}
---------------------------------
//EditLead

package Homework.week5;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass
{
	@Test
	public void editLead() throws InterruptedException 
	{
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.name("submitButton")).click();
	
}
}

-----------------------------------------------------------------------------------------------------------------------

//DeleteLead

package Homework.week5;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass
{
	@Test
	public void deleteLead()throws InterruptedException
	{
		
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Delete")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}

}
}

-----------------------------------------------------------
//DuplicateLead

package Homework.week5;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass
{
	@Test
	public void duplicateLead() throws InterruptedException 
	{
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
}
}

---------------------------------------------------------------

//Sequence Execution

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test" verbose="5">
    <classes>
      <class name="Homework.week5.DeleteLead"/>
      <class name="Homework.week5.EditLead"/>
      <class name="Homework.week5.CreateLead"/>
      <class name="Homework.week5.DuplicateLead"/>
     
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
------------------------------------------------------------------
	      
//Parallel Execution
	      
	      











	


