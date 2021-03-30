package com.juan.spidergames.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;

import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.enums.EnumUtils;
import com.juan.spidergames.enums.KakuroStatus;

public class KakuroStatusReadConverter implements Converter<String, KakuroStatus> {

	@Override
	public KakuroStatus convert(String statusCode) {
		KakuroStatus status = EnumUtils.getKakuroStatusByCode(statusCode);
		if(status == null) {
			throw new BaseBodyResponseException("Could not convert Kakuro status code " + statusCode 
					+ " to an actual status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return status;
	}

}
