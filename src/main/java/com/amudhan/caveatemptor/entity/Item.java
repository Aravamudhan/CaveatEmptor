package com.amudhan.caveatemptor.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="item")
@SuppressWarnings("unused")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="initialprice", nullable=false)
	private BigDecimal initialPrice;
	@Column(name="auctionstart")
	private Date auctionStart;
	@Column(name="auctionend")
	private Date auctionEnd;
	@Column(name="is_auction_ended")
	private boolean isAuctionEnded;
	@Column(name="is_auction_in_progress")
	private boolean isAuctionInProgress;
	private Set<Image> images;
	private Set<Bid> bids;
	private User seller;
	private Set<Category> categories;
	@Column(name="description")
	private String description;
	
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
	public Date getAuctionEnd() {
		return auctionEnd;
	}
	public void setAuctionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}
	public Date getAuctionStart() {
		return auctionStart;
	}
	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}
	private boolean isAuctionEnded() {
		return isAuctionEnded;
	}
	private void setAuctionEnded(boolean isAuctionEnded) {
		this.isAuctionEnded = isAuctionEnded;
	}
	private boolean isAuctionInProgress() {
		return isAuctionInProgress;
	}
	private void setAuctionInProgress(boolean isAuctionInProgress) {
		this.isAuctionInProgress = isAuctionInProgress;
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
	private Set<Category> getCategories() {
		return categories;
	}
	private void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	
}
