package com.udacity.jwdnd.course1.cloudstorage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

import io.github.bonigarcia.wdm.WebDriverManager;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestInstance(Lifecycle.PER_CLASS)
//@TestMethodOrder(OrderAnnotation.class)
class CloudStorageApplicationTests {

//	@LocalServerPort
//	private int port;
//
//	private static WebDriver driver;
//	private SignupPage signupPage;
//	private LoginPage loginPage;
//	private HomePage homePage;
//	private NoteModule noteModule;
//	private ResultPage resultPage;
//	private CredentialModule credentialModule;
//	
//	@BeforeAll
//	static void beforeAll() {
//		WebDriverManager.chromedriver().setup();
//	}
//
//	@BeforeEach
//	public void beforeEach() {
//		this.driver = new ChromeDriver();
//		signupPage = new SignupPage(driver);
//		loginPage = new LoginPage(driver);
//		homePage = new HomePage(driver);
//		noteModule = new NoteModule(driver);
//		resultPage = new ResultPage(driver);
//		credentialModule = new CredentialModule(driver);
//	}
//	
//	@AfterEach
//	public void afterEach() {
//		driver.close();
//	}
//
//	@AfterAll
//	public void afterAll() {
//		driver.quit();
//	}
//
////	
////	@Test
////	public void getLoginPage() {
////		driver.get("http://localhost:" + this.port + "/login");
////		Assertions.assertEquals("Login", driver.getTitle());
////	}
////	
////	
////	@Test
////	public void getSignupPage() {
////		driver.get("http://localhost:" + this.port + "/signup");
////		Assertions.assertEquals("Sign Up", driver.getTitle());
////	}
//	
////	@Test
////	public void testSignup() {
////		driver.get("http://localhost:" + this.port + "/signup");
////		signupPage.fillSignupForm();
////		signupPage.submitSignupForm();
////		Assertions.assertEquals(0, driver.findElements( By.id("signupSuccessfulMessage")).size());
////	}
//	
//	@Test
//	@Order(1)
//	public void testSignUpAndLoginAndLogout() {
//		driver.get("http://localhost:" + this.port + "/signup");
//		signupPage.fillSignupForm();
//		signupPage.submitSignupForm();
//		WebElement waitSignupConfirmation = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("signupSuccessfulMessage")));
////		this.goToPage("login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.logout();
//		WebElement waitLoginScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("loginButton")));
//		goToPage("home");
//		Assertions.assertEquals("Login", driver.getTitle());
//	}	
//	
//	@Test
//	@Order(2)
//	public void testUnauthorisedAccess() {
//		driver.get("http://localhost:" + this.port + "/home");
//		Assertions.assertEquals("Login", driver.getTitle());	
//	}
//	
//	@Test
//	@Order(3)
//	public void testNoteDeletion() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openNotesTab();
//		noteModule.addANewNote();
//		noteModule.fillTheNote();
//		resultPage.backToHome();
//		noteModule.noteDeleteClick();
//		resultPage.backToHome();
//		boolean doesNoteExist = noteModule.doesNoteExist();
//		Assertions.assertEquals(false,doesNoteExist);
//	}
//	
//	@Test
//	@Order(4)
//	public void testCredentialDeletion() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openCredentialsTab();
//		credentialModule.addANewCredential();
//		credentialModule.fillTheCredential();
//		resultPage.backToHome();
//		credentialModule.credentialDeleteClick();
//		resultPage.backToHome();
//		boolean doesCredentialExist = credentialModule.doesCredentialExist();
//		Assertions.assertEquals(false, doesCredentialExist);
//
//	}
//
//	@Test
//	@Order(5)
//	public void testNoteCreation() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openNotesTab();
//		noteModule.addANewNote();
//		noteModule.fillTheNote();
//		resultPage.backToHome();
//		noteModule.noteEditClick();
//		Note firstNote = noteModule.getFirstNote();
//		Assertions.assertEquals("Test title", firstNote.getNotetitle());
//		Assertions.assertEquals("Test Description", firstNote.getNotedescription());
//	}
//	
//	@Test
//	@Order(6)
//	public void testCredentialCreation() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openCredentialsTab();
//		credentialModule.addANewCredential();
//		credentialModule.fillTheCredential();
//		resultPage.backToHome();
//		Credential credential = credentialModule.getFirstCredentialList();
//		Assertions.assertEquals("www.linkedin.com", credential.getUrl());
//		Assertions.assertEquals("testUser", credential.getUsername());
//		Assertions.assertNotEquals("secure", credential.getPassword());
//	}
//	
//	@Test
//	@Order(7)
//	public void testNoteEditing() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openNotesTab();
//		noteModule.addANewNote();
//		noteModule.fillTheNote();
//		resultPage.backToHome();
//		noteModule.noteEditClick();
//		noteModule.editTheNote();
//		resultPage.backToHome();
//		noteModule.noteEditClick();
//		Note firstNote = noteModule.getFirstNote();
//		Assertions.assertEquals("Test title new", firstNote.getNotetitle());
//		Assertions.assertEquals("Test Description new", firstNote.getNotedescription());
//	}
//	
//	@Test
//	@Order(8)
//	public void testCredentialEditing() {
//		driver.get("http://localhost:" + this.port + "/login");
//		loginPage.fillLoginForm();
//		loginPage.submitLoginForm();
//		WebElement waitHomeScreen = new WebDriverWait(driver, 5)
//				.until(webDriver -> webDriver.findElement(By.id("logoutButton")));
//		homePage.openCredentialsTab();
//		credentialModule.addANewCredential();
//		credentialModule.fillTheCredential();
//		resultPage.backToHome();
//		credentialModule.credentialEditClick();;
//		credentialModule.editTheCredential();
//		resultPage.backToHome();
//		credentialModule.credentialEditClick();
//		Credential firstCredential = credentialModule.getFirstCredential();
//		Assertions.assertEquals("www.facebook.com", firstCredential.getUrl());
//		Assertions.assertEquals("usernamenew", firstCredential.getUsername());
//		Assertions.assertEquals("passwordnew", firstCredential.getPassword());
//	}
//	
//	public void goToPage(String path) {
//		driver.get("http://localhost:" + this.port + "/"+path);
//	}

}
