package com.revature.charityapprequestorms.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;



class RequestTransactionDTOTest {

	@Test
	void dtoTest() {
		RequestorTransactionDto requestorTransaction=new RequestorTransactionDto();
		requestorTransaction.setActive(true);
		requestorTransaction.setCategoryId(1);
		requestorTransaction.setStatus("verified");
		//requestorTransaction.setCreatedDate(LocalDateTime.now());
		//requestorTransaction.setModifiedDate(LocalDateTime.now());
		
		requestorTransaction.setFundNeeded(1000.0);
		requestorTransaction.setRequestedBy(1);
		requestorTransaction.setId(1);
		assertEquals(1,requestorTransaction.getCategoryId());
		//assertEquals(requestorTransaction.getCreatedDate(),LocalDateTime.now());
		//assertEquals(requestorTransaction.getModifiedDate(),LocalDateTime.now());
		assertEquals(1000.0,requestorTransaction.getFundNeeded());
		assertEquals(1,requestorTransaction.getId());
		assertEquals("verified",requestorTransaction.getStatus());
	}

}
