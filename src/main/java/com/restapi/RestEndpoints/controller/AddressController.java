package com.restapi.RestEndpoints.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.RestEndpoints.entity.Address;
import com.restapi.RestEndpoints.entity.Customer;
import com.restapi.RestEndpoints.exception.AddressNotFoundException;
import com.restapi.RestEndpoints.exception.CustomerNotFoundException;
import com.restapi.RestEndpoints.repository.AddressRepository;
import com.restapi.RestEndpoints.repository.CustomerRepository;

@RestController
public class AddressController {
	
	@Autowired
	AddressRepository repository;
	
	@Autowired
	CustomerRepository repo;
	
	
//	@GetMapping("/customers/addresses")
//	public ResponseEntity<Object> getAll()
//	{
//		List<Address> a1 = new ArrayList<>();
//		
//		a1 = repository.findAll();
//		
//		if(a1.isEmpty())
//		{
//			throw new AddressNotFoundException();
//		}
//		return new ResponseEntity<>(a1,HttpStatus.OK);
//	}
	
//	@GetMapping("/customers/addresses/{id}")
//	public ResponseEntity<Object> getAddressById(@PathVariable("id") int id)
//	{
//		
//		
//		Optional<Address> obj = repository.findById(id);
//		
//		Address address = new Address();
//		if(obj.isPresent())
//		{
//			address = obj.get();
//		}
//		else
//		{
//			throw new AddressNotFoundException();
//		}
//		
//		return new ResponseEntity<>(address,HttpStatus.OK);
//			
//	}
	
	@GetMapping("/customers/{custid}/addresses")
	public ResponseEntity<Object> getByCustId(@PathVariable("custid") int custid)
	{
		Optional<Customer> customer = repo.findById(custid);
		Customer existingCustomer = new Customer();
		if(customer.isPresent())
		{
			existingCustomer = customer.get();
		}
		else
		{
			throw new CustomerNotFoundException();
		}
		
		return new ResponseEntity<>(existingCustomer.getAddress(),HttpStatus.OK);
	}
	
//	@GetMapping("/customers/{custid}/addresses/{addressid}")
//	public ResponseEntity<Object> getByAddressId(@PathVariable("custid") int custid,@PathVariable("addressid") int addressid)
//	{
//		Optional<Customer> customer = repo.findById(custid);
//		Customer existingCustomer = new Customer();
//		if(customer.isPresent())
//		{
//			existingCustomer = customer.get();
//		}
//		else
//		{
//			throw new CustomerNotFoundException();
//		}
//		
//		Address address = new Address();
//		
//		for(Address obj:existingCustomer.getAddress())
//		{
//			if(addressid==obj.getId())
//			{
//				address=obj;
//				return new ResponseEntity<>(address,HttpStatus.OK);
//			}
//		}
//		throw new AddressNotFoundException();
//		
//		
//	}
}
