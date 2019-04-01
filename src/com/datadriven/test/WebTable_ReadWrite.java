package com.datadriven.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class WebTable_ReadWrite {
	
	WebDriver driver;

	@Test
	public void trainSearch() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://etrain.info/in");
		
		WebElement from = driver.findElement(By.id("tbsfi1"));
		from.sendKeys("Pune");
		Thread.sleep(5000);
		from.sendKeys(Keys.ENTER);
		
		WebElement to = driver.findElement(By.id("tbsfi3"));
		to.sendKeys("Wardha");
		Thread.sleep(5000);
		to.sendKeys(Keys.ENTER);
		
		WebElement searchButton = driver.findElement(By.id("tbssbmtbtn"));
		searchButton.click();
		
		
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[1]/td[1]/a
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[2]/td[1]/a
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[3]/td[1]/a
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[12]/td[1]/a
		
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[1]/td[2]/a
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[2]/td[2]/a
		//*[@id="content"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[12]/td[2]/a
		
		String beforeXpath_TrainNo = "//*[@id=\"content\"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[";
		String afterXpath_TrainNo = "]/td[1]/a";
		
		String beforeXpath_TrainName = "//*[@id=\"content\"]/table/tbody/tr[2]/td/div[1]/div[1]/table/tbody/tr[";
		String afterXpath_TrainName = "]/td[2]/a";
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='trainlist rnd5']//tr"));
		System.out.println("total rows is "+ rows.size());
		
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Automation\\Projects\\DataDriven_FW\\src\\com\\testdata\\CrmPROTestData.xlsx");
		
		if(!reader.isSheetExist("TrainSearch")) {
			reader.addSheet("TrainSearch");
			reader.addColumn("TrainSearch", "TrainName");
			reader.addColumn("TrainSearch", "TrainNo");
			
		}
		
		

		int rowCount = rows.size();
		
		for(int i=2; i<=rowCount; i++ ) {
			
			String actualXpath_TrainName = beforeXpath_TrainName + i + afterXpath_TrainName;
			String TrainName = driver.findElement(By.xpath(actualXpath_TrainName)).getText();
			System.out.println(TrainName);
			reader.setCellData("TrainSearch", "TrainName", i, TrainName);
			
			String actualXpath_TrainNo = beforeXpath_TrainNo + i + afterXpath_TrainNo ;
			String trainNumber = driver.findElement(By.xpath(actualXpath_TrainNo)).getText();
			int TrainNo = Integer.parseInt(trainNumber);
			System.out.println(TrainNo);
			reader.setCellData("TrainSearch", "TrainNo", i, trainNumber);
				
			
		}
		
		
		
			
		
		
		
	}

}
