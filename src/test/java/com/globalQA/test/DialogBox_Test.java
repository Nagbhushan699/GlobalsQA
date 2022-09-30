package com.globalQA.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.globalQA.baseTest.BaseTest;
import com.globalQA.constants.CONSTANTS;
import com.globalQA.page.DialogBox;

public class DialogBox_Test extends BaseTest{
	static Logger log=Logger.getLogger(DialogBox_Test.class);
	DialogBox dialog;
	@BeforeClass()
	public void beforeclass() {
		dialog=homepage.goToDialogBox();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
	}
	@Test(priority = 1)
	public void verifyExistingUsersText() {
		String actual=dialog.getExistingUsersText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXISTINGUSERSTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void verifyNameHeaderText() {
		String actual=dialog.getNameHeaderText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.NAMEHEADERTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 3)
	public void verifyEmailHeaderText() {
		String actual=dialog.getEmailHeaderText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EMAILHEADERTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 4)
	public void verifyPasswordHeaderText() {
		String actual=dialog.getPasswordHeaderText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.PASSWORDHEADERTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 5)
	public void verifyCreateNewUserText() {
		String actual=dialog.getcreateNewUserText();
		log.info("actual result : "+actual);
		String expected=CONSTANTS.CREATENEWUSERBTNTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 6)
	public void verifyCreateNewUserBtnClickable() {
		boolean actual=dialog.iscreateNewUserBtnClickable();
		log.info("actual result : "+actual);
		Assert.assertTrue(actual);
	}
	@Test(priority = 7)
	public void verifyNameInputText() {
		String actual=dialog.getNameInputText("Nagbhushan");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.NAMEINPUTTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 8)
	public void verifyEmailInputText() {
		String actual=dialog.getEmailInputText("bhushan@123");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EMAILINPUTTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 8)
	public void verifyPassInputText() {
		String actual=dialog.getPassInputText("pass@123");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.PASSINPUTTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 9)
	public void verifyAllInputs() {
		String actual=dialog.enterAllInputs("Nagbhushan","bhushan@123","pass@123");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXISTINGUSERSTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 10)
	public void verifyCancelBtnClickable() {
		String actual=dialog.IsCancelBtnClickable("Nagbhushan","bhushan@123","pass@123");
		log.info("actual result : "+actual);
		String expected=CONSTANTS.EXISTINGUSERSTXT;
		log.info("expected result : "+expected);
		Assert.assertEquals(actual, expected);
	}
}
