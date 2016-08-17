package com.amudhan.caveatemptor.entity;

import java.io.Serializable;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.amudhan.caveatemptor.constant.ImageQueries;

@NamedQueries({
	@NamedQuery(name=ImageQueries.GETALLIMAGES, query=ImageQueries.GETALLIMAGES_Q)
})
@Entity
@Table(name="image")
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="image_sequence")
	@SequenceGenerator(initialValue= 1, name="image_sequence", allocationSize=1)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="imageurl", nullable=false)
	private String imageUrl;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid")
	@NotNull
	private Item item;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
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
	public void setId(long id) {
		this.id = id;
	}
}
