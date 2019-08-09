package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.entity.User;
import com.bae.repository.UserRepository;

@Service
public class AuthUserServiceImpl implements AuthUserService {

	private UserRepository repo;

	@Autowired
	public AuthUserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User getUserByMemberNumber(String memberNumber) {
		User user = new User((long) 0, "na", "na");
		List<User> userList = repo.findAll();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(i);
			System.out.println(userList.get(i).getMemberNumber());
			System.out.println(memberNumber);
			if ((String)userList.get(i).getMemberNumber() == memberNumber) {
				System.out.println("if used");
				user.setId(userList.get(i).getId());
				user.setMemberNumber(userList.get(i).getMemberNumber());
				user.setUsername(userList.get(i).getUsername());
			}
		}
		return user;
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
