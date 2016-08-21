package com.amudhan.caveatemptor.test.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.test.DaoTest;
import com.amudhan.caveatemptor.test.common.Entities;
import com.amudhan.caveatemptor.test.common.Validator;

public class ItemDaoTest extends DaoTest {
	
	@Inject
	private ItemDao	itemDao;
	@Inject
	private UserDao userDao;
	@Inject
	private Entities entities;
	@Inject
	private Validator validator;

	/*TC5: Create Item*/
	@Test
	public void createItem(){
		/*A User is necessary for the creation of an item*/
		User seller = entities.getSeller();
		Item item = entities.getItem();
		Bid bid = entities.getBid();
		bid.setItem(item);
		bid.setBidder(entities.getBuyer());
		Image image = entities.getImage();
		image.setItem(item);
		item.setSeller(seller);
		Set<Image> images = new HashSet<Image>();
		images.add(image);
		item.setImages(images);
		Set<Bid> bids = new HashSet<Bid>();
		item.setBids(bids);
		seller.getSellingItems().add(item);
		userDao.persist(seller);
		entityManager.flush();
		Item persistedItem = itemDao.getItem(item.getId());
		validator.checkPersistedItem(persistedItem);
	}
	/*TC6: Create multiple items*/
	@Test
	public void createMultipleItems(){
		User seller = entities.getSeller();
		Item itemOne = entities.getItem();
		Item itemTwo = entities.getItem();
		Bid bidOne = entities.getBid();
		bidOne.setItem(itemOne);
		bidOne.setBidder(entities.getBuyer());
		Image imageOne = entities.getImage();
		imageOne.setItem(itemOne);
		itemOne.setSeller(seller);
		Set<Image> images = new HashSet<Image>();
		images.add(imageOne);
		itemOne.setImages(images);
		Set<Bid> bidsOne = new HashSet<Bid>();
		itemOne.setBids(bidsOne);
		Bid bidTwo = entities.getBid();
		bidTwo.setItem(itemTwo);
		bidTwo.setBidder(entities.getBuyer());
		Image imageTwo = entities.getImage();
		imageTwo.setItem(itemTwo);
		itemTwo.setSeller(seller);
		Set<Image> imagesTwo = new HashSet<Image>();
		images.add(imageTwo);
		itemTwo.setImages(imagesTwo);
		Set<Bid> bidsTwo = new HashSet<Bid>();
		itemTwo.setBids(bidsTwo);
		seller.getSellingItems().add(itemOne);
		seller.getSellingItems().add(itemTwo);
		userDao.persist(seller);
		entityManager.flush();
		Item persistedItemOne = itemDao.getItem(itemOne.getId());
		Item persistedItemTwo = itemDao.getItem(itemTwo.getId());
		validator.checkPersistedItem(persistedItemOne);
		validator.checkPersistedItem(persistedItemTwo);
	}
	/*TC7: Remove Item*/
	@Test
	public void removeItem(){
		User seller = entities.getSeller();
		Item item = seller.getSellingItems().iterator().next();
		userDao.persist(seller);
		entityManager.flush();
		List<Long> bidIds = new ArrayList<Long>();
		for(Bid bid : item.getBids()){
			bidIds.add(bid.getId());
		}
		List<Long> imageIds = new ArrayList<Long>();
		for(Image image : item.getImages()){
			imageIds.add(image.getId());
		}
		itemDao.remove(item);
		entityManager.flush();
	    validator.checkRemovedItem(item.getId());
		for(long id : bidIds){
			validator.checkRemovedBid(id);
		}
		for(Bid bid : item.getBids()){
			validator.checkRemovedBid(bid.getId());
		}
		for(long id : imageIds){
			validator.checkRemovedImage(id);
		}
	}
	/*TC8: Remove all items*/
	@Test
	public void removeAllItems(){
		
	}
	
}
