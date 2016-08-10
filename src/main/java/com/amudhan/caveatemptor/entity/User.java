package com.amudhan.caveatemptor.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
 * User - A user can be a seller or a buyer.
 * Name - A value type that represents firstName and lastName.
 * Sellers - One seller can have multiple selling items.
 * Buyers - One buyer can have multiple bids on different items.
 * Address- A user can have multiple addresses with types BILLING and SHIPPING.
 * Billing details - A user can have multiple billing details of types BANKACCOUNT and CREDITCARD.
 * */
@Entity(name="user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/*Instead of using @Embedded type, separate String types for firstName, lastName could also be used, 
	 * with direct mapping to their respective columns. Name here is a value type without any persistent identifier.*/
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(	name = "firstName",	column = @Column(name = "firstname", nullable=false)),
			@AttributeOverride(	name = "lastName",	column = @Column(name = "lastname"))
	})
	private Name name;
	@Enumerated(EnumType.STRING)
	@Column(name="usertype")
	@NotNull
	private UserType userType;
	private Set<Item> sellingItems;
	private Set<Bid> bids;
	private Set<Address> addresses;
	private Set<BillingDetails> billingDetails; 
	
	public enum UserType{ SELLER, BUYER, ADMIN}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
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
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddressess(Set<Address> addresses) {
		this.addresses = addresses;
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
