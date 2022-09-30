package com.globalQA.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamplePage {
	WebDriver driver;
	public SamplePage(WebDriver driver) {
		this.driver=driver;
	}
	By choosefile=By.xpath("//input[@name='file-553']");
	By title=By.xpath("//h1[text()='Sample Page Test']");
	By name=By.id("g2599-name");
	By email=By.id("g2599-email");
	By website=By.id("g2599-website");
	By experience=By.id("g2599-experienceinyears");
	By FunctionalTesting =By.xpath("//input[@value='Functional Testing']");
	By AutomationTesting=By.xpath("//input[@value='Automation Testing']");
	By ManualTesting=By.xpath("//input[@value='Manual Testing']");
	By graduate=By.xpath("//input[@value='Graduate']");
	By postGraduate=By.xpath("//input[@value='Post Graduate']");
	By Other=By.xpath("//input[@value='Other']");
	By alertBox=By.xpath("//button[text()='Alert Box : Click Here']");
	By comments=By.id("contact-form-comment-g2599-comment");
	By submit=By.xpath("//button[@type='submit']");

	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String getUploadedFilePath() {
		WebElement input=driver.findElement(choosefile);
		input.sendKeys("D:\\textures\\BRICKS\\00180.jpg");
		return input.getAttribute("value");
	}
	public String getName(String n) {
		WebElement name1=driver.findElement(name);
		name1.clear();
		name1.sendKeys(n);
		return name1.getAttribute("value");
	}
	public String getEmail(String n) {
		WebElement email1=driver.findElement(email);
		email1.clear();
		email1.sendKeys(n);
		return email1.getAttribute("value");
	}
	public String getWebSite(String n) {
		WebElement website1=driver.findElement(website);
		website1.clear();
		website1.sendKeys(n);
		return website1.getAttribute("value");
	}
	public String getExperience(String s) {
		WebElement exper=driver.findElement(experience);
		Select sel=new Select(exper);
		sel.selectByVisibleText(s);
		return exper.getAttribute("value");
	}
	public boolean clickFunctionalTestingExpertise() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(FunctionalTesting).click();
		return driver.findElement(FunctionalTesting).isSelected();
	}
	public boolean clickAutomationTestingExpertise() {
		driver.findElement(AutomationTesting).click();
		return driver.findElement(AutomationTesting).isSelected();
	}
	public boolean clickManualTestingExpertise() {
		driver.findElement(ManualTesting).click();
		return driver.findElement(ManualTesting).isSelected();
	}
	public boolean clickOngraduateEducation() {
		driver.findElement(graduate).click();
		return driver.findElement(graduate).isSelected();
	}
	public boolean clickOnPostgraduateEducation() {
		driver.findElement(postGraduate).click();
		return driver.findElement(postGraduate).isSelected();
	}
	public boolean clickOtherEducation() {
		driver.findElement(Other).click();
		return driver.findElement(Other).isSelected();
	}
	public String getAlertTextBeforeAccept() throws InterruptedException {
		String text=" ";
		try {

			System.out.println("Waiting for Alert");
			WebElement alertele=driver.findElement(alertBox);
			alertele.click();
			Thread.sleep(4000);

		} catch (UnhandledAlertException f) {

		    try {

		    	System.out.println("Alert Displayed");
				Alert alert=driver.switchTo().alert();
				text=alert.getText();
				System.out.println("alert text  : "+text);
				alert.accept();

		    } catch (NoAlertPresentException e) {

		        e.printStackTrace();

		    }

		}

	
		return text;
	}
//	public String getAlertTextAfterAccept() {
//		WebElement alertele=driver.findElement(alertBox);
//		alertele.click();
//		Alert alert=driver.switchTo().alert();
//		alert.accept();
//		String text=alert.getText();
//		alert.accept();
//		return text;
//	}
	public String getComments(String n) {
		WebElement comments1=driver.findElement(comments);
		comments1.sendKeys(n);
		return comments1.getText();
	}
	public boolean clickSubmitBtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(submit).click();
		return driver.findElement(submit).isSelected();
	}
}
