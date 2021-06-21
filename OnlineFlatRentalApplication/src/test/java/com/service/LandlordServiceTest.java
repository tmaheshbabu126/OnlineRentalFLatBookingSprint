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

import com.entities.Landlord;
import com.advice.LandlordNotFoundException;
import com.repository.ILandlordRepository;

@SpringBootTest
class LandlordServiceTest {
	@Autowired
	ILandlordService landlordservice;
	
	@MockBean
	ILandlordRepository lrepo;

	@Test
	void testAddLandlord() {
	Landlord l1 = new Landlord();
		l1.setLandlordId(1);
		l1.setLandlordName("ashish");
	    l1.setLandlordAge(23);
	
        Mockito.when((Landlord)this.lrepo.save(l1)).thenReturn(l1);
        Assertions.assertThat(this.landlordservice.addLandlord(l1)).isEqualTo(l1);
		
	
	}

	@Test
	void testUpdateLandlord() throws LandlordNotFoundException {
		Landlord l1 = new Landlord();
		l1.setLandlordId(1);
		l1.setLandlordName("ashish");
	    l1.setLandlordAge(23);

		
		Optional<Landlord> l2=Optional.of(l1);
		Mockito.when(lrepo.findById(1)).thenReturn(l2);
		l1.setLandlordName("sai");
		Mockito.when(lrepo.save(l1)).thenReturn(l1);
		assertThat(landlordservice.updateLandlord(l1).equals(l1));
		
	}

	@Test
	void testDeleteLandlord() {
		Landlord  l1 = new Landlord();
		l1.setLandlordId(1);
		l1.setLandlordName("ashish");
	    l1.setLandlordAge(23);
		Optional<Landlord> l2=Optional.of(l1);
		
		Mockito.when(lrepo.findById(100)).thenReturn(l2);
		Mockito.when(lrepo.existsById(l1.getLandlordId())).thenReturn(false);
		assertFalse(lrepo.existsById(l1.getLandlordId()));

	
	}

	@Test
	void testViewLandlord()    {
		
		Landlord  l1 = new Landlord();
		l1.setLandlordId(1);
		l1.setLandlordName("ashish");
	    l1.setLandlordAge(23);

			Mockito.when(lrepo.save(l1)).thenReturn(l1);
			Landlord response=landlordservice.addLandlord(l1);
			assertThat(response.getLandlordId()).isEqualTo(1);
			assertThat(response.getLandlordName()).isEqualTo("ashish");
			assertThat(response.getLandlordAge()).isEqualTo(23);
		
	
	}

	@Test
	void testViewAllLandlord() {
		Landlord  l1 = new Landlord();
		l1.setLandlordId(1);
		l1.setLandlordName("ashish");
	    l1.setLandlordAge(23);

		Landlord  l2 = new Landlord();
		l2.setLandlordId(2);
		l2.setLandlordName("sai");
	    l2.setLandlordAge(24);

    
	    List<Landlord> landlordList = new ArrayList();
	    landlordList.add(l1);
	    landlordList.add(l2);
	    Mockito.when(this.lrepo.findAll()).thenReturn(landlordList);
	    Assertions.assertThat(this.landlordservice.viewAllLandlord()).isEqualTo(landlordList);
	
	}

}
