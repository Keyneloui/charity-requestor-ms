package com.revature.charityapprequestorms.dto;



import java.time.LocalDateTime;

import lombok.Data;

@Data

public class FundRequestDto {

	private Integer id;

	private int categoryId;

	private double fundNeeded;

	private int requestedBy;
	
	private String createdBy = "keyne";

	private LocalDateTime createdDate;

	private LocalDateTime modifiedDate;

	private boolean active;

}
