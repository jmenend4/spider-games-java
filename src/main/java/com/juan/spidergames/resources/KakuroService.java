package com.juan.spidergames.resources;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.juan.spidergames.api.responses.BaseBodyResponseException;
import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.enums.Difficulty;
import com.juan.spidergames.repositories.KakuroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakuroService {
	
	private final KakuroRepository repository;

	public Kakuro insertKakuro(Kakuro kakuro) {
		return repository.insert(kakuro);
	}

	public Kakuro updateKakuro(Kakuro kakuro) {
		Optional<Kakuro> savedKakuroOptional = this.repository.findById(kakuro.getId());
		if(savedKakuroOptional.isEmpty()) {
			throw new BaseBodyResponseException(
					"Could not find kakuro with id " + kakuro.getId(), HttpStatus.NOT_ACCEPTABLE);
		}
		Kakuro savedKakuro = repository.save(kakuro);
		return savedKakuro;
	}

	public Optional<Kakuro> getById(String id) {
		return this.repository.findById(id);
	}

	public Page<Kakuro> getByDifficulty(Difficulty difficulty, Pageable pageable) {
		return this.repository.findByDifficulty(difficulty, pageable);
	}

}
