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
