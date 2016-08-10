package com.amudhan.caveatemptor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="image")
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="imageurl", nullable=false)
	private String imageUrl;
	@NotNull
	private Item item;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String getImageUrl() {
		return imageUrl;
	}
	private void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
}
