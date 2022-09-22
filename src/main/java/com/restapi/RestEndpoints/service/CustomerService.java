package com.restapi.RestEndpoints.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.restapi.RestEndpoints.entity.Customer;
import com.restapi.RestEndpoints.exception.CustomerEntryIsnotValid;
import com.restapi.RestEndpoints.exception.CustomerNotFoundException;
import com.restapi.RestEndpoints.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	public String createCust(List<Customer> obj)
	{
		for(Customer s:obj)
		{
		if(s.getName()==null || s.getAddress()==null || s.getPhoneno()==null)
		{
			throw new CustomerEntryIsnotValid();
		}
		repository.save(s);
		}
		return "Customer created successfully";
	}
	
	public List<Customer> getAllCustomers()
	{
		return repository.findAll();
	}
	
	public Customer getCustomer(int id)
	{
		Optional<Customer> dbCustomer = repository.findById(id);
		Customer existingCustomer = new Customer();
		if(dbCustomer.isPresent())
		{
			existingCustomer = dbCustomer.get();
		}
		else
		{
			existingCustomer = null;
		}
		return existingCustomer;
	}
	
	public String updateCustomer(int id,Customer obj)
	{
		Optional<Customer> dbCustomer = repository.findById(id);
		Customer existingCustomer = new Customer();
		if(dbCustomer.isPresent())
		{
			existingCustomer = dbCustomer.get();
			existingCustomer.setName(obj.getName());
			existingCustomer.setAddress(obj.getAddress());
			existingCustomer.setPhoneno(obj.getPhoneno());
			repository.save(existingCustomer);
			return "Customer updated successfully";
		}
		throw new CustomerNotFoundException();
	}
	
	public String deleteCustomer(int id)
	{
		Optional<Customer> dbCustomer = repository.findById(id);
		if(dbCustomer.isPresent())
		{
		repository.deleteById(id);
		return "Deleted successfully";
		}
		throw new CustomerNotFoundException();
	}
	
	public List<Customer> getCustomersByName(String name)
	{
		List<Customer> obj=repository.findByName(name);
		
		if(!obj.isEmpty())
		return obj;
		
		throw new CustomerNotFoundException();
	}
	
	public Customer getCustomersByAddress(String address)
	{
		Customer obj = repository.findByAdd(address);
		
		if(obj==null)
		{
			throw new CustomerNotFoundException();
		}
		
		return obj;
	}
	
	public List<Customer> orderByName()
	{
		return repository.orderByName();
	}

}
