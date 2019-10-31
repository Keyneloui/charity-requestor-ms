package com.revature.charityapprequestorms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.charityapprequestorms.dto.CategoryDTO;

@Service
public class CategoryService {
	@Autowired
	RestTemplate restTemplate;
	public CategoryDTO getFund(final Integer Id) {
		String apiUrl = "https://charity-category.herokuapp.com";
		ResponseEntity<CategoryDTO> postForEntity = restTemplate.getForEntity(apiUrl + "/categories/" + Id,
				CategoryDTO.class);
		CategoryDTO result = postForEntity.getBody();

		System.out.println(result);
		return result;

	}

}
