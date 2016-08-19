package com.amudhan.caveatemptor.test.dao;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.entity.BankAccount;
import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.entity.CreditCard;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.test.DaoTest;
import com.amudhan.caveatemptor.test.common.Entities;

public class UserDaoTest extends DaoTest {

	@Inject
	private UserDao userDao;
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private final Entities entities = new Entities();
	/*User test*/
	public boolean checkPersistedSeller(User persistedUser){
		Assert.assertNotNull(persistedUser);
		logger.info("Details for the user: "+persistedUser.getName().getFirstName()+" "+
				persistedUser.getName().getLastName()+" ID"+persistedUser.getId()+" Usertype: "+persistedUser.getUserType());
		Assert.assertNotNull(persistedUser.getAddresses());
		for(Address address : persistedUser.getAddresses()){
			Assert.assertNotNull(address);
			Assert.assertNotNull(address.getUser());
			logger.info("Address details");
			Assert.assertEquals(address.getUser().getId(), persistedUser.getId());
			logger.info("Address ID: "+address.getId()+" Address type:  "+address.getAddressType() +
					 " Owner ID"+address.getUser().getId());
		}
		Assert.assertNotNull(persistedUser.getCreditCards());
		for(CreditCard creditCard : persistedUser.getCreditCards()){
			Assert.assertNotNull(creditCard);
			Assert.assertEquals(creditCard.getOwner().getId(), persistedUser.getId());
			logger.info("Credit card details");
			logger.info("Credit card number: "+creditCard.getCreditCardNumber()+" Expiry year"+creditCard.getExpiryYear()+
					" Expiry month: "+creditCard.getExpiryMonth()+" Owner ID"+creditCard.getOwner().getId());
		}
		Assert.assertNotNull(persistedUser.getBankAccounts());
		for(BankAccount bankAccount : persistedUser.getBankAccounts()){
			Assert.assertNotNull(bankAccount);
			Assert.assertEquals(bankAccount.getOwner().getId(), persistedUser.getId());
			logger.info("Bank account details");
			logger.info("Account number: "+bankAccount.getAccountNumber()+" Bank name: "+
					bankAccount.getBankName()+" Account ID: "+bankAccount.getId()+" Ownder ID"+bankAccount.getOwner().getId());
		}
		Assert.assertNotNull(persistedUser.getSellingItems());
		for(Item item : persistedUser.getSellingItems()){
			Assert.assertNotNull(item);
			Assert.assertNotNull(item.getImages());
			Assert.assertNotNull(item.getCategory());
			Assert.assertEquals(item.getSeller().getId(), persistedUser.getId());
		}
		Assert.assertNull(persistedUser.getBids());
		return true;
	}
	public boolean checkPersistedBuyer(User persistedUser){
		Assert.assertNotNull(persistedUser);
		logger.info("Details for the user: "+persistedUser.getName().getFirstName()+" "+
				persistedUser.getName().getLastName()+" ID"+persistedUser.getId()+" Usertype: "+persistedUser.getUserType());
		Assert.assertNotNull(persistedUser.getAddresses());
		for(Address address : persistedUser.getAddresses()){
			Assert.assertNotNull(address);
			Assert.assertNotNull(address.getUser());
			logger.info("Address details");
			Assert.assertEquals(address.getUser().getId(), persistedUser.getId());
			logger.info("Address ID: "+address.getId()+" Address type:  "+address.getAddressType() +
					 " Owner ID"+address.getUser().getId());
		}
		Assert.assertNotNull(persistedUser.getCreditCards());
		for(CreditCard creditCard : persistedUser.getCreditCards()){
			Assert.assertNotNull(creditCard);
			Assert.assertEquals(creditCard.getOwner().getId(), persistedUser.getId());
			logger.info("Credit card details");
			logger.info("Credit card number: "+creditCard.getCreditCardNumber()+" Expiry year"+creditCard.getExpiryYear()+
					" Expiry month: "+creditCard.getExpiryMonth()+" Owner ID"+creditCard.getOwner().getId());
		}
		Assert.assertNotNull(persistedUser.getBankAccounts());
		for(BankAccount bankAccount : persistedUser.getBankAccounts()){
			Assert.assertNotNull(bankAccount);
			Assert.assertEquals(bankAccount.getOwner().getId(), persistedUser.getId());
			logger.info("Bank account details");
			logger.info("Account number: "+bankAccount.getAccountNumber()+" Bank name: "+
					bankAccount.getBankName()+" Account ID: "+bankAccount.getId()+" Ownder ID"+bankAccount.getOwner().getId());
		}
		Assert.assertNotNull(persistedUser.getBids());
		for(Bid bid : persistedUser.getBids()){
			Assert.assertNotNull(bid);
			Assert.assertEquals(bid.getBidder().getId(), persistedUser.getId());
			/*logger.info("Bid details");
			logger.info(bid.getId()+" "+bid.getItem().getName());*/
		}
		Assert.assertNull(persistedUser.getSellingItems());
		return true;
	}
	
	/*TC1: Create seller"*/
	//TODO: Check the generated queries.
	@Test
	public void createSeller(){
		User seller = entities.getSeller();
		/*
		 * CascadeType is ALL. Address, BankAccount, CreditCard, Item, Image are all persisted along with User.
		 * 
		 * */
		userDao.persist(seller);
		User persistedUser = userDao.getUser(seller.getId());
		checkPersistedSeller(persistedUser);
	}
	/*TC3: Remove seller*/
	@Test
	public void createBuyer(){
		User buyer = entities.getBuyer();
		buyer.setUserType(UserType.BUYER);
		userDao.persist(buyer);
		User persistedUser = userDao.getUser(buyer.getId());
		checkPersistedBuyer(persistedUser);
	}
}
