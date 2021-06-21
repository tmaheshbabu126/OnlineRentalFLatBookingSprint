package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entities.Landlord;
import com.advice.LandlordNotFoundException;


@Service
public interface ILandlordService {

	public Landlord addLandlord(Landlord landlord);
	public List<Landlord> addLandlords(List<Landlord> ls);
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException;
	public String deleteLandlord(Landlord landlord) throws LandlordNotFoundException;
	public Landlord viewLandlord(int id) throws LandlordNotFoundException, Exception;
	public List<Landlord> viewAllLandlord();
	String deleteLandlordbyId(int id) throws LandlordNotFoundException;
	
	
}


