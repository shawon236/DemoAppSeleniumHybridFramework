package SeleniumVersion4.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myaplication.pages.HomePage;
import com.myaplication.pages.SearchPage;
import com.myapplication.baseclass.Base;

public class ProductSearchTest extends Base{
	
	SearchPage serachPage;
	HomePage homePage;
	
	public ProductSearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {				
		driver = browserInialyze(prop.getProperty("browser"), prop.getProperty("url"));	
		homePage = new HomePage(driver);
		}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		//HomePage homePage = new HomePage(driver);
		//homePage.enterProductNameSearchBoxField(dataProp.getProperty("validProduct"));
		//SearchPage serachPage = homePage.clickOnSerachButton();
		
		serachPage = homePage.searchForProduct(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//SearchPage serachPage = new SearchPage(driver);
		
		Assert.assertTrue(serachPage.verifyAddtoCartDispaly(),"Valid product is not display in search result");
	}
	
	@Test(priority=2)
	public void verifySearchWithInValidProduct() {
		//HomePage homePage = new HomePage(driver);
		//homePage.enterProductNameSearchBoxField(dataProp.getProperty("invalidProduct"));
		//serachPage = homePage.clickOnSerachButton();
		serachPage = homePage.searchForProduct(dataProp.getProperty("invalidProduct"));
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataProp.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//SearchPage serachPage = new SearchPage(driver);		
		//String actualSearchMsg = serachPage.retriveNoproductFoundMsgText();
		Assert.assertEquals(serachPage.retriveNoproductFoundMsgText(),dataProp.getProperty("productNotFoundMsg"),"No Message found in search display");
	}
	
	@Test(priority=3)
	public void verifySearchWithOutAnyProduct() {
		
		//HomePage homePage = new HomePage(driver);
		serachPage = homePage.clickOnSerachButton();
		
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		//SearchPage serachPage = new SearchPage(driver);		
		//String actualSearchMsg = serachPage.retriveNoproductFoundMsgText();
		Assert.assertEquals(serachPage.retriveNoproductFoundMsgText(),dataProp.getProperty("productNotFoundMsg"),"No Message found in search display");
	}
}
