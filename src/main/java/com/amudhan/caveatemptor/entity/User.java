package com.amudhan.caveatemptor.entity;

import java.util.Map;
import java.util.Set;

public class User {
	private long id;
	private String firstName;
	private String lastName;
	private Set<Item> sellingItems;
	private Set<Bid> biddingItems;
	private Map<Address.AddressType, Address> address;
	private Map<BillingDetails.BillingType, BillingDetails> billingDetails; 
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Item> getSellingItems() {
		return sellingItems;
	}
	public void setSellingItems(Set<Item> sellingItems) {
		this.sellingItems = sellingItems;
	}
	public Set<Bid> getBiddingItems() {
		return biddingItems;
	}
	public void setBiddingItems(Set<Bid> biddingItems) {
		this.biddingItems = biddingItems;
	}
	public Map<Address.AddressType, Address> getAddress() {
		return address;
	}
	public void setAddress(Map<Address.AddressType, Address> address) {
		this.address = address;
	}
	public Map<BillingDetails.BillingType, BillingDetails> getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(Map<BillingDetails.BillingType, BillingDetails> billingDetails) {
		this.billingDetails = billingDetails;
	}
	public long getId() {
		return id;
	}

}
