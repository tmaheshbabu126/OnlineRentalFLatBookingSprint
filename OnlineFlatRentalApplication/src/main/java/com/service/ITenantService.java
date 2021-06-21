package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.advice.TenantNotFoundException;
import com.entities.Tenant;

@Service
public interface ITenantService {
	public Tenant addTenant(Tenant tenant) ;
	public Tenant updateTenant(Tenant tenant) throws Exception;
	public Tenant viewTenant(int id) throws  Exception ;
	public List<Tenant> viewAllTenant();
	public String deleteTenant() throws TenantNotFoundException, Exception;
	public String deleteTenant(int id) throws TenantNotFoundException, Exception ;
	
//	public Tenant validateTenant(int tenantId);

}
