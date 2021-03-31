package com.juan.spidergames.domain.kakuro.cell;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReferenceCell implements KakuroCell {
	
	private CellType cellType = CellType.REFERENCE;
	private Integer rightReference;
	private Integer downReference;
}
