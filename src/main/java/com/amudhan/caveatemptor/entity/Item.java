package com.amudhan.caveatemptor.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.amudhan.caveatemptor.constant.ItemQueries;

@NamedQueries({
	@NamedQuery(name=ItemQueries.GETALLITEMS, query=ItemQueries.GETALLITEMS_Q)
})
@Entity
@Table(name="item")
public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@OneToMany(mappedBy="item")
	private Set<Image> images;
	@OneToMany(mappedBy="item")
	private Set<Bid> bids;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sellerid")
	private User seller;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryid")
	private Category category;
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
	public boolean isAuctionEnded() {
		return isAuctionEnded;
	}
	public void setAuctionEnded(boolean isAuctionEnded) {
		this.isAuctionEnded = isAuctionEnded;
	}
	public boolean isAuctionInProgress() {
		return isAuctionInProgress;
	}
	public void setAuctionInProgress(boolean isAuctionInProgress) {
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", initialPrice="
				+ initialPrice + ", auctionStart=" + auctionStart
				+ ", auctionEnd=" + auctionEnd + ", isAuctionEnded="
				+ isAuctionEnded + ", isAuctionInProgress="
				+ isAuctionInProgress + ", images=" + images + ", bids=" + bids
				+ ", seller=" + seller + ", category=" + category
				+ ", description=" + description + "]";
	}
	
}
