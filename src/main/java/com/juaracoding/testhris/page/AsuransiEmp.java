package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testhris.driver.DriverSingleton;

public class AsuransiEmp {
	private WebDriver driver;
	
	public AsuransiEmp() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a")
	private WebElement sideBarReimbursement;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuReimbursement;

	@FindBy(css = "#content > div.col-md-6 > a")
	private WebElement btnAdd;
	
	@FindBy(id = "Card_Number")
	private WebElement txtCard;
	
	@FindBy(id = "PIC")
	private WebElement txtnama;
	
	@FindBy(id = "rupiah")
	private WebElement txtNilai;
	
	@FindBy(id = "tgl")
	private WebElement txtTgl;
	
	@FindBy(id = "reason")
	private List<WebElement> txtReasonGlass;
	
	@FindBy(css = "#content > div.row > div > div > div.panel-body > form > div > input.btn.btn-primary.btn-block")
	private WebElement btnSubmit;
	
	@FindBy(css = "#content > div:nth-child(7) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(1) > div > a")
	private WebElement btnKwitansi;
	
	@FindBy(css = "#content > div:nth-child(7) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(3) > div > a")
	private WebElement btnResep;
	
	@FindBy(css = "#content > div:nth-child(7) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(5) > div > a")
	private WebElement btnDiagnosa;
	
	@FindBy(css = "#content > div:nth-child(7) > div > div > div.panel-body > form > div > table > tbody > tr > td:nth-child(7) > div > a")
	private WebElement btnOthers;
	
	@FindBy(id = "file")
	private WebElement txtFile;
	
	@FindBy(css = "#modal_form > div > div > div.modal-footer > input")
	private WebElement btnUpload;
	
	@FindBy(css = "#content > div:nth-child(8) > div:nth-child(2) > div > input")
	private WebElement btnKirim;
	
	public void sideBarAsuransi() {		
		sideBarReimbursement.click();
	}
	
	public void goToKlaimAsuransi() {		
		SubMenuReimbursement.get(0).click();
	}
	
	public void goToAdd() {		
		btnAdd.click();;
	}
	
	public void inputDataKlaim() {		
		txtCard.sendKeys("123345");
		txtnama.sendKeys("Nanu");
		txtNilai.sendKeys("2000000");
		
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
	}
	
	

}
