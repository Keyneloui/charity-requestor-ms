package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;



class FundRequestDTOTest {

	//@Test
	void fundRequestTest() {
		FundRequestDto fundRequest=new FundRequestDto();
		fundRequest.setActive(true);
		fundRequest.setCategoryId(1);
		//fundRequest.setCreatedDate(LocalDateTime.now());
		//fundRequest.setExpiryDate(LocalDateTime.now());
		//fundRequest.setModifiedDate(LocalDateTime.now());
		fundRequest.setDescription("Fund for poor children education");
		fundRequest.setTitle("Food");
		fundRequest.setFundNeeded(1000.0);
		fundRequest.setRequestedBy(1);
		fundRequest.setId(1);
		fundRequest.setCategoryName("Food");
		fundRequest.setRequestedByEmail("keyne.loui@gmail.com");
		fundRequest.setRequestedByName("keyne");
		assertEquals(1,fundRequest.getCategoryId());
		//assertEquals(fundRequest.getCreatedDate(),LocalDateTime.now());
		//assertEquals(fundRequest.getExpiryDate(),LocalDateTime.now());
		//assertEquals(fundRequest.getModifiedDate(),LocalDateTime.now());
		assertEquals("Fund for poor children education",fundRequest.getDescription());
		assertEquals("Food",fundRequest.getTitle());
		assertEquals(1000.0,fundRequest.getFundNeeded());
		assertEquals(1,fundRequest.getId());
		assertEquals("Food",fundRequest.getCategoryName());
		assertEquals("keyne.loui@gmail.com",fundRequest.getRequestedByEmail());
		assertEquals("keyne",fundRequest.getRequestedByName());
		
	}

}
