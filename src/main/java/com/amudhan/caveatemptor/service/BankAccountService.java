package com.amudhan.caveatemptor.service;

import com.amudhan.caveatemptor.entity.BankAccount;

public interface BankAccountService {
	public void persist(BankAccount bankAccount);
	public void remove(BankAccount bankAccount);
}
