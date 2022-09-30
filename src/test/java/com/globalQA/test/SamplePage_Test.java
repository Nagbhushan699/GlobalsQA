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
import com.globalQA.page.SamplePage;
import com.globalQA.utility.ExcelReader_Utility;

public class SamplePage_Test extends BaseTest {
	static Logger log=Logger.getLogger(SamplePage_Test.class);
	SamplePage sample;
	@BeforeClass()
	public void before() {
		sample=	homepage.goToSamplePage();
	}
	@Test(priority = 1)
	public void verifyTitle() {
		String actual=   sample.getTitle();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDSAMPLEPAGETITLE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void verifyUploadedFilePath() {
		String actual=   sample.getUploadedFilePath();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDUPLOADEDFILEPATH;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 3,dataProvider = "dp1")
	public void verifyName(String name,String email,String website) {
		String actual=   sample.getName(name);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDNAME;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider()
	public Object[][] dp1() throws InvalidFormatException, IOException{
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\test\\resources"+File.separator+"Test_Data.xlsx";
		String sheetName="Sheet3";
		ExcelReader_Utility excel=new ExcelReader_Utility(fullpath,sheetName);
		return excel.getAllData();
	}
	@Test(priority = 4,dataProvider = "dp2")
	public void verifyEmail(String name,String email,String website) {
		String actual=   sample.getEmail(email);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDEMAIL;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider()
	public Object[][] dp2() throws InvalidFormatException, IOException{
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\test\\resources"+File.separator+"Test_Data.xlsx";
		String sheetName="Sheet3";
		ExcelReader_Utility excel=new ExcelReader_Utility(fullpath,sheetName);
		return excel.getAllData();
	}
	@Test(priority = 5,dataProvider = "dp3")
	public void verifyWebSite(String name,String email,String website) {
		String actual=   sample.getWebSite(website);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDWEBSITE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider()
	public Object[][] dp3() throws InvalidFormatException, IOException{
		String path=System.getProperty("user.dir");
		String fullpath=path+File.separator+"src\\test\\resources"+File.separator+"Test_Data.xlsx";
		String sheetName="Sheet3";
		ExcelReader_Utility excel=new ExcelReader_Utility(fullpath,sheetName);
		return excel.getAllData();
	}
	@Test(priority = 6,dataProvider = "dp4")
	public void verifyExperience(String exp) {
		String actual= sample.getExperience(exp);
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDEXPERIENCE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@DataProvider()
	public Object[] dp4() throws InvalidFormatException, IOException{
		Object[] ob= {"0-1","1-3","3-5","5-7","7-10","10+"};
		return ob;
	}
	@Test(priority = 7)
	public void verifyFunctionalTestingExpertise() {
		boolean actual=   sample.clickFunctionalTestingExpertise();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 8)
	public void verifyAutomationTestingExpertise() {
		boolean actual=   sample.clickAutomationTestingExpertise();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 9)
	public void verifyManualTestingExpertise() {
		boolean actual=   sample.clickManualTestingExpertise();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 10)
	public void verifyOngraduateEducation() {
		boolean actual=   sample.clickOngraduateEducation();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 11)
	public void verifyOnPostgraduateEducation() {
		boolean actual=   sample.clickOnPostgraduateEducation();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 12)
	public void verifyOtherEducation() {
		boolean actual=   sample.clickOtherEducation();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 13)
	public void verifyAlertTextBeforeAccept() throws InterruptedException {
		String actual=   sample.getAlertTextBeforeAccept();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDBEFOREALERTACCEPTMSG;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
//	@Test(priority = 15)
//	public void verifyAlertTextAfterAccept() {
//		String actual=   sample.getAlertTextAfterAccept();
//		String expected=CONSTANTS.EXPECTEDBEFOREALERTACCEPTMSG;
//		Assert.assertEquals(actual, expected);
//	}
	@Test(priority = 16)
	public void verifyComments() {
		String actual=   sample.getComments("I am passionate about software testing");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDCOMMENTTEXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 17)
	public void verifyclickSubmitBtn() {
		boolean actual= sample.clickSubmitBtn();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
}
