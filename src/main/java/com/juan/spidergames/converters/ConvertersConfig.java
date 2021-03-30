package com.juan.spidergames.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class ConvertersConfig {
	
	@Bean
	public MongoCustomConversions cellsConverters() {
		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new CellsReadConverter());
		converters.add(new CellsWriteConverter());
		
		return new MongoCustomConversions(converters);
	}

}
