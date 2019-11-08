package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageTest {
	

	@Test
	void messageTest() {
		Message message=new Message(null);
		message.setMessage("charityapp");
		assertEquals("charityapp",message.getMessage());
		
	}

}
