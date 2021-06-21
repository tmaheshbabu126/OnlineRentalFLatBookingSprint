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
import com.advice.LandlordNotFoundException;
import com.repository.ILandlordRepository;
import com.service.ILandlordService;

@Service
public class ILandlordServiceImplementation implements ILandlordService {
	
	List<Landlord> ll;
	Landlord landlord;
	
	@Autowired(required=true)
	ILandlordRepository lrepo;

		@Override
		public  Landlord addLandlord(Landlord landlord) {
			Landlord ld = lrepo.save(landlord);
			return ld;
		}
		
		@Override
		public List<Landlord> addLandlords(List<Landlord> ls){
			ll= new ArrayList<>();
			ll=lrepo.saveAll(ls);
			return ll;
		}

		
	  @Override 
	  public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		  int id=landlord.getLandlordId();
			Supplier<Exception> s1 = ()->new LandlordNotFoundException("Landlord id is not present in the database");
			Landlord l1=null;
			try {
				l1 = lrepo.findById(id).orElseThrow(s1);
				l1.setLandlordName(landlord.getLandlordName());
				l1.setLandlordAge(landlord.getLandlordAge());
				lrepo.save(l1);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
				return l1;
	  }
	  
	  @Override 
	  public String deleteLandlord(Landlord landlord) throws LandlordNotFoundException { 
		  int id=landlord.getLandlordId();
			Supplier<Exception> s1 = ()->new LandlordNotFoundException("Landlord id is not present in the database");
			Landlord l1=null;
			try {
				l1 = lrepo.findById(id).orElseThrow(s1);
				lrepo.delete(l1);
				return "Landlord  is succesfully deleted";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return e.toString();
			}
		  
	  }
	  
	  @Override
		public String deleteLandlordbyId(int id) throws LandlordNotFoundException {
			Supplier<Exception> s1 = ()->new LandlordNotFoundException("Landlord id is not present in the database");
			Landlord l1=null;
			try {
				l1 = lrepo.findById(id).orElseThrow(s1);
				lrepo.delete(l1);
				return "Landlord with id : "+id+" is succesfully deleted";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return e.toString(); 
			}
			
	  }
	  
	  @Override 
	  public Landlord viewLandlord(int id) throws Exception { 
		  Supplier<Exception> s1 = ()->new LandlordNotFoundException("Landlord id is not present in the database");
			Landlord l1=null;
		  Landlord ll = lrepo.findById(id).orElseThrow(s1);;
			return ll; 
	  }
	  
	  @Override 
	  public List<Landlord> viewAllLandlord() { 
		  ll=new ArrayList<>();
		  ll=lrepo.findAll();
		  
	   return ll; 
	   }







	 

}
