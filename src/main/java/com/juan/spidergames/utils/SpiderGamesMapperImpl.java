package com.juan.spidergames.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.juan.spidergames.api.kakuro.KakuroCellDTO;
import com.juan.spidergames.api.kakuro.KakuroDTO;
import com.juan.spidergames.api.paging.PageResponseDTO.ResultPage;
import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.domain.kakuro.cell.BlackCell;
import com.juan.spidergames.domain.kakuro.cell.KakuroCell;
import com.juan.spidergames.domain.kakuro.cell.ReferenceCell;
import com.juan.spidergames.domain.kakuro.cell.WhiteCell;

@Component
public class SpiderGamesMapperImpl implements SpiderGamesMapper {

	@Override
	public Kakuro mapToEntity(KakuroDTO kakuro) {
		return Kakuro.builder()
				.id(kakuro.getId())
				.difficulty(kakuro.getDifficulty())
				.height(kakuro.getHeight())
				.width(kakuro.getWidth())
				.status(kakuro.getStatus())
				.grid(this.mapToEntity(kakuro.getGrid()))
				.build();
	}

	@Override
	public List<List<KakuroCell>> mapToEntity(List<List<KakuroCellDTO>> grid) {
		return grid.stream().map(this::mapKakuroRowToEntity).collect(Collectors.toList());
	}
	
	@Override
	public List<KakuroCell> mapKakuroRowToEntity(List<KakuroCellDTO> row) {
		return row.stream().map(this::mapToEntity).collect(Collectors.toList());
	}

	@Override
	public KakuroCell mapToEntity(KakuroCellDTO cell) {
		switch(cell.getCellType()) {
		case BLACK: {
			return new BlackCell();
		}
		case WHITE: {
			WhiteCell whiteCell = new WhiteCell();
			whiteCell.setValue(cell.getValue());
			return whiteCell;
		}
		case REFERENCE: {
			ReferenceCell referenceCell = new ReferenceCell();
			referenceCell.setRightReference(cell.getRightReference());
			referenceCell.setDownReference(cell.getRightReference());
			return referenceCell;
		}
		default: {
			throw new BaseBodyResponseException("Invalid cell type: " + cell.getCellType(), HttpStatus.NOT_ACCEPTABLE);
		}
		}
	}
	
	private List<List<KakuroCellDTO>> mapKakuroGridToApi(List<List<KakuroCell>> grid) {
		return grid.stream().map(this::mapKakuroRowToApi).collect(Collectors.toList());
	}
	
	private List<KakuroCellDTO> mapKakuroRowToApi(List<KakuroCell> row) {
		return row.stream().map(this::mapToApi).collect(Collectors.toList());
	}
	
	private KakuroCellDTO mapToApi(KakuroCell cell) {
		return KakuroCellDTO.builder()
				.cellType(cell.getCellType())
				.rightReference(cell.getRightReference())
				.downReference(cell.getDownReference())
				.value(cell.getValue())
				.build();
	}
	
	@Override
    public <T, V> List<V> mapList(List<T> ts, Function<T, V> mapper) {
        return ts.stream().map(mapper).collect(Collectors.toList());
    }
	
	@Override
	public KakuroDTO mapToApi(Kakuro kakuro) {
		return KakuroDTO.builder()
				.id(kakuro.getId())
				.difficulty(kakuro.getDifficulty())
				.height(kakuro.getHeight())
				.width(kakuro.getWidth())
				.status(kakuro.getStatus())
				.grid(this.mapKakuroGridToApi(kakuro.getGrid()))
				.build();
	}

	@Override
	public <T, V> ResultPage<V> mapToPageApi(Page<T> page, Function<T, V> contentMapper) {
		ResultPage<V> result = new ResultPage<V>();
		result.setNumber(page.getNumber());
		result.setNumberOfElements(page.getNumberOfElements());
		result.setSize(page.getSize());
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		result.setIsFirst(page.isFirst());
		result.setIsLast(page.isLast());
		result.setHasNext(page.hasNext());
		result.setHasPrevious(page.hasPrevious());
		result.setContent(this.mapList(page.getContent(), contentMapper));
		
		return result;
	}
	
}
