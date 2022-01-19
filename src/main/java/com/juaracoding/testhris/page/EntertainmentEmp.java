package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testhris.driver.DriverSingleton;

public class EntertainmentEmp {
private WebDriver driver;
	
	public EntertainmentEmp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a")
	private WebElement sideBarReimbursement;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuReimbursement;
	
	@FindBy(css = "#content > div:nth-child(2) > div > div > a")
	private WebElement btnAdd;
	
	public void sideBarAsuransi() {		
		sideBarReimbursement.click();
	}
	
	public void goToKlaimAsuransi() {		
		SubMenuReimbursement.get(3).click();
	}
	
	public void goToAdd() {		
		btnAdd.click();;
	}
	
}
