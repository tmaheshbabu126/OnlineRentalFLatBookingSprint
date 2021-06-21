package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;



@Entity
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@NotNull
	@Min(1)
	private int tenant_id;
	
	@NotBlank(message = "Tenant name cannot be empty")
	@NotNull
	@Size(min=3,max=12)

	private String name;
	
	
	@NotBlank(message = "Tenant age cannot be empty")
	@NotNull
	@Min(18)
	
	private int age;
	
	@OneToOne
	@JoinColumn(name = "house_No")
	private FlatAddress tenantAddress;
	
	
	
	
	
	public Tenant(int tenant_id, String name, int age, FlatAddress tenantAddress) {
		super();
		this.tenant_id = tenant_id;
		this.name = name;
		this.age = age;
		this.tenantAddress = tenantAddress;
	}
	public Tenant() {
		super();
	}
	public int getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(int tenant_id) {
		this.tenant_id = tenant_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public FlatAddress getTaddress() {
		return tenantAddress;
	}
	public void setTaddress(FlatAddress taddress) {
		this.tenantAddress = taddress;
	}
	@Override
	public String toString() {
		return "Tenant [tenant_id=" + tenant_id + ", age=" + age + ", tenantAddress=" + tenantAddress + "]";
	}
	
	
}
