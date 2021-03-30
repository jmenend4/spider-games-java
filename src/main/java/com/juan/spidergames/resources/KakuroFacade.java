package com.juan.spidergames.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.juan.spidergames.api.responses.BaseBodyResponse;
import com.juan.spidergames.api.responses.BaseBodyResponseException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakuroFacade {
	
	public ResponseEntity<BaseBodyResponse<String>> putKakuro() {
		throw new BaseBodyResponseException("ErrorError", HttpStatus.BAD_REQUEST);
//		return ResponseEntity.ok(BaseBodyResponse.response("holahola"));
	}

}
