package com.amudhan.caveatemptor.entity;

import java.util.Set;

public class Category {
	private long id;
	private String name;
	private Set<Category> parentCategories;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Category> getParentCategories() {
		return parentCategories;
	}
	public void setParentCategories(Set<Category> parentCategories) {
		this.parentCategories = parentCategories;
	}
	public long getId() {
		return id;
	}
}
