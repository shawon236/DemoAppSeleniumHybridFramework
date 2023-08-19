package com.myaplication.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButtonField;
	//===========================================
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this); //HomePage.class
	}
	//============================================
	//Actions
	
	public void enterProductNameSearchBoxField(String serachProductText) {
		searchBoxField.sendKeys(serachProductText);
	}
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage clickOnSerachButton() {
		searchButtonField.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForProduct(String serachProductText) {
		searchBoxField.sendKeys(serachProductText);
		searchButtonField.click();
		return new SearchPage(driver);
	}
	

}
