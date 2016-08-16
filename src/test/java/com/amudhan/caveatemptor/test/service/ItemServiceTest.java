package com.amudhan.caveatemptor.test.service;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.service.ItemService;
import com.amudhan.caveatemptor.test.ServiceTest;


public class ItemServiceTest extends ServiceTest{
	@Inject
	private ItemService itemService;
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceTest.class);
	
	@Test
	void getItem(){
		Item item = itemService.getItem(1);
		Assert.assertNotNull(item);
		Assert.assertEquals(item.getName(), "Kindle e book reader");
		Assert.assertEquals(item.getInitialPrice(), new BigDecimal(6000));
		logger.info(item.getName()+" "+item.getInitialPrice());
	}
}
