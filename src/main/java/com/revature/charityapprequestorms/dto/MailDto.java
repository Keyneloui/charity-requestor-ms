package com.revature.charityapprequestorms.dto;

import lombok.Data;

@Data
public class MailDto {
	private String description;

	private String categoryName;

	private String title;
	
	private double amount;
	
	private String name;
	
	private String emailId;

}
