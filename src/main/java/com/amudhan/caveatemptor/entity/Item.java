package com.amudhan.caveatemptor.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Item {
	private long id;
	private String name;
	private BigDecimal initialPrice;
	private Date auctionStart;
	private Date auctionEnd;
	private Set<Image> images;
	private Set<Bid> bids;
	private User seller;
	private Category category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}
	public Date getAutionEnd() {
		return auctionEnd;
	}
	public void setAutionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}
	public Date getAuctionStart() {
		return auctionStart;
	}
	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	public Set<Bid> getBids() {
		return bids;
	}
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategoryId(Category category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
}
