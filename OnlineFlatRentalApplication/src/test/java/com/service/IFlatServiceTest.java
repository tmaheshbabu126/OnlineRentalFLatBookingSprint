

package com.service;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.entities.Flat;
import com.advice.FlatNotFoundException;
import com.repository.IFlatRepository;

@SpringBootTest
class IFlatServiceTest {
	
	@Autowired
	IFlatService flatservice;
	
	@MockBean
	IFlatRepository farep;
	

	@Test
	void testAddFlat() {
		
		Flat flat1=new Flat();
		flat1.setFlatId(1);
		flat1.setCost(2500);
		flat1.setFlatAdress(1,"Hyderabad","India",500045,"Telangana","JubileeHills");
		flat1.setAvialibilty("Available");
		flat1.setLandlord(1,"sairam",22);
		
		Mockito.when((Flat)this.farep.save(flat1)).thenReturn(flat1);
		Assertions.assertThat(this.flatservice.addFlat(flat1)).isEqualTo(flat1);
		
	}
		
		
	@Test
	void testUpdateFlat() throws Exception {
		
		Flat flat1=new Flat();
		flat1.setFlatId(1);
		flat1.setCost(3500);
		flat1.setFlatAdress(1,"Rangareddy","India",500045,"Telangana","Aziznagar");
		flat1.setAvialibilty("Available");
		flat1.setLandlord(1,"Mahesh",23);
		
		Optional<Flat> flat2 = Optional.of(flat1);
		Mockito.when(farep.findById(1)).thenReturn(flat2);
		flat1.setCost(1434);
		
		Mockito.when(farep.save(flat1)).thenReturn(flat1);
		
		
		Assertions.assertThat(flatservice.updateFlat(flat1)).isEqualTo(flat1);
		
		
		
	}

	@Test
	void testRempoveFlat() throws FlatNotFoundException {
		
		Flat flat1 = new Flat();
		flat1.setFlatId(1);
		flat1.setCost(3500);
		flat1.setFlatAdress(1,"Rangareddy","India",500045,"Telangana","Aziznagar");
		flat1.setAvialibilty("Available");
		flat1.setLandlord(1,"Mahesh",23);
		
		Optional<Flat> flat2 = Optional.of(flat1);
		
		Mockito.when(farep.findById((int) 2)).thenReturn(flat2);
		Mockito.when(farep.existsById(flat1.getFlatId())).thenReturn(false);
		assertFalse(farep.existsById(flat1.getFlatId()));
		
	}

	@Test
	void testViewFlat() throws FlatNotFoundException, Exception {
		
		Flat flat1 = new Flat();
		flat1.setAvialibilty("Available");
		flat1.setCost(4500);
		flat1.setFlatAdress(2,"Hyderabad","India",500055,"Telangana","LB Nagar");
		flat1.setFlatId(1);
		flat1.setLandlord(1,"sairam",22);
		
		
		Optional<Flat> faList = Optional.of(flat1);
	
		
		 Mockito.when(farep.findById(1)).thenReturn(faList);
	        Assertions.assertThat(Optional.of(flatservice.viewFlat(1))).isEqualTo(faList);
			
		
	}
		

	@Test
	void testViewAllFlat() {
		
		Flat flat1 = new Flat();
		flat1.setAvialibilty("Available");
		flat1.setCost(4500);
		flat1.setFlatAdress(2,"Hyderabad","India",500055,"Telangana","LB Nagar");
		flat1.setFlatId(1);
		flat1.setLandlord(1,"sairam",22);
		
		Flat flat2 = new Flat();
		flat2.setAvialibilty("Available");
		flat2.setCost(4500);
		flat2.setFlatAdress(2,"Hyderabad","India",500055,"Telangana","LB Nagar");
		flat2.setFlatId(2);
		flat2.setLandlord(1,"ram",22);
		
		List<Flat> faList = new ArrayList();
		faList.add(flat1);
		faList.add(flat2);
		
		

        Mockito.when(this.farep.findAll()).thenReturn(faList);
        Assertions.assertThat(this.flatservice.viewAllFlat()).isEqualTo(faList);
		
		
		
	}

	@Test
	void testViewAllFlatByCost() {
		
		Flat flat1 = new Flat();
		flat1.setCost(4500);
		flat1.setAvialibilty("Available");
		Mockito.when((Flat)farep.save(flat1)).thenReturn(flat1);
		Assertions.assertThat(flatservice.viewAllFlatByCost(4500, "Available"));
	}

//	
//	@Test
//	void testCreateFlats() {
//		fail("Not yet implemented");
//	}
	
	
}
