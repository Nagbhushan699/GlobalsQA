package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.globalQA.utility.Calendar_Utility;

public class DatePicker {
	WebDriver driver;
	public DatePicker(WebDriver driver) {
		this.driver=driver;
	}
	By frame=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By title=By.xpath("//h1[text()='DatePicker']");
	By date=By.xpath("//input[@id='datepicker']");
	By prevBtn=By.xpath("//span[text()='Prev']");
	By nextBtn=By.xpath("//span[text()='Next']");
	By datePickerTitle=By.xpath("//div[@class='ui-datepicker-title']");
	String dateXpath="//a[text()='day']";
	public void switchToFrame() {
		WebElement frame1=driver.findElement(frame);
		driver.switchTo().frame(frame1);
	}

	public String getDate(int day,int month,int year) throws InterruptedException {
	    	switchToFrame();
		    driver.findElement(date).click();
		WebElement prev=driver.findElement(prevBtn);
		WebElement next=driver.findElement(nextBtn);	
		WebElement actual=driver.findElement(datePickerTitle);
		Calendar_Utility cal=new Calendar_Utility();
		cal.getElements(prev, next, actual);
		cal.calendarUtilityByPrevNextBtn(month, year);
		dateXpath="//a[text()='"+day+"']";
		WebElement dt=driver.findElement(By.xpath(dateXpath));
		dt.click();   
		return driver.findElement(date).getAttribute("value");

	}
}
