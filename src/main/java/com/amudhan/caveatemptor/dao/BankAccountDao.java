package com.amudhan.caveatemptor.dao;

import com.amudhan.caveatemptor.entity.BankAccount;

public interface BankAccountDao {
	public void persist(BankAccount bankAccount);
	public void remove(BankAccount bankAccount);
}