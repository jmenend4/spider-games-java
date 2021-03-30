package com.juan.spidergames.api.responses;

import lombok.Getter;

@Getter
public class BaseBodyError {
	
	private BodyError error;

	public BaseBodyError(BodyError error) {
		this.error = error;
	}
	
	public static BaseBodyError error(BodyError error) {
		return new BaseBodyError(error);
	}
}
