package com.juan.spidergames.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.juan.spidergames.domain.kakuro.cell.BlackCell;
import com.juan.spidergames.domain.kakuro.cell.KakuroCell;
import com.juan.spidergames.domain.kakuro.cell.PersistedCell;
import com.juan.spidergames.domain.kakuro.cell.ReferenceCell;
import com.juan.spidergames.domain.kakuro.cell.WhiteCell;

public class CellsReadConverter implements Converter<List<List<PersistedCell>>, List<List<KakuroCell>>> {

	@Override
	public List<List<KakuroCell>> convert(List<List<PersistedCell>> sourceCells) {
		List<List<KakuroCell>> convertedCells = new ArrayList<>();
		sourceCells.forEach(cellsRow -> {
			List<KakuroCell> convertedCellsRow = new ArrayList<>();
			cellsRow.forEach(cell -> {
				switch(cell.getCellType()) {
				case "BLACK": {
					convertedCellsRow.add(BlackCell.builder().build());
					break;
				}
				case "WHITE": {
					convertedCellsRow.add(WhiteCell.builder().value(cell.getValue()).build());
					break;
				}
				case "REFERENCE": {
					convertedCellsRow.add(ReferenceCell.builder()
							.rightReference(cell.getRightReference())
							.downReference(cell.getRightReference())
							.build());
					break;
				}
				default: {
					throw new RuntimeException("Invalid cell type");
				}
				}
			});
			convertedCells.add(convertedCellsRow);
		});
		return convertedCells;
	}

}
