package com.amudhan.caveatemptor.entity;

import javax.persistence.Entity;

@Entity
public class CreditCard extends BillingDetails {
	private String number;
	private String expiryMonth;
	private String expiryYear;
	private final BillingDetails.BillingType billingType = BillingDetails.BillingType.CREDITCARD;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getEmpiryYear() {
		return expiryYear;
	}
	public void setEmpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public BillingDetails.BillingType getBillingType() {
		return billingType;
	}
}
