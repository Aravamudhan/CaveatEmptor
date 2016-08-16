package com.amudhan.caveatemptor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.dao.BankAccountDao;
import com.amudhan.caveatemptor.entity.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void persist(BankAccount bankAccount) {
		entityManager.persist(bankAccount);
	}

	@Override
	public void remove(BankAccount bankAccount) {
		entityManager.remove(bankAccount);
	}

}
