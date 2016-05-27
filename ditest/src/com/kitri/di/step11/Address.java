package com.kitri.di.step11;

public class Address {
	private String zip;
	private String address;
	private String detailAddress;
	
	
	
	public Address() {
		super();
	}

	public Address(String zip, String address, String detailAddress) {
		super();
		this.zip = zip;
		this.address = address;
		this.detailAddress = detailAddress;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}


	@Override
	public String toString() {
		return "ÁÖ¼Ò : " + zip + "  " + address + "  " + detailAddress;
	}
}
