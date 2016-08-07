package com.amudhan.caveatemptor.entity;

import javax.persistence.Entity;

@Entity
public class Image {
	private long id;
	private String name;
	private String imageUrl;
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
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
}
