package com.globalQA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.DragAndDrop;

public class DragAndDrop_Test extends BaseTest {
	static Logger log=Logger.getLogger(DragAndDrop_Test.class);
	DragAndDrop drag;
	@BeforeClass()
	public void before() {
	drag=	homepage.goToDragAndDrop();
	}
	@Test
	public void verifyTitle() {
	String actual=drag.getTitle();
	log.info("actual result : "+actual);
	String expected=CONSTANTS.EXPECTEDRAGANDDROP;
	log.info("expected result : "+expected);
	Assert.assertEquals(actual, expected);
	}
	@Test()
	public void verifyValidDragable() {
	String actual=drag.getValidDroppableText();
	log.info("actual result : "+actual);
	String expected=CONSTANTS.EXPECTEDVALIDDROPPED;
	log.info("expected result : "+expected);
	Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void verifyNonValidDragable() {
		String actual=drag.getNonValidDroppableText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXPECTEDNONVALIDDROPPED;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
}
