package com.revature.charityapprequestorms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapprequestorms.dto.CategoryDTO;

@SpringBootTest
class CategoryServiceTest {
	@Autowired
	CategoryService categoryService;

	//@Test
	void validIdFundTest() {
		int categoryId=1;
		CategoryDTO categoryDto=null;
		categoryDto=categoryService.getFund(categoryId);
		assertNotNull(categoryDto);
		
		
	}
	//@Test
	void inValidIdFundTest() {
		int categoryId=12;
		CategoryDTO categoryDto=null;
		categoryDto=categoryService.getFund(categoryId);
		assertNull(categoryDto);
		
		
	}

}
