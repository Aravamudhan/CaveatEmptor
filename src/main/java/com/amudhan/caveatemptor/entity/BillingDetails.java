package com.amudhan.caveatemptor.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * By default the properties of a superclass are ignored unless annotated by MappedSuperclass
 * **/
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	@NotNull
	private User owner;
		
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
}
