package com.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Flat;
import com.entities.FlatAddress;
import com.entities.Landlord;
import com.advice.FlatNotFoundException;
import com.repository.IFlatRepository;
import com.service.IFlatService;

@Service
public class IFlatServiceImpl implements IFlatService {
	

	List<Flat> fa;
	Flat flat;

		@Autowired(required=true)
		IFlatRepository farepo;
		
		
		
//		
//		public Flat createFlats() {
//				fa=new ArrayList<>();
//				FlatAddress f = new FlatAddress(2,"ks","hyd","ts",500045,"india");
//				Landlord l =null;
//				l.setLandlordId(2);
//						
//				Flat f1 = new Flat(1,5000f,f, "Not Available");
//				Flat f3= farepo.save(f1);
//			
//			Landlord l = new Landlord();
//			l.getFlatList().add(f1);
//				fa.add(f1);
//
//		return null;
//	}

		


		@Override
		  public Flat addFlat(Flat flat) {

		Flat f= farepo.save(flat);

			return f;
			 
		    
		  }
	@Override
	public Flat updateFlat(Flat flat) throws Exception {
		
		
			
		int id=flat.getFlatId();
		Supplier<Exception> s1 = ()->new FlatNotFoundException("Flat id is not present in the database");
		Flat flt1 =farepo.findById(id).orElseThrow(s1);
			flt1.setAvialibilty(flat.getAvialibilty());
			flt1.setCost(flat.getCost());
			flt1.setFlatAdress(flat.getFlatAdress());
			farepo.save(flt1);
			return flt1;
			
		
	
		
		
	}

	@Override
	public String deleteFlat(Flat flat) throws Exception {
		int id=flat.getFlatId();
		Supplier<Exception> s1 = ()->new FlatNotFoundException("Flat id is not present in the database");
		Flat flt1=null;
		
			flt1= farepo.findById(id).orElseThrow(s1);
			farepo.delete(flt1);
		
		
		return "Deleted from service";
		
		
	}

	@Override
	public Flat viewFlat(int id) throws Exception {
		Supplier<Exception> s1 = ()->new FlatNotFoundException("Flat id is not present in the database");
		System.out.println(" in service");
		Flat flt1= farepo.findById(id).orElseThrow(s1);
		return flt1;
	}
		
	

	@Override
	public List<Flat> viewAllFlat() {
		fa=new ArrayList<>();
		fa=farepo.findAll();
		return fa;
	
	}

	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {
		fa=new ArrayList<>();
		fa=farepo.findAll();
		return null;
	}

}