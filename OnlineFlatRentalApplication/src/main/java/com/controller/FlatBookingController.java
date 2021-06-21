package com.controller;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.FlatBooking;
import com.service.IFlatBookingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;




@RestController
@RequestMapping(path="/api")
public class FlatBookingController {

	@Autowired
	IFlatBookingService flatbookingservice;
	
	@PostMapping(path="/addFlatBooking")
	public ResponseEntity<FlatBooking> addFlatBooking (@Validated @RequestBody FlatBooking flat)
	{
	FlatBooking o1=flatbookingservice.addFlatBooking(flat);	
	ResponseEntity re=new ResponseEntity<FlatBooking>(o1,HttpStatus.OK);
	return re;
	}
			
			  @DeleteMapping(path="/removeFlatBooking/{id}") 
			  public ResponseEntity<String> removeFlatBooking(@PathVariable long id)  
			  {
			  flatbookingservice.removeFlatBooking(id );
			  ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); 
			  return re;
			  }
			 
	
			
		 @GetMapping(path="/viewAllFlatBooking") 
			  public ResponseEntity<FlatBooking> viewAllFlatBookings(){
			  
				  List<FlatBooking>ls=flatbookingservice.viewAllFlatBooking();
			   ResponseEntity re=new ResponseEntity<List<FlatBooking>>(ls,HttpStatus.OK);
			   return re; 
		 }
			  

		 @PutMapping(path="/updateFlatBooking")
	     public ResponseEntity<FlatBooking> updateOrder(@Validated @RequestBody FlatBooking flat) throws Exception
	     {
		FlatBooking f1= flatbookingservice.updateFlatBooking(flat);
		ResponseEntity re=new ResponseEntity<FlatBooking>(f1,HttpStatus.OK);
		return re;	
	     }
		
		 
		 @GetMapping(path="/viewFlatBooking/{id}")    
			public ResponseEntity<FlatBooking> viewFlatBooking(@PathVariable Long id)
			{
				Optional<FlatBooking> o1=flatbookingservice.viewFlatBooking(id);
				
				ResponseEntity re=new ResponseEntity<Optional<FlatBooking>>(o1,HttpStatus.OK);
				return re;	
			}
}
	

	
			