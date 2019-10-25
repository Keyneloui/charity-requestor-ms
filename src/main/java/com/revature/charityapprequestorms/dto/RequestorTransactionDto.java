package com.revature.charityapprequestorms.dto;


import java.time.LocalDateTime;



import lombok.Data;

@Data

public class RequestorTransactionDto {
	
	private Integer id;

	
	private int categoryId;

	
	private double fundNeeded;
	
	
	private String status;

	
	private int requestedBy;

	
	private LocalDateTime createdDate;

	
	private LocalDateTime modifiedDate;

	
	private boolean active;

}
