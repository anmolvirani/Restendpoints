package com.restapi.RestEndpoints.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private HttpStatus status;
	private String error;
	
	private Timestamp timestamp;
	
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus notFound) {
		this.status = notFound;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
