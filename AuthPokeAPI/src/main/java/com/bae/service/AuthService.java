package com.bae.service;

import com.bae.entity.AuthLog;
import com.bae.entity.User;

public interface AuthService {

	User getUser(String memberNumber);
	String createUser(User user);
	Object searchPokeAPIName(String poke, Long userID);
	Object searchPokeAPIID(String pokeID, Long userID);
	void sendLog(AuthLog log);
	Boolean checkUser(Long userID);
}
