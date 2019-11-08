package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class CategoryDTOTest {

	@Test
	void dtoTest() {
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setCategoryName("Education");
		assertEquals("Education",categoryDTO.getCategoryName());
		
		
	}

	

}
