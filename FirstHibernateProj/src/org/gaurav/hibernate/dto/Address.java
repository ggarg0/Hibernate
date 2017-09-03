package org.gaurav.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
	
	public Address()
	{
		
	}
	public Address(String street, String city, String state, String pincode)
	{
		this.street=street;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
	}
	
	@Column (name="USER_STREET")
	private String street;
	
	@Column (name="USER_CITY")
	private String city;
	
	@Column (name="USER_STATE")
	private String state;
	
	@Column (name="USER_PINCODE")
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
