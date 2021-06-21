package com.service;

import java.util.List;
import java.util.Optional;

import com.entities.Flat;
import com.advice.FlatNotFoundException;

public interface IFlatService {
	public Flat addFlat(Flat flat);
	public Flat updateFlat(Flat flat) throws FlatNotFoundException, Exception;
	public String deleteFlat(Flat flat) throws FlatNotFoundException, Exception;
	public Flat viewFlat(int id) throws Exception;
	public List<Flat> viewAllFlat();
	public List<Flat> viewAllFlatByCost(float cost,String availability);

}
