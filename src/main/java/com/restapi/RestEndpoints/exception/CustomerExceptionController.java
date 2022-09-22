package com.restapi.RestEndpoints.exception;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionController {
	
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotfound(CustomerNotFoundException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setTimestamp(Timestamp.from(Instant.now()));
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setError("Customer not found");
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CustomerEntryIsnotValid.class)
	public ResponseEntity<Object> customerNotValid(CustomerEntryIsnotValid exception)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError("Customer Not Valid");
		errorResponse.setTimestamp(Timestamp.from(Instant.now()));
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AddressNotFoundException.class)
	public ResponseEntity<Object> addressNotFound(AddressNotFoundException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(Timestamp.from(Instant.now()));
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setError("Address not found");
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
