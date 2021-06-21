package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.advice.TenantNotFoundException;
import com.entities.FlatAddress;
import com.entities.Tenant;

import com.repository.ITenantRepository;

@SpringBootTest
public class TenantServiceTest {
	
	@Autowired
	ITenantService tenantservice;
	
	@MockBean
	ITenantRepository tenantrepo;
	
	@Test //testing add tenant
	void testAddTenant() {
	
		Tenant tenantref=new Tenant();
		tenantref.setName("Mahesh");
		tenantref.setAge(22);
		tenantref.setTaddress(new FlatAddress(7,"krishnangar","Hyderabad","Telangana",500456,"India"));
		tenantref.setTenant_id(5);	
		Mockito.when(tenantrepo.save(tenantref)).thenReturn(tenantref);
		assertThat(tenantservice.addTenant(tenantref)).isEqualTo(tenantref);
		
	}
	
    @Test
	void testUpdateTenant() throws Exception  {
		
    	Tenant tenantref=new Tenant();
		tenantref.setName("Mahesh");
		tenantref.setAge(22);
		tenantref.setTaddress(new FlatAddress(7,"krishnangar","Hyderabad","Telangana",500456,"India"));
		tenantref.setTenant_id(5);		
		Optional<Tenant> e2=Optional.of(tenantref);
		Mockito.when(tenantrepo.findById(5)).thenReturn(e2).toString();
		tenantref.setName("Rakesh");
		Mockito.when(tenantrepo.save(tenantref)).thenReturn(tenantref);
		assertThat(tenantservice.updateTenant(tenantref)).isEqualTo(tenantref);
	
    	
	}
	
    
	
	@Test
	void testViewTenant() throws TenantNotFoundException, Exception  {
		
		Tenant tenantref2=new Tenant();
		tenantref2.setName("Rakesh");
		tenantref2.setAge(25);
		tenantref2.setTaddress(new FlatAddress(8,"krishnangar","Hyderabad","Telangana",500556,"India"));
		tenantref2.setTenant_id(6);
		Optional<Tenant> e2=Optional.of(tenantref2);
		Mockito.when(tenantrepo.findById(6)).thenReturn(e2);
		assertThat(tenantservice.viewTenant(6)).isEqualTo(tenantref2);
		
		
	}
	
	
	@Test
	void testViewAllTenant() {
		
		Tenant tenantref=new Tenant();
		tenantref.setName("Mahesh");
		tenantref.setAge(22);
		tenantref.setTaddress(new FlatAddress(7,"krishnangar","Hyderabad","Telangana",500456,"India"));
		tenantref.setTenant_id(5);

		Tenant tenantref2=new Tenant();
		tenantref2.setName("Rakesh");
		tenantref2.setAge(25);
		tenantref2.setTaddress(new FlatAddress(8,"krishnangar","Hyderabad","Telangana",500556,"India"));
		tenantref2.setTenant_id(6);
		
		List<Tenant> empList = new ArrayList<>();
		empList.add(tenantref);
		empList.add(tenantref2);
		
		Mockito.when(tenantrepo.findAll()).thenReturn(empList);
		
		assertThat(tenantservice.viewAllTenant()).isEqualTo(empList);
	}
	
	@Test
	void deleteTenant()  {
		Tenant tenantref2=new Tenant();
		tenantref2.setName("Rakesh");
		tenantref2.setAge(25);
		tenantref2.setTaddress(new FlatAddress(8,"krishnangar","Hyderabad","Telangana",500556,"India"));
		tenantref2.setTenant_id(6);
		
		Optional<Tenant> e2=Optional.of(tenantref2);
		Mockito.when(tenantrepo.findById(6)).thenReturn(e2);
		Mockito.when(tenantrepo.existsById(tenantref2.getTenant_id())).thenReturn(false);
		assertFalse(tenantrepo.existsById(tenantref2.getTenant_id()));
	
	}  
	

}
