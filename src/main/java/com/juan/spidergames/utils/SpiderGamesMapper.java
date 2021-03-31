package com.juan.spidergames.utils;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.juan.spidergames.api.kakuro.KakuroCellDTO;
import com.juan.spidergames.api.kakuro.KakuroDTO;
import com.juan.spidergames.api.paging.PageResponseDTO.ResultPage;
import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.domain.kakuro.cell.KakuroCell;

public interface SpiderGamesMapper {

	Kakuro mapToEntity(KakuroDTO kakuro);

	List<List<KakuroCell>> mapToEntity(List<List<KakuroCellDTO>> grid);

	List<KakuroCell> mapKakuroRowToEntity(List<KakuroCellDTO> row);

	KakuroCell mapToEntity(KakuroCellDTO cell);

	KakuroDTO mapToApi(Kakuro kakuro);

	<T, V> List<V> mapList(List<T> ts, Function<T, V> mapper);

	<T, V> ResultPage<V> mapToPageApi(Page<T> page, Function<T, V> contentMapper);

}