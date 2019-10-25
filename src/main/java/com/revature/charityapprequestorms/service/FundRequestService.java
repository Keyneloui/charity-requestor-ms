package com.revature.charityapprequestorms.service;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.MessageConstant;
import com.revature.charityapprequestorms.exception.ServiceException;
import com.revature.charityapprequestorms.exception.ValidatorException;
import com.revature.charityapprequestorms.model.FundRequest;
import com.revature.charityapprequestorms.model.RequestorTransaction;
import com.revature.charityapprequestorms.repository.FundRequestRepository;
import com.revature.charityapprequestorms.repository.RequestorTransactionRepository;
import com.revature.charityapprequestorms.validator.FundRequestValidation;

@Service
public class FundRequestService {

	@Autowired
	FundRequestRepository fundRequestRepo;

	@Autowired
	RequestorTransactionRepository requestorTransactionRepo;
	
	@Autowired
	FundRequestValidation fundRequestValidation;
	
	

	/**
	 * Raise fund request in Fund Request service
	 * 
	 * data is passed in fund request object, If the object is returned as null,
	 * return ServiceException If the object is valid, return Fund request object
	 */
	@Transactional
	public void addFundRequest(final FundRequestDto fundRequestDto) throws ServiceException {
		

		try {
			FundRequest fundRequest = new FundRequest();

			fundRequest.setCategoryId(fundRequestDto.getCategoryId());
			fundRequest.setRequestedBy(fundRequestDto.getRequestedBy());
			fundRequest.setFundNeeded(fundRequestDto.getFundNeeded());

		

			FundRequest fundResp = fundRequestRepo.findById(fundRequestDto.getCategoryId());
			if (fundResp == null) {
				fundRequestValidation.fundRequestValidator(fundRequest);
				

				fundRequest.setActive(true);
				fundRequest.setCreatedDate(LocalDateTime.now());
				fundRequest.setModifiedDate(LocalDateTime.now());

				fundRequestRepo.save(fundRequest);
				RequestorTransaction requestorTransaction = new RequestorTransaction();
				requestorTransaction.setStatus("Verified");
				requestorTransaction.setActive(true);
				requestorTransaction.setCreatedDate(LocalDateTime.now());
				requestorTransaction.setModifiedDate(LocalDateTime.now());
				requestorTransaction.setCategoryId(fundRequest.getCategoryId());
				requestorTransaction.setFundNeeded(fundRequest.getFundNeeded());
				requestorTransaction.setRequestedBy(fundRequest.getRequestedBy());
				requestorTransactionRepo.save(requestorTransaction);

			}

			else {
				
				throw new ServiceException(MessageConstant.FUND_REQUEST_ADDITION);

			}
		} 
		catch (ValidatorException e) {
			throw new ServiceException(MessageConstant.FUND_REQUEST_VALIDATOR);

		}catch (Exception e) {
			throw new ServiceException(MessageConstant.FUND_REQUEST_ADDITION);

		}

	}

	public List<FundRequest> findAll() throws ServiceException {
		List<FundRequest> list = null;
		list = fundRequestRepo.findAll();
		if(list.isEmpty())
		{
			throw new ServiceException(MessageConstant.FUND_REQUEST);
		}
		return list;
	}

	public List<RequestorTransaction> findAllRequest() throws ServiceException {
		List<RequestorTransaction> list = null;
		list = requestorTransactionRepo.findAll();
		if(list.isEmpty())
		{
			throw new ServiceException(MessageConstant.FUND_REQUEST);
		}
		return list;
	}

	
}
