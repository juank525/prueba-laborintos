package com.laborintos.prueba.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.laborintos.prueba.model.User;

@Component
public class UserClient {
	
	@Value("${url.services.rest}")
	private String urlService;

	public User[] getUserServices() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(urlService, User[].class);
		User[] usersServices = responseEntity.getBody();
		return usersServices;
	}
}
