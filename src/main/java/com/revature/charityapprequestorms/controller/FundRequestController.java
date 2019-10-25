package com.revature.charityapprequestorms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.Message;
import com.revature.charityapprequestorms.exception.ServiceException;
import com.revature.charityapprequestorms.model.FundRequest;
import com.revature.charityapprequestorms.model.RequestorTransaction;
import com.revature.charityapprequestorms.service.FundRequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("fundrequest")
public class FundRequestController {
	@Autowired
	FundRequestService fundRequestService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FundRequestController.class);

	/**
	 * Raise fund request in Fund Request Controller
	 * 
	 * @RequestBody  If the object is Invalid, return
	 *        ServiceException ,If the credential is valid, return UserDetails object
	 */

	@PostMapping
	@ApiOperation(value = "RaiseRequest API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fund added Successfully", response = FundRequestDto.class),
			@ApiResponse(code = 400, message = "Fund cannot be added", response = Message.class) })
	public ResponseEntity<?> addRequest(@RequestBody FundRequestDto fundRequestDto) {

		try {
			fundRequestService.addFundRequest(fundRequestDto);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (ServiceException e) {
			LOGGER.error("ServiceException",e);

			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**
	 * List  Current Fund request in Fund request Controller
	 * 
	 * If the list is returned as null, return ServiceException If the list is
	 * valid, return UserDetails object
	 */

	@GetMapping("/listCurrentRequest")
	@ApiOperation(value = "listCurrentRequest API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = FundRequest.class),
			@ApiResponse(code = 400, message = "Fund request cannot be listed", response = Message.class) })

	public ResponseEntity<?> listFundRequest() {

		List<FundRequest> list = null;
		

		try {
			list = fundRequestService.findAll();

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ServiceException e) {
			LOGGER.error("Exception",e);
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}
	/**
	 * List All Fund request in Fund request Controller
	 * 
	 * If the list is returned as null, return ServiceException If the list is
	 * valid, return UserDetails object
	 */

	@GetMapping("/RequestorTransaction")
	@ApiOperation(value = "List Requestor Transaction API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = RequestorTransaction.class),
			@ApiResponse(code = 400, message = "Fund request cannot be listed", response = Message.class) })

	public ResponseEntity<?> listAllRequest() {

		List<RequestorTransaction> list = null;
		

		try {
			list = fundRequestService.findAllRequest();

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (ServiceException e) {
			LOGGER.error("Exception",e);
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}

}
