package com.juaracoding.testhris.page;

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
	
	@FindBy(css = "#content > div:nth-child(10) > div > ul > li:nth-child(3) > div.timeline-body > div.timeline-content > p")
	private WebElement txthasil;
	
	@FindBy(id = "tgl")
	private WebElement txtTgl;
	
	@FindBy(id = "tgl2")
	private WebElement txtTgl2;
	
	@FindBy(id = "btn-filter")
	private WebElement btnFilter;
	
	@FindBy(css = "#table_filter > label > input")
	private WebElement txtSearch;
	
	@FindBy(id = "btnSearch")
	private WebElement btnSaerch;
	
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
	
	public String getTxthasil() {
		return txthasil.getText();
	}
	
	public void inputFilter() {		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("document.getElementById('tgl').value='2022-01-19'");
		JS.executeScript("document.getElementById('tgl2').value='2022-01-19'");
		btnFilter.click();
	}
	
	public void inputSearch() {		
		txtSearch.sendKeys("ex");
		btnSaerch.click();
	}
}
