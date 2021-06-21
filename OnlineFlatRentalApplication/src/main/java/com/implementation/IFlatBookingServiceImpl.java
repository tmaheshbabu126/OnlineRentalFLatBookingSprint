package com.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.entities.Flat;
import com.entities.FlatBooking;
import com.advice.FlatBookingNotFoundException;
import com.advice.FlatNotFoundException;
import com.repository.IFlatBookingRepository;
import com.service.IFlatBookingService;

@Service
public class IFlatBookingServiceImpl implements IFlatBookingService {
	@Autowired
	IFlatBookingRepository irepo;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flat) {
		FlatBooking o1 = irepo.save(flat);
		return o1;
	}

	@Override
	public String removeFlatBooking(long id)  {
		irepo.deleteById(id);
		return "Deleted Successful";	
	}
	
	
	 @Override 
	 public FlatBooking updateFlatBooking(FlatBooking f) throws Exception { 
	 long id=f.getBookingId(); 
	 Supplier<Exception> o1 = ()->new ResourceNotFoundException("FlatBooking id is not present in the database"); 
	 FlatBooking f1=irepo.findById(id).orElseThrow(o1);
	 f1.setBookingFromDate(f.getBookingFromDate());
	 f1.setBookingToDate(f.getBookingToDate());
	 irepo.save(f1); 
	 return f1; 
	  }
	  

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> ls=new ArrayList<>();
		ls=irepo.findAll();
		// TODO Auto-generated method stub
		return ls;
	}


	  @Override
		public Optional<FlatBooking> viewFlatBooking(long id) {
			Optional<FlatBooking> o1=irepo.findById(id);
			return o1;	
		}

	
	  
	
}