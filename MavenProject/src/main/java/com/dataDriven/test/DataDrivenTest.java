package com.dataDriven.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.Xls_Reader;

public class DataDrivenTest {
	@Test

	
	public void testcase1() 
	{
		
		Xls_Reader reader= new Xls_Reader("C:\\Users\\chandani.kumari\\eclipse-workspace\\MavenProject\\Guru9912.xlsx");
		
		String username= reader.getCellData("ReadData", "Username", 2);
		
		String password = reader.getCellData("ReadData", "Password", 2);
		
		
		System.setProperty("webdriver.chrome.driver","C://Users//chandani.kumari//Desktop//MO//Selenium//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

}
}
