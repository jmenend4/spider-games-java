package com.juan.spidergames.domain.kakuro.cell;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WhiteCell implements KakuroCell{
	
	private CellType cellType = CellType.WHITE;
	private Integer value;
}