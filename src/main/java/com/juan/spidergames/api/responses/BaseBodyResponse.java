package com.juan.spidergames.api.responses;

import lombok.Data;

@Data
public class BaseBodyResponse<T> {
	
	private T result;
	private BaseBodyError error;
	
	public BaseBodyResponse(T response) {
		this.result = response;
		this.error = null;
	}
	
	public static <T> BaseBodyResponse<T> result(T response) {
		return new BaseBodyResponse<T>(response);
	}

}
