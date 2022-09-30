package com.globalQA.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	By slider=By.xpath("//a[text()='Slider']");
	By tooltip=By.xpath("//a[text()='ToolTip']");
	By dialogBox=By.xpath("//a[text()='DialogBox']");
	By progressBar=By.xpath("//a[text()='ProgressBar']");
	By frame=By.xpath("//a[text()='Frames']");
	By dropdown=By.xpath("//a[text()='DropDown']");
	By datePicker=By.xpath("//a[@class='button tiny_button button_pale regular_text' and text()='DatePicker']");
	By dragAndDrop=By.xpath("//a[text()='DragAndDrop']");
	By samplePage=By.xpath("//a[text()='SamplePage']");
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public Slider goToSlider() {
		driver.findElement(slider).click();
		return new Slider(driver);
	}
	public Tooltip goToTooltip() {
		driver.findElement(tooltip).click();
		return new Tooltip(driver);
	}
	public DialogBox goToDialogBox() {
		driver.findElement(dialogBox).click();
		return new DialogBox(driver);
	}
	public ProgressBar goToProgressBar() {
		driver.findElement(progressBar).click();
		return new ProgressBar(driver);
	}
	public FrameAndWindows goToFrameAndWindows() {
		driver.findElement(frame).click();
		return new FrameAndWindows(driver);
	}
	public Dropdown goToDropdown() {
		driver.findElement(dropdown).click();
		return new  Dropdown(driver);
	}
	public DatePicker goToDatePicker() {
		driver.findElement(datePicker).click();
		return new  DatePicker(driver);
	}
	public DragAndDrop goToDragAndDrop() {
		driver.findElement(dragAndDrop).click();
		return new DragAndDrop(driver);
	}
	public SamplePage goToSamplePage() {
		driver.findElement(samplePage).click();
		return new SamplePage(driver);
	}

}
