package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Item;

public interface ItemDao{
	public List<Item> getItems();
	public Item getItem(long id);
	public void persist(Item item);
	public void remove(Item item);
}
