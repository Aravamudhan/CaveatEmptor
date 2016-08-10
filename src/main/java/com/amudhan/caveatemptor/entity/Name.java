package com.amudhan.caveatemptor.entity;

import javax.persistence.Embeddable;

@SuppressWarnings("unused")
@Embeddable
public class Name {
	private String firstName;
	private String lastName;
	
	private String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private String getLastName() {
		return lastName;
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
