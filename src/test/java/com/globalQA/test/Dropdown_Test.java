package com.globalQA.test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.Dropdown;
import com.globalQA.utility.ExcelReader_Utility;

public class Dropdown_Test extends BaseTest{
	static Logger log=Logger.getLogger(Dropdown_Test.class);
	Dropdown drop;
	@BeforeClass()
	public void before() {
		drop=	homepage.goToDropdown();
	}
	@Test
	public void verifyTitle() {
	String actual=	drop.getTitle();
	log.info("actual result : "+actual);
	String expected=CONSTANTS.DROPDOWNTITLE;
	log.info("expected result : "+expected);
	Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifySelectCountryOptionText() {
		String actual=	drop.getSelCountry();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.SELECTCOUNTRYOPTION;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifySelectCountryHeaderText() {
		String actual=	drop.getSelectCountryHeader();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.SELECTCOUNTRYHEADER;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test()
	public void verifySelectedDropdownValue() {
		String actual=	drop.getDropdownValue("ALB");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDROPDOWNVALUE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
//	@DataProvider()
//	public Object[][] data() throws InvalidFormatException, IOException{
//		String path=System.getProperty("user.dir");
//		String fullPath=path+File.separator+"\\src\\test\\resources"+File.separator+"Test_Data.xlsx";
//		String sheetName="Sheet2";
//		ExcelReader_Utility excel=new ExcelReader_Utility(fullPath,sheetName);
//		return excel.getAllData();
//	}
	
}
