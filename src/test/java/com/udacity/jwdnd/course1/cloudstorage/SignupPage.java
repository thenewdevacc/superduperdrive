package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	private WebDriver webDriver;

	@FindBy(id="inputFirstName")
	private WebElement firstname;
	
	@FindBy(id="inputLastName")
	private WebElement lastname;
	
	@FindBy(id="inputUsername")
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(id="signupbutton")
	private WebElement signupButton;
	
	@FindBy(id="backtologinlink")
	private WebElement loginLink;
	
	public SignupPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void fillSignupForm() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"John"+"';", firstname);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"Doe"+"';", lastname);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"testuser"+"';", username);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"secure"+"';", password);
//		firstname.sendKeys("John");
//		lastname.sendKeys("Doe");
//		username.sendKeys("testuser");
//		password.sendKeys("secure");
	}
	
	public void submitSignupForm() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",signupButton);
	}
	
	public void backToLogin() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",loginLink);
	}
}
