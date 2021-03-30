package com.juan.spidergames.converters;

import org.springframework.core.convert.converter.Converter;

import com.juan.spidergames.enums.KakuroStatus;

public class KakuroStatusWriteConverter implements Converter<KakuroStatus, String>{

	@Override
	public String convert(KakuroStatus status) {
		return status.getCode();
	}
	

}
