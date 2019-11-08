package com.revature.charityapprequestorms.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestorTransactionTest {

	//@Test
	public void fundRequest() {
		RequestorTransaction requestorTransaction = new RequestorTransaction();
		requestorTransaction.setActive(true);
		requestorTransaction.setCategoryId(1);
		requestorTransaction.setStatus("verified");
		requestorTransaction.setFundNeeded(1000.0);
		requestorTransaction.setRequestedBy(1);
		requestorTransaction.setId(1);
		assertEquals(1, requestorTransaction.getCategoryId());
		assertEquals("verified", requestorTransaction.getStatus());
		assertEquals(1000.0, requestorTransaction.getFundNeeded());
		assertEquals(1, requestorTransaction.getRequestedBy());
		assertEquals(1, requestorTransaction.getId());
		//requestorTransaction.setCreatedDate(LocalDateTime.now());
		//assertEquals(requestorTransaction.getCreatedDate(), LocalDateTime.now());
		//requestorTransaction.setModifiedDate(LocalDateTime.now());
		//assertEquals(requestorTransaction.getModifiedDate(), LocalDateTime.now());

	}

}
