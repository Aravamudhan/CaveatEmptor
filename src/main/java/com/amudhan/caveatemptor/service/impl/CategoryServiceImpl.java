package com.amudhan.caveatemptor.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.CategoryDao;
import com.amudhan.caveatemptor.entity.Category;
import com.amudhan.caveatemptor.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDao categoryDao;
	@Override
	public Category getCategory(long id) {
		return categoryDao.getCategory(id);
	}

}
