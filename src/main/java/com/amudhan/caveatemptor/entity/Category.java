package com.amudhan.caveatemptor.entity;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Category {
	private long id;
	private String name;
	private Set<Category> parentCategories;
	private Set<Item> items;
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
	private Set<Item> getItems() {
		return items;
	}
	@SuppressWarnings("unused")
	private void setItems(Set<Item> items) {
		this.items = items;
	}
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
}
