package com.bae.service;

import com.bae.entity.User;

public interface AuthUserService {

	User getUserByMemberNumber(String memberNumber);
	Boolean checkUserbyID(Long id);
	String createUser(User user);
	
}
