package com.amudhan.caveatemptor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="bid")
public class Bid {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="amount", nullable=false)
	private BigDecimal amount;
	@Column(name="createdon", nullable=false)
	private Date createdOn;
	@Column(name="issuccess", columnDefinition="default 0")
	private boolean isSuccess;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid")
	@NotNull
	private Item item;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bidderid")
	@NotNull
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
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
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
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Bid [id=" + id + ", amount=" + amount + ", createdOn="
				+ createdOn + ", isSuccess=" + isSuccess + ", item=" + item
				+ ", bidder=" + bidder + "]";
	}
}
