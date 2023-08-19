package SeleniumVersion4.SeleniumPractice;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myapplication.baseclass.Base;
import com.myaplication.pages.AccountSuccessPage;
import com.myaplication.pages.HomePage;
import com.myaplication.pages.RegisterPage;
import com.myapplication.Utility.Utilities;


public class RegistrationTest extends Base {
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegistrationTest() {
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {				
		driver = browserInialyze(prop.getProperty("browser"), prop.getProperty("url"));
		
		HomePage homePage = new HomePage(driver);
		//homePage.clickOnMyAccount();
		registerPage = homePage.navigateToRegisterPage();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			//driver.get("https://www.tutorialsninja.com/demo/");	
		}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	@Test(priority=1)
	public void registrationPageWithValidDataMandatoryField() {
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(options);
//		driver.get("https://www.tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		//System.out.println(driver.getCurrentUrl());	
		//Assert.assertTrue(driver.getCurrentUrl().contains("register"));
		
		
		//registerPage.enterFirstName(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp());
		//registerPage.enterLastName(dataProp.getProperty("lastName")+Utilities.generateTimeStamp());
		//registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephoneNumber(Utilities.generateTimeStamp());
		//registerPage.enterPassword(dataProp.getProperty("testPwd"));
		//registerPage.enterConfirmPassword(dataProp.getProperty("testPwd"));
		//registerPage.selectNewsLetterSubscriptionYes();
		//registerPage.selectPrivacyPolicy();
		//accountSuccessPage = registerPage.clickOnContinueButton();
		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp(), 
				dataProp.getProperty("lastName")+Utilities.generateTimeStamp(), 
				//"myemail_"+Utilities.generateTimeStamp()+"@email.com", 
				Utilities.generateEmailWithTimeStamp(),
				Utilities.generateTimeStamp(), dataProp.getProperty("testPwd"), dataProp.getProperty("testPwd"));
		
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName")+Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys("myemail_"+Utilities.generateTimeStamp()+"@email.com");
		//driver.findElement(By.id("input-telephone")).sendKeys(Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("testPwd"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("testPwd"));
		
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		//String expectedMsg = dataProp.getProperty("accountCreatedMsg");
		//String actulaMesg = accountSuccessPage.retriveAccountSuccessMsg();
		//System.out.println(actulaMesg);
		//Assert.assertEquals(actulaMesg,expectedMsg,"Account did not create successfuly!");
		Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMsg(),dataProp.getProperty("accountCreatedMsg"),"Account did not create successfuly!");
	}
	
	@Test(priority=2)
	public void registrationPageWithValidDataAllField() {
				
		//RegisterPage registerPage = new RegisterPage(driver);
		//registerPage.enterFirstName(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp());
		//registerPage.enterLastName(dataProp.getProperty("lastName")+Utilities.generateTimeStamp());
		//registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephoneNumber(Utilities.generateTimeStamp());
		//registerPage.enterPassword(dataProp.getProperty("testPwd"));
		//registerPage.enterConfirmPassword(dataProp.getProperty("testPwd"));
		//registerPage.selectNewsLetterSubscriptionYes();
		//registerPage.selectPrivacyPolicy();
		//accountSuccessPage = registerPage.clickOnContinueButton();
		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp(), 
				dataProp.getProperty("lastName")+Utilities.generateTimeStamp(), 
				Utilities.generateEmailWithTimeStamp(), 
				Utilities.generateTimeStamp(), dataProp.getProperty("testPwd"), dataProp.getProperty("testPwd"));
			
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		
		//String expectedMsg = dataProp.getProperty("accountCreatedMsg");
		//String actulaMesg = accountSuccessPage.retriveAccountSuccessMsg();	
		//Assert.assertEquals(actulaMesg,expectedMsg,"Account did not create successfuly!");
		Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMsg(),dataProp.getProperty("accountCreatedMsg"),"Account did not create successfuly!");
	}
	
	
	@Test(priority=3)
	public void verifyRegisterAccountWithoutFillingAnyDetails() {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(options);
//		driver.get("https://www.tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(registerPage.displayWarningMsg(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), 
				dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), 
				dataProp.getProperty("telephoneWarning"), dataProp.getProperty("pwdWarning")),"All warning messgae are not displayed");
		
		
		/*
		String actualPrivacyWarning = registerPage.retrivePrivacyPolicyWarningMsg();
		Assert.assertTrue(actualPrivacyWarning.contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy warning message is not displayed");
		
		//String firstNameWarningMsg = registerPage.retriveFirstNameMissingWarningMsg();
		Assert.assertEquals(registerPage.retriveFirstNameMissingWarningMsg(),dataProp.getProperty("firstNameWarning"), "First  name missing warning msg is not displayed");
		
		//String lastNameWarningMsg = registerPage.retriveLastNameMissingWarningMsg();
		Assert.assertEquals(registerPage.retriveLastNameMissingWarningMsg(),dataProp.getProperty("lastNameWarning"), "Last  name missing warning msg is not displayed");
		
		//String emailWarningMsg = registerPage.retriveEmailMissingWarningMsg();
		Assert.assertEquals(registerPage.retriveEmailMissingWarningMsg(),dataProp.getProperty("emailWarning"), "Email missing warning message is not displayed");
		
		//String telephoneWarningMsg = registerPage.retriveTelephoneMissingWarningMsg();
		Assert.assertEquals(registerPage.retriveTelephoneMissingWarningMsg(),dataProp.getProperty("telephoneWarning"), "Telephone Number missing warning message is not displayed");
		
		//String passwordWarningMsg = registerPage.retrivePwdMissingWarningMsg();
		Assert.assertEquals(registerPage.retrivePwdMissingWarningMsg(),dataProp.getProperty("pwdWarning"), "Password missing warning message is not displayed");
		*/
		
	}
	@Test(priority=4)
	public void registerWithExistingEmailId() {
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		//RegisterPage registerPage = new RegisterPage(driver);
		//registerPage.enterFirstName(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp());
		//registerPage.enterLastName(dataProp.getProperty("lastName")+Utilities.generateTimeStamp());
		//registerPage.enterEmailAddress(prop.getProperty("email"));
		//registerPage.enterTelephoneNumber(Utilities.generateTimeStamp());
		//registerPage.enterPassword(dataProp.getProperty("testPwd"));
		//registerPage.enterConfirmPassword(dataProp.getProperty("testPwd"));
		//registerPage.selectPrivacyPolicy();
		//registerPage.clickOnContinueButton();
		
		registerPage.registerWithAllFields(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp(), 
				dataProp.getProperty("lastName")+Utilities.generateTimeStamp(), 
				prop.getProperty("email"), 
				Utilities.generateTimeStamp(), dataProp.getProperty("testPwd"), dataProp.getProperty("testPwd"));	
		//driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName")+ Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName")+Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("email"));
		//driver.findElement(By.id("input-telephone")).sendKeys(Utilities.generateTimeStamp());
		//driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("testPwd"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("testPwd"));
		
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//String emailAddActualWarning = registerPage.getDuplicateEmailWarningMsg();
		Assert.assertTrue(registerPage.getDuplicateEmailWarningMsg().contains(dataProp.getProperty("duplicateEmailWarning")), "Email exist warning message is not displayed");
		
	}
	
	
	
	
	

}
