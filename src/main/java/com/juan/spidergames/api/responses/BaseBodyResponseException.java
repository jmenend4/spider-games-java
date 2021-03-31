package com.juan.spidergames.api.responses;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
@SuppressWarnings("serial")
public class BaseBodyResponseException extends RuntimeException {

	private BodyError error;
	
	public BaseBodyResponseException(String message, HttpStatus status) {
		super(message);
		this.error =  BodyError.builder().code(status.value()).message(message).name(status.name()).build();
	}

}
