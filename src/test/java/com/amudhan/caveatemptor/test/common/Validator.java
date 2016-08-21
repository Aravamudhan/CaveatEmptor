package com.amudhan.caveatemptor.test.common;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.entity.BankAccount;
import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.entity.Category;
import com.amudhan.caveatemptor.entity.CreditCard;
import com.amudhan.caveatemptor.entity.Image;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.AddressService;
import com.amudhan.caveatemptor.service.BankAccountService;
import com.amudhan.caveatemptor.service.BidService;
import com.amudhan.caveatemptor.service.CategoryService;
import com.amudhan.caveatemptor.service.CreditCardService;
import com.amudhan.caveatemptor.service.ImageService;
import com.amudhan.caveatemptor.service.ItemService;
import com.amudhan.caveatemptor.service.UserService;

public class Validator {
	
	@Inject
	private UserService userService;
	@Inject
	private ItemService itemService;
	@Inject
	private ImageService imageService;
	@Inject
	private AddressService addressService;
	@Inject
	private CreditCardService creditCardService;
	@Inject
	private BankAccountService bankAccountService;
	@Inject
	private CategoryService categoryService;
	@Inject
	private BidService bidService;
	private static final Logger logger = LoggerFactory.getLogger(Validator.class);
	
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
			logger.info("Item details");
			logger.info("Item ID: "+item.getId()+" "+item.getName()+" Category ID "+item.getCategory().getId()+
					" Category name: "+item.getCategory().getName());
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
			logger.info("Bid details");
			logger.info("Bid ID: "+bid.getId()+" "+bid.getItem().getName());
		}
		Assert.assertNull(persistedUser.getSellingItems());
		return true;
	}
	public boolean checkPersistedItem(Item persistedItem){
		Assert.assertNotNull(persistedItem);
		logger.info("Item details: Item ID: "+persistedItem.getId()+" Item name: "+persistedItem.getName());
		User seller = persistedItem.getSeller();
		Assert.assertNotNull(seller);
		logger.info("Seller details: Seller ID: "+seller.getId()+" Seller Name: "+seller.getName());
		Assert.assertNotNull(persistedItem.getBids());
		for(Bid bid : persistedItem.getBids()){
			logger.info("Bid details: Bid ID "+bid.getId()+" Bidder ID: "+bid.getBidder().getId()+" Bidder name: "+
						bid.getBidder().getName());
		}
		Assert.assertNotNull(persistedItem.getImages());
		for(Image image : persistedItem.getImages()){
			logger.info("Image details: Image ID: "+image.getId()+" Image name "+image.getName());
		}
		return true;
	}
	public boolean checkRemovedUser(long id){
		User user = userService.getUser(id);
		Assert.assertNull(user);
		return true;
	}
	public boolean checkRemovedItem(long id){
		Item item = itemService.getItem(id);
		Assert.assertNull(item);
		return true;
	}
	public boolean checkRemovedImage(long id){
		Image image = imageService.getImage(id);
		Assert.assertNull(image);
		return true;
	}
	public boolean checkRemovedAddress(long id)
	{
		Address address = addressService.getAddress(id);
		Assert.assertNull(address);
		return true;
	}
	public boolean checkRemovedCreditCard(long id)
	{
		CreditCard creditCard = creditCardService.getCreditCard(id);
		Assert.assertNull(creditCard);
		return true;
	}
	public boolean checkRemovedBankAccount(long id){
		BankAccount bankAccount = bankAccountService.getBankAccount(id);
		Assert.assertNull(bankAccount);
		return true;
	}
	public boolean checkRemovedCategory(long id){
		Category category = categoryService.getCategory(id);
		Assert.assertNull(category);
		return true;
	}
	public boolean checkRemovedBid(long id){
		Bid bid = bidService.getBid(id);
		Assert.assertNull(bid);
		return true;
	}
}
