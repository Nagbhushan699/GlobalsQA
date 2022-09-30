package com.globalQA.utility;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class Calendar_Utility {
	WebElement prev;
	WebElement next;
	WebElement act;
	public void getElements(WebElement prev,WebElement next,WebElement actual) {
		this.prev=prev;
		this.next=next;
		this.act=actual;
	}
	public String getMonth(int month) {
		String[]arr= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		return arr[month-1];
	}
	public void calendarUtilityByPrevNextBtn(int month,int year) {
		String actual=act.getText();
		String expected=getMonth(month)+" "+year;
		Calendar cal=Calendar.getInstance();
		Date date=new Date();
		cal.setTime(date);
		int currentmonth=cal.get(Calendar.MONTH);
		int currentyear=cal.get(Calendar.YEAR);
		if(year<currentmonth) {
			while(!actual.equals(expected)) {
				prev.click();
				try {
				actual=act.getText();
				}
				catch(StaleElementReferenceException e) {
					actual=act.getText();
				}
			}
		}
		else if(year==currentyear && month<currentmonth) {
			while(!actual.equals(expected)) {
				prev.click();
				try {
					actual=act.getText();
					}
					catch(StaleElementReferenceException e) {
						actual=act.getText();
					}
			}
		}
		else {
			while(!actual.equals(expected)) {
				next.click();
				try {
					actual=act.getText();
					}
					catch(StaleElementReferenceException e) {
						actual=act.getText();
					}
			}
		}

	}
}
