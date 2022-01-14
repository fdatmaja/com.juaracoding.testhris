package com.juaracoding.testhris.utils;

public enum TestCases {

	T1("Testing Login Employee Account"),
	T2("Testing Klaim Asuransi Employee"),
	T3("Testing Klaim Glass Employee"),
	T4("Testing Approve Glass Employee"),
	T5("Testing Login HRD Account"),
	T6("Testing Klaim Asuransi HRD"),
	T7("Testing Klaim Glass HRD");
	
	private String testName;	

	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
