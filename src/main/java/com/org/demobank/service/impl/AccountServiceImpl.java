package com.org.demobank.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.demobank.bean.User;
import com.org.demobank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	public User getAccountInfo(String userName) {
		RestTemplate restTemplate = new RestTemplate();
		String sapiResourceUrl
		  = "http://localhost:8082/demosapi/"+userName+"/account";

		ResponseEntity<User> response
		  = restTemplate.getForEntity(sapiResourceUrl, User.class);

		return response.getBody();
	}

}
