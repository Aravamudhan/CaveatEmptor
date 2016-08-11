package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Item;

public interface ItemDao{
	/**
	 * Read operations
	 * **/
	public List<Item> getItems();
	public Item getItem(long id);
}
