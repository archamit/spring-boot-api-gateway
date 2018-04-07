package com.car.insurance.feign.domains;

import java.io.Serializable;

public class UserDetailsData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7440680243577224809L;
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String address;
	private String zip;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
