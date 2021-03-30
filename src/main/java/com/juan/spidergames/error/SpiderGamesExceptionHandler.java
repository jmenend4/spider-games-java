package com.juan.spidergames.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.juan.spidergames.api.responses.BaseBodyError;
import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.api.responses.BodyError;

@ControllerAdvice
public class SpiderGamesExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {BaseBodyResponseException.class})
	public ResponseEntity<BaseBodyError> handleExceptions(BaseBodyResponseException ex, WebRequest request) {
		BodyError error = ex.getError();
		return ResponseEntity.status(error.getCode()).body(BaseBodyError.error(error));
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<BaseBodyError> handleExceptions(Exception ex, WebRequest request) {
		BodyError error = BodyError.builder()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage())
				.name(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseBodyError.error(error));
	}

}
