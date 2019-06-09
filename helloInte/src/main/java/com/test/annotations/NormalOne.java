package com.test.annotations;

public class NormalOne {
	@MyNotNull
	private String address;

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}