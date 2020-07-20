package acl.galen.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

import junit.framework.Assert;



public class GalenSpecDef {
	// Report generation variables
	public static GalenTestInfo test;
	HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
	List<GalenTestInfo> tests = new ArrayList<GalenTestInfo>();
	LayoutReport layoutReport;

	/**
	 * Call me to create the Report
	 */
	public void generateReport(String browser) {
		// Create a GalenTestInfo object
		test = GalenTestInfo.fromString(browser);
	}

	/**
	 * call galen spec file by provided path
	 */
	public void verfiyPageVisualValidation(WebDriver driver, String Browser, String path, String layOutName) {
		try {
			// checkLayout function checks the layout and returns a LayoutReport object
			layoutReport = Galen.checkLayout(driver, System.getProperty("user.dir") + path, null);

			test.getReport().layout(layoutReport, "check" + layOutName);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}


	/**
	 * call me after method
	 */
	public void callAfterMethod() {
		// Add test object to the tests list
		tests.add(test);
	}

	/**
	 * After Test report generation
	 */
	public void callAfterTest() {
		try {
			htmlReportBuilder.build(tests, "target/galen-html-reports");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If layoutReport has errors Assert Fail
		if (layoutReport.errors() > 0) {
			System.out.println("Layout test failed");
		}
	}

	/**
	 * Navigate to checkout page
	 * @throws InterruptedException 
	 */
	public void navigateToSearchPage(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		try {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector("div.header-container input.search-input[name ='searchText']"))));
		} catch (Exception e) {
			System.out.println("Search is not  available");
		}
		
		WebElement searchBox = driver.findElement(By.cssSelector("div.header-container input.search-input[name ='searchText']"));
		searchBox.sendKeys("mens");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

}
