package com.bae.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.bae.entity.AuthLog;
import com.bae.repository.LogRepository;


@Service
public class LogService {

	private LogRepository repo;

	@Autowired
	public LogService(LogRepository repo) {
		this.repo = repo;
	}

	@JmsListener(destination = "AuthLog", containerFactory = "myFactory")
	public void receiveAccount(AuthLog log) {
		System.out.println("Received User Log:-  " + log.getUserID());
		repo.save(log);
	}
	
	public Collection<AuthLog> getAllLogs(){
		return repo.findAll();
	}

}
