package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DialogBox {
	WebDriver driver;
	public DialogBox(WebDriver driver) {
		this.driver=driver;
	}
	By formIframe=By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame lazyloaded']");
	By existing_Users=By.xpath("//h1[text()='Existing Users:']");
	By name_Header=By.xpath("//th[text()='Name']");
	By email_Header=By.xpath("//th[text()='Email']");
	By password_Header=By.xpath("//th[text()='Password']");
	By create_New_User=By.xpath("//button[@id='create-user']");
	By input_Name=By.xpath("//input[@id='name']");
	By input_Email=By.xpath("//input[@id='email']");
	By input_Pass=By.xpath("//input[@id='password']");
	By create_New_Account=By.xpath("//button[text()='Create an account']");
	By cancel=By.xpath("//button[text()='Cancel']");
	//page Actions
	public void switchToFrame() {
		WebElement frame=driver.findElement(formIframe);
		driver.switchTo().frame(frame);
	}
	public String getExistingUsersText() {
		switchToFrame();
		return driver.findElement(existing_Users).getText();
	}
	public String getNameHeaderText() {
		return driver.findElement(name_Header).getText();
	}
	public String getEmailHeaderText() {
		return driver.findElement(email_Header).getText();
	}
	public String getPasswordHeaderText() {
		return driver.findElement(password_Header).getText();
	}
	public String getcreateNewUserText() {
		return driver.findElement(create_New_User).getText();
	}
	public boolean iscreateNewUserBtnClickable() {
		driver.findElement(create_New_User).click();
		return driver.findElement(create_New_User).isSelected();
	}
	public String getNameInputText(String s) {
		WebElement ele=driver.findElement(input_Name);
		ele.clear();
		ele.sendKeys(s);
		String text=ele.getAttribute("value");
		return text;
	}
	public String getEmailInputText(String s) {
		WebElement ele=driver.findElement(input_Email);
		ele.clear();
		ele.sendKeys(s);
		String text=ele.getAttribute("value");
		return text;
	}
	public String getPassInputText(String s) {
		WebElement ele=driver.findElement(input_Pass);
		ele.clear();
		ele.sendKeys(s);
		String text=ele.getAttribute("value");
		return text;
	}
	public String enterAllInputs(String name,String email,String pass) {
		getNameInputText(name);
		getEmailInputText(email);
		getPassInputText(pass);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(create_New_Account).click();
		return driver.findElement(existing_Users).getText();
	}
	public String IsCancelBtnClickable(String name,String email,String pass) {
		getNameInputText(name);
		getEmailInputText(email);
		getPassInputText(email);
		driver.findElement(cancel).click();
		return driver.findElement(existing_Users).getText();
	}
}
