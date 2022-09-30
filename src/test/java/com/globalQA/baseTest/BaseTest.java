package com.globalQA.baseTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.globalQA.driverFactory.Driver_Factory;
import com.globalQA.page.HomePage;
import com.globalQA.utility.ConfigReader_Utility;
import com.globalQA.utility.Screenshot_Utility;

public class BaseTest {
	Driver_Factory df;
	protected WebDriver driver;
	Properties prop;
	public HomePage homepage;
	@BeforeTest()
	public void beforeTest() throws IOException {
	df=new Driver_Factory();
	driver=df.getDriver();
	prop=ConfigReader_Utility.readProperties();
	driver.get(prop.getProperty("baseurl"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)");
	homepage=new HomePage(driver);
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			com.globalQA.utility.Screenshot_Utility.takeScreenshot(driver, result.getMethod().getMethodName());
		}
	}
   @AfterTest
   public void afterTest() {
	   driver.quit();
   }

}
