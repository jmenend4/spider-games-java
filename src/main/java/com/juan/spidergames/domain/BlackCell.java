package com.juan.spidergames.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BlackCell implements KakuroCell {
	
	private final CellType cellType = CellType.BLACK;
}
