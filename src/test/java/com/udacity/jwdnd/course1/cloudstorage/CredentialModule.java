package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

public class CredentialModule {

	private WebDriver webDriver;
	
	@FindBy(id="addNewCredentialButton")
	private WebElement addCredentialButton;
	
	@FindBy(how = How.CLASS_NAME, using = "credentialEditButton")
	private WebElement credentialEditButton;
	
	@FindBy(how = How.CLASS_NAME, using = "credentialDeleteButton")
	private WebElement credentialDeleteButton;
	
	@FindBy(how = How.CLASS_NAME, using = "credentialListUrl")
	private WebElement credentialListUrl;
	
	@FindBy(how = How.CLASS_NAME, using = "credentialListUsername")
	private WebElement credentialListUsername;
	
	@FindBy(how = How.CLASS_NAME, using = "credentialListPassword")
	private WebElement credentialListPassword;
	
	@FindBy(id="credential-url")
	private WebElement credentialUrlField;
	
	@FindBy(id="credential-username")
	private WebElement credentialUsernameField;
	
	@FindBy(id="credential-password")
	private WebElement credentialPasswordField;
	
	@FindBy(id="credentialSubmit")
	private WebElement credentialSubmissionButton;
	
	public CredentialModule(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(webDriver, 40)
                .until(ExpectedConditions.visibilityOf(element));
    }

	public void addANewCredential() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",addCredentialButton);
	}

	public void fillTheCredential() {
		this.waitForVisibility(credentialUrlField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"www.linkedin.com"+"';", credentialUrlField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"testUser"+"';", credentialUsernameField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"secure"+"';", credentialPasswordField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",credentialSubmissionButton);
	}
	
	public void credentialEditClick() {
		this.waitForVisibility(credentialEditButton);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",credentialEditButton);		
	}

	public void credentialDeleteClick() {
		this.waitForVisibility(credentialDeleteButton);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",credentialDeleteButton);
	}

	public boolean doesCredentialExist() {
		return (this.doesElementExist(webDriver,"credentialListUrl") && this.doesElementExist(webDriver,"credentialListUsername") && this.doesElementExist(webDriver,"credentialListPassword"));
	}
	
	private boolean doesElementExist(WebDriver webDriver, String classname) {
		try {
			webDriver.findElement(By.className(classname));
			return true;
		} catch(NoSuchElementException exception) {
			return false;
		}
	}


	public Credential getFirstCredentialList() {
		this.waitForVisibility(credentialListUrl);
		String firstCredentialUrl = credentialListUrl.getText();
		String firstCredentialUsername = credentialListUsername.getText();
		String firstCredentialPassword = credentialListPassword.getText();
		//System.out.print("Title: " + noteTitleInput.getText() + " and Description: " + noteDescriptionInput.getText());
		Credential firstCredential = new Credential(null, firstCredentialUrl, firstCredentialUsername,null,firstCredentialPassword,null);
		return firstCredential;
	}

	public void editTheCredential() {
		this.waitForVisibility(credentialUrlField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"www.facebook.com"+"';", credentialUrlField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"usernamenew"+"';", credentialUsernameField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"passwordnew"+"';", credentialPasswordField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",credentialSubmissionButton);		
	}

	public Credential getFirstCredential() {
		this.waitForVisibility(credentialUrlField);
		String firstCredentialUrl = credentialUrlField.getAttribute("value");
		String firstCredentialUsername = credentialUsernameField.getAttribute("value");
		String firstCredentialPassword = credentialPasswordField.getAttribute("value");
		//System.out.print("Title: " + noteTitleInput.getText() + " and Description: " + noteDescriptionInput.getText());
		Credential firstCredential = new Credential(null, firstCredentialUrl, firstCredentialUsername,null,firstCredentialPassword,null);
		return firstCredential;
	}

	
}
