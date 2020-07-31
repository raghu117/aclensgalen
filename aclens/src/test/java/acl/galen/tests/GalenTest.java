package acl.galen.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	 * Galen test using Chrome browser
	 */
	@Test(alwaysRun=true)
	public void chromeGalenTest() throws IOException, InterruptedException {
		generateReport("Chrome browser");
		openChromeBrowser();
		verifyHomePageAndSearchPageUI("chrome");
		callAfterMethod();
	}
	
	/**
	 * Galen test using Firefox browser
	 */
	@Test(alwaysRun=true,priority=1)
	public void firfoxGalenTest() throws IOException, InterruptedException {
		generateReport("FireFox browser");
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
	
	
	
	/**
	 * Verify Visual elements on Home page and Search Page
	 * @param browser
	 * @throws IOException
	 * @throws InterruptedException
	 */
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
	
	}
	
}
