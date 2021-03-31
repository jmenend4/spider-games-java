package com.juan.spidergames.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;

import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.enums.Difficulty;
import com.juan.spidergames.enums.EnumUtils;

public class DificultyReadConverter implements Converter<String, Difficulty> {

	@Override
	public Difficulty convert(String code) {
		Difficulty dificulty = EnumUtils.getDificultyByCode(code);
		if(dificulty == null) {
			throw new BaseBodyResponseException(
					"Could not convert dificulty code " + code, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return dificulty;
	}

}
