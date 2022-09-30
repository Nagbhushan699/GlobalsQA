package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	WebDriver driver;
	public DragAndDrop(WebDriver driver) {
		this.driver=driver;
	}
	By title=By.xpath("//h1[text()='Drag And Drop']");
	By acceptedElements=By.xpath("//li[@id='Accepted Elements']");
	By nonvalidDragable=By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']/p");
	By validDragable=By.xpath("//div[@id='draggable']/p");
	By droppable=By.xpath("//div[@id='droppable']/p");
	By frame=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String getValidDroppableText() {
		driver.findElement(acceptedElements).click();
		WebElement iframe=driver.findElement(frame);
		driver.switchTo().frame(iframe);
		WebElement drag=driver.findElement(validDragable);
		WebElement drop=driver.findElement(droppable);
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		return drop.getText();
	}
	public String getNonValidDroppableText() {
		WebElement drag=driver.findElement(nonvalidDragable);
		WebElement drop=driver.findElement(droppable);
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		return drop.getText();
	}
}
