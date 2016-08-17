package com.amudhan.caveatemptor.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.amudhan.caveatemptor.constant.AddressQueries;
@NamedQueries({
	@NamedQuery(name=AddressQueries.GETALLADDRESSES, query=AddressQueries.GETALLADDRESSES_Q)
})
@Entity
@Table(name="address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_sequence")
	@SequenceGenerator(initialValue= 1, name="address_sequence", allocationSize=1)
	private long id;
	@Column(name="building", nullable=false)
	private String building;
	@Column(name="street", nullable=false)
	private String street;
	@Column(name="zipcode", nullable=false)
	private String zipCode;
	@Column(name="city", nullable=false)
	private String city;
	@Enumerated(EnumType.STRING)
	@Column(name="usertype")
	@NotNull
	private AddressType addressType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	@NotNull
	private User user;
	
	public enum AddressType{ BILLING, SHIPPING}
	
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		return "Address [id=" + id + ", building=" + building + ", street="
				+ street + ", zipcode=" + zipCode + ", city=" + city
				+ ", addressType=" + addressType + ", user=" + user + "]";
	}
}
