package com.juaracoding.testhris.utils;

public enum TestCases {

	T1("Testing Login Employee Account"),
	T2("Testing Klaim Asuransi Employee"),
	T3("Testing Klaim Glass Employee"),
	T4("Testing Approve Glass Employee"),
	T5("Testing Entertainment Employee"),
	T6("Testing Promotion Employee"),
	T7("Testing Promotion History Employee"),
	T8("Testing Login HRD Account"),
	T9("Testing Klaim Asuransi HRD"),
	T10("Testing Klaim Glass HRD");
	
	private String testName;	

	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
