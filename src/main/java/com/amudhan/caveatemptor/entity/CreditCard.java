package com.amudhan.caveatemptor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.amudhan.caveatemptor.constant.CreditCardQueries;

@NamedQueries({
	@NamedQuery(name=CreditCardQueries.GETALLCREDITCARDS, query=CreditCardQueries.GETALLCREDITCARDS_Q)
})
@Entity
@Table(name="creditcard")
public class CreditCard extends BillingDetails{
	@Column(name="creditcardnumber")
	private String creditCardNumber;
	@Column(name="expirymonth")
	private String expiryMonth;
	@Column(name="expiryyear")
	private String expiryYear;
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
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
}
