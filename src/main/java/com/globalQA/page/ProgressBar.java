package com.globalQA.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar {
	WebDriver driver;
	By title=By.xpath("//h1[text()='Progress Bar']");
	By download_Manager=By.id("Download Manager");
	By random_Progress_Bar=By.id("Random Progress Bar");
	By progressIframe=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By start_Download=By.id("downloadButton");
	By file_Download=By.xpath("//span[@id='ui-id-1']");
	By progressBar=By.xpath("//div[@class='progress-label']");
	By cancelDownload=By.xpath("//button[text()='Cancel Download']");
	public ProgressBar(WebDriver driver) {
		this.driver=driver;
	}
	public void switchToFrame() {
		WebElement frame=driver.findElement(progressIframe);
		driver.switchTo().frame(frame);
	}
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String handlingOfProgressBar(String text) throws InterruptedException {
		WebElement start=driver.findElement(start_Download);
		start.click();
		Thread.sleep(3000);
		WebElement progressTxt=driver.findElement(progressBar);
		Wait<WebDriver>  wait=new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(30, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.textToBePresentInElement(progressTxt,text));
		driver.findElement(cancelDownload).click();
		return driver.findElement(start_Download).getText();
	}

}
