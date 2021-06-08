package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.page.PatientFinderPage;

public class PatientTest extends WebDriverWrapper{
	
	@Test	
	public void addPatientTest() throws InterruptedException {	
		
		
		
		LoginPage login = new LoginPage(driver);
		login.sendUsername("admin");		 
		login.sendPassword("pass");		
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");		
		login.clickOnLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.mousehoverOnPatientClient();
		dashboard.clickOnPatients();
		
		PatientFinderPage patientfinpage = new PatientFinderPage(driver);
		patientfinpage.switchToPatientPage();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.name("pat")));
		
		Select sl = new Select(driver.findElement(By.id("form_title")));
		sl.selectByVisibleText("Mr.");
		
		driver.findElement(By.id("form_fname")).sendKeys("Gagan");
		
		driver.findElement(By.id("form_lname")).sendKeys("Sharma");
		
		driver.findElement(By.id("form_pubpid")).sendKeys("897");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-06-07");
		Select slGender = new Select(driver.findElement(By.id("form_sex")));
		slGender.selectByVisibleText("Male");
		
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.className("closeDlgIframe")).click();
		
		driver.switchTo().defaultContent();		
		
		
		String asertText=new String(driver.findElement(By.xpath("//span[@data-bind='text: pname()']")).getText());   
		
		Assert.assertEquals(asertText, "Gagan Sharma");
		
		
		
		
		
	}

}
