package com.revature.charityapprequestorms.dto;

public class MessageConstant {

	private MessageConstant() {
		super();
	}

	// ConnectionUtil Messages
	public static final String DRIVER_CLASS = "Unable to load the driver class";

	public static final String SQL_CONNECTION = "Unable to get Connection";

	public static final String CLOSE_CONNECTION = "Unable to close the Connection";

	// Admin class Messages

	public static final String ADMIN_TRANSACTION_EMPTY = "No transactions yet";

	// Fund Request messages

	public static final String FUND_REQUEST = "Unable to list fund";

	public static final String FUND_REQUEST_ADDITION = "Unable to add fund,category id Exists";

	public static final String FUND_REQUEST_ALTER = "Unable to alter fund";

	// Validator Exception Messages

	public static final String FUND_REQUEST_VALIDATOR = "Give valid inputs";

	public static final String REQUESTOR_VALIDATOR = "Requestor Id Not Found";

	public static final String FUND_REQUEST_ID = "Invalid Transaction Id";

}
