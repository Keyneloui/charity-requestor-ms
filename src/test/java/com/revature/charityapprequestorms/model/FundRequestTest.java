package com.revature.charityapprequestorms.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FundRequestTest {

	//@Test
	public void fundRequest() {
		FundRequest fundRequest = new FundRequest();
		fundRequest.setActive(true);
		fundRequest.setCategoryId(1);
		//fundRequest.setCreatedDate(LocalDateTime.now());
		//assertEquals(fundRequest.getCreatedDate(), LocalDateTime.now());
		//fundRequest.setExpiryDate(LocalDateTime.now());
		//assertEquals(fundRequest.getExpiryDate(), LocalDateTime.now());
		//fundRequest.setModifiedDate(LocalDateTime.now());
		//assertEquals(fundRequest.getModifiedDate(), LocalDateTime.now());
		fundRequest.setDescription("Fund for poor children education");
		fundRequest.setTitle("Food");
		fundRequest.setFundNeeded(1000.0);
		fundRequest.setRequestedBy(1);
		fundRequest.setId(1);
		assertEquals(1, fundRequest.getCategoryId());
		assertEquals("Fund for poor children education", fundRequest.getDescription());
		assertEquals("Food", fundRequest.getTitle());
		assertEquals(1000.0, fundRequest.getFundNeeded());
		assertEquals(1, fundRequest.getId());
	}

}
