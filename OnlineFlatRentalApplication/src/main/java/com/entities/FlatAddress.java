package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class FlatAddress {
	
	@Id
	@NotBlank(message = "Tenant houseNo cannot be empty")
	@NotNull
	@Min(1)
	private int houseNo;
	private String street;
	private String city;
	private String state;
	private int pin;
	private String country;
	
	
	
	public FlatAddress(int house_No, String street, String city, String state, int pin, String country) {
		super();
		this.houseNo = house_No;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
//		this.tenant = tenant;
	}
	
	
	
	
	
	
	
	public FlatAddress() {
		super();
	}







	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "FlatAdress [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", country=" + country + "]";
	}
	
	
	
	
	
	
}

