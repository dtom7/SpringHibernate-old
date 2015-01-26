package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="ADDRESS_TYPE", length=10)
	private String addressType;
	@Column(name="FULL_ADDRESS")
	private String fullAddress;
	
	public Address() {}
	
	public Address(String addressType, String fullAddress) {
		super();
		this.addressType = addressType;
		this.fullAddress = fullAddress;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

}
