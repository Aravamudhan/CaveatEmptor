package com.amudhan.caveatemptor.test.dao;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.entity.Address.AddressType;
import com.amudhan.caveatemptor.entity.BankAccount;
import com.amudhan.caveatemptor.entity.CreditCard;
import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.Name;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.test.DaoTest;

public class UserDaoTest extends DaoTest {

	@Inject
	private UserDao userDao;
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	/*Common method that returns a fully initialized User*/
	public User getUser(){
		User user = new User();
		Name name = new Name();
		name.setFirstName(randomStringGenerator.randomString());
		name.setLastName(randomStringGenerator.randomString());
		user.setName(name);
		/*Address:Billing*/
		Address billingAddress = new Address();
		billingAddress.setAddressType(AddressType.BILLING);
		billingAddress.setBuilding("No.56,Galaxy Apartment");
		billingAddress.setStreet("Express avenue");
		billingAddress.setZipCode("878987");
		billingAddress.setCity("Chennai");
		billingAddress.setUser(user);
		/*Address:Shipping*/
		Address shippingAddress = new Address();
		shippingAddress.setAddressType(AddressType.SHIPPING);
		shippingAddress.setBuilding("MaxBeat info city");
		shippingAddress.setStreet("Prexit street");
		shippingAddress.setZipCode("878983");
		shippingAddress.setCity("Chennai");
		shippingAddress.setUser(user);
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(shippingAddress);
		addresses.add(billingAddress);
		user.setAddresses(addresses);
		/*Image*/
		Image image = new Image();
		image.setImageUrl("/resources/images/tshirt");
		image.setName("Cotton T Shirt");
		Set<Image> images = new HashSet<Image>();
		images.add(image);
		/*Item with images, seller*/
		Set<Item> sellingItems = new HashSet<Item>();
		Item item = new Item();
		item.setName("Cotton T Shirt");
		item.setDescription("Smooth and pure cotton t shirt");
		item.setInitialPrice(new BigDecimal(300));
		item.setSeller(user);
		item.setImages(images);
		sellingItems.add(item);
		image.setItem(item);
		user.setSellingItems(sellingItems);
		/*CreditCard*/
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardNumber("787587837878387");
		creditCard.setEmpiryYear("23");
		creditCard.setExpiryMonth("10");
		creditCard.setOwner(user);
		Set<CreditCard> creditCards = new HashSet<CreditCard>();
		creditCards.add(creditCard);
		user.setCreditCards(creditCards);
		/*BankAccount*/
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber("84928293829");
		bankAccount.setBankName("ABC Bank");
		bankAccount.setOwner(user);
		Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
		bankAccounts.add(bankAccount);
		user.setBankAccounts(bankAccounts);
		return user;
	}
	/*User test*/
	public boolean checkPersistedUser(User persistedUser){
		Assert.assertNotNull(persistedUser);
		Assert.assertNotNull(persistedUser.getAddresses());
		Assert.assertNotNull(persistedUser.getBankAccounts());
		Assert.assertNotNull(persistedUser.getCreditCards());
		Assert.assertNotNull(persistedUser.getSellingItems());
		logger.info("Details for the user: "+persistedUser.getName().getFirstName()+" "+
				persistedUser.getName().getLastName()+" ID"+persistedUser.getId()+" Usertype: "+persistedUser.getUserType());
		logger.info("Bank account details");
		for(BankAccount bankAccountFromDataSource : persistedUser.getBankAccounts()){
			logger.info("Account number: "+bankAccountFromDataSource.getAccountNumber()+" Bank name: "+
							bankAccountFromDataSource.getBankName()+" Account ID: "+bankAccountFromDataSource.getId()+" Ownder ID"+bankAccountFromDataSource.getOwner().getId());
		}
		logger.info("Credit card details");
		for(CreditCard creditCardFromDataSource : persistedUser.getCreditCards()){
			logger.info("Credit card number: "+creditCardFromDataSource.getCreditCardNumber()+" Expiry year"+creditCardFromDataSource.getEmpiryYear()+
					" Expiry month: "+creditCardFromDataSource.getExpiryMonth()+" Owner ID"+creditCardFromDataSource.getOwner().getId());
		}
		for(Address addressFromDataSource : persistedUser.getAddresses()){
			logger.info("Address ID: "+addressFromDataSource.getId()+" Address type:  "+addressFromDataSource.getAddressType() +
					 " Owner ID"+addressFromDataSource.getUser().getId());
		}
		return true;
	}
	/*TC1: Create seller"*/
	@Test
	public void createSeller(){
		User seller = getUser();
		seller.setUserType(UserType.SELLER);
		/*
		 * CascadeType is ALL. Address, BankAccount, CreditCard, Item, Image are all persisted along with User.
		 * */
		userDao.persist(seller);
		//entityManager.flush();
		
		User persistedUser = userDao.getUser(seller.getId());
		checkPersistedUser(persistedUser);
	}
	/*TC2: Remove seller*/
	@Test
	public void createBuyer(){
		User buyer = getUser();
		buyer.setUserType(UserType.BUYER);
		userDao.persist(buyer);
		User persistedUser = userDao.getUser(buyer.getId());
		checkPersistedUser(persistedUser);
	}
	
}
