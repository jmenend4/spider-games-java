package com.juan.spidergames.api.responses;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BodyError {

	private Integer code;
	private String name;
	private String message;
}
