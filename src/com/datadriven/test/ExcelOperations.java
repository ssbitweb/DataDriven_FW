package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Automation\\Projects\\DataDriven_FW\\src\\com\\testdata\\CrmPROTestData.xlsx");
		
		if(!reader.isSheetExist("HomePage")) {
			reader.addSheet("HomePage");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("Column count in regTestData :" +colCount);
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Amreen"));
	}

}
