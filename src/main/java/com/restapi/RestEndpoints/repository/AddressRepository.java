package com.restapi.RestEndpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.RestEndpoints.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
