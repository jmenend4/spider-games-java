package com.juan.spidergames.resources;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.juan.spidergames.api.kakuro.KakuroDTO;
import com.juan.spidergames.api.kakuro.KakuroResponseDTO;
import com.juan.spidergames.api.kakuro.KakuroResponseDTO.KakuroResultDTO;
import com.juan.spidergames.api.paging.PageResponseDTO;
import com.juan.spidergames.api.paging.PageResponseDTO.ResultPage;
import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.api.string.StringResponseDTO;
import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.enums.Difficulty;
import com.juan.spidergames.utils.SpiderGamesMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakuroFacade {
	
	private final KakuroService service;
	private final SpiderGamesMapper mapper;
	private final HttpServletRequest httpRequest;
	
	public ResponseEntity<StringResponseDTO> putKakuro(KakuroDTO kakuro) {
		this.validateGrid(kakuro);
		Kakuro savedKakuro;
		
		if(kakuro.getId() == null) {
			savedKakuro = this.service.insertKakuro(this.mapper.mapToEntity(kakuro));
		} else {
			savedKakuro = this.service.updateKakuro(this.mapper.mapToEntity(kakuro));
		}
		StringResponseDTO response =
				StringResponseDTO.result(httpRequest.getRequestURL() + "/" + savedKakuro.getId(), StringResponseDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	private void validateGrid(KakuroDTO kakuro) {
		if(kakuro.getGrid().size() != kakuro.getHeight()) {
			throw new BaseBodyResponseException(
					"Height and actual grid rows count do not match", HttpStatus.NOT_ACCEPTABLE);
		}
		kakuro.getGrid().forEach(row -> {
			if(row.size() != kakuro.getWidth()) {
				throw new BaseBodyResponseException(
						"All rows must have a count of cells equal to the kakuro width", HttpStatus.NOT_ACCEPTABLE);
			}
		});
		
	}

	public ResponseEntity<KakuroResponseDTO> getById(String id) {
		Optional<Kakuro> kakuro = this.service.getById(id);
		if(kakuro.isEmpty()) {
			throw new BaseBodyResponseException("Could not find kakuro with id " + id, HttpStatus.NOT_FOUND);
		}
		KakuroDTO kakuroDTO = this.mapper.mapToApi(kakuro.get());
		KakuroResultDTO result = KakuroResultDTO.builder().kakuro(kakuroDTO).build();
		KakuroResponseDTO response = KakuroResponseDTO.result(result, KakuroResponseDTO.class);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<PageResponseDTO<KakuroDTO>> getByDifficulty(
			Difficulty difficulty, Integer pageNumber, Integer pageSize) {
		
		Pageable pageable = getPageable(pageNumber, pageSize);
		Page<Kakuro> kakurosPage = this.service.getByDifficulty(difficulty, pageable);
		this.validatePage(kakurosPage);
		ResultPage<KakuroDTO> resultPage = this.mapper.mapToPageApi(kakurosPage, mapper::mapToApi);
		PageResponseDTO<KakuroDTO> response = new PageResponseDTO<KakuroDTO>();
		response.setResult(resultPage);
		
		return ResponseEntity.ok(response);
	}
	
	private Pageable getPageable(Integer pageNumber, Integer pageSize) {
		if(pageNumber == null) {
			pageNumber = 0;
		}
		if(pageSize == null) {
			pageSize = 20;
		}
		if(pageSize > 100) {
			pageSize = 100;
		}
		return PageRequest.of(pageNumber, pageSize, Sort.by("updatedOn"));
	}
	
	public void validatePage(Page<Kakuro> page) {
        if (page.getTotalPages() > 0 && page.getNumber() > page.getTotalPages() - 1) {
            throw new BaseBodyResponseException(
                    "Page out of range", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
        }
        if (page.getTotalPages() == 0 || page.getContent() == null || page.getContent().isEmpty()) {
            throw new BaseBodyResponseException("No kakuros found", HttpStatus.NOT_FOUND);
        }
    }

}
