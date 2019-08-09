package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.User;
import com.bae.service.AuthServiceIpml;



@RestController
public class AuthController {

	private AuthServiceIpml service;
	@Autowired
	public AuthController(AuthServiceIpml service) {
		this.service=service;
	}
	
	@PostMapping(value="createUser", consumes="application/json")
	public String createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	
	@GetMapping(value="searchPokeAPIName/{userID}/{pokeName}", produces="application/json")
	public Object serchPokeAPIName(@PathVariable("userID") Long userID, @PathVariable("pokeName") String pokeName) {
		return service.searchPokeAPIName(pokeName, userID);
	}

	@GetMapping(value="searchPokeAPIID/{userID}/{pokeID}", produces="application/json")
	public Object serchPokeAPIID(@PathVariable("userID") Long userID, @PathVariable("pokeID") String pokeID) {
		return service.searchPokeAPIName(pokeID, userID);
	}
}
