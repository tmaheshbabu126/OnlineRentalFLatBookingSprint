package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.FlatBooking;
import com.advice.FlatBookingNotFoundException;
import com.repository.IFlatBookingRepository;

@SpringBootTest
class FlatBookingServiceTest {
	@Autowired
	IFlatBookingService flatbookingservice;
	
	@MockBean
	IFlatBookingRepository frepo;

	@Test
	void testAddFlatBooking() {
		FlatBooking f1 = new FlatBooking();
		f1.setBookingId(1);
		f1.setBookingFromDate("12-4-2021");
		f1.setBookingToDate("14-4-2021");
		
        Mockito.when((FlatBooking)this.frepo.save(f1)).thenReturn(f1);
        Assertions.assertThat(this.flatbookingservice.addFlatBooking(f1)).isEqualTo(f1);
	}

	@Test
	void testRemoveFlatBooking() {
		FlatBooking f1 = new FlatBooking();
		f1.setBookingId(1);
		f1.setBookingFromDate("12-4-2021");
		f1.setBookingToDate("14-4-2021");
		
		Optional<FlatBooking> f2=Optional.of(f1);
		
		Mockito.when(frepo.findById((long) 100)).thenReturn(f2);
		Mockito.when(frepo.existsById(f1.getBookingId())).thenReturn(false);
		assertFalse(frepo.existsById(f1.getBookingId()));
	}

	
	  @Test 
	  void testUpdateFlatBooking() throws Exception{
		  
	  
	   FlatBooking f1 = new FlatBooking();
	  f1.setBookingId(1); 
	  f1.setBookingFromDate("12-4-2021");
	  f1.setBookingToDate("14-4-2021");
	  Optional<FlatBooking> f2=Optional.of(f1);
	  Mockito.when(this.frepo.findById((long) 1)).thenReturn(f2); 
	  f1.setBookingId(1);
	  Mockito.when((FlatBooking)frepo.save(f1)).thenReturn(f1);
	  Assertions.assertThat(this.flatbookingservice.updateFlatBooking(f1)).isEqualTo(f1);
	 }
	 

	@Test
	void testViewAllFlatBooking() {
		FlatBooking f1 = new FlatBooking();
		f1.setBookingId(1);
		f1.setBookingFromDate("12-4-2021");
		f1.setBookingToDate("14-4-2021");
		
       
    	FlatBooking f2 = new FlatBooking();
    	f2.setBookingId(2);
		f2.setBookingFromDate("18-4-2021");
		f2.setBookingToDate("21-4-2021");
    
	    List<FlatBooking> flatbookingList = new ArrayList();
	    flatbookingList.add(f1);
	    flatbookingList.add(f2);
	    Mockito.when(this.frepo.findAll()).thenReturn( flatbookingList);
	    Assertions.assertThat(this.flatbookingservice.viewAllFlatBooking()).isEqualTo( flatbookingList);
	}

	@Test
	void testViewFlatBooking() {
		FlatBooking f1 = new FlatBooking();
		f1.setBookingId(1);
		f1.setBookingFromDate("12-4-2021");
		f1.setBookingToDate("14-4-2021");
		
		Mockito.when(frepo.save(f1)).thenReturn(f1);
		FlatBooking response=flatbookingservice.addFlatBooking(f1);
		Assertions.assertThat(response.getBookingId()).isEqualTo(1);
		Assertions.assertThat(response.getBookingFromDate()).isEqualTo("12-4-2021");
		Assertions.assertThat(response.getBookingToDate()).isEqualTo("14-4-2021");
		
     
	}

}
