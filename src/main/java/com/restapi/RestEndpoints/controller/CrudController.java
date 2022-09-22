package com.restapi.RestEndpoints.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.RestEndpoints.repository.CustomerRepository;
import com.restapi.RestEndpoints.service.CustomerService;
import com.restapi.RestEndpoints.entity.Customer;
import com.restapi.RestEndpoints.exception.CustomerNotFoundException;

@RestController
public class CrudController {

	@Autowired
	CustomerService service;
	
	@PostMapping("/customers")
	public ResponseEntity<Object> createCust(@RequestBody List<Customer> obj)
	{
		String message = service.createCust(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content","foo");
		Map<String,String> mp = new HashMap<>();
		mp.put("message",message);
		return new ResponseEntity<>(mp,headers,HttpStatus.CREATED);
	}
	
	// Getting all the customers
	@GetMapping("/customers")
	public ResponseEntity<Object> getAllCustomers()
	{
		List<Customer> obj = new ArrayList<>();
//		if(name!=null)
//		{
//			obj = service.getCustomersByName(name);
//		}
//		else
//		{
		obj = service.getAllCustomers();
//		}
		
		
		if(obj.isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		return new ResponseEntity<>(obj,HttpStatus.OK);
		
	}
	
	// getting the customers by id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable("id") int id)
	{
		Customer obj = new Customer();
		obj = service.getCustomer(id);
		
		if(obj!=null)
		{
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		throw new CustomerNotFoundException();
		
		
	}
	
	//getting the customers by name
//	@GetMapping("/customers")
//	public ResponseEntity<Object> getCustomersByName(@RequestParam("name") String name)
//	{
//		List<Customer> obj = new ArrayList<>();
//		obj = service.getCustomersByName(name);
//		
//		if(obj.isEmpty())
//		{
//			throw new CustomerNotFoundException();
//		}
//		return new ResponseEntity<>(obj,HttpStatus.OK);
//	}
	
//	@GetMapping("/getByAdd")
//	public Customer getCustomersByAdd(@RequestParam("address") String address)
//	{
//		return service.getCustomersByAddress(address);
//	}
	
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id,@RequestBody Customer obj)
	{
		String msg = service.updateCustomer(id, obj);
		Map<String,String> response = new HashMap<>();
		response.put("Message",msg);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id)
	{
		String msg = service.deleteCustomer(id);
		Map<String,String> response = new HashMap<>();
		response.put("Message",msg);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
//	@GetMapping("/orderByName")
//	public List<Customer> orderByName()
//	{
//		return service.orderByName();
//		
//	}
	
}
