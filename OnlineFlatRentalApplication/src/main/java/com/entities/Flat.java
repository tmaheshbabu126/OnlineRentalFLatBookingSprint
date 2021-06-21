package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;






@Entity
public class Flat {
	
	@Id
	//@GeneratedValue
	//@NotNull
	//@Pattern(regexp ="^[0-9]")
	private int flatId;
	
	
	//@Min (value=5000 , message = "min.value")
	//@Max (value=20000 , message = "max.value")
	private float cost;
	
	
	@OneToOne
	@JoinColumn(name="houseNo")
	private FlatAddress flatAddress;
	
	
	//@Pattern(regexp ="^[A-Z][a-z]", message = "mesage must be either Available or Not Available")
	private String avialibilty;
	
	

	//@JoinColumn(name="landlordId")
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name="landlordId")
	private Landlord landlord;
	
	
	public Flat() {
		super();
	}

	public Flat(int flatId, float cost, FlatAddress flatAddress, String avialibilty, Landlord landlord) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.avialibilty = avialibilty;
		this.landlord = landlord;
		

	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public FlatAddress getFlatAdress() {
		return flatAddress;
	}

	public void setFlatAdress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvialibilty() {
		return avialibilty;
	}

	public void setAvialibilty(String avialibilty) {
		this.avialibilty = avialibilty;
	}

//	@Override
//	public String toString() {
//		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", avialibilty="
//				+ avialibilty + "]";
//	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", avialibilty="
				+ avialibilty + ", landlord=" + landlord + "]";
	}

	public void setFlatAdress(int i, String string, String string2, int j, String string3, String string4) {
		// TODO Auto-generated method stub
		
	}

	public void setLandlord(int i, String string, int j) {
		// TODO Auto-generated method stub
		
	}

}