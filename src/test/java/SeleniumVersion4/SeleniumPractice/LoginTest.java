package SeleniumVersion4.SeleniumPractice;
import com.myaplication.pages.AccountPage;
import com.myaplication.pages.HomePage;
import com.myaplication.pages.LoginPage;
import com.myapplication.Utility.Utilities;
import com.myapplication.baseclass.Base;



import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends Base {
	
	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
				
		driver = browserInialyze(prop.getProperty("browser"), prop.getProperty("url"));		
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateLoginPage();
				
	}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority =1)
	public void verifyLoginWithInvalidCredintials()  {					
		loginPage.loginApp(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));				
		Assert.assertTrue(loginPage.retriveWarningMsgText().contains(dataProp.getProperty("invalidEmailPwdWarning")),"Expected Waring did not matched");
 		
	}
	@Test(priority=2)
	public void verifyLoginWithInvalidPwd() {
				
		loginPage.loginApp(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
			
		Assert.assertTrue(loginPage.retriveWarningMsgText().contains(dataProp.getProperty("invalidEmailPwdWarning")),"Expected Waring did not matched"); 
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithValidCreditial() {
				
		accountPage = loginPage.loginApp(prop.getProperty("email"), prop.getProperty("password"));		
		Assert.assertTrue(accountPage.verifyAccountEditInfoOptions(),"Account page is not displayed");
		accountPage.logOutApp();
		Assert.assertTrue(accountPage.verifyAccountLogout(),"Account Logout message is not displayed");
	}
	
	@Test(priority=4,dataProvider="validCredentialTestData")
	public void verifyLoginWithValidCreditials(String email, String password) {
				
		accountPage = loginPage.loginApp(email, password);		
		Assert.assertTrue(accountPage.verifyAccountEditInfoOptions(),"Account info is not displayed");
				
	}
	
	@DataProvider(name="validCredentialTestData")
	public Object[][] loginTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	
	@Test(priority =5)
	public void verifyLoginWithInValidEmailValidPwd()  {				
		loginPage.loginApp(dataProp.getProperty("invalidEmail"), prop.getProperty("password"));
		Assert.assertTrue(dataProp.getProperty("invalidEmailPwdWarning").contains(loginPage.retriveWarningMsgText()),"Expected Waring did not matched");
			
	}
	
}
