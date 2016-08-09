package com.amudhan.caveatemptor.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	private UserType userType;
	private Set<Item> sellingItems;
	private Set<Bid> bids;
	private Set<Address> addressess;
	private Set<BillingDetails> billingDetails; 
	
	public enum UserType{ SELLER, BUYER, ADMIN}
	
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
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Set<Item> getSellingItems() {
		return sellingItems;
	}
	public void setSellingItems(Set<Item> sellingItems) {
		this.sellingItems = sellingItems;
	}
	public Set<Bid> getBids() {
		return bids;
	}
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	public Set<Address> getAddressess() {
		return addressess;
	}
	public void setAddressess(Set<Address> addressess) {
		this.addressess = addressess;
	}
	public Set<BillingDetails> getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(Set<BillingDetails> billingDetails) {
		this.billingDetails = billingDetails;
	}
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

}
