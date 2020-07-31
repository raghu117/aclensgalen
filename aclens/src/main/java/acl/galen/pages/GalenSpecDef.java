package acl.galen.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	 *Generate Report
	 */
	public void generateReport(String scriptName) {
		// Create a GalenTestInfo object
		test = GalenTestInfo.fromString(scriptName);
	}

	/**
	 * Call galen spec file by provided path
	 */
	public void verfiyPageVisualValidation(WebDriver driver, String Browser, String path, String layOutName) {
		try {
			// checkLayout function checks the layout and returns a LayoutReport object
			layoutReport = Galen.checkLayout(driver, System.getProperty("user.dir") + path, null);

			test.getReport().layout(layoutReport, "check" + layOutName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * After Method
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
	}

	/**
	 * Navigate to Search Page
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
		Thread.sleep(7000);
	}

}
