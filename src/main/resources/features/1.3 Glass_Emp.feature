Feature: Klaim Glass Employee

Scenario: Testing Klaim Glass Employee
	When Drop down list yang berisi Klaim Asuransi dan Klaim Kacamata Employee
	And Menampilkan halaman Klaim Glass Employee
	And Cek Next dan Previous Glass
	And Cek Filter dan Search Glass
	And Klik Add Claim Glass
	And User input nomor nama tanggal nilai klaim glass and click submit
	And User upload dokumen glass and click kirim
	Then Data Pengajuan Klaim glass Berhasil diajukan