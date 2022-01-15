Feature: Klaim Glass HRD

Scenario: Testing Klaim Glass HRD
	When Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata
	And Menampilkan halaman Klaim Glass
	And Klik Edit Klaim Glass
	And Approve Klaim Glass
	Then Data Klaim Glass Berhasil diajukan