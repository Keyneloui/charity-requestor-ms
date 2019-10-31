package com.revature.charityapprequestorms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	public Boolean validateId(final Integer userId) {
		String apiUrl = "https://userapp-v1.herokuapp.com";
		ResponseEntity<Boolean> postForEntity = restTemplate.getForEntity(apiUrl + "/admin/" + userId + "/validate",
				Boolean.class);
		Boolean result = postForEntity.getBody();

		System.out.println(result);
		return result;

	}

	public UserDTO getUser(final Integer userId) {
		String apiUrl = "https://userapp-v1.herokuapp.com";
		ResponseEntity<UserDTO> postForEntity = restTemplate.getForEntity(apiUrl + "/admin/" + userId, UserDTO.class);
		UserDTO result = postForEntity.getBody();

		System.out.println(result);
		return result;

	}

	public FundRequestDto getFund(final Integer Id) {
		String apiUrl = "https://charity-category.herokuapp.com";
		ResponseEntity<FundRequestDto> postForEntity = restTemplate.getForEntity(apiUrl + "/categories/" + Id,
				FundRequestDto.class);
		FundRequestDto result = postForEntity.getBody();

		System.out.println(result);
		return result;

	}
}
