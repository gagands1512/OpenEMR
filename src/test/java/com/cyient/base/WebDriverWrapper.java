package com.cyient.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverWrapper {
	
	protected WebDriver driver;
	
	@BeforeMethod	
	public void setup() {
		
		String browser = "ch";
		if(browser.equals("ch")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else if(browser.equals("ff")) {
			System.setProperty("webdriver.firefox.driver", "src/test/resources/driver/geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://demo.openemr.io/b/openemr");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
