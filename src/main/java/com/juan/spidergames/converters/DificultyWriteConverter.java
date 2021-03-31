package com.juan.spidergames.converters;

import org.springframework.core.convert.converter.Converter;

import com.juan.spidergames.enums.Dificulty;

public class DificultyWriteConverter implements Converter<Dificulty, String>{

	@Override
	public String convert(Dificulty dificulty) {
		return dificulty.getCode();
	}

}
