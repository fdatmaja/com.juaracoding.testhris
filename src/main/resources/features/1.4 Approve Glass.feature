Feature: Approve Glass HRD

Scenario: Testing Approve Glass HRD
	When Ganti User lalu input username password employee and click login
	And Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata
	And Menampilkan halaman Approve Glass
	And Klik Edit Approve Glass
	And Approve Glass
	Then Data Approve Glass Berhasil diajukan