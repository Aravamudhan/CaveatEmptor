package com.amudhan.caveatemptor.entity;

import javax.persistence.Entity;

@Entity
public class BankAccount extends BillingDetails {
	private String accountNumber;
	private String bankName;
	private final BillingDetails.BillingType billingType = BillingDetails.BillingType.BANKACCOUNT;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public BillingDetails.BillingType getBillingType() {
		return billingType;
	}
	
}	
