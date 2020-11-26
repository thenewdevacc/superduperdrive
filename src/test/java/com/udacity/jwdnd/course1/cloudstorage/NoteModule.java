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

import com.udacity.jwdnd.course1.cloudstorage.model.Note;

public class NoteModule {
	
	private WebDriver webDriver;
	
	@FindBy(id="addNewNoteButton")
	private WebElement addNoteButton;
	
	@FindBy(how = How.CLASS_NAME, using = "noteEditButton")
	private WebElement noteEditButton;
	
	@FindBy(how = How.CLASS_NAME, using = "noteDeleteButton")
	private WebElement noteDeleteButton;
	
	@FindBy(how = How.CLASS_NAME, using = "noteListTitle")
	private WebElement noteListTitle;
	
	@FindBy(how = How.CLASS_NAME, using = "noteListDescription")
	private WebElement noteListDescription;
	
	@FindBy(id="note-title")
	private WebElement noteTitleField;
	
	@FindBy(id="note-description")
	private WebElement noteDescField;
	
	@FindBy(id="noteSubmit")
	private WebElement noteSubmissionButton;
	
	
	public NoteModule(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	private void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(webDriver, 40)
                .until(ExpectedConditions.visibilityOf(element));
    }

	public void addANewNote() {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",addNoteButton);
	}
	
	public void fillTheNote() {
		this.waitForVisibility(noteTitleField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"Test title"+"';", noteTitleField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"Test Description"+"';", noteDescField);
//		noteTitleField.sendKeys("Test title");
//		noteDescField.sendKeys("Test Description");
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",noteSubmissionButton);
	}
	
	public void noteEditClick() {
		this.waitForVisibility(noteEditButton);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",noteEditButton);
	}
	
	public void noteDeleteClick() {
		this.waitForVisibility(noteDeleteButton);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",noteDeleteButton);
	}

	public Note getFirstNote() {
		// Retrieve data and insert it in firstNote object
		this.waitForVisibility(noteTitleField);
		String firstNoteTitle = noteTitleField.getAttribute("value");
		String firstNoteDescription = noteDescField.getAttribute("value");
		//System.out.print("Title: " + noteTitleInput.getText() + " and Description: " + noteDescriptionInput.getText());
		Note firstNote = new Note(null, firstNoteTitle, firstNoteDescription,null);
		return firstNote;
	}
	
	public boolean doesNoteExist() {
		return (this.doesElementExist(webDriver,"noteListTitle") && this.doesElementExist(webDriver,"noteListDescription"));
	}

	private boolean doesElementExist(WebDriver webDriver, String classname) {
		try {
			webDriver.findElement(By.className(classname));
			return true;
		} catch(NoSuchElementException exception) {
			return false;
		}
	}

	public void editTheNote() {
		this.waitForVisibility(noteTitleField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"Test title new"+"';", noteTitleField);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].value='"+"Test Description new"+"';", noteDescField);
//		noteTitleField.sendKeys("Test title");
//		noteDescField.sendKeys("Test Description");
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",noteSubmissionButton);

	}

}
