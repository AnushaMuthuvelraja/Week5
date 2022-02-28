package Homework.week5;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClassDataProvider 
{

public ChromeDriver driver;

@BeforeMethod
public void preCondition() 
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();

}
}

----------------------------------------------------------------------------------
	
//CreateLeadDataProvider
	
package Homework.week5;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLeadDataProvider extends BaseClassDataProvider 
{
	@Test(dataProvider="CreateLeadDataProvider")
	public void createLeadDataProvider(String cName,String fName,String lName) throws InterruptedException 
	{
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider(name="CreateLeadDataProvider")
	public String[][] sendData()throws IOException
	{

		//ReadExcelDataProvider read=new ReadExcelDataProvider();
		//String[][] data=read.readData();

		return ReadExcelDataProvider.readData();
	}
}

------------------------------------------------------

//ReadExcelDataProvider

package Homework.week5;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ReadExcelDataProvider 
{

	private static String stringCellValue;

	public static String[][] readData()throws IOException 
	{

		XSSFWorkbook wbook=new XSSFWorkbook("/Selenium/src/main/java/Homework/week5/data/DataProvider1.Xlsx");// the excel file path
		XSSFSheet ws = wbook.getSheet("DataProvider1");//Get into the sheet
		//XSSFSheet ws = wbook.getSheetAt(0);
		//XSSFRow row=ws.getRow(1);//In sheet we have to get into rows
		int rows=ws.getLastRowNum();//get no of rows
		//System.out.println("rows=" +rows);
		int allRows=ws.getPhysicalNumberOfRows();
		//System.out.println(allRows);
		short cells=ws.getRow(0).getLastCellNum();
		//System.out.println(cells);
		String[][]data=new String[2][3];
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=ws.getRow(i);//get into rows

			for(int j=0;j<cells;j++)
			{

				XSSFCell cell=row.getCell(j);
				String cellValue=cell.getStringCellValue();
				System.out.println(cellValue);
				data[i-1][j]=cellValue;
				//return ReadExcelDataProvider.readData("CreateLeadDataProvider");		
			}
		}
		wbook.close();
		return data;
	}

}

----------------------------------------------------
//DataProvidertestng.xml
	
	<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite" verbose="5">
<parameter name="url" value=" http://leaftaps.com/opentaps/ "></parameter>
<parameter name="username" value="DemoSalesManager"></parameter>
<parameter name="password" value="crmsfa"></parameter>
  
  <test thread-count="5" name="Test">
  <classes> 
  
  <class name="Homework.week5.CreateLeadDataProvider"/>
  
  </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

	





	
