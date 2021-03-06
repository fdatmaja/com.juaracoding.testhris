package com.juaracoding.testhris.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.testhris.config.AutomationFrameworkConfiguration;
import com.juaracoding.testhris.driver.DriverSingleton;
import com.juaracoding.testhris.page.ApprGlass;
import com.juaracoding.testhris.page.AsuransiEmp;
import com.juaracoding.testhris.page.EntertainmentEmp;
import com.juaracoding.testhris.page.GlassEmp;
import com.juaracoding.testhris.page.LoginEMP;
import com.juaracoding.testhris.page.LoginHRD;
import com.juaracoding.testhris.page.PromotionEmp;
import com.juaracoding.testhris.page.PromotionHistEmp;
import com.juaracoding.testhris.page.ReimbursementHRD;
import com.juaracoding.testhris.utils.ConfigurationProperties;
import com.juaracoding.testhris.utils.Constants;
import com.juaracoding.testhris.utils.GetScreenShot;
import com.juaracoding.testhris.utils.TestCases;
import com.juaracoding.testhris.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	private WebDriver driver;
	private LoginHRD login;
	private AsuransiEmp asuransiEmp;
	private GlassEmp glassEmp;
	private ApprGlass apprGlass;
	private LoginEMP loginEmp;
	private ReimbursementHRD reimbursement;
	private PromotionEmp promotionEmp;
	private PromotionHistEmp promotionHistEmp;
	private EntertainmentEmp entertainmentEmp;
	ExtentTest extentTest;
	TestCases[] tests = TestCases.values();
	static ExtentReports report = new ExtentReports("src/main/resources/HrisTestReport.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		login = new LoginHRD();
		asuransiEmp = new AsuransiEmp();
		glassEmp = new GlassEmp();
		apprGlass = new ApprGlass();
		loginEmp = new LoginEMP();
		reimbursement = new ReimbursementHRD();
		promotionEmp = new PromotionEmp();
		promotionHistEmp = new PromotionHistEmp();
		entertainmentEmp = new EntertainmentEmp();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		
	}
	
	//login emp
	@Given("^User go to the Website Employee")
	public void user_go_to_the_Website_Employee() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL_EMP);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL_EMP);
	}
	
	@When("^User input username password employee and click login")
	public void user_input_username_password_employee_and_click_login() {
		loginEmp.goToLoggedIn(configurationProperties.getEmpUserName(), configurationProperties.getEmpPassword());
		extentTest.log(LogStatus.PASS, "User input username password employee and click login");
	}
	
	@Then("^User go to dashboard employee")
	public void user_go_to_dashboard_employee() throws IOException {
		assertEquals(configurationProperties.getEmpDisplayName(), loginEmp.getTxtDisplayName());
		//extentTest.log(LogStatus.PASS, "User go to dashboard employee");
//		String screenShotPath = GetScreenShot.capture(driver, "screenShotNameEmp");
//		extentTest.log(LogStatus.PASS, "User go to dashboard employee" + extentTest.addScreenCapture(screenShotPath));
	}
	
	//klaim asuransi emp
	@When("^Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata Employee")
	public void drop_down_list_yang_berisi_Klaim_Asuransi_dan_Klaim_Kacamata_employee(){
		asuransiEmp.sideBarAsuransi();
		extentTest.log(LogStatus.PASS, "Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata Employee");
	}
	
	@When("^Menampilkan halaman Klaim Asuransi Employee")
	public void menampilkan_halaman_Klaim_Asuransi_Employee() {
		asuransiEmp.goToKlaimAsuransi();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Klaim Asuransi Employee");
	}
	
	@When("^Cek Filter dan Search Asuransi")
	public void cek_Filter_dan_Search_Asuransi() {
		asuransiEmp.inputFilter();
		asuransiEmp.inputSearch();
		extentTest.log(LogStatus.PASS, "Cek Filter dan Search Asuransi");
	}
	
	@When("^Klik Add Claim Asuransi")
	public void klik_Add_Claim_Asuransi() {
		asuransiEmp.goToAdd();
		extentTest.log(LogStatus.PASS, "Klik Add Claim Asuransi");
	}
	
	@When("^User input nomor nama tanggal nilai klaim asuransi and click submit")
	public void user_input_nomor_nama_tanggal_nilai_klaim_asuransi_and_click_submit() {
		asuransiEmp.inputDataKlaim();
		extentTest.log(LogStatus.PASS, "User input nomor nama tanggal nilai klaim asuransi and click submit");
	}
	
	@When("^User upload dokumen and click kirim")
	public void user_upload_dokumen_and_click_kirim() {
		asuransiEmp.uploadDokumen();
		extentTest.log(LogStatus.PASS, "User upload dokumen and click kirim");
	}
	
	@Then("^Data Pengajuan Klaim Asuransi Berhasil diajukan")
	public void data_Klaim_Pengajuan_Asuransi_Berhasil_diajukan() {
		assertEquals(configurationProperties.getNotifasuransi(), asuransiEmp.getTxthasil());
		extentTest.log(LogStatus.PASS, "Data Pengajuan Klaim Asuransi Berhasil diajukan");
	}
	
	//glass emp
	@When("^Menampilkan halaman Klaim Glass Employee")
	public void menampilkan_halaman_Klaim_Glass_Employee() {
		glassEmp.goToKlaimGlass();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Klaim Glass Employee");
	}
	
	@When("^Cek Next dan Previous Glass")
	public void cek_Next_dan_Previous_Glass() throws IOException {
		glassEmp.kilkNextPrev();
		driver = DriverSingleton.getDriver();
		String screenShotPath = GetScreenShot.capture(driver, "NextAndPreviousGlass");
		extentTest.log(LogStatus.INFO, "Cek Next dan Previous Glass" + extentTest.addScreenCapture(screenShotPath));
	}
	
	@When("^Cek Filter dan Search Glass")
	public void cek_Filter_dan_Search_GLass() {
		//glassEmp.inputView();
		glassEmp.inputSearch();
		extentTest.log(LogStatus.PASS, "Cek Filter dan Search Glass");
	}
	
	@When("^Klik Add Claim Glass")
	public void klik_Add_Claim_Glass() {
		glassEmp.goToAdd();
		extentTest.log(LogStatus.PASS, "Klik Add Claim Glass");
	}
	
	@When("^User input nomor nama tanggal nilai klaim glass and click submit")
	public void user_input_nomor_nama_tanggal_nilai_klaim_glass_and_click_submit() {
		glassEmp.inputDataKlaim();
		extentTest.log(LogStatus.PASS, "User input nomor nama tanggal nilai klaim glass and click submit");
	}
	
	@When("^User upload dokumen glass and click kirim")
	public void user_upload_dokumen_glass_and_click_kirim() {
		glassEmp.uploadDokumen();
		extentTest.log(LogStatus.PASS, "User upload dokumen glass and click kirim");
	}
	
	@Then("^Data Pengajuan Klaim glass Berhasil diajukan")
	public void data_Klaim_Pengajuan_Glass_Berhasil_diajukan() {
		assertEquals(configurationProperties.getNotifglass(), glassEmp.getTxthasil());
		extentTest.log(LogStatus.PASS, "Data Pengajuan Klaim glass Berhasil diajukan");
	}
	
	//approve glass
	@When("^Ganti User lalu input username password employee and click login")
	public void ganti_user_lalu_user_input_username_password_employee_and_click_login() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		loginEmp.logOut();
		loginEmp.goToLoggedIn(configurationProperties.getLeadUserName(), configurationProperties.getLeadPassword());
		extentTest.log(LogStatus.PASS, "Ganti User lalu User input username password employee and click login");
	}
	
	@When("^Menampilkan halaman Approve Glass")
	public void menampilkan_halaman_Approve_Glass() {
		apprGlass.sideBarAsuransi();
		apprGlass.goToApproveGlass();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Approve Glass");
	}
	
	
	@When("^Cek Filter dan Search Approve Glass")
	public void cek_Filter_dan_Search_Approve_Glass() {
		apprGlass.inputFilter();
		apprGlass.inputSearch();
		extentTest.log(LogStatus.PASS, "Cek Filter dan Search Approve Glass");
	}
	
	@When("^Klik Edit Approve Glass")
	public void klik_Edit_Approve_Glass() {
		apprGlass.goToDetail();
		extentTest.log(LogStatus.PASS, "Klik Edit Approve Glass");
	}
	
	@When("^Approve Glass")
	public void approve_Glass() {
		apprGlass.approveKlaim();
		extentTest.log(LogStatus.PASS, "Approve Glass");
	}
	
	@Then("^Data Approve Glass Berhasil diajukan")
	public void data_Approve_Glass_Berhasil_diajukan() {
		assertEquals(configurationProperties.getNotifasuransi(), apprGlass.getTxthasil());
		extentTest.log(LogStatus.PASS, "Data Approve Glass Berhasil diajukan");
	}
	
	//Entertainment
	@When("^Menampilkan halaman Entertainment Employee")
	public void menampilkan_halaman_Entertainment_Employee() {
		entertainmentEmp.goToKlaimAsuransi();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Entertainment Employee");
	}
	
	@When("^Klik Add Entertainment")
	public void klik_Add_Entertainment() {
		entertainmentEmp.goToAdd();
		extentTest.log(LogStatus.PASS, "Klik Add Entertainment");
	}
	
	// promotion
	@When("^Drop down list yang berisi Promotion dan Promotion History")
	public void drop_down_list_yang_berisi_Promotion_dan_Promotion_History() {
		promotionEmp.sideBar();
		extentTest.log(LogStatus.PASS, "Drop down list yang berisi Promotion dan Promotion History");
	}
	
	@When("^Menampilkan halaman Promotion")
	public void menampilkan_halaman_Promotion() {
		promotionEmp.goToPromotion();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Promotion");
	}
	
	@When("^Cek Next dan Previous")
	public void cek_Next_dan_Previous() throws IOException {
		promotionEmp.kilkNextPrev();
		driver = DriverSingleton.getDriver();
		String screenShotPath = GetScreenShot.capture(driver, "NextAndPrevious");
		extentTest.log(LogStatus.INFO, "Cek Next dan Previous" + extentTest.addScreenCapture(screenShotPath));
	}
	
	@When("^Cek Filter dan Search")
	public void cek_Filter_dan_Search() {
		promotionEmp.inputView();
		promotionEmp.inputSearch();
		extentTest.log(LogStatus.PASS, "Cek Filter dan Search");
	}
	
	@When("^Klik Add Promotion")
	public void klik_Add_Promotion() {
		promotionEmp.goToAdd();
		extentTest.log(LogStatus.PASS, "Klik Add Promotion");
	}
	
	@When("^Cek tombol fungsi view tujuan")
	public void cek_tombol_fungsi_view_tujuan() {
		promotionEmp.inputViewTujuan();
		extentTest.log(LogStatus.PASS, "Cek tombol fungsi view tujuan");
	}
	
	@When("^Cek tombol fungsi view identitas")
	public void cek_tombol_fungsi_view_identitas() {
		promotionEmp.inputViewIdentitas();
		extentTest.log(LogStatus.PASS, "Cek tombol fungsi view identitas");
	}
	
	@When("^Input nik")
	public void input_nik() {
		promotionEmp.selectNik();
		extentTest.log(LogStatus.PASS, "Input nik");
	}
	
	//promotion hist
	@When("^Menampilkan halaman Promotion History")
	public void menampilkan_halaman_Promotion_History() {
		promotionHistEmp.goToPromotionHist();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Promotion History");
	}
	
	@When("^Cek Next dan Previous History")
	public void cek_Next_dan_Previous_History() throws IOException {
		promotionHistEmp.kilkNextPrev();
		driver = DriverSingleton.getDriver();
		String screenShotPath = GetScreenShot.capture(driver, "NextAndPreviousHistory");
		extentTest.log(LogStatus.INFO, "Cek Next dan Previous History" + extentTest.addScreenCapture(screenShotPath));
	}
	
	@When("^Cek Filter dan Search History")
	public void cek_Filter_dan_Search_History() {
		promotionHistEmp.inputFilter();
		promotionHistEmp.inputSearch();
		extentTest.log(LogStatus.PASS, "Cek Filter dan Search History");
	}
	
	// login HRD
	@Given("^User go to the Website")
	public void user_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL_HRD);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL_HRD);
	}
	
	@When("^User input username password and click login")
	public void user_input_username_password_and_click_login() {
		login.goToLoggedIn(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username password and click login");
	}
	
	@Then("^User go to dashboard")
	public void user_go_to_dashboard() throws IOException {
		assertEquals(configurationProperties.getDisplayName(), login.getTxtDisplayName());
		extentTest.log(LogStatus.PASS, "User go to dashboard");
//		String screenShotPath = Utils.capture(driver, "screenShotName");
//		extentTest.log(LogStatus.PASS, "User go to dashboard" + extentTest.addScreenCapture(screenShotPath));
	}
	
	
	//Klaim Asuransi HRD
	@When("^Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata")
	public void drop_down_list_yang_berisi_Klaim_Asuransi_dan_Klaim_Kacamata() {
		reimbursement.sideBarAsuransi();
		extentTest.log(LogStatus.PASS, "Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata");
	}
	
	@When("^Menampilkan halaman Klaim Asuransi")
	public void menampilkan_halaman_Klaim_Asuransi() {
		reimbursement.goToKlaimAsuransi();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Klaim Asuransi");
	}
	
	@When("^Klik Edit Klaim Asuransi")
	public void klik_Edit_Klaim_Asuransi() {
		reimbursement.gotoDetailKlaim();
		reimbursement.ajukanKlaimAsuransi();
		extentTest.log(LogStatus.PASS, "Klik Edit Klaim Asuransi");
	}
	
	@When("^Approve Klaim Asuransi")
	public void approve_Klaim_Asuransi() {
		reimbursement.approveKlaimAsuransi();
		extentTest.log(LogStatus.PASS, "Approve Klaim Asuransi");
	}
	
	@Then("^Data Klaim Asuransi Berhasil diajukan")
	public void data_Klaim_Asuransi_Berhasil_diajukan() {
		assertEquals(configurationProperties.getNotifklaim(), reimbursement.getTxthasil());
		extentTest.log(LogStatus.PASS, "Data Klaim Asuransi Berhasil diajukan");
	}
	
	//Klaim Glass HRD
	@When("^Menampilkan halaman Klaim Glass")
	public void menampilkan_halaman_Klaim_Glass() {
		reimbursement.goToKlaimGlass();
		extentTest.log(LogStatus.PASS, "Menampilkan halaman Klaim Glass");
	}
	
	@When("^Klik Edit Klaim Glass")
	public void klik_Edit_Klaim_Glass() {
		reimbursement.gotoDetailKlaim();
		reimbursement.ajukanKlaimGlass();
		extentTest.log(LogStatus.PASS, "Klik Edit Klaim Glass");
	}
	
	@When("^Approve Klaim Glass")
	public void approve_Klaim_Glass() {
		reimbursement.approveKlaimGlass();
		extentTest.log(LogStatus.PASS, "Approve Klaim Glass");
	}
	
	@Then("^Data Klaim Glass Berhasil diajukan")
	public void data_Klaim_Glass_Berhasil_diajukan() {
		assertEquals(configurationProperties.getNotifklaim(), reimbursement.getTxthasil());
		extentTest.log(LogStatus.PASS, "Data Klaim Glass Berhasil diajukan");
	}
	
	@After
	public void closeObject() {
		Utils.testCount++;
		report.endTest(extentTest);
		report.flush();
	}
}
