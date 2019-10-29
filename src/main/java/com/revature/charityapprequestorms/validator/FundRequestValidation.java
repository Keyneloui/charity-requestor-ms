package com.revature.charityapprequestorms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.charityapprequestorms.dto.MessageConstant;
import com.revature.charityapprequestorms.exception.ValidatorException;
import com.revature.charityapprequestorms.model.FundRequest;
import com.revature.charityapprequestorms.service.UserService;
@Component

public class FundRequestValidation {
	
	/** Fund request validation **/
	public void fundRequestValidator(FundRequest fundRequest) throws ValidatorException {
		int categoryid = fundRequest.getCategoryId();
		int requestorId = fundRequest.getRequestedBy();
		double fundNeeded = fundRequest.getFundNeeded();
		if (categoryid == 0) {
			throw new ValidatorException(MessageConstant.FUND_REQUEST_VALIDATOR);
		}
		if (requestorId == 0){
			throw new ValidatorException(MessageConstant.FUND_REQUEST_VALIDATOR);
		}
		if (fundNeeded == 0) {
			throw new ValidatorException(MessageConstant.FUND_REQUEST_VALIDATOR);
		}
		
		validateUser(requestorId);
		
	}
	
	@Autowired
	private UserService userService;
	
	public void validateUser(Integer userId) throws ValidatorException {
		
		Boolean validateId = userService.validateId(userId);
		if ( validateId == null || !validateId) {
			throw new ValidatorException("Requestor Id not found");
		}
	}
}
