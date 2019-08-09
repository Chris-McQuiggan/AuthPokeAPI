package com.bae.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.AuthLog;
import com.bae.service.LogService;

@RestController
public class LogController {
	
	private LogService service;
	@Autowired
	public LogController(LogService service) {
		this.service=service;
	}
	
	@GetMapping(value="getAllLogs", produces="application/json")
	public Collection<AuthLog> getAllLogs() {
		return service.getAllLogs();
	}

}
