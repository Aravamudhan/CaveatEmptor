package com.amudhan.caveatemptor.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.amudhan.caveatemptor.constant.UserQueries;

@NamedQueries({
	@NamedQuery(name=UserQueries.GETALLUSERS, query=UserQueries.GETALLUSERS_Q)
})
/*
 * User - A user can be a seller or a buyer.
 * Name - A value type that represents firstName and lastName.
 * Sellers - One seller can have multiple selling items.
 * Buyers - One buyer can have multiple bids on different items.
 * Address- A user can have multiple addresses with types BILLING and SHIPPING.
 * Billing details - A user can have multiple billing details of types BANKACCOUNT and CREDITCARD.
 * CascadeType.ALL - 
 * */
@Entity
@Table(name="user_details")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_sequence")
	@SequenceGenerator(initialValue= 1, name="user_sequence", allocationSize=1)
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
	@OneToMany(mappedBy="seller", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Item> sellingItems;
	@OneToMany(mappedBy="bidder", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Bid> bids;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses;
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<CreditCard> creditCards; 
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<BankAccount> bankAccounts;
	
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
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<CreditCard> getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	public Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
