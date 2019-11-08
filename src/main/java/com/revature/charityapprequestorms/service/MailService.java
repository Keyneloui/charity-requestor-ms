package com.revature.charityapprequestorms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.revature.charityapprequestorms.dto.MailDto;

@Service
public class MailService {
	@Autowired
	RestTemplate restTemplate;

	private static Logger LOGGER = LoggerFactory.getLogger(MailService.class);
	/*
	 * Mail Microservice is called using the url,mailDTO class is taken, and the
	 * corresponding messages is passed to the mail using the dto class parameters
	 */

	void sendMail(final MailDto mailDTO) {
		try {
			String apiUrl = "https://charity-notification.herokuapp.com";
			ResponseEntity<Void> postForEntity = restTemplate.postForEntity(apiUrl + "/mail/fundReqMail", mailDTO,
					Void.class);
			System.out.println(postForEntity);
		} catch (RestClientException e) {
			LOGGER.error("Exception", e);
		}
	}

}
