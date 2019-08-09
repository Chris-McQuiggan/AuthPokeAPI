package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.SourceServiceImpl;


@RestController
public class SourceController {
	
	private SourceServiceImpl service;
	@Autowired
	public SourceController(SourceServiceImpl service) {
		this.service=service;
	}
	
	@GetMapping(value="getByName/{name}", produces="application/json")
	public Object getByName(@PathVariable("name") String name) {
		return service.getByName(name);
	}
	
	@GetMapping(value="getById/{id}", produces="application/json")
	public Object getById(@PathVariable("id") String id) {
		return service.getById(id);
	}
}
