package com.dataDriven.test;

import org.testng.annotations.Test;

import utilities.Xls_Reader;

public class Parameterize {
	
	@Test
	
	public void fetchdata()
	{
		Xls_Reader reader= new Xls_Reader("C:\\Users\\chandani.kumari\\eclipse-workspace\\MavenProject\\Guru9912.xlsx");
		int rowcount = reader.getRowCount("ReadData");
		
		
	for( int rownum=2; rownum<=rowcount; rownum++)
	{
		String username= reader.getCellData("ReadData", "Username", rownum);
		System.out.println(username);
	}
	}

}
