package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Slider {
	WebDriver driver;
	By iframe=By.xpath("//p/iframe[@class='demo-frame lazyloaded']");
	By green=By.xpath("//div[@id='green']//span[@class='ui-slider-handle ui-corner-all ui-state-default']");
	By blue=By.xpath("//div[@id='blue']//span[@class='ui-slider-handle ui-corner-all ui-state-default']");
	By colorBtn=By.id("swatch");
	By range=By.xpath("//ul[@class='resp-tabs-list ']//li[text()='Range']");
	By rangeIframe=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By range_Handle=By.xpath("//div[@id='slider-range']//span[@class='ui-slider-handle ui-corner-all ui-state-default']");
	By amount=By.xpath("//input[@id='amount']");
	By step=By.xpath("//ul[@class='resp-tabs-list ']//li[text()='Steps']");
	By stepIframe=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By stepHandle=By.xpath("//div[@id='slider']/span[@class='ui-slider-handle ui-corner-all ui-state-default']");
	By stepText=By.xpath("//label[text()='Donation amount ($50 increments):']/following::input");
	public Slider(WebDriver driver) {
		this.driver=driver;
	}
	//page Actions
	public void switchToFrame() {
		WebElement frame=driver.findElement(iframe);
		driver.switchTo().frame(frame);
	}
	public String getGreenColor() throws InterruptedException {
		switchToFrame();
		Actions act=new Actions(driver);
		WebElement greencolor=driver.findElement(green);
		act.dragAndDropBy(greencolor, 150, 0).perform();
		Thread.sleep(5000);
		WebElement swatch=driver.findElement(colorBtn);
		String btncolor=swatch.getCssValue("background-color");
		String hexcolor=Color.fromString(btncolor).asHex();
		return hexcolor;
	}
	public String getBlueColor() {
		Actions act=new Actions(driver);
		WebElement bluecolor=driver.findElement(blue);
		act.dragAndDropBy(bluecolor, 300, 0).perform();
		WebElement swatch=driver.findElement(colorBtn);
		String btncolor=swatch.getCssValue("background-color");
		String hexcolor=Color.fromString(btncolor).asHex();
		return hexcolor;
	}
	public String getAmount(int amt) {
		driver.switchTo().defaultContent();
		driver.findElement(range).click();
		WebElement rangehandle=driver.findElement(rangeIframe);
		driver.switchTo().frame(rangehandle);
		WebElement ele=driver.findElement(amount);
		System.out.println(ele.getAttribute("value"));
		Actions act=new Actions(driver);
		WebElement handle=driver.findElement(range_Handle);
		act.dragAndDropBy(handle, amt, 0).perform();
		return ele.getAttribute("value");
	}
	public String getSteps(int val) {
		driver.switchTo().defaultContent();
		driver.findElement(step).click();
		WebElement stepframe=driver.findElement(stepIframe);
		driver.switchTo().frame(stepframe);
		WebElement step=driver.findElement(stepHandle);
		Actions act=new Actions(driver);
		act.dragAndDropBy(step, val, 0).perform();
		return driver.findElement(stepText).getAttribute("value");
		
	}
}
