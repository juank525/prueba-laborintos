package com.laborintos.prueba.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laborintos.prueba.model.User;
import com.laborintos.prueba.repository.IAddressRepository;
import com.laborintos.prueba.repository.ICompanyRepository;
import com.laborintos.prueba.repository.IGeolocationRepository;
import com.laborintos.prueba.repository.IUserRepository;
import com.laborintos.prueba.services.UserClient;

@Component
public class UserBusiness {
	
	@Autowired
	private IAddressRepository  addressRepository;
	
	@Autowired
	private ICompanyRepository companyRepository;
	
	@Autowired
	private IGeolocationRepository geolocationRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserClient userClient;
	
	public void createUsers() {
		User[] users = userClient.getUserServices();
		for(User user : users) {
			user.getAddress().setGeo(geolocationRepository.save(user.getAddress().getGeo()));
			user.setAddress(addressRepository.save(user.getAddress()));
			user.setCompany(companyRepository.save(user.getCompany()));
			userRepository.save(user);
		}
	}

}
