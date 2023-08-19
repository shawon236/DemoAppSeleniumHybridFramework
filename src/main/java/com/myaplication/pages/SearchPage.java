package com.myaplication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
		
		//===========================================
		public SearchPage (WebDriver driver) {
			this.driver=driver;
			
			PageFactory.initElements(driver, this); //SearchPage.class
		}
			//============================================
		@FindBy(xpath="//span[text()='Add to Cart']")
		private WebElement validProductSearchResult;
		
		@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
		private WebElement noProductSearchMsgText;
		
		
		public boolean verifyAddtoCartDispaly() {
			boolean dispalyStatus = validProductSearchResult.isDisplayed();
			return dispalyStatus;
		}
		
		public String retriveNoproductFoundMsgText() {
			String noproductfoundMsg = noProductSearchMsgText.getText();
			return noproductfoundMsg;
		}

}
