package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.testhris.driver.DriverSingleton;

public class GlassEmp {
	private WebDriver driver;
	
	public GlassEmp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a")
	private WebElement sideBarReimbursement;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuReimbursement;
	
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
	
	@FindBy(css = "#content > div.col-md-6 > a")
	private WebElement btnAdd;
	
	@FindBy(id = "Card_Number")
	private WebElement txtCard;
	
	@FindBy(id = "PIC")
	private WebElement txtnama;
	
	@FindBy(id = "rupiah")
	private WebElement txtNilai;
	
//	@FindBy(id = "tgl")
//	private WebElement txtTgl;
	
	@FindBy(id = "reason")
	private List<WebElement> txtReasonGlass;
	
	@FindBy(css = "#content > div.row > div > div > div.panel-body > form > div > input.btn.btn-primary.btn-block")
	private WebElement btnSubmit;
	
	@FindBy(css = "#content > div:nth-child(7) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(1) > div > a")
	private WebElement btnKwitansi;
	
	@FindBy(css = "#content > div:nth-child(8) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(3) > div > a")
	private WebElement btnResep;
	
	@FindBy(css = "#content > div:nth-child(8) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(5) > div > a")
	private WebElement btnDiagnosa;
	
	@FindBy(css = "#content > div:nth-child(8) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(7) > div > a")
	private WebElement btnOthers;
	
	@FindBy(id = "file")
	private WebElement txtFile;
	
	@FindBy(css = "#modal_form > div > div > div.modal-footer > input")
	private WebElement btnUpload;
	
	@FindBy(css = "#content > div:nth-child(9) > div:nth-child(2) > div > div > input")
	private WebElement btnKirim;
	
	@FindBy(css = "#content > div:nth-child(10) > div > ul > li > div.timeline-body > div.timeline-content > p")
	private WebElement txthasil;
	
	public void sideBarAsuransi() {		
		sideBarReimbursement.click();
	}
	
	public void goToKlaimGlass() {		
		SubMenuReimbursement.get(1).click();
	}
	
	public void goToAdd() {		
//		WebDriverWait wait2 = new WebDriverWait(driver, 5000);
//		wait2.until(ExpectedConditions.elementToBeClickable(btnAdd));
//		
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", btnAdd); 
//		btnAdd.click();;
		
		Actions actions = new Actions(driver);
		actions.moveToElement(btnAdd).click().build().perform();
	}
	
	public void inputDataKlaim() {		
		txtCard.sendKeys("123345");
		txtnama.sendKeys("Nanu");
		txtNilai.sendKeys("200000");
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("document.getElementById('tgl').value='2021-01-14'");
		
		btnSubmit.click();
	}
	
	
	public void uploadDokumen() {		
		btnKwitansi.click();
		txtFile.sendKeys("C:\\Users\\F. D. Atmaja\\Pictures\\spek.PNG");
		btnUpload.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnResep.click();
		txtFile.sendKeys("C:\\Users\\F. D. Atmaja\\Pictures\\spek.PNG");
		btnUpload.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnDiagnosa.click();
		txtFile.sendKeys("C:\\Users\\F. D. Atmaja\\Pictures\\spek.PNG");
		btnUpload.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnOthers.click();
		txtFile.sendKeys("C:\\Users\\F. D. Atmaja\\Pictures\\spek.PNG");
		btnUpload.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		btnKirim.click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
	public void inputView() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(btnCompress).click().build().perform();
		//btnCompress.click();
		
		btnReload.click();
		btnCollapse.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnCollapse.click();
		
		btnCompress.click();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getTxthasil() {
		return txthasil.getText();
	}

}
