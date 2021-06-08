package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By loginClickLocator = By.xpath("//button[@type='submit']");
	private By InvalidCrdentialsLocator = By.xpath("//div[@class='alert alert-danger login-failure m-1']");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendUsername(String username) {
		
		driver.findElement(usernameLocator).sendKeys(username);
		
	}
	
	public void sendPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(loginClickLocator).click();
	}
	
	public String invalidCredentials() {
		String statement = driver.findElement(InvalidCrdentialsLocator).getText();
		
		return statement;
	}

}
