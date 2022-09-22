package com.restapi.RestEndpoints.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity(name="Address")
@Table(name="Address")
public class Address
{
	@Id
	int id;
	long pincode;
	String city,country;
	
//	@OneToMany(mappedBy="address",fetch=FetchType.LAZY)
//	private List<Customer> customers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(int id, long pincode, String city, String country) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.city = city;
		this.country = country;
		
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
