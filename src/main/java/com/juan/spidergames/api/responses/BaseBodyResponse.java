package com.juan.spidergames.api.responses;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseBodyResponse<T> {
	
	private T result;
	private BodyError error;
	
	public BaseBodyResponse(T result) {
		this.result = result;
		this.error = null;
	}
	
	public static <T, V> V result(T result, Class<V> clazz) {
		V response = null;
		try {
			response = clazz.getDeclaredConstructor().newInstance();
			Method setResult = clazz.getMethod("setResult", Object.class);
			setResult.invoke(response, result);
		} catch (Exception e) {
			throw new BaseBodyResponseException(
					"There was an issue generating the response but the service was executed successfully"
					, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		return response;
	}

}
