package com.cyient.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.AddPatientPage;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.page.PatientFinderPage;

public class PatientTest extends WebDriverWrapper{
	
	@Test	
	public void addPatientTest() throws InterruptedException {	
		
		
		
		LoginPage login = new LoginPage(driver);
		login.sendUsername("admin");		 
		login.sendPassword("pass");		
		login.selectLanguage("English (Indian)");
		login.clickOnLogin();
		
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.mousehoverOnPatientClient();
		dashboard.clickOnPatients();
		
		PatientFinderPage patientfinpage = new PatientFinderPage(driver);
		patientfinpage.switchToPatientPage();
		patientfinpage.clickOnAddNewPatient();
		
		driver.switchTo().defaultContent();
		
		AddPatientPage addpatientpage = new AddPatientPage(driver);
		addpatientpage.switchToAddPatientPage();
		addpatientpage.selectTitle("Mr.");
		addpatientpage.firstName("Gagan");
		addpatientpage.lastName("Sharma");
		addpatientpage.publicId("8974");
		addpatientpage.dob("2021-06-07");
		addpatientpage.gender("Male");		
		addpatientpage.create();
		
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.id("modalframe")));
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
		
		//driver.findElement(By.className("closeDlgIframe")).click();
		
		driver.switchTo().defaultContent();		
		
		
		String asertText=new String(driver.findElement(By.xpath("//span[@data-bind='text: pname()']")).getText());   
		
		Assert.assertEquals(asertText, "Gagan Sharma");
		
		
		
		
		
	}

}
