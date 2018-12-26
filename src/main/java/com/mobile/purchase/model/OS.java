package com.mobile.purchase.model;

import org.springframework.stereotype.Component;

public class OS {
	
	private String  name;
	private String version;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
