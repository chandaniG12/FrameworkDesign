package KeywordDriven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableFunction {
	
	static WebDriver driver;
	
	public static String[][] fetchDataFromExcel(){
		
		Workbook wb = null;
		String[][] data = null;
		
		try
		{
			String path= fetchpro("KEYWORD_PATH");
			File fis = new File(path);
			FileInputStream file = new FileInputStream(fis);
			
			System.out.println(path);
			
			String xten = path.substring(path.indexOf(".") +1);
			System.out.println(xten);
			
			if(xten.equals("xlsx"))
			{
				wb = new XSSFWorkbook(file);
				//wb = new HSSFWorkbook(file);
			}
			else
			{
				//wb = new XSSFWorkbook(file);
				wb = new HSSFWorkbook(file);
			}
			
			Sheet sheet = wb.getSheet("Sheet2");
			int rownum = sheet.getLastRowNum();
			System.out.println("Row :" +rownum );
			
			int column = sheet.getRow(0).getLastCellNum();
			
			data = new String[rownum][column];
			
			for(int i= 0; i< rownum; i++)
			{
				
				Row row = sheet.getRow(i);
				
				for( int j= 0 ; j< column; j++)
				{
					Cell cell = row.getCell(j);
					String value = cell.toString();
					data[i][j] = value;
				}
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			
			
		}
		
		return data;
	}
		
	
		
	public static String fetchpro(String text)
	{
		Properties pro= new Properties();
		FileInputStream input;
		try
		{
			input = new FileInputStream(System.getProperty("user.dir") + "\\src\\ObjectRepositoryFile\\object.properties ");
			pro.load(input);
		}
		
		catch(Exception ex)
		{
			
		}
		
		return pro.getProperty(text);
	}
	
	
	

	
	public void LaunchApplication()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chandani.kumari//Desktop//MO//Selenium//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(fetchpro("URL"));

		
	}
	
	
	
	public void fillText(String locationBy, String locatorvalue , String text)
	{
		switch(locationBy) {
		
		case "xpath":
			driver.findElement(By.xpath(locatorvalue)).sendKeys(text);
			break;
			
		case "name":
			driver.findElement(By.name(locatorvalue)).sendKeys(text);
			break;
		}
		
		
	}
	
	public void Click(String locationBy, String locatorElement)
	{
		
       switch(locationBy) {
		
		case "xpath":
			driver.findElement(By.xpath(locatorElement)).click();
			break;
			
		case "name":
			driver.findElement(By.name(locatorElement)).click();
			break;
		}

	}
		
	

	

}


	

