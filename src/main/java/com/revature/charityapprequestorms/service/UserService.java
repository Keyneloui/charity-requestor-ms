package com.revature.charityapprequestorms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	public Boolean validateId(final Integer userId) {
		String apiUrl = "https://userapp-v1.herokuapp.com";
		ResponseEntity<Boolean> postForEntity = restTemplate.postForEntity(apiUrl + "/admin/login", userId,
				Boolean.class);
		Boolean result = postForEntity.getBody();

		System.out.println(result);
		return result;

	}
}
