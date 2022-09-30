package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Tooltip {
	WebDriver driver;
	public Tooltip(WebDriver driver) {
		this.driver=driver;
	}
	By formBased=By.xpath("//ul[@class='resp-tabs-list ']//li[text()='Forms Based']");
	By formIframe=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By firstName_TipTxt=By.xpath("//div[@class='ui-tooltip-content']");
	By lastName_TipTxt=By.xpath("//div[@role='tooltip']//div[text()='Please provide also your lastname.']");
	By address_TipTxt=By.xpath("//div[@role='tooltip']//div[text()='Your home or work address.']");
	By firstName=By.xpath("//input[@id='firstname']");
	By lastName=By.xpath("//input[@id='lastname']");
	By address=By.xpath("//input[@id='address']");
	//page Action
	public String verifyFirstNameToolTipText() {
		driver.findElement(formBased).click();
		WebElement frame=driver.findElement(formIframe);
		driver.switchTo().frame(frame);
		WebElement fName=driver.findElement(firstName);
		Actions act=new Actions(driver);
		act.moveToElement(fName).perform();
		return driver.findElement(firstName_TipTxt).getText();
	}
	public String verifyLastNameToolTipText() {
		WebElement lName=driver.findElement(lastName);
		Actions act=new Actions(driver);
		act.moveToElement(lName).perform();
		return driver.findElement(lastName_TipTxt).getText();
	}
	public String verifyAddressToolTipText() {
		WebElement address1=driver.findElement(address);
		Actions act=new Actions(driver);
		act.moveToElement(address1).perform();
		return driver.findElement(address_TipTxt).getText();
	}

}
