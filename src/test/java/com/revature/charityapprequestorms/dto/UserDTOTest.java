package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDTOTest {

	//@Test
	void dtoTest() {
		UserDTO userDTO=new UserDTO();
		userDTO.setId(1);
		userDTO.setEmail("keyne.loui@gmail.com");
		userDTO.setName("keyne");
		assertEquals("keyne",userDTO.getName());
		assertEquals("keyne.loui@gmail.com",userDTO.getEmail());
		assertEquals(1,userDTO.getId());
	}

}
