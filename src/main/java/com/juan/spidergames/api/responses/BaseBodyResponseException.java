package com.juan.spidergames.api.responses;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseBodyResponseException extends RuntimeException {

	private static final long serialVersionUID = 7442870445642147368L;
	private BodyError error;
	
	public BaseBodyResponseException(String message, HttpStatus status) {
		super(message);
		this.error =  BodyError.builder().code(status.value()).message(message).name(status.name()).build();
	}

}
