package com.revature.charityapprequestorms.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapprequestorms.dto.MailDto;

@SpringBootTest
class MailServiceTest {

	@Autowired
	MailService mailService;

	@Autowired
	UserService userService;

	@Test
	void sendMailTest() {

		MailDto mailDTO = new MailDto();

		mailDTO.setName("keyne");
		mailDTO.setEmailId("keyne.loui@gmail.com");

		mailDTO.setTitle("Food");
		mailDTO.setDescription("Fund for poor children's survival");
		mailDTO.setAmount(10000);

		mailDTO.setCategoryName("food");
		mailService.sendMail(mailDTO);
		assert(true);
	}

}
