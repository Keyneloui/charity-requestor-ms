package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MailDTOTest {

	//@Test
	void dtoTest() {
		MailDto mailDto=new MailDto();
		mailDto.setAmount(1000.0);
		mailDto.setCategoryName("Food");
		mailDto.setDescription("Food for children");
		mailDto.setEmailId("keyne.loui@gmail.com");
		mailDto.setName("keyne");
		mailDto.setTitle("Eatables");
		assertEquals(1000.0,mailDto.getAmount());
		assertEquals("Food",mailDto.getCategoryName());
		assertEquals("Food for children",mailDto.getDescription());
		assertEquals("keyne.loui@gmail.com",mailDto.getEmailId());
		assertEquals("keyne",mailDto.getName());
		assertEquals("Eatables",mailDto.getTitle());
	
	}

}
