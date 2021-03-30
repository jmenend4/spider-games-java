package com.juan.spidergames.converters;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.juan.spidergames.domain.KakuroCell;

public class CellsWriteConverter implements Converter<List<List<KakuroCell>>, List<List<KakuroCell>>> {

	@Override
	public List<List<KakuroCell>> convert(List<List<KakuroCell>> cells) {
		return cells;
	}

}
