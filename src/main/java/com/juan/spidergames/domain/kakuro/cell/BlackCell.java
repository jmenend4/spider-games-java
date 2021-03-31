package com.juan.spidergames.domain.kakuro.cell;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlackCell implements KakuroCell {
	
	private CellType cellType = CellType.BLACK;
}
