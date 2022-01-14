package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testhris.driver.DriverSingleton;

public class ApprGlass {
	private WebDriver driver;
	
	public ApprGlass() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a")
	private WebElement sideBarReimbursement;
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(3) > a")
	private WebElement SubMenuReimbursement;
	
	@FindBy(css = "#table > tbody > tr:nth-child(1) > td:nth-child(6) > a")
	private WebElement btnEdit;
	
	@FindBy(css = "#content > div:nth-child(8) > div:nth-child(2) > div > div > input")
	private WebElement btnApprove;
	
	public void sideBarAsuransi() {		
		sideBarReimbursement.click();
	}
	
	public void goToApproveGlass() {		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		SubMenuReimbursement.click();
	}
	
	public void goToDetail() {		
		btnEdit.click();
	}
	
	public void approveKlaim() {		
		btnApprove.click();
	}
}
