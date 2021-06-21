
package com.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
//@Component
@Entity
public class Landlord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int landlordId;
	
	//@NotEmpty(message = "Landlord name cannot be empty")
	//@NotNull
	//@Size(min=3,max=15)
	//@Pattern(regexp ="^[A-Z][a-z]", message ="length must be 3 and max 15 and dont use numbers")
	private String landlordName;
	
	//@NotEmpty(message = " Landlord age cannot be empty")
	//@NotNull
	//@Min(value=18,message="age should be Positive Number and Mnimun age 18 is required")
	//@Pattern(regexp ="^[0-9]")
	private int landlordAge;

	
	@OneToMany(cascade=CascadeType.ALL)
	private  List<Flat> flatList = new ArrayList<Flat>();
	
	public Landlord()
	{ 
		super();
	}

	public Landlord(int landlordId, String landlordName, int landlordAge) { 
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
	}

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public int getLandlordAge() {
		return landlordAge;
	}

	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}
	
	
	
	
	

}
