package com.amudhan.caveatemptor.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.dao.CreditCardDao;
import com.amudhan.caveatemptor.entity.CreditCard;

@Repository
public class CreditCardDaoImpl implements CreditCardDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void persist(CreditCard creditCard) {
		entityManager.persist(creditCard);
	}

	@Override
	public void remove(CreditCard creditCard) {
		entityManager.remove(creditCard);
	}

}
