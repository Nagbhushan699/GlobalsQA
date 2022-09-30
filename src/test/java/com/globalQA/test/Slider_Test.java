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
import com.globalQA.page.Slider;
import com.globalQA.utility.ExcelReader_Utility;

import freemarker.template.utility.Constants;

public class Slider_Test extends BaseTest{
	static Logger log=Logger.getLogger(Slider_Test.class);
	Slider slider;
	@BeforeClass()
	public void beforeclass() {
		slider=homepage.goToSlider();
	}
	@Test
	public void verifyGreenColorSlider() throws InterruptedException {
		String actual= slider.getGreenColor();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.GREEN_SLIDER_COLOUR;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void verifyBlueColorSlider() {
		String actual=slider.getBlueColor();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.BLUE_SLIDER_COLOUR;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2,dataProvider = "dp1")
	public void verifyRangeSlider(int s1,int s2) {
		String actual=slider.getAmount(s1);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.RANGE_SLIDER_AMOUNT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider
	public Object[][] dp1() throws InvalidFormatException, IOException{
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\test\\resources"+File.separator+"Test_Data.xlsx";
		String sheetName="Sheet2";
		ExcelReader_Utility excel=new ExcelReader_Utility(fullpath,sheetName);
		return excel.getAllData1();
	}
	@Test(priority=3,dataProvider = "dp2")
	public void verifyStepSlider(int m1,int m2) {
		String actual=slider.getSteps(m2);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.STEPS_SLIDER_AMOUNT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider
	public Object[][] dp2() throws InvalidFormatException, IOException{
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\test\\resources"+File.separator+"Test_Data.xlsx";
		String sheetName="Sheet2";
		ExcelReader_Utility excel=new ExcelReader_Utility(fullpath,sheetName);
		return excel.getAllData();
	}

}
