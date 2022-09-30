package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	WebDriver driver;
	public Dropdown(WebDriver driver) {
		this.driver=driver;
	}
	By title=By.xpath("//h1[text()='DropDown Menu']");
	By sel_Country=By.xpath("//li[@id='Select Country']");
	By select_Country_Header=By.tagName("strong");
	By select=By.tagName("select");
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String getSelCountry() {
		return driver.findElement(sel_Country).getText();
	}
	public String getSelectCountryHeader() {
		return driver.findElement(select_Country_Header).getText();
	}

	public String getDropdownValue(String value) {
		WebElement drop=driver.findElement(select);
		Select sel=new Select(drop);
		sel.selectByValue(value);
		return drop.getAttribute("value");
	}
}