package com.myaplication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	WebDriver driver;
	
	//===========================================
	public RegisterPage (WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this); //RegisterPage.class
	}
		//============================================
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneFiled;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreePrivacyPlocyCheckedField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButtonield;
	
	@FindBy(xpath="//div[contains(@class, 'dismissible')]")
	private WebElement duplicateEmailWarningMsg;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newLattersubscribeYesSelect;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameMissingWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameMissingWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailMissingWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneNumMissingWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordMissingWarning;

	public String retrivePwdMissingWarningMsg() {
		String pwdWarningText = passwordMissingWarning.getText();
		return pwdWarningText;
	}
	
	public String retriveTelephoneMissingWarningMsg() {
		String telephoneWarningText = telephoneNumMissingWarning.getText();
		return telephoneWarningText;
	}
	
	public String retriveEmailMissingWarningMsg() {
		String emailWarningText = emailMissingWarning.getText();
		return emailWarningText;
	}
	
	public String retriveLastNameMissingWarningMsg() {
		String lastNameWarningText = lastNameMissingWarning.getText();
		return lastNameWarningText;
	}
	public String retriveFirstNameMissingWarningMsg() {
		String firstNameWarningText = firstNameMissingWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrivePrivacyPolicyWarningMsg() {
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailIdText) {
		emailField.sendKeys(emailIdText);
	}
	public void enterTelephoneNumber(String telephoneNumberTxt) {
		telephoneFiled.sendKeys(telephoneNumberTxt);
	}
	
	public void enterPassword(String passwordTxt) {
		passwordField.sendKeys(passwordTxt);
	}
	public void enterConfirmPassword(String confirmPasswordTxt) {
		confirmpasswordField.sendKeys(confirmPasswordTxt);
	}
	
	public void selectPrivacyPolicy() {
		agreePrivacyPlocyCheckedField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButtonield.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectNewsLetterSubscriptionYes() {
		newLattersubscribeYesSelect.click();
	}
	
	public String getDuplicateEmailWarningMsg() {
		String textWarningDuplicateEmail = duplicateEmailWarningMsg.getText();
		return textWarningDuplicateEmail;
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailIdText, String telephoneNumberTxt, String passwordTxt, String confirmPasswordTxt) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailIdText);
		telephoneFiled.sendKeys(telephoneNumberTxt);
		passwordField.sendKeys(passwordTxt);
		confirmpasswordField.sendKeys(confirmPasswordTxt);
		agreePrivacyPlocyCheckedField.click();
		continueButtonield.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailIdText, String telephoneNumberTxt, String passwordTxt, String confirmPasswordTxt) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailIdText);
		telephoneFiled.sendKeys(telephoneNumberTxt);
		passwordField.sendKeys(passwordTxt);
		confirmpasswordField.sendKeys(confirmPasswordTxt);
		newLattersubscribeYesSelect.click();
		agreePrivacyPlocyCheckedField.click();
		continueButtonield.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean displayWarningMsg(String expPrivacyWarning, String expFirstNameWarning, String expLastNameWarning, String expEmailWarning, String expTelephoneWarning, String expPwdWarning) {
			
		boolean privacyWarningStatus = privacyPolicyWarning.getText().contains(expPrivacyWarning);
		boolean firstNameWarningStatus = firstNameMissingWarning.getText().equals(expFirstNameWarning);	
		boolean lastNameWarningStatus = lastNameMissingWarning.getText().equals(expLastNameWarning);	
		boolean emailWarningStatus = emailMissingWarning.getText().equals(expEmailWarning);
		boolean telephoneWarningStatus = telephoneNumMissingWarning.getText().equals(expTelephoneWarning);
		boolean pwdWarningStatus = passwordMissingWarning.getText().equals(expPwdWarning);
		return privacyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && pwdWarningStatus;
		
	}
	
}
