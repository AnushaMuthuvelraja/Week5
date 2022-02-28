
//Baseparameter
package Homework.week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseparameter 
{

	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String uname,String pwd) 
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	
}
-------------------------------------------------
//CreateLeadParameter
	
package Homework.week5;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLeadParameters extends Baseparameter {

	@Test
	
	public void createLeadParameter()
	
	{
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HP");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anu");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Muthu");
		driver.findElement(By.name("submitButton")).click();
	
		
	}
 
}
-----------------------------------------
	//parametertestng.xml
	
	<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite" verbose="5">


<parameter name="url" value="http://leaftaps.com/opentaps/"></parameter>
<parameter name="username" value="DemoSalesManager"></parameter>
<parameter name="password" value="crmsfa"></parameter>

  <test  thread-count="5" name="Test">
  
  <classes>
 
  <class name="Homework.week5.CreateLeadParameters"/>
  
  </classes>
  </test >
 
</suite> <!-- Suite -->



 
	

	
	
