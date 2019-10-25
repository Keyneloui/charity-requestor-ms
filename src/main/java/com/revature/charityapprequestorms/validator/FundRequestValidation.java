package com.revature.charityapprequestorms.validator;

import org.springframework.stereotype.Component;

import com.revature.charityapprequestorms.dto.MessageConstant;
import com.revature.charityapprequestorms.exception.ValidatorException;
import com.revature.charityapprequestorms.model.FundRequest;
@Component

public class FundRequestValidation {
	private FundRequestValidation() {
	}

	static FundRequestValidation fundValidator = null;

	/**
	 * Get instance of Fund request validation class
	 **/
	public static FundRequestValidation getInstance() {
		if (fundValidator == null) {
			fundValidator = new FundRequestValidation();
		}
		return fundValidator;

	}

	/** Fund request validation **/
	public void fundRequestValidator(FundRequest fundRequest) throws ValidatorException {
		int categoryid = fundRequest.getCategoryId();
		int requestorId = fundRequest.getRequestedBy();
		double fundNeeded = fundRequest.getFundNeeded();
		if (categoryid == 0) {
			throw new ValidatorException(MessageConstant.FUND_REQUEST_ADDITION);
		}
		if (requestorId == 0) {
			throw new ValidatorException(MessageConstant.FUND_REQUEST_ADDITION);
		}
		if (fundNeeded == 0) {
			throw new ValidatorException(MessageConstant.FUND_REQUEST_ADDITION);
		}
	}
}
