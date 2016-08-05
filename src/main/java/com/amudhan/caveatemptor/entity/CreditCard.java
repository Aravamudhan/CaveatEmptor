package com.amudhan.caveatemptor.entity;

public class CreditCard extends BillingDetails {
	private String number;
	private String expiryMonth;
	private String empiryYear;
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
		return empiryYear;
	}
	public void setEmpiryYear(String empiryYear) {
		this.empiryYear = empiryYear;
	}
	public BillingDetails.BillingType getBillingType() {
		return billingType;
	}
}
