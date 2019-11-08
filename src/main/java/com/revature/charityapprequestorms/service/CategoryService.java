package com.revature.charityapprequestorms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CategoryService.class);
	/* Category Microservice is called using url,id is passed as input and category name object
	 * is returned,if the object is null,rest client exception is catched,
	 * if the object is valid ,returns the result
	 * 
	 */
	public CategoryDTO getFund(final Integer Id) {
		String apiUrl = "https://charity-category.herokuapp.com";
		CategoryDTO result = null;
		try {
			ResponseEntity<CategoryDTO> postForEntity = restTemplate.getForEntity(apiUrl + "/categories/" + Id,
					CategoryDTO.class);
			result = postForEntity.getBody();
		} catch (RestClientException e) {
			LOGGER.error("RestClientException",e);
		}

		return result;

	}

}
