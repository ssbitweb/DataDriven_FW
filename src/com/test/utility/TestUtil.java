package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader("C:\\Selenium_Automation\\Projects\\DataDriven_FW\\src\\com\\testdata\\CrmPROTestData.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int rowNum = 2; rowNum <= reader.getRowCount("RegCRMPRO"); rowNum++) {
				
					String firstname = reader.getCellData("RegCRMPRO", "firstname", rowNum);
					String lastname = reader.getCellData("RegCRMPRO", "lastname", rowNum);
					String email = reader.getCellData("RegCRMPRO", "email", rowNum);
					String username = reader.getCellData("RegCRMPRO", "username", rowNum);
					

					Object ob[] = {firstname, lastname, email, username};
					myData.add(ob);
					
			}
			return myData;
		
	}
	
	
	
	

}
