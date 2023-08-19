package com.myaplication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//===========================================
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this); //LoginPage.class
	}
		//============================================
	
	
	@FindBy(id="input-email")
	private WebElement emailAddressInputField;
	
	@FindBy(id="input-password")
	private WebElement passwordInputField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailPwdNotMatchingWarning;
	
	//Action
	public void enterEmailAddress(String emailText) {
		emailAddressInputField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		passwordInputField.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage loginApp(String emailText, String passwordText ) {
		emailAddressInputField.sendKeys(emailText);
		passwordInputField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public String retriveWarningMsgText() {
		String warningText = emailPwdNotMatchingWarning.getText();
		return warningText;
	}
		
}
	

