package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper{


	public Object[][] main;


	@Test(dataProvider="invalidCredentialData",dataProviderClass = DataProviderUtils.class)
    public void invalidCredentialTest(String username,String password,String languageText,String expectedValue)
    {
		LoginPage login = new LoginPage(driver);
		login.sendUsername(username);
		 
		 login.sendPassword(password);
		
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText(languageText);
		
		login.clickOnLogin();
		
		String statement = login.invalidCredentials();
		
		Assert.assertEquals(statement,expectedValue);

    }
	
	
	@Test(dataProvider="validCredentialExcelData",dataProviderClass = DataProviderUtils.class)
	public void validCredentialTest(String username,String password,String languageText,String expectedValue) {
		
		 LoginPage login = new LoginPage(driver);
		 DashboardPage dashboard = new DashboardPage(driver);
		 
		 login.sendUsername(username);
		 
		 login.sendPassword(password);
		
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText(languageText);
		
		login.clickOnLogin();
		
		String Title = dashboard.getDashboardPageTitle();
		
		Assert.assertEquals(Title,expectedValue);
	}
	
	
	  public void UIComponentTest() {
	  
	  String actualDescription =
	  driver.findElement(By.xpath("//contains(text(),'popular')")).getText();
	  
	  Assert.assertEquals(actualDescription,
	  "The most popular open-source Electronic Health Record and Medical Practice Management solution."
	  );
	  
	  String actualPassword =
	  driver.findElement(By.id("clearPass")).getAttribute("placeholder");
	  
	  Assert.assertEquals(actualPassword, "Password:");
	  
	  
	  
	  
	  
	  }
	 
	
	

}
