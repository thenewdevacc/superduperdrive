package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

private WebDriver webDriver;
	

	@FindBy(how = How.CLASS_NAME, using = "homeLink")
	private WebElement backToHomeButton;
	
	
	public ResultPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void backToHome() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",backToHomeButton);
	}
}
