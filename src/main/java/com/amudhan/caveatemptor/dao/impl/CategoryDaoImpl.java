package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.dao.CategoryDao;
import com.amudhan.caveatemptor.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Category getCategory(long id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> getCategories() {
		return null;
	}

}
