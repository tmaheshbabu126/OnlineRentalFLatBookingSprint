/**
 * 
 */
package com.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advice.TenantNotFoundException;
import com.entities.Tenant;
import com.repository.ITenantRepository;
import com.service.ITenantService;

/**
 * @author Mahesh babu 
 *
 */

@Service
public class ITenantServiceImplementation implements ITenantService {
	
List<Tenant> tenant_list;
Tenant tenant;
	
	@Autowired(required=true)
	ITenantRepository terepo;
	
	
	//method to add tenant adding tenant (check whether there is a valid address so that tenant can be added)
	@Override
	public Tenant addTenant(Tenant tenant) {
		
		Tenant t = terepo.save(tenant); // saving/adding tenant values in database
		return t;
	}

	
	//updating tenant name, age and address
	@Override
	public Tenant updateTenant(Tenant tenant) throws Exception {
		Tenant t1 = null;
	
		int id=tenant.getTenant_id();
		Supplier<Exception> s1 = ()->new TenantNotFoundException("Tenant id is not present in the database");
				
		t1 = terepo.findById(id).orElseThrow(s1); //finding teanant by id if not found throwing user defined exception
		t1.setName(tenant.getName());
		t1.setAge(tenant.getAge());
	    t1.setTaddress(tenant.getTaddress()); // setting/updating all the records
		terepo.save(t1);//saving it in database
		return t1;
			
	}
	
	//viewing tenant by id 

	@Override
	public Tenant viewTenant(int id) throws Exception {
		Supplier<Exception> s1 = ()->new TenantNotFoundException("Tenant id is not present in the database");
		Tenant t1=null;
		t1 = terepo.findById(id).orElseThrow(s1);//finding teanant by id if not found throwing user defined exception
		
		
		return t1;
	}
	
	
	
	//viewing all tenant

	@Override
	public List<Tenant> viewAllTenant() {
		// TODO Auto-generated method stub
		tenant_list=new ArrayList<>();
		tenant_list=terepo.findAll(); // finding all tenants from database
		return tenant_list;  //sending the list
		
	}
	
	//delete tenants
	@Override
	public String deleteTenant() throws Exception {
		
		terepo.deleteAll();   // deleting all the tenants from database
		return "Tenants are succesfully deleted";
		
	}

	//delete specific tenant
	@Override
	public String deleteTenant(int id) throws Exception {
		Supplier<Exception> s1 = ()->new TenantNotFoundException("Tenant id is not present in the database");
		Tenant t1=null;
	
		t1 = terepo.findById(id).orElseThrow(s1); //find tenant if not found throw custom exception
		terepo.delete(t1); //delete the tenant from database
		return "Tenant with id : "+id+" is succesfully deleted";
		
		
	}
	

	


	
	

	

}
