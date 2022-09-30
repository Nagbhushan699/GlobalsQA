package com.globalQA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.Tooltip;

public class ToolTipTest extends BaseTest{
	static Logger log=Logger.getLogger(ToolTipTest.class);
	Tooltip tip;
	@BeforeClass()
	public void before() {
		tip=homepage.goToTooltip();
	}
	@Test
	public void verifyFirstNameTooltipTxt() {
		String actual=	tip.verifyFirstNameToolTipText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.FIRSTNAME_TOOLTIPTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifylastNameTooltipTxt() {
		String actual=	tip.verifyLastNameToolTipText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.LASTNAME_TOOLTIPTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 1)
	public void verifyAddressTooltipTxt() {
		String actual=	tip.verifyAddressToolTipText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.ADDRESS_TOOLTIPTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}

}
