package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(long id) {
		return entityManager.find(Item.class, id);
	}
}
