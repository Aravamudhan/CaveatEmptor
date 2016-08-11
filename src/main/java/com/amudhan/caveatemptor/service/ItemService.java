package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.Item;

public interface ItemService {
	public Item getItem(long id);
	public List<Item> getItems();
	
}
