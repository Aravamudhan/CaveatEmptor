package com.amudhan.caveatemptor.test.dao;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.Name;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.test.DaoTest;

public class ItemDaoTest extends DaoTest {
	
	@Inject
	private ItemDao itemDao;
	@Inject
	private UserDao userDao;
	private static final Logger logger = LoggerFactory.getLogger(ItemDaoTest.class);

	public void createItem(){
		/*A User is necessary for the creation of an item*/
		User seller = new User();
		seller.setUserType(UserType.SELLER);
		Name name = new Name();
		name.setFirstName(randomStringGenerator.randomString());
		name.setLastName(randomStringGenerator.randomString());
		seller.setName(name);
		
		Item item = new Item();
		item.setSeller(seller);
		item.setName(randomStringGenerator.randomString());
		item.setInitialPrice(new BigDecimal(555));
		item.setDescription("A great product");
		
		Set<Item> sellingItems = new HashSet<Item>();
		sellingItems.add(item);
		seller.setSellingItems(sellingItems);
		userDao.persist(seller);
		entityManager.flush();
		
		Item persistedItem = itemDao.getItem(item.getId());
		Assert.assertNotNull(persistedItem);
		User persistedUser = userDao.getUser(persistedItem.getSeller().getId());
		Assert.assertNotNull(persistedUser);
		logger.info("Item details");
		logger.info("Item ID: "+persistedItem.getId()+" Item name: "+item.getName());
		logger.info("Seller ID: "+persistedUser.getId()+" Seller name: "+persistedUser.getName().getFirstName()+" "+
				persistedUser.getName().getLastName());
	}
	
	public void removeItem(){
		User seller = userDao.getUser(10000002);
		logger.info(seller.getId()+" "+seller.getName().getFirstName()+" "+seller.getUserType());
		Item item = new Item();
		item.setSeller(seller);
		item.setName(randomStringGenerator.randomString());
		item.setInitialPrice(new BigDecimal(111));
		item.setDescription("Random product!!");
				
		Set<Item> sellingItems = seller.getSellingItems();
		sellingItems.add(item);
		userDao.merge(seller);
		entityManager.flush();
		/*Checking the existence of items*/
		User persistedSeller = userDao.getUser(10000002);
		for(Item persistedItem : persistedSeller.getSellingItems()){
			Assert.assertNotNull(persistedItem);
		}
		/*removing item*/
		logger.info("Item details -  ID:"+item.getId());
		itemDao.remove(item);
	}
	
}
