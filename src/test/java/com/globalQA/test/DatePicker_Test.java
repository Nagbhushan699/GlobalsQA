package com.globalQA.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.page.DatePicker;

public class DatePicker_Test extends BaseTest{
	DatePicker date;
	@BeforeClass()
	public void before12() {
		date=	homepage.goToDatePicker();
	}
	@Test
	public void verifySimpleDatePicker() throws InterruptedException {
		String actual=date.getDate(13, 2, 2020);
		System.out.println("actual res : "+actual);
		String expected="02/13/2020";
		Assert.assertEquals(actual, expected);
	}

}
