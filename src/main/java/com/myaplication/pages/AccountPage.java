package com.myaplication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	//===========================================
	public AccountPage (WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this); //AccountPage.class
	}
		//============================================
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountInfo;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountOption;
	
	@FindBy(xpath="//ul//a[text()='Logout']")
	private WebElement logOutOption;
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	private WebElement logOutMsgText;
	
	public boolean verifyAccountEditInfoOptions() {
		boolean displayStatus = myAccountInfo.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnMyAccount() {
		myAccountOption.click();
	}
	
	public void clickOnLogOutOption() {
		logOutOption.click();
	}
	
	public void logOutApp() {
		myAccountOption.click();
		logOutOption.click();
	}
	
	public boolean verifyAccountLogout() {
		
		boolean accountLogOutMsg = logOutMsgText.isDisplayed();
		return accountLogOutMsg;
	}
	
}
