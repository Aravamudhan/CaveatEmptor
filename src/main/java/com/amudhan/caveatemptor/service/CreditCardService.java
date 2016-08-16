package com.amudhan.caveatemptor.service;

import com.amudhan.caveatemptor.entity.CreditCard;

public interface CreditCardService {
	public void persist(CreditCard creditCard);
	public void remove(CreditCard creditCard);
}
