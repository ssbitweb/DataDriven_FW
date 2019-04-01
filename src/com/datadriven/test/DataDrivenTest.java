package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		
		//getting testdata from excel
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Automation\\Projects\\DataDriven_FW\\src\\com\\testdata\\CrmPROTestData.xlsx");
		
		String firstname = reader.getCellData("RegCRMPRO", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("RegCRMPRO", "lastname", 2);
		System.out.println(lastname);
		
		String email = reader.getCellData("RegCRMPRO", "emailAddress", 2);
		System.out.println(email);
		
		String username = reader.getCellData("RegCRMPRO", "username", 2);
		System.out.println(username);
		
		//getting url
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.crmpro.com/register/");
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='payment_plan_id']")));
		sel.selectByVisibleText("Free Edition");
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		
		
	}

}
