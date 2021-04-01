package com.juan.spidergames.utils;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import com.juan.spidergames.api.kakuro.KakuroCellDTO;
import com.juan.spidergames.api.kakuro.KakuroDTO;
import com.juan.spidergames.api.paging.PageResponseDTO.ResultPage;
import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.domain.kakuro.cell.KakuroCell;

/**
 * The purpose of this class is to provide the conversion methods from API transfer objects to database documents
 * and viceversa. It also provides the appropriate collection mappings.
 * @author Juan Menendez
 *
 */
public interface SpiderGamesMapper {

	/**
	 * Map the kakuro data transfer object to a kakuro document object in order to be persisted
	 * @param kakuro
	 * @return kakuro document
	 */
	Kakuro mapToEntity(KakuroDTO kakuro);
	
	/**
	 * Map a kakuro grid of transfer object cells to a grid of db document cells
	 * @param grid
	 * @return a list of lists of document cells representing the kakuro grid to be persisted
	 */
	List<List<KakuroCell>> mapToEntity(List<List<KakuroCellDTO>> grid);

	/**
	 * Maps a single row of a kakuro grid of transfer objects to the corresponding row of document objects
	 * @param row
	 * @return a row of document kakuro cells to be persisted as part of a grid
	 */
	List<KakuroCell> mapKakuroRowToEntity(List<KakuroCellDTO> row);

	/**
	 * Map a single cell of a kakuro transfer object grid to a cell of document object to be persisted
	 * @param cell
	 * @return a document cell to be persisted as part of a grid
	 */
	KakuroCell mapToEntity(KakuroCellDTO cell);

	/**
	 * Maps a document kakuro that was gathered from the db to a transfer object in order to be used as a
	 * response in an REST API
	 * @param kakuro
	 * @return a kakuro ready to be placed in an REST API response object
	 */
	KakuroDTO mapToApi(Kakuro kakuro);

	/**
	 * A generic list mapper. Maps from one list to another of the same size but containing objects result of the
	 * provided mapper.
	 * @param <T> Type of the object to be mapped
	 * @param <V> Type of the resulting mapped object
	 * @param ts List of T objects to be mapped to another type
	 * @param mapper Function that converts from type T to V
	 * @return a new list of the same size of ts with objects of type V
	 */
	<T, V> List<V> mapList(List<T> ts, Function<T, V> mapper);

	/**
	 * A generic page mapper. Maps from a Page object of type T to a Page with content of type V
	 * of the same size resulting of mapping T to V using the provided mapper
	 * @param <T> Type of the object to be mapped
	 * @param <V> Type of the resulting mapped object
	 * @param page Page of T objects to be mapped to another type
	 * @param contentMapper Function that converts from type T to V
	 * @return a new list of the same size of page containing objects of type V
	 */
	<T, V> ResultPage<V> mapToPageApi(Page<T> page, Function<T, V> contentMapper);

}