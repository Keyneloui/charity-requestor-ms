package com.revature.charityapprequestorms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.revature.charityapprequestorms.dto.CategoryDTO;

@Service
public class CategoryService {
	@Autowired
	RestTemplate restTemplate;
	public CategoryDTO getFund(final Integer Id) {
		String apiUrl = "https://charity-category.herokuapp.com";
		CategoryDTO result = null;
		try {
			ResponseEntity<CategoryDTO> postForEntity = restTemplate.getForEntity(apiUrl + "/categories/" + Id,
					CategoryDTO.class);
			result = postForEntity.getBody();
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);
		return result;

	}

}
