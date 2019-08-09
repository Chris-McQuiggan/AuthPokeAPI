package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.AuthLog;
import com.bae.entity.User;

@Service
public class AuthServiceIpml implements AuthService{
	
	private RestTemplate restTemplate;
    private JmsTemplate jmsTemplate;

	@Autowired
	public AuthServiceIpml(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate = restTemplate;
        this.jmsTemplate = jmsTemplate;
	}

	@Override
	public User getUser(String memberNumber) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String createUser(User user) {
		HttpEntity<User> entity = new HttpEntity<User>(user);
		ResponseEntity<String> exchangePoke = restTemplate.exchange(
				"http://localhost:8081/createUser/",
				HttpMethod.POST, entity, String.class);
		return exchangePoke.getBody();
	}

	@Override
	public void sendLog(AuthLog log) {
		jmsTemplate.convertAndSend("AuthLog", log);
	}

	@Override
	public Object searchPokeAPIName(String pokeName, Long userID) {
		AuthLog log = new AuthLog(userID, pokeName);
		sendLog(log);
		if(checkUser(userID)) {
			ResponseEntity<Object> exchangePoke = restTemplate.exchange(
					"http://localhost:8082/getByName/"+pokeName,
					HttpMethod.GET, null, Object.class);
			return exchangePoke.getBody();
		}
		return null;
	}

	@Override
	public Object searchPokeAPIID(String pokeID, Long userID) {
		AuthLog log = new AuthLog(userID, pokeID);
		sendLog(log);
		if(checkUser(userID)) {
			ResponseEntity<Object> exchangePoke = restTemplate.exchange(
					"http://localhost:8082/getById/"+pokeID,
					HttpMethod.GET, null, Object.class);
			return exchangePoke.getBody();
		}
		return null;
	}

	@Override
	public Boolean checkUser(Long userID) {
		ResponseEntity<Boolean> exchangePoke = restTemplate.exchange(
				"http://localhost:8081/checkid/"+userID,
				HttpMethod.GET, null, Boolean.class);
		return exchangePoke.getBody();
	}

}
