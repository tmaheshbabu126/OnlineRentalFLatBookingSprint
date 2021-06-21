package com.service;


import java.util.List;
import java.util.Optional;

import com.entities.FlatBooking;

public interface IFlatBookingService {
	
	FlatBooking addFlatBooking(FlatBooking flat);
     Optional<FlatBooking> viewFlatBooking(long id);
	List<FlatBooking> viewAllFlatBooking();
	String removeFlatBooking(long id);
	FlatBooking updateFlatBooking(FlatBooking flat) throws Exception;
	
	
	
}


