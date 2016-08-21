package com.amudhan.caveatemptor.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.entity.BankAccount;
import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.entity.CreditCard;
import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.test.DaoTest;
import com.amudhan.caveatemptor.test.common.Entities;
import com.amudhan.caveatemptor.test.common.Validator;

public class UserDaoTest extends DaoTest {

	@Inject
	private UserDao userDao;
	@Inject
	private Entities entities;
	@Inject
	private Validator validator;
	
	/*TC1: Create seller"*/
	@Test
	public void createSeller(){
		User seller = entities.getSeller();
		/*
		 * CascadeType is ALL. Address, BankAccount, CreditCard, Item, Image are all persisted along with User.
		 * 
		 * */
		userDao.persist(seller);
		entityManager.flush();
		User persistedUser = userDao.getUser(seller.getId());
		validator.checkPersistedSeller(persistedUser);
	}
	/*TC2: Remove seller*/
	@Test
	public void removeSeller(){
		User seller = entities.getSeller();
		userDao.persist(seller);
		entityManager.persist(seller);
		entityManager.flush();
		User persistedUser = userDao.getUser(seller.getId());
		boolean persisted = validator.checkPersistedSeller(persistedUser);
		List<Long> addressIds = new ArrayList<Long>();
		for(Address address : persistedUser.getAddresses()){
			addressIds.add(address.getId());
		}
		List<Long> itemIds = new ArrayList<Long>();
		List<Long> imageIds = new ArrayList<Long>();
		List<Long> bidIds = new ArrayList<Long>();
		for(Item item : persistedUser.getSellingItems()){
			itemIds.add(item.getId());
			for(Image image : item.getImages()){
				imageIds.add(image.getId());
			}
			for(Bid bid : item.getBids()){
				bidIds.add(bid.getId());
			}
		}
		List<Long> creditCardIds = new ArrayList<Long>();
		for(CreditCard creditCard : seller.getCreditCards()){
			creditCardIds.add(creditCard.getId());
		}
		List<Long> bankAccountIds = new ArrayList<Long>();
		for(BankAccount bankAccount : seller.getBankAccounts()){
			bankAccountIds.add(bankAccount.getId());
		}
		if(persisted){
			userDao.remove(seller);
			entityManager.flush();
			validator.checkRemovedUser(persistedUser.getId());
			for(long id : addressIds){
				validator.checkRemovedAddress(id);
			}
			for(long id : itemIds){
				validator.checkRemovedItem(id);
			}
			for(long id : imageIds){
				validator.checkRemovedImage(id);
			}
			for(long id : creditCardIds){
				validator.checkRemovedCreditCard(id);
			}
			for(long id : bankAccountIds){
				validator.checkRemovedBankAccount(id);
			}
			for(long id : bidIds){
				validator.checkRemovedBid(id);
			}
		}
	}
	/*TC3: Create buyer*/
	@Test
	public void createBuyer(){
		User buyer = entities.getBuyer();
		buyer.setUserType(UserType.BUYER);
		userDao.persist(buyer);
		entityManager.flush();
		User persistedUser = userDao.getUser(buyer.getId());
		validator.checkPersistedBuyer(persistedUser);
	}
	/*TC4: Remove buyer*/
	@Test
	public void removeBuyer(){
		User buyer = entities.getBuyer();
		userDao.persist(buyer);
		entityManager.persist(buyer);
		entityManager.flush();
		User persistedUser = userDao.getUser(buyer.getId());
		boolean persisted = validator.checkPersistedBuyer(persistedUser);
		List<Long> addressIds = new ArrayList<Long>();
		for(Address address : persistedUser.getAddresses()){
			addressIds.add(address.getId());
		}
		List<Long> bidIds = new ArrayList<Long>();
		for(Bid bid : buyer.getBids()){
			bidIds.add(bid.getId());
		}
		List<Long> creditCardIds = new ArrayList<Long>();
		for(CreditCard creditCard : buyer.getCreditCards()){
			creditCardIds.add(creditCard.getId());
		}
		List<Long> bankAccountIds = new ArrayList<Long>();
		for(BankAccount bankAccount : buyer.getBankAccounts()){
			bankAccountIds.add(bankAccount.getId());
		}
		if(persisted){
			userDao.remove(buyer);
			entityManager.flush();
			validator.checkRemovedUser(persistedUser.getId());
			for(long id : addressIds){
				validator.checkRemovedAddress(id);
			}
			for(long id : bidIds){
				validator.checkRemovedBid(id);
			}
			for(long id : creditCardIds){
				validator.checkRemovedCreditCard(id);
			}
			for(long id : bankAccountIds){
				validator.checkRemovedBankAccount(id);
			}
		}
	}

}
