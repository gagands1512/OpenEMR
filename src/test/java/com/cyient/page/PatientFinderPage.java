package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {
	private By patientFrameLocator = By.name("fin");
	private By addNewLocator = By.id("create_patient_btn1");
	
	private WebDriver driver;
	
	public PatientFinderPage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void switchToPatientPage() {
		driver.switchTo().frame(driver.findElement(patientFrameLocator));
	}
	
	public void clickOnAddNewPatient() {
		driver.findElement(addNewLocator).click();
	}

}
