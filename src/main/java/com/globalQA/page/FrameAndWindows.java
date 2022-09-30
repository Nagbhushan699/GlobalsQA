package com.globalQA.page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameAndWindows {
	WebDriver driver;
	public FrameAndWindows(WebDriver driver) {
		this.driver=driver;
	}
	By frame=By.xpath("//iframe[@name='globalSqa']");
	By title=By.xpath("//h1[text()='Frames And Windows']");
	By openNewTab=By.xpath("//div[@rel-title='Open New Tab']//a[text()='Click Here']");
	By iframe=By.xpath("//li[@id='iFrame']");
	By trainings=By.xpath("//div[@class='page_heading']/h1[text()='Trainings']");
	By mail=By.xpath("//h1[text()='Trainings']/preceding::div[text()='contact@globalsqa.com']");
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public void switchToFrame() {
		WebElement frame1=driver.findElement(frame);
		driver.switchTo().frame(frame1);
	}
	public String handlingOfMultipleWindows() {
		String parentWindow=driver.getWindowHandle();
		driver.findElement(openNewTab).click();
		Set<String>allWindows=driver.getWindowHandles();
		Iterator<String>itr=allWindows.iterator();
		String text=" ";
		while (itr.hasNext()) {
			String child =itr.next();
			if(!child.equals(parentWindow)) {
				driver.switchTo().window(child);
				WebElement childWindowTitle=driver.findElement(title);
				text=childWindowTitle.getText();
			}
			driver.switchTo().window(parentWindow);
		}
		return text;
	}
	public String handlingOfIframes() {
		driver.findElement(iframe).click();
		switchToFrame();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
		WebElement text= driver.findElement(mail);
		return text.getText();
	}
}
