package com.restapi.RestEndpoints.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restapi.RestEndpoints.entity.Address;
import com.restapi.RestEndpoints.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	public List<Customer> findByName(String name);
	
//	public List<Customer> findByAddress(String address);
	
	public Customer findByAdd(String address);
	
	@Query(value="SELECT * FROM Customer ORDER BY name",nativeQuery=true)
	public List<Customer> orderByName();
	
//	@Query(value="SELECT * FROM Address WHERE ")
//	public List<Address> getByCustId();
	
	

}
