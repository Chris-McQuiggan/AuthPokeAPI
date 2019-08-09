package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {
	
	private RestTemplate restTemplate;

	@Autowired
	public SourceServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<Object> findByNumber(String number) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+number, HttpMethod.GET, entity, Object.class);

	}

	
	@Override
	public Object getByName(String name) {
		return findByNumber(name).getBody();
	}

	@Override
	public Object getById(String id) {
		return findByNumber(id).getBody();
	}
	
}
