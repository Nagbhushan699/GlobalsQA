package com.globalQA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.ProgressBar;

public class ProgressBar_Test extends BaseTest {
	static Logger log=Logger.getLogger(ProgressBar_Test.class);
	ProgressBar	 progress;
	@BeforeClass()
	public void before() {
	 progress=homepage.goToProgressBar();
	}
	@Test()
	public void verifyTitle() {
		String actual=progress.getTitle();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.PROGRESSBARTITLE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void verifyDownloadManagerProgressBar() throws InterruptedException {
	progress.switchToFrame();
	String actual=	progress.handlingOfProgressBar("90%");
	log.info("actual result : "+actual);
	String expected="Start Download";
	log.info("expected result : "+expected);
	Assert.assertEquals(actual, expected);
	}
//	@DataProvider()
//	public Object[] dp1() {
//		Object[] obj= {"2%","50%","60%","90%","100%"};
//		return obj;
//	}

}
