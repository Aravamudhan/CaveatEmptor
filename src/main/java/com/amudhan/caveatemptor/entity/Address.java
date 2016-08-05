package com.amudhan.caveatemptor.entity;

public class Address {
	private long id;
	private String building;
	private String street;
	private String zipcode;
	private String city;
	private AddressType addressType;
	
	public enum AddressType{ HOME, BILLING, SHIPPING}
	
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public long getId() {
		return id;
	}
}
