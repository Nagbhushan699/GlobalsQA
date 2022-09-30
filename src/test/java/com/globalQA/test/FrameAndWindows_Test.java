package com.globalQA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.FrameAndWindows;

public class FrameAndWindows_Test extends BaseTest {
	static Logger log=Logger.getLogger(FrameAndWindows_Test.class);
	FrameAndWindows frame;
	@BeforeClass()
	public void before() {
		frame=homepage.goToFrameAndWindows();
	}
	@Test()
	public void verifyTitle() {
	String actual=frame.getTitle();
	log.info("actual result : "+actual);
	String expected=CONSTANTS.FRAMEANDWINDOWSTITLE;
	log.info("expected result : "+expected);
	Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void verifyAnotherWindowText() {
		String actual=frame.handlingOfMultipleWindows();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.FRAMEANDWINDOWSTITLE;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void verifyIframesText() {
		String actual=frame.handlingOfIframes();
		String expected=CONSTANTS.MAILTXT;
		Assert.assertEquals(actual, expected);
	}
}
