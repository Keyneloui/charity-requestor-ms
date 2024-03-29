package com.revature.charityapprequestorms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapprequestorms.dto.CategoryDTO;
import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.MailDto;
import com.revature.charityapprequestorms.dto.MessageConstant;
import com.revature.charityapprequestorms.dto.RequestorTransactionDto;
import com.revature.charityapprequestorms.dto.UserDTO;
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

	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	MailService mailService;

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
			fundRequest.setDescription(fundRequestDto.getDescription());
			fundRequest.setTitle(fundRequestDto.getTitle());

			FundRequest fundResp = fundRequestRepo.findById(fundRequestDto.getCategoryId());
			if (fundResp == null) {
				fundRequestValidation.fundRequestValidator(fundRequest);

				fundRequest.setActive(true);
				fundRequest.setCreatedDate(LocalDateTime.now());
				fundRequest.setModifiedDate(LocalDateTime.now());

				fundRequestRepo.save(fundRequest);
				// Mail service
				MailDto mailDTO = new MailDto();
				UserDTO user = userService.getUser(fundRequestDto.getRequestedBy());
				if (user != null) {
					mailDTO.setName(user.getName());
					mailDTO.setEmailId(user.getEmail());
				}
				mailDTO.setTitle(fundRequestDto.getTitle());
				mailDTO.setDescription(fundRequestDto.getDescription());
				mailDTO.setAmount(fundRequestDto.getFundNeeded());
				// Category service
				CategoryDTO categoryDTO = categoryService.getFund(fundRequest.getCategoryId());
				if (categoryDTO != null) {
					fundRequestDto.setCategoryName(categoryDTO.getCategoryName());
				}
				mailDTO.setCategoryName(fundRequestDto.getCategoryName());
				mailService.sendMail(mailDTO);

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
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());

		}

	}

	/**
	 * List fund request in Fund Request service
	 * 
	 * data is iterated in fund request object, If the object is returned as null,
	 * return ServiceException If the object is valid, return Fund request array
	 */

	public List<FundRequestDto> findAll() throws ServiceException {
		List<FundRequest> list = fundRequestRepo.findAll();

		List<FundRequestDto> listDto = new ArrayList<>();
		for (FundRequest fundRequest : list) {
			FundRequestDto dto = new FundRequestDto();
			dto.setCategoryId(fundRequest.getCategoryId());
			dto.setDescription(fundRequest.getDescription());
			dto.setFundNeeded(fundRequest.getFundNeeded());
			dto.setTitle(fundRequest.getTitle());
			dto.setCreatedDate(fundRequest.getCreatedDate());
			dto.setModifiedDate(fundRequest.getModifiedDate());
			dto.setActive(true);
			dto.setRequestedBy(fundRequest.getRequestedBy());
			dto.setId(fundRequest.getId());
			dto.setExpiryDate(fundRequest.getExpiryDate());

			// User service
			UserDTO user = userService.getUser(fundRequest.getRequestedBy());
			if (user != null) {
				dto.setRequestedByName(user.getName());
				dto.setRequestedByEmail(user.getEmail());
			}
			// category Service
			CategoryDTO categoryDTO = categoryService.getFund(fundRequest.getCategoryId());
			if (categoryDTO != null) {
				dto.setCategoryName(categoryDTO.getCategoryName());
			}
			listDto.add(dto);

		}
		if (listDto.isEmpty()) {
			throw new ServiceException(MessageConstant.FUND_REQUEST);
		}
		return listDto;
	}

	/**
	 * List fund request transaction in Fund Request service
	 * 
	 * data is iterated from fund request object, If the object is returned as null,
	 * return ServiceException If the object is valid, return Fund request object
	 */

	public List<RequestorTransactionDto> findAllRequest() throws ServiceException {
		List<RequestorTransaction> list = requestorTransactionRepo.findAll();
		List<RequestorTransactionDto> listDto = new ArrayList<>();
		for (RequestorTransaction requestorTransaction : list) {
			RequestorTransactionDto dto = new RequestorTransactionDto();
			dto.setCategoryId(requestorTransaction.getCategoryId());
			dto.setFundNeeded(requestorTransaction.getFundNeeded());
			dto.setCreatedDate(requestorTransaction.getCreatedDate());
			dto.setModifiedDate(requestorTransaction.getModifiedDate());
			dto.setActive(true);
			dto.setRequestedBy(requestorTransaction.getRequestedBy());
			dto.setId(requestorTransaction.getId());
			listDto.add(dto);

			if (listDto.isEmpty()) {
				throw new ServiceException(MessageConstant.FUND_REQUEST);
			}

		}
		return listDto;
	}

	/**
	 * Viewing fund request transaction in Fund Request service
	 * 
	 * id is returned in fund request object, If the object is returned as null,
	 * return ServiceException If the object is valid, return Fund request object
	 */

	public FundRequestDto findById(int id) throws ServiceException {

		FundRequest fundRequest = fundRequestRepo.findByTransactionId(id);
		FundRequestDto dto = null;
		if (fundRequest != null) {
			dto = new FundRequestDto();
			dto.setCategoryId(fundRequest.getCategoryId());
			dto.setDescription(fundRequest.getDescription());
			dto.setFundNeeded(fundRequest.getFundNeeded());
			dto.setTitle(fundRequest.getTitle());
			dto.setCreatedDate(fundRequest.getCreatedDate());
			dto.setModifiedDate(fundRequest.getModifiedDate());
			dto.setActive(true);
			dto.setRequestedBy(fundRequest.getRequestedBy());
			dto.setId(fundRequest.getId());
			dto.setExpiryDate(fundRequest.getExpiryDate());
			// user service
			UserDTO user = userService.getUser(fundRequest.getRequestedBy());
			if (user != null) {
				dto.setRequestedByName(user.getName());
				dto.setRequestedByEmail(user.getEmail());
			}
			// category service
			CategoryDTO categoryDTO = categoryService.getFund(fundRequest.getCategoryId());
			if (categoryDTO != null) {
				dto.setCategoryName(categoryDTO.getCategoryName());
			} else {
				throw new ServiceException(MessageConstant.FUND_REQUEST_ID);
			}

		}
		return dto;
	}
}
