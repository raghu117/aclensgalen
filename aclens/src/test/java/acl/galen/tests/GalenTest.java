package acl.galen.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import acl.galen.pages.GalenSpecDef;


public class GalenTest extends GalenSpecDef{
	
	WebDriver driver;
	
	/**
	 * Before test to represent start
	 */
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method");
	}
	
	/**
	 * Before test to represent start
	 */
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	/**
	 * Galen Layout Test Using Chrome
	 */
	@Test(alwaysRun=true)
	public void chromeGalenTest() throws IOException, InterruptedException {
		generateReport("chrome browser");
		openChromeBrowser();
		verifyHomePageAndSearchPageUI("chrome");
		callAfterMethod();
	}
	
	/**
	 * Galen Layout Test Using Mozilla
	 */
	@Test(alwaysRun=true,priority=1)
	public void firfoxGalenTest() throws IOException, InterruptedException {
		generateReport("Mozilla FireFox browser");
		openFirefoxBrowser();
		verifyHomePageAndSearchPageUI("mozilla");
		callAfterMethod();
	}
			
	@AfterMethod
	public void aftermethod() {
		try{
		System.out.println("quit driver");
		driver.quit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterTest(alwaysRun=true)
	public void afterTest(){
		callAfterTest();
	}
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		System.out.println("before suite");
	}
	
	@AfterSuite()
	public void afterSuite() throws IOException, InterruptedException{
		System.out.println("after suite");
	}
	
	
	public void verifyHomePageAndSearchPageUI(String browser) throws IOException, InterruptedException {
		// Open Home Page
		openHomePage();
		//Home Page UI
		verfiyPageVisualValidation(driver, browser, "\\src\\main\\java\\acl\\galen\\specfiles\\acl-home-page.spec", "AcL HomePage");
		//Navigate to register page
		navigateToSearchPage(driver);
		verfiyPageVisualValidation(driver, browser, "\\src\\main\\java\\acl\\galen\\specfiles\\acl-searchresultpage.spec", "ACL SearchResultsPage");
	}
		
	/**
	 * Open brand website
	 */
	public void openHomePage() {
		// Go to aclens.com
        driver.get("https://www.aclens.com/");	
	}
    
	/**
	 * Open Chrome browser
	 */
	public void openChromeBrowser() {
		//set property for chrome driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resource\\chromedriver.exe");
		 //Create a Chrome Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set the browser size for desktop
       // driver.manage().window().setSize(new Dimension(1200, 800));
        
	}
	
	/**
	 * Open Firefox browser
	 */
	public void openFirefoxBrowser() {
		// set property for chrome driver
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\main\\resource\\geckodriver.exe");
		// Create a Firefox Driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// Set the browser size for desktop
		//driver.manage().window().setSize(new Dimension(1200, 800));
	
	}
	

	
	public void callmeForWaiting(long timeInMilliSeconds) {
    	try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public WebElement waitForElement(String locator) {	    	
         By by=By.cssSelector(locator);
    	 WebElement element=new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(by)); 
    	 
    	 return element;
    }
}