package com.revature.charityapprequestorms.dto;

public class MessageConstant {

	// ConnectionUtil Messages
	public static final String DRIVER_CLASS = "Unable to load the driver class";

	public static final String SQL_CONNECTION = "Unable to get Connection";

	public static final String CLOSE_CONNECTION = "Unable to close the Connection";

	// Login Messages

	public static final String INVALID_LOGIN_CREDENTIALS = "Invalid Email/Password";

	// Donor class Messages

	public static final String DONOR_LIST_EMPTY = "No Donor Contributions yet";

	public static final String DONOR_TRANSACTION_EMPTY = "No transactions yet";

	public static final String USER_ALREADY_EXISTS = "User Already Exists,Register with a new email";

	// Admin class Messages

	public static final String ADMIN_TRANSACTION_EMPTY = "No transactions yet";

	// Fund Request messages

	public static final String FUND_REQUEST = "Unable to list fund";

	public static final String FUND_REQUEST_ADDITION = "Unable to add fund,category id Exists";

	public static final String FUND_REQUEST_ALTER = "Unable to alter fund";
	
	//Validator Exception Messages
	
	public static final String FUND_REQUEST_VALIDATOR="Give valid inputs";

}
