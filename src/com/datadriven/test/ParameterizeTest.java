package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		//getting url
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.crmpro.com/register/");
		
		//DataDriven approach(Parameterization) -- used to create dataDriven framework -- driving data from excel files.
		
		//reading data
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Automation\\Projects\\DataDriven_FW\\src\\com\\testdata\\CrmPROTestData.xlsx");

		int rowCount = reader.getRowCount("RegCRMPRO");
		
		reader.addColumn("RegCRMPRO", "Status");
		
		//Parameterization -- always done using for loop.
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			
			System.out.println("==============");
			String firstname = reader.getCellData("RegCRMPRO", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname = reader.getCellData("RegCRMPRO", "lastname", rowNum);
			System.out.println(lastname);
			
			String email = reader.getCellData("RegCRMPRO", "emailAddress", rowNum);
			System.out.println(email);
			
			String username = reader.getCellData("RegCRMPRO", "username", rowNum);
			System.out.println(username);
			
			
			
			//enterData
			Select sel = new Select(driver.findElement(By.xpath("//select[@id='payment_plan_id']")));
			sel.selectByVisibleText("Free Edition");
			
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
			
			driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).sendKeys(email);
			
			driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
			
			//write data into cell
			reader.setCellData("RegCRMPRO", "Status", rowNum, "Pass"); 
		}
	}

}
