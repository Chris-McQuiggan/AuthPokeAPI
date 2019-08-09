package com.bae.service;

import org.springframework.http.ResponseEntity;

public interface SourceService {
	
	public ResponseEntity<Object> findByNumber(String number);

	public Object getByName(String name);
	
	public Object getById(String id);
	
}
