package com.revature.charityapprequestorms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapprequestorms.dto.UserDTO;


@SpringBootTest
class UserServiceTest {
	@Autowired
	UserService userService;

	//@Test
	void validTest() {
		
		Boolean userDto=null;
		int userId=1;
		userDto=userService.validateId(userId);
		assertNotNull(userDto);
		
	}
	//@Test
	void inValidTest() {
		
		Boolean userDto=null;
		int userId=12;
		userDto=userService.validateId(userId);
		assertFalse(userDto);
		
	}
	//@Test
	void validIdTest()
	{
		UserDTO userDto=null;
		int userId=1;
		userDto=userService.getUser(userId);
		assertNotNull(userDto);
	}
	//@Test
	void inValidIdTest()
	{
		UserDTO userDto=null;
		int id=12;
		
		userDto=userService.getUser(id);
		assertNull(userDto.getId());
	}

}
