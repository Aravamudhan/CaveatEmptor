package com.amudhan.caveatemptor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name="bankaccount")
public class BankAccount extends BillingDetails {
	@Column(name="accountnumber")
	@NotNull
	private String accountNumber;
	@Column(name="bankname")
	@NotNull
	private String bankName;
	
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
}	
