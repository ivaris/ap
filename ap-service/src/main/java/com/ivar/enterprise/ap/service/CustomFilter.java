package com.ivar.enterprise.ap.service;

public class CustomFilter {
	private String key;
	private Object value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public CustomFilter(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
