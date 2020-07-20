package acl.galen.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ReportTest {
	

@Test
public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resource\\chromedriver.exe");
	       ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");	
			Thread.sleep(10000);
			WebDriver driver=new ChromeDriver(opt);		
			System.out.println(System.getProperty("user.dir").replace("\\", "/"));
			driver.get("file:///C:/Users/SDWA-190/git/GelanVisualRegression/Galen/target/galen-html-reports/5-tablet-825-825.html");
	
			System.out.println(getFailedObjects(driver)+" "+ getFailedObjects(driver).size());
	}



	public List<String> getFailedObjects(WebDriver driver) {
	       List<String> objs=new ArrayList<String>();
			List<WebElement> erros=driver.findElements(By.tagName("a"));
			System.out.println(erros.size());
			for(WebElement error: erros)
			{
				if(error.getAttribute("class").contains("status-error")) {
					  objs.add(error.getAttribute("data-highlight-objects"));
					  System.out.println(error.getAttribute("data-highlight-objects"));
					  
				}
			
			}
			
			return objs;
			
		}

}
