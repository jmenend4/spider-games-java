package com.juan.spidergames.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WhiteCell implements KakuroCell{
	
	private final CellType cellType = CellType.WHITE;
	private Integer value;
}