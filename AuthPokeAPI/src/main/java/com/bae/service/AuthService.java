package com.bae.service;

import com.bae.entity.AuthLog;
import com.bae.entity.User;

public interface AuthService {

	User getUser(Long userID);
	String createUser(User user);
	String searchPokeAPIName(String poke);
	String searchPokeAPIID(Long pokeID);
	String sendLog(AuthLog log);
	
}
