package com.juan.spidergames.converters;

import org.springframework.core.convert.converter.Converter;

import com.juan.spidergames.enums.Difficulty;

public class DificultyWriteConverter implements Converter<Difficulty, String>{

	@Override
	public String convert(Difficulty dificulty) {
		return dificulty.getCode();
	}

}
