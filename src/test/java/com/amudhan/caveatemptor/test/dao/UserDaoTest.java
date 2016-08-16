package com.amudhan.caveatemptor.test.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.entity.Address.AddressType;
import com.amudhan.caveatemptor.entity.Name;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.service.UserService;

@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
@Transactional
public class UserDaoTest /*extends DaoTest*/ {

	@Inject
	private UserDao userDao;
	@Inject
	private ItemDao itemDao;
	@Inject
	private UserService userService;
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Test
	@Transactional
	@Rollback(true)
	public void insertUserWithAllDetails(){
		User user = new User();
		user.setUserType(UserType.SELLER);
		
		Name name = new Name();
		name.setFirstName("TestUserFirstName");
		name.setLastName("TestUserLastName");
		user.setName(name);
		
		Address billingAddress = new Address();
		billingAddress.setAddressType(AddressType.BILLING);
		billingAddress.setBuilding("No.56,Galaxy Apartment");
		billingAddress.setStreet("Express avenue");
		billingAddress.setZipCode("878987");
		billingAddress.setCity("Chennai");
		billingAddress.setUser(user);

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
		
/*		Image image = new Image();
		image.setImageUrl("/resources/images/tshirt");
		image.setName("Cotton T Shirt");
		
		Set<Image> images = new HashSet<Image>();
		images.add(image);
		
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
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardNumber("787587837878387");
		creditCard.setEmpiryYear("23");
		creditCard.setExpiryMonth("10");
		creditCard.setOwner(user);
		
		Set<CreditCard> creditCards = new HashSet<CreditCard>();
		creditCards.add(creditCard);
		user.setCreditCards(creditCards);
		
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber("84928293829");
		bankAccount.setBankName("ABC Bank");
		bankAccount.setOwner(user);
		
		Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
		bankAccounts.add(bankAccount);
		user.setBankAccounts(bankAccounts);*/
		entityManager.persist(user);
		//entityManager.flush();
		//userService.persist(user);
		long userId = user.getId();
		User persistedUser = userDao.getUser(userId);
		Assert.assertEquals(user.getName().getFirstName(), persistedUser.getName().getFirstName());
		logger.info(user.getId()+" " +user.getName().getFirstName());
		for(Address address : addresses){
			logger.info(address.getId()+" "+address.getUser().getName().getFirstName());
		}
		
	}
}
