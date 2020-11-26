package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	private WebDriver webDriver;
	
	@FindBy(id="nav-notes-tab")
	private WebElement notesTabButton;
	
	@FindBy(id="nav-credentials-tab")
	private WebElement credentialsTabButton;
	
	@FindBy(id="logoutButton")
	private WebElement logoutButton;
	
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	
	public void logout() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",logoutButton);
	}
	
	public void openNotesTab() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",notesTabButton);
	}


	public void openCredentialsTab() {
		// TODO Auto-generated method stub
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",credentialsTabButton);
	}

}
