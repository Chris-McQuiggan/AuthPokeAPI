package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

public class AuthUserServiceImpl implements AuthUserService{
	
	private UserRepository repo;

	@Autowired
	public AuthUserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User getUserByMemberNumber(String memberNumber) {
		List<User> userList = repo.findAll();
		for (int i=0 ; i<userList.size() ; i++) {
			if(userList.get(i).getMemberNumber()==memberNumber) {
				return userList.get(i);
			}
		}
		return null;
	}

	@Override
	public Boolean checkUserbyID(Long id) {
		Boolean user = repo.existsById(id);
		return user;
	}

	@Override
	public String createUser(User user) {
		repo.save(user);
		return "User Created Successfully";
	}

}
