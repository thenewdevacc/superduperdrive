package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver webDriver;

	@FindBy(id="inputUsername")
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(webDriver, 40)
                .until(ExpectedConditions.visibilityOf(element));
    }
	
	public void fillLoginForm() {
		this.waitForVisibility(username);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"testuser"+"';", username);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"secure"+"';", password);
//		username.sendKeys("testuser");
//		password.sendKeys("secure");
	}
	
	public void submitLoginForm() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",loginButton);
	}
	
}
