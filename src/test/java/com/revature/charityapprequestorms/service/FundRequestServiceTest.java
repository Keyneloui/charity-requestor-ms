package com.revature.charityapprequestorms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.RequestorTransactionDto;
import com.revature.charityapprequestorms.exception.ServiceException;

import com.revature.charityapprequestorms.model.RequestorTransaction;

@SpringBootTest
class FundRequestServiceTest {

	@Autowired
	FundRequestService fundRequestService;

	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	MailService mailService;

//	@Test
	void addFundRequestTest() throws ServiceException {
		FundRequestDto fundRequestDTO = new FundRequestDto();

		fundRequestDTO.setCategoryId(8);
		fundRequestDTO.setRequestedBy(1);
		fundRequestDTO.setFundNeeded(1000);
		fundRequestDTO.setDescription("Food for children");
		fundRequestDTO.setTitle("Food");
		fundRequestDTO.setActive(true);
		fundRequestDTO.setCreatedDate(LocalDateTime.now());
		fundRequestDTO.setModifiedDate(LocalDateTime.now());
		fundRequestService.addFundRequest(fundRequestDTO);
		assertNotNull(fundRequestDTO);

		RequestorTransaction requestorTransaction = new RequestorTransaction();
		requestorTransaction.setStatus("Verified");
		requestorTransaction.setActive(true);
		requestorTransaction.setCreatedDate(LocalDateTime.now());
		requestorTransaction.setModifiedDate(LocalDateTime.now());
		requestorTransaction.setCategoryId(1);
		requestorTransaction.setFundNeeded(1000);
		requestorTransaction.setRequestedBy(1);
	}

	@Test
	void findAllTest() throws ServiceException {

		List<FundRequestDto> fundRequestObj = null;
		fundRequestObj = fundRequestService.findAll();
		assertNotNull(fundRequestObj);

	}
	@Test
	void findAllRequestTest() throws ServiceException {

		List<RequestorTransactionDto> fundRequestObj = null;
		fundRequestObj = fundRequestService.findAllRequest();
		assertNotNull(fundRequestObj);

	}
	//@Test
	void findByIdTest() throws ServiceException{
		
		FundRequestDto fundRequestObj=null;
		fundRequestObj=fundRequestService.findById(3);
		assertNotNull(fundRequestObj);
		

}
}
