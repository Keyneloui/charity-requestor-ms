package com.revature.charityapprequestorms.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapprequestorms.model.FundRequest;

@SpringBootTest
class FundRequestRepositoryTest {
	
	@Autowired
	FundRequestRepository fundRequestRepository;

	//@Test
	void findByIdTest() {
		int categoryId=1;
		FundRequest fundRequest=null;
		fundRequest=fundRequestRepository.findById(categoryId);
		assertNotNull(fundRequest);
		
	}
	////@Test
	void findByTransactionId()
	{
		int id=3;
		FundRequest fundRequest=null;
		fundRequest=fundRequestRepository.findByTransactionId(id);
		assertNotNull(fundRequest);
	}

}
