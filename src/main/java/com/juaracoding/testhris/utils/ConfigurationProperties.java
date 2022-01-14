package com.juaracoding.testhris.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.txt")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String userName;
	
	@Value("${mypassword}")
	private String password;
	
	@Value("${displayname}")
	private String displayName;
	
	@Value("${empusername}")
	private String EmpUserName;
	
	@Value("${emppassword}")
	private String EmpPassword;
	
	@Value("${empdisplayname}")
	private String empDisplayName;
	
	@Value("${leadusername}")
	private String leadUserName;
	
	
	@Value("${leadpassword}")
	private String leadPassword;
	
	@Value("${leaddisplayname}")
	private String leadDisplayName;

	public String getEmpDisplayName() {
		return empDisplayName;
	}

	public String getEmpUserName() {
		return EmpUserName;
	}

	public String getEmpPassword() {
		return EmpPassword;
	}

	public String getBrowser() {
		return browser;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public String getLeadUserName() {
		return leadUserName;
	}

	public String getLeadPassword() {
		return leadPassword;
	}

	public String getLeadDisplayName() {
		return leadDisplayName;
	}
}
