package com.revature.charityapprequestorms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.revature.charityapprequestorms.dto.UserDTO;

@Service
public class UserService {

	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	RestTemplate restTemplate;
	/*
	 * User Microservice is called using url,id is passed as input and validation is
	 * done, if the object is null,rest client exception is catched, if the object
	 * is valid ,returns the result
	 * 
	 */

	public Boolean validateId(final Integer userId) {
		Boolean result = null;
		try {
			String apiUrl = "https://userapp-v1.herokuapp.com";
			ResponseEntity<Boolean> postForEntity = restTemplate.getForEntity(apiUrl + "/admin/" + userId + "/validate",
					Boolean.class);

			result = postForEntity.getBody();

		} catch (RestClientException e) {
			LOGGER.error("Exception", e);
		}
		return result;

	}
	/*
	 * User Microservice is called using url,id is passed as input and user object
	 * is returned if the object is null,rest client exception is catched, if the
	 * object is valid ,returns the result
	 * 
	 */

	public UserDTO getUser(final Integer userId) {
		UserDTO result = new UserDTO();
		try {
			String apiUrl = "https://userapp-v1.herokuapp.com";

			ResponseEntity<UserDTO> postForEntity = restTemplate.getForEntity(apiUrl + "/admin/" + userId,
					UserDTO.class);

			result = postForEntity.getBody();

		} catch (RestClientException e) {
			LOGGER.error("Exception", e);
		}
		return result;

	}

}
