package com.juaracoding.testhris.page;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testhris.driver.DriverSingleton;

public class ReimbursementHRD {
	private WebDriver driver;
	
	public ReimbursementHRD() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement sideBarReimbursement;
	
	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li")
	private List<WebElement> SubMenuReimbursement;

	@FindBy(xpath = "//a[@class=\"btn btn-circle btn-warning\"]")
	private List<WebElement> btnEdit;
	
	@FindBy(css = "#panel-image > div.col-md-12 > div > a.btn.btn-success")
	private WebElement btnAjukan;
	
	@FindBy(css = "#panel-image > div.col-md-12 > div > form > button")
	private WebElement btnAjukanGlass;
	
	@FindBy(css = "#panel-image > div.col-md-12 > div > button.btn.btn-success")
	private WebElement btnApprove;
	
	@FindBy(id = "claim_before")
	private WebElement txtJumlahClaimBefore;
	
	@FindBy(id = "claim_after")
	private WebElement txtJumlahClaim;
	
	@FindBy(id = "reason")
	private WebElement txtReason;
	
	@FindBy(id = "reason")
	private List<WebElement> txtReasonGlass;
	
	@FindBy(css = "#modal_approve > div > div > form > div.modal-footer > button.btn.btn-primary")
	private WebElement btnSubmit;
	
	
	public void sideBarAsuransi() {		
		sideBarReimbursement.click();
	}
	
	public void goToKlaimAsuransi() {		
		SubMenuReimbursement.get(0).click();
	}
	
	public void goToKlaimGlass() {		
		SubMenuReimbursement.get(1).click();
	}
	
	public void gotoDetailKlaim() {
		btnEdit.get(0).click();
	}
	
	public void ajukanKlaimAsuransi() {
		btnAjukan.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void approveKlaimAsuransi() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnApprove.click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		txtJumlahClaim.sendKeys(txtJumlahClaimBefore.getAttribute("value"));
		txtReason.sendKeys("Test Alasan");
		//btnSubmit.click();
	}
	
	public void ajukanKlaimGlass() {
		btnAjukanGlass.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void approveKlaimGlass() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		btnApprove.click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtJumlahClaim.sendKeys(txtJumlahClaimBefore.getAttribute("value"));
		
		//Actions actions = new Actions(driver);
    	//actions.moveToElement(txtReason).perform();
		//txtReason.click();
		txtReasonGlass.get(1).sendKeys("Test Alasan");
		//btnSubmit.click();
	}
	
}
