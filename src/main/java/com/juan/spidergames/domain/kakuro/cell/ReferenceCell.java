package com.juan.spidergames.domain.kakuro.cell;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReferenceCell implements KakuroCell {
	
	private final CellType cellType = CellType.REFERENCE;
	private Integer rightReference;
	private Integer downReference;
}
