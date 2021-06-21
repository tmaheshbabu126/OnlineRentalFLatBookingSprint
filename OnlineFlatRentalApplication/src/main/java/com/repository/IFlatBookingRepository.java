package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.FlatBooking;

@Repository
	public interface IFlatBookingRepository  extends JpaRepository<FlatBooking,Long>{
//		public Flat addFlatBooking(FlatBooking flat) ;
//		public Flat updateFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//		public Flat deleteFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//		public Flat viewFlatBooking(int id) throws FlatBookingNotFoundException;
//		public List<FlatBooking> viewAllFlatBooking();

	}



