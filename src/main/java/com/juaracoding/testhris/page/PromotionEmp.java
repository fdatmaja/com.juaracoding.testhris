package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.testhris.driver.DriverSingleton;

public class PromotionEmp {
	private WebDriver driver;
	private Select select;
	
	public PromotionEmp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(7) > a")
	private WebElement sideBarPromotion;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuPromotion;

	@FindBy(css = "#content > div.col-md-6 > a")
	private WebElement btnAdd;
	
	@FindBy(css = "#table_filter > label > input")
	private WebElement txtSearch;
	
	@FindBy(id = "btnSearch")
	private WebElement btnSaerch;
	
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btnCompress;
	
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btnReload;
	
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btnCollapse;
	
	@FindBy(css = "#table_previous > a")
	private WebElement btnPrev;
	
	@FindBy(css = "#table_next > a")
	private WebElement btnNext;
	
	@FindBy(css = "#content > form > div:nth-child(1) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btnCompressTujuan;
	
	@FindBy(css = "#content > form > div:nth-child(1) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btnReloadTujuan;
	
	@FindBy(css = "#content > form > div:nth-child(1) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btnCollapseTujuan;
	
	@FindBy(css = "#content > form > div:nth-child(6) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btnCompressIdentitas;
	
	@FindBy(css = "#content > form > div:nth-child(6) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btnReloadIdentitas;
	
	@FindBy(css = "#content > form > div:nth-child(6) > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btnCollapseIdentitas;
	
	@FindBy(id = "nik")
	private WebElement selectNik;
	
	public void sideBar() {		
		sideBarPromotion.click();
	}
	
	public void goToPromotion() {		
		SubMenuPromotion.get(0).click();
	}
	
	public void inputView() {		
		btnCompress.click();
		btnReload.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnCollapse.click();
		btnCollapse.click();
		btnCompress.click();
	}
	
	public void inputViewTujuan() {		
		btnCompressTujuan.click();
		btnReloadTujuan.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnCollapseTujuan.click();
		btnCollapseTujuan.click();
		btnCompressTujuan.click();
	}
	
	public void inputViewIdentitas() {		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCompressIdentitas.click();
		btnReloadIdentitas.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnCollapseIdentitas.click();
		btnCollapseIdentitas.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCompressIdentitas.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void selectNik() {
		select = new Select(selectNik);
		select.selectByIndex(1);
	}
	
	public void inputSearch() {		
		txtSearch.sendKeys("Test");
		btnSaerch.click();
	}
	
	public void kilkNextPrev() {		
		btnNext.click();
		btnPrev.click();
	}
	
	public void goToAdd() {		
		btnAdd.click();;
	}
	
	public void inputDataPromotion() {		

	}
	
}
