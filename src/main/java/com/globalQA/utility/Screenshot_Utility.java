package com.globalQA.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Screenshot_Utility {
	public static void takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String projPath=System.getProperty("User.dir");
		String fullpath=projPath+File.separator+"Failed_Testcases_Screenshots"+File.separator+screenshotName+" .jpg";
		File destfile=new File(fullpath);
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		try {
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, destfile);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
