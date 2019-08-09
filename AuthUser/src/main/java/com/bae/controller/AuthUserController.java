package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.service.AuthUserServiceIpml;

@RestController
public class AuthUserController {

	private AuthUserServiceIpml service;
	@Autowired
	public AuthUserController(AuthUserServiceIpml service) {
		this.service=service;
	}
	
	@GetMapping(value="/get/{memNum}", produces="application/json")
	public User getUserByMemberNumber(@PathVariable("memNum") String memNum) {
		return service.getUserByMemberNumber(memNum);
	}
	
	@GetMapping(value="/checkid/{id}")
	public Boolean checkUserbyID(@PathVariable("id") Long id) {
		return service.checkUserbyID(id);
	}
	
	@PostMapping(value="/createUser", consumes="application/json")
	public String createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
}
