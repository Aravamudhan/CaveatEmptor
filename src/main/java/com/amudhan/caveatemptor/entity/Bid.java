package com.amudhan.caveatemptor.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bid {
	private long id;
	private BigDecimal amount;
	private Date createdOn;
	private Item item;
	private User bidder;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getBidder() {
		return bidder;
	}
	public void setBidder(User bidder) {
		this.bidder = bidder;
	}
	public long getId() {
		return id;
	}
}
