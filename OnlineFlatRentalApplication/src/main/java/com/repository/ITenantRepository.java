package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Tenant;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant, Integer>{
//	public Tenant addTenant(Tenant tenant) ;
//	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException;
//	public Tenant deleteTenant(Tenant tenant) throws TenantNotFoundException;	
//	public Tenant viewTenant(int id) throws TenantNotFoundException;
//	public List<Tenant> viewAllTenant();
//	public Tenant validateTenant(int tenantId);

}
