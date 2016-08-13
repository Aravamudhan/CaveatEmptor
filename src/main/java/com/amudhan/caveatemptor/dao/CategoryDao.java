package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Category;

public interface CategoryDao {
	public List<Category> getCategories();
	public Category getCategory(long id);
}
