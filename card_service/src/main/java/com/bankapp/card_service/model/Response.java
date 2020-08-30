package com.bankapp.card_service.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response {

	private Integer statusCode;
	private Object  response;
	
}
