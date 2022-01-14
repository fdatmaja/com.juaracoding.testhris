package com.juaracoding.testhris.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testhris.driver.DriverSingleton;

public class LoginHRD {
	private WebDriver driver;
	
	public LoginHRD() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div:nth-child(1) > input")
	private WebElement txtUser;
	
	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div:nth-child(2) > input")
	private WebElement txtPass;
	
	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div.login-buttons > button")
	private WebElement btnLogin;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(1) > li > a > div.info")
	private WebElement txtDisplayName;
	
	public void goToLoggedIn(String username, String password) {		
		txtUser.sendKeys(username);
		txtPass.sendKeys(password);
		btnLogin.click();
	}

	public String getTxtDisplayName() {
		return txtDisplayName.getText();
	}
}
