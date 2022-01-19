package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.testhris.driver.DriverSingleton;

public class PromotionHistEmp {
	private WebDriver driver;
	private Select select;
	
	public PromotionHistEmp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(7) > a")
	private WebElement sideBarPromotion;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuPromotion;
	
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
	
	@FindBy(css = "#table_previous > a")
	private WebElement btnPrev;
	
	@FindBy(css = "#table_next > a")
	private WebElement btnNext;
	
	public void sideBar() {		
		sideBarPromotion.click();
	}
	
	public void goToPromotionHist() {		
		SubMenuPromotion.get(1).click();
	}
	
	public void inputSearch() {		
		txtSearch.sendKeys("Test");
		btnSaerch.click();
	}
	
	public void kilkNextPrev() {		
		btnNext.click();
		btnPrev.click();
	}
	
	public void inputFilter() {		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("document.getElementById('tgl').value='2021-01-19'");
		JS.executeScript("document.getElementById('tgl2').value='2021-01-19'");
		btnFilter.click();
	}
	
}
